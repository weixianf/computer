/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.21-log : Database - superman
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`superman` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `superman`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `AdminName` varchar(50) DEFAULT NULL,
  `AdminPwd` varchar(50) DEFAULT NULL,
  `Adname` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `admin` */

insert  into `admin`(`aid`,`AdminName`,`AdminPwd`,`Adname`,`sex`,`age`,`idCard`,`did`) values (1,'11','11',NULL,NULL,NULL,NULL,NULL),(2,'22','22',NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `adminbar` */

DROP TABLE IF EXISTS `adminbar`;

CREATE TABLE `adminbar` (
  `bid` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `nid` int(11) DEFAULT NULL,
  PRIMARY KEY (`bid`),
  KEY `FK_adminbar` (`nid`),
  CONSTRAINT `FK_adminbar` FOREIGN KEY (`nid`) REFERENCES `netbar` (`nid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `adminbar` */

/*Table structure for table `computer` */

DROP TABLE IF EXISTS `computer`;

CREATE TABLE `computer` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `comnumber` varchar(50) DEFAULT NULL,
  `nid` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  CONSTRAINT `FK_computer` FOREIGN KEY (`cid`) REFERENCES `spends` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `computer` */

/*Table structure for table `dictory` */

DROP TABLE IF EXISTS `dictory`;

CREATE TABLE `dictory` (
  `did` int(11) NOT NULL AUTO_INCREMENT,
  `diction` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dictory` */

/*Table structure for table `netbar` */

DROP TABLE IF EXISTS `netbar`;

CREATE TABLE `netbar` (
  `nid` int(11) NOT NULL AUTO_INCREMENT,
  `netbarname` varchar(50) DEFAULT NULL,
  `netbarAddress` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`nid`),
  CONSTRAINT `FK_netbar` FOREIGN KEY (`nid`) REFERENCES `computer` (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC;

/*Data for the table `netbar` */

/*Table structure for table `spends` */

DROP TABLE IF EXISTS `spends`;

CREATE TABLE `spends` (
  `sid` int(11) NOT NULL AUTO_INCREMENT,
  `uptime` datetime DEFAULT NULL,
  `downtime` datetime DEFAULT NULL,
  `Mid` int(11) DEFAULT NULL,
  `Price` float DEFAULT NULL,
  `Fee` float DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `spends` */

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `uid` int(11) NOT NULL,
  `cardId` varchar(50) DEFAULT NULL,
  `cardPwd` varchar(50) DEFAULT NULL,
  `UsersName` varchar(50) DEFAULT NULL,
  `sex` varchar(50) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `Balance` float DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `NewIndex1` (`did`),
  CONSTRAINT `FK_users` FOREIGN KEY (`did`) REFERENCES `spends` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
