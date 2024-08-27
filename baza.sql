/*
SQLyog Community v13.1.9 (64 bit)
MySQL - 10.4.21-MariaDB : Database - seminarskips
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarskips` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `seminarskips`;

/*Table structure for table `clanstvo` */

DROP TABLE IF EXISTS `clanstvo`;

CREATE TABLE `clanstvo` (
  `GrupaID` int(11) NOT NULL,
  `PolaznikID` int(11) NOT NULL,
  `Status` varchar(255) DEFAULT NULL,
  `Ocena` int(11) DEFAULT 0,
  PRIMARY KEY (`GrupaID`,`PolaznikID`),
  KEY `fk_pola` (`PolaznikID`),
  CONSTRAINT `fk_gru` FOREIGN KEY (`GrupaID`) REFERENCES `grupa` (`GrupaID`),
  CONSTRAINT `fk_pola` FOREIGN KEY (`PolaznikID`) REFERENCES `polaznik` (`PolaznikID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `clanstvo` */

insert  into `clanstvo`(`GrupaID`,`PolaznikID`,`Status`,`Ocena`) values 
(9,2,'ZAVRSIO/LA',4),
(9,3,'PAO/LA',5),
(10,4,'ZAVRSIO/LA',4),
(11,1,'PAO/LA',3),
(11,3,'PAO/LA',3),
(11,4,'ZAVRSIO/LA',0),
(13,3,'PRIJAVA',0),
(13,6,'PAO/LA',1),
(19,2,'ZAVRSIO/LA',5),
(20,1,'PRIJAVA',0),
(20,4,'PRIJAVA',0);

/*Table structure for table `grupa` */

DROP TABLE IF EXISTS `grupa`;

CREATE TABLE `grupa` (
  `GrupaID` int(11) NOT NULL AUTO_INCREMENT,
  `MaxBrojPolaznika` int(11) DEFAULT NULL,
  `NazivGrupe` varchar(255) DEFAULT NULL,
  `DatumPocetkaRadaGrupe` datetime DEFAULT NULL,
  `DatumZavrsnogTesta` datetime DEFAULT NULL,
  `KursID` int(11) DEFAULT NULL,
  PRIMARY KEY (`GrupaID`),
  KEY `fk_kur` (`KursID`),
  CONSTRAINT `fk_kur` FOREIGN KEY (`KursID`) REFERENCES `kurs` (`KursID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

/*Data for the table `grupa` */

insert  into `grupa`(`GrupaID`,`MaxBrojPolaznika`,`NazivGrupe`,`DatumPocetkaRadaGrupe`,`DatumZavrsnogTesta`,`KursID`) values 
(1,9,'A1','2023-08-12 00:00:00','2023-08-31 00:00:00',1),
(8,6,'A3','2022-03-20 00:00:00','2022-03-30 00:00:00',2),
(9,11,'A2','2023-08-29 00:00:00','2023-08-31 00:00:00',7),
(10,11,'A4','2023-08-29 19:56:40','2023-08-31 19:56:46',6),
(11,18,'B1','2023-08-29 00:00:00','2023-09-20 00:00:00',2),
(12,20,'B2','2023-08-20 00:00:00','2023-09-20 00:00:00',4),
(13,25,'B4','2023-08-29 00:00:00','2023-10-29 00:00:00',11),
(18,20,'G1','2023-10-10 00:00:00','2023-12-15 00:00:00',12),
(19,25,'G10','2023-08-31 00:00:00','2023-10-31 00:00:00',12),
(20,12,'G4','2020-03-20 00:00:00','2023-04-20 00:00:00',13);

/*Table structure for table `kurs` */

DROP TABLE IF EXISTS `kurs`;

CREATE TABLE `kurs` (
  `KursID` int(11) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(255) DEFAULT NULL,
  `ImePrezimePredavaca` varchar(255) DEFAULT NULL,
  `VremeTrajanja` int(11) DEFAULT NULL,
  `Oblast` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`KursID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kurs` */

insert  into `kurs`(`KursID`,`Naziv`,`ImePrezimePredavaca`,`VremeTrajanja`,`Oblast`) values 
(1,'Python','Milica Milic',15,'Backend'),
(2,'Java','Marko Markovic',30,'backend'),
(4,'Spring','Milos Milic',20,'frontend i backend'),
(6,'AI','Ana Anic',25,'frontend'),
(7,'Go','Ivan Ivanovic',10,'backend'),
(8,'C++','Ranko Rankovic',20,'backend'),
(11,'C#','Ana Andric',10,'backend'),
(12,'PHP','Mara Maric',20,'backend'),
(13,'HTML i CSS','Aleksa Aleksic',10,'frontend'),
(14,'JavaScript','Ivan Ivanic',10,'frontend');

/*Table structure for table `lekcija` */

DROP TABLE IF EXISTS `lekcija`;

CREATE TABLE `lekcija` (
  `LekcijaID` int(11) NOT NULL AUTO_INCREMENT,
  `NazivLekcija` varchar(255) DEFAULT NULL,
  `KursID` int(11) NOT NULL,
  PRIMARY KEY (`LekcijaID`,`KursID`),
  KEY `fk_kursid` (`KursID`),
  CONSTRAINT `fk_kursid` FOREIGN KEY (`KursID`) REFERENCES `kurs` (`KursID`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4;

/*Data for the table `lekcija` */

insert  into `lekcija`(`LekcijaID`,`NazivLekcija`,`KursID`) values 
(1,'Lekcija1',6),
(2,'Lekcija2',6),
(3,'Lekcija3',6),
(4,'Uvod1',2),
(5,'Uvod2',2),
(6,'Lekcija1Go',7),
(7,'Lekcija2Go',7),
(8,'Lekcija3Go',7),
(9,'Lekcija1C++',8),
(10,'Lekcija2C++',8),
(11,'Lekcija3C++',8),
(13,'Lekcija1C',11),
(14,'Lekcija2C',11),
(15,'Lekcija3C',11),
(16,'Lekcija1PHP',12),
(17,'Lekcija2PHP',12),
(18,'Lekcija3PHP',12),
(19,'Lekcija1HTML',13),
(20,'Lekcija2HTML',13),
(21,'Lekcija3CSS',13),
(25,'Lekcija1JS',14),
(26,'Lekcija2JS',14);

/*Table structure for table `ocena` */

DROP TABLE IF EXISTS `ocena`;

CREATE TABLE `ocena` (
  `OcenaID` int(11) NOT NULL AUTO_INCREMENT,
  `PolaznikID` int(11) NOT NULL,
  `KursID` int(11) NOT NULL,
  `Ocena` int(10) DEFAULT NULL,
  `Komentar` varchar(255) DEFAULT NULL,
  `Status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`OcenaID`,`PolaznikID`,`KursID`),
  KEY `fk_pol` (`PolaznikID`),
  KEY `fk_k` (`KursID`),
  CONSTRAINT `fk_k` FOREIGN KEY (`KursID`) REFERENCES `kurs` (`KursID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_pol` FOREIGN KEY (`PolaznikID`) REFERENCES `polaznik` (`PolaznikID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `ocena` */

/*Table structure for table `polaznik` */

DROP TABLE IF EXISTS `polaznik`;

CREATE TABLE `polaznik` (
  `PolaznikID` int(11) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(255) DEFAULT NULL,
  `Prezime` varchar(255) DEFAULT NULL,
  `DatumRodjenja` date DEFAULT NULL,
  `Username` varchar(255) DEFAULT NULL,
  `Lozinka` varchar(255) DEFAULT NULL,
  `Pol` varchar(1) DEFAULT NULL,
  `Telefon` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`PolaznikID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

/*Data for the table `polaznik` */

insert  into `polaznik`(`PolaznikID`,`Ime`,`Prezime`,`DatumRodjenja`,`Username`,`Lozinka`,`Pol`,`Telefon`) values 
(1,'Marko','Markovic','2003-03-02','a1','123','M','0608282061'),
(2,'Marijana','Maric','2003-08-20','mara','1234','Z','0698574562'),
(3,'Andjela','Andric','2000-05-03','andjela@a.rs','23','Z','0602030101'),
(4,'Uros','Urosevic','2000-06-02','u1','000','M','060235241'),
(5,'Valentina','Vidojevic','2000-08-15','val','12345','Z','0602020230'),
(6,'Iva','Ivic','2000-05-20','i@i.rs','123','Z','0652031423'),
(7,'Milica','Papic','2000-06-07','milica','5678','Z','065231452');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `ZaposleniID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(255) DEFAULT NULL,
  `Lozinka` varchar(255) DEFAULT NULL,
  `Ime` varchar(255) DEFAULT NULL,
  `Prezime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ZaposleniID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`ZaposleniID`,`Username`,`Lozinka`,`Ime`,`Prezime`) values 
(1,'z1','123','Zara','Zaric'),
(2,'z2','234','Mara','Maric'),
(3,'admin','admin','Admin','Admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
