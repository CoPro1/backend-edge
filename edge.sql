USE edge;

DROP TABLE IF EXISTS `craft_unit`;
CREATE TABLE `craft_unit` (
                        `id` int(11)  AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `craft_unit` VALUES (1,'工艺1'),
                                (2,'工艺2'),
                                (3,'工艺3'),
                                (4,'工艺4'),
                                (5,'工艺5'),
                                (6,'工艺6'),
                                (7,'工艺7'),
                                (8,'工艺8'),
                                (9,'工艺9'),
                                (10,'工艺10'),
                                (11,'工艺11'),
                                (12,'工艺12'),
                                (13,'工艺13'),
                                (14,'工艺14');

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

INSERT INTO `my_task` VALUES (1,1,'43534disuse34','边端工艺1','100','2020-01-10 09:53:32','2020-01-11 9:53:32','edge2','1','简单的任务描述1'),
                             (2,1,'dsf234d3466sf','边端工艺2','10','2020-01-11 09:53:32','2020-01-12 09:53:32','edge3','2','简单的任务描述2'),
                             (3,1,'fds345err4546','边端工艺3','20','2020-01-14 09:53:32','2020-01-15 09:53:32','edge4','3','简单的任务描述3'),
                             (4,1,'43534disuse43','边端工艺4','100','2020-01-15 09:53:32','2020-01-16 9:53:32','edge2','4','简单的任务描述1'),
                             (5,1,'dsf234d3466s6','边端工艺5','10','2020-01-16 09:53:32','2020-01-17 09:53:32','edge3','5','简单的任务描述2'),
                             (6,1,'fds345err454g','边端工艺6','20','2020-01-17 09:53:32','2020-01-18 09:53:32','edge4','0','简单的任务描述3'),
                             (7,1,'43534disuse37','边端工艺7','100','2020-01-18 09:53:32','2020-01-19 9:53:32','edge2','1','简单的任务描述1'),
                             (8,1,'dsf234d3466s5','边端工艺8','10','2020-01-19 09:53:32','2020-01-20 09:53:32','edge3','2','简单的任务描述2'),
                             (9,1,'fds345err4543','边端工艺9','20','2020-01-20 09:53:32','2020-01-21 09:53:32','edge4','3','简单的任务描述3');
