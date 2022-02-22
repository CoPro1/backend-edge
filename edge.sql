USE edge;

DROP TABLE IF EXISTS `craft_unit`;
CREATE TABLE `craft_unit` (
                        `id` int(11)  AUTO_INCREMENT,
                        `name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `craft_unit` VALUES (1,'zengyuxin好帅'),
                            (2,'zz好帅'),
                            (3,'zengyuxin真的好帅');