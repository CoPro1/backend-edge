package cn.edu.sjtu.ist.ecssbackendedge.service.impl;

import cn.edu.sjtu.ist.ecssbackendedge.dao.ProcessManageDao;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.ProcessManage;
import cn.edu.sjtu.ist.ecssbackendedge.entity.domain.processmanage.Step;
import cn.edu.sjtu.ist.ecssbackendedge.entity.dto.ProcessManageDTO;
import cn.edu.sjtu.ist.ecssbackendedge.service.ProcessManageService;
import cn.edu.sjtu.ist.ecssbackendedge.utils.process.BpmnUtils;
import cn.hutool.core.util.XmlUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.camunda.bpm.model.bpmn.instance.DataStoreReference;
import org.camunda.bpm.model.bpmn.instance.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import  org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @brief 流程 serviceImpl
 * @author rsp
 * @version 0.1
 * @date 2021-11-26
 */
@Slf4j
@Service
public class ProcessManageServiceImpl implements ProcessManageService {

    @Autowired
    private ProcessManageDao processManageDao;

    @Override
    public ProcessManage insertProcess(ProcessManage processManage) throws RuntimeException {
        if (processManageDao.findProcessByName(processManage.getName()).size() > 0) {
            throw new RuntimeException("该名称已存在");
        }
        processManageDao.createProcess(processManage);
        log.info("插入流程成功!");
        return processManageDao.findProcessByName(processManage.getName()).get(0);
    }

    @Override
    public ProcessManage insertProcessWithFile(ProcessManage processManage, MultipartFile file) {
        String bpmn = BpmnUtils.multiFileToStr(file);
        verifyName(bpmn);
        processManage.setBpmn(bpmn);
        return insertProcess(processManage);
    }

    @Override
    public void deleteProcess(String id) {
        processManageDao.removeProcess(id);
        log.info("删除流程id={}成功!", id);
    }

    @Override
    public void banProcess(String id) {
        processManageDao.banProcess(id);
        log.info("禁用流程id={}成功!", id);
    }

    @Override
    public void enableProcess(String id) {
        processManageDao.banProcess(id);
        log.info("禁用流程id={}成功!", id);
    }

    @Override
    public void updateProcess(String id, ProcessManage processManage) {
        processManage.setId(id);
        log.info(processManage.toString());
        processManageDao.modifyProcess(processManage);
        log.info("更新流程id={}成功!", id);
    }

    @Override
    public List<ProcessManage> getAllProcessesByUser(String userId) {
        List<ProcessManage> processManages = processManageDao.findProcessesByOwner(userId);
        log.info("获取用户id=" + userId + "的所有流程成功");
        return processManages;
    }

    @Override
    public List<ProcessManage> getAllProcesses() {
        List<ProcessManage> processManages = processManageDao.findAllProcesses();
        log.info("获取所有流程成功");
        return processManages;
    }

    private void verifyName(String bpmn){
        BpmnModelInstance instance = Bpmn.readModelFromStream(BpmnUtils.strToInStream(bpmn));
        Collection<? extends Task> tasks = instance.getModelElementsByType(Task.class);
        for (Task task : tasks) {
            Assert.notNull(task.getName(), "Task节点应该绑定名称");
        }
        Collection<? extends DataStoreReference> dsrs = instance.getModelElementsByType(DataStoreReference.class);
        for (DataStoreReference dsr : dsrs) {
            Assert.notNull(dsr.getName(), "数据节点应该绑定名称");
        }
    }

    @Override
    public void updateProcessBpmn(String processId, MultipartFile file) {
        String bpmn = BpmnUtils.multiFileToStr(file);
        verifyName(bpmn);
        ProcessManage processManage = findProcess(processId);
        processManage.setBpmn(bpmn);
        processManageDao.modifyProcess(processManage);
    }

    @Override
    public void updateProcessStep(String processId, Step step) {
        ProcessManage processManage = findProcess(processId);
        if (step == Step.FINISHED) {
            processManage.verifySelf();
        }
        processManage.setStep(step);
        processManageDao.modifyProcess(processManage);
    }

    @Override
    public void updateProcessName(String processId, String name) {
        ProcessManage processManage = findProcess(processId);
        processManage.setName(name);
        processManageDao.modifyProcess(processManage);
    }

    @Override
    public ProcessManage findProcess(String processId) {
        return processManageDao.findProcessById(processId);
    }

    @Override
    public List<ProcessManage> findOwnedProcesses(String owner) {
        return processManageDao.findProcessesByOwner(owner);
    }

    @Override
    public String findBpmn(String processId) {
        ProcessManage processManage = findProcess(processId);
        return processManage.getBpmn();
    }

    @Override
    public Boolean issueProcess(String ip, String port, ProcessManageDTO processManageDTO) {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        System.out.println(ip);
        System.out.println(port);
        HttpPost httpPost = new HttpPost(ip + ':' + port + "/process");
        httpPost.addHeader("Content-Type", "application/json");
        String jsonString = JSON.toJSONString(processManageDTO);
        StringEntity entity = new StringEntity(jsonString, "UTF-8");
        httpPost.setEntity(entity);

        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpClient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                // 释放资源
                if (httpClient != null) {
                    httpClient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO: 返回的顺序有问题，会按照task的放置顺序而不是连出来的顺序
    @Override
    public List<String> findBpmnEvents(String processId){
        ProcessManage processManage = findProcess(processId);
        String Bpmn  = processManage.getBpmn();
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(Bpmn));
            Document document = db.parse(is);
            NodeList taskList = XmlUtil.getNodeListByXPath("//*[name()='bpmn2:task']", document);
//            NodeList taskList = document.getElementsByTagName("bpmn2:task");
            int taskCnt = taskList.getLength();
            List<String> result = new ArrayList<>();
            for(int i = 0; i < taskCnt; i++) {
                Node task = taskList.item(i);
                NamedNodeMap attrs = task.getAttributes();
                for(int j = 0; j < attrs.getLength(); j++) {
                    Node attr = attrs.item(j);
                    result.add(attr.getNodeValue());
                }
            }
            List<String> strForDel = new ArrayList<>();
            for(String str : result) {
                if(str.contains("Activi")) {
                    strForDel.add(str);
                }
            }
            result.removeAll(strForDel);
            return result;
        }
        catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
