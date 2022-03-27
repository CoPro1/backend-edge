USE edge;

DROP TABLE IF EXISTS `craft_unit`;
CREATE TABLE `craft_unit` (
                        `id` int(11)  AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `craft_unit` VALUES (1,'工艺1'),
                            (2,'工艺2'),
                            (3,'工艺3');

DROP TABLE IF EXISTS `my_task`;
CREATE TABLE `my_task` (
                              `id` int(11)  AUTO_INCREMENT,
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

INSERT INTO `my_task` VALUES (1,'43534disuse34','边端工艺1','100','2020-01-10 09:53:32','2020-01-11 9:53:32','edge2','1','简单的任务描述1'),
                          (2,'dsf234d3466sf','边端工艺2','10','2020-01-11 09:53:32','2020-01-12 09:53:32','edge3','2','简单的任务描述2'),
                          (3,'fds345err4546','边端工艺3','20','2020-01-14 09:53:32','2020-01-15 09:53:32','edge4','3','简单的任务描述3');


# DROP TABLE IF EXISTS `task_state`;
# CREATE TABLE `task_state` (
#                               `id` int(11)  AUTO_INCREMENT,
#                               `state` int(11) DEFAULT NULL,
#                               PRIMARY KEY (`id`),
#                               FOREIGN KEY (id) REFERENCES my_task(id)
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8;
#
# INSERT INTO `task_state` VALUES (1,'1'),
#                                 (2,'2'),
#                                 (3,'3');

# select * from edge.my_task natural join edge.task_state;