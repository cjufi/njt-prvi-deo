/*
SQLyog Community v13.2.0 (64 bit)
MySQL - 8.0.33 : Database - njt_1_kolokv_maj_2026
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`njt_1_kolokv_maj_2026` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `njt_1_kolokv_maj_2026`;

/*Table structure for table `izdavac` */

DROP TABLE IF EXISTS `izdavac`;

CREATE TABLE `izdavac` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  `pib` varchar(50) DEFAULT NULL,
  `maticniBroj` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `sedisteFirme` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `izdavac` */

insert  into `izdavac`(`id`,`naziv`,`pib`,`maticniBroj`,`sedisteFirme`) values 
(1,'izdavac1','123','123','Beograd'),
(2,'izdavac2','456','456','Smederevo');

/*Table structure for table `knjiga` */

DROP TABLE IF EXISTS `knjiga`;

CREATE TABLE `knjiga` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  `datumIzdavanja` date DEFAULT NULL,
  `tiraz` int DEFAULT NULL,
  `izdavac` bigint DEFAULT NULL,
  `pisac` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `izdavac` (`izdavac`),
  KEY `pisac` (`pisac`),
  CONSTRAINT `knjiga_ibfk_5` FOREIGN KEY (`izdavac`) REFERENCES `izdavac` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `knjiga_ibfk_6` FOREIGN KEY (`pisac`) REFERENCES `pisac` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `knjiga` */

insert  into `knjiga`(`id`,`naziv`,`datumIzdavanja`,`tiraz`,`izdavac`,`pisac`) values 
(9,'knjiga2','2026-05-11',5,1,1),
(10,'knjiga3','2026-05-11',5,1,1),
(11,'knjiga4','2026-05-11',5,1,1);

/*Table structure for table `pisac` */

DROP TABLE IF EXISTS `pisac`;

CREATE TABLE `pisac` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(50) DEFAULT NULL,
  `sifra` varchar(50) DEFAULT NULL,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `godiste` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `pisac` */

insert  into `pisac`(`id`,`email`,`sifra`,`ime`,`prezime`,`godiste`) values 
(1,'pera','pera','Pera','Peric',1999),
(2,'zika','zika','Zika','Zikic',1990);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
