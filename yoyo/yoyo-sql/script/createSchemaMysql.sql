DROP TABLE IF EXISTS `market`;

CREATE TABLE `market` (
  `idmar` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `lastModified` datetime DEFAULT NULL,
  `version` smallint(6) NOT NULL DEFAULT '1', -- optimistic lock
  PRIMARY KEY (`idmar`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
