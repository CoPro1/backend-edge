USE edge;

DROP TABLE IF EXISTS `craft_unit`;
CREATE TABLE `craft_unit` (
                        `id` int(11)  AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `craft_unit` VALUES (1,'裁剪'),
                                (2,'切边'),
                                (3,'压制'),
                                (4,'焊接'),
                                (5,'检查焊点'),
                                (6,'电泳防锈'),
                                (7,'清理表面'),
                                (8,'喷漆'),
                                (9,'安装转向系统'),
                                (10,'安装连杆'),
                                (11,'安装后桥'),
                                (12,'安装油箱'),
                                (13,'起吊翻转'),
                                (14,'安装管路'),
                                (15,'安装减震器'),
                                (16,'安装刹车盘'),
                                (17,'安装动力总成'),
                                (18,'安装底盘'),
                                (19,'安装车壳'),
                                (20,'安装内饰'),
                                (21,'加注防冻液'),
                                (22,'预热车侧'),
                                (23,'安装侧面防擦条'),
                                (24,'检查漆面'),
                                (25,'四轮定位检测'),
                                (26,'尾气排放检测'),
                                (27,'密封性能测试');

DROP TABLE IF EXISTS `my_task`;
CREATE TABLE `my_task` (
                              `id` int(11)  AUTO_INCREMENT,
                              `user_id` int(11) DEFAULT NULL,
                              `task_id` varchar(255) DEFAULT NULL,
                              `pro_name` varchar(255) DEFAULT NULL,
                              `times` int(11) DEFAULT NULL,
                              `arrive_time` timestamp DEFAULT NULL,
                              `deadline` timestamp DEFAULT NULL,
                              `next_edge` varchar(255) DEFAULT NULL,
                              `state` int(11) DEFAULT NULL,
                              `description` varchar(255) DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `my_task` VALUES (1,1,'dd88bb9fa2565344f8f38e4e5d55a340','冲压','100','2020-01-10 09:53:32','2020-01-11 9:53:32','edge2','1','简单的冲压工艺'),
                             (2,1,'b29e1805f2fcb1beb72d39e5adb5331e','焊接','10','2020-01-11 09:53:32','2020-01-12 09:53:32','edge3','2','简单的焊接工艺'),
                             (3,1,'621ad6276e51288d041f110da3d7e753','涂装','20','2020-01-14 09:53:32','2020-01-15 09:53:32','edge4','3','简单的涂装工艺'),
                             (4,1,'238a4326c485cef4a73d27f62c117802','总装','100','2020-01-15 09:53:32','2020-01-16 9:53:32','edge2','4','简单的总装工艺'),
                             (5,1,'8c677b8ce30b62751b84ec80ba7c20d9','检测','10','2020-01-16 09:53:32','2020-01-17 09:53:32','edge3','5','简单的检测工艺'),
                             (6,1,'b88fde00a04ce47398e8d1b69415d2f2','边端工艺6','20','2020-01-17 09:53:32','2020-01-18 09:53:32','edge4','0','简单的任务描述6'),
                             (7,1,'5447712ae447ae5041c085357b353180','边端工艺7','100','2020-01-18 09:53:32','2020-01-19 9:53:32','edge2','1','简单的任务描述7'),
                             (8,1,'86173b6311dbe781c5b92615cbeeafcb','边端工艺8','10','2020-01-19 09:53:32','2020-01-20 09:53:32','edge3','2','简单的任务描述8'),
                             (9,1,'f83bf818ac7f49e8e1509a0a83642c64','边端工艺9','20','2020-01-20 09:53:32','2020-01-21 09:53:32','edge4','3','简单的任务描述9');

