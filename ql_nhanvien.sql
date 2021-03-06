-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: ql_nhanvien
-- ------------------------------------------------------
-- Server version	5.7.15-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calamviec`
--

DROP TABLE IF EXISTS `calamviec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calamviec` (
  `idcalamviec` int(11) NOT NULL AUTO_INCREMENT,
  `maca` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `tenca` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `giobatdau` varchar(45) CHARACTER SET utf8 NOT NULL,
  `gioketthuc` varchar(45) CHARACTER SET utf8 NOT NULL,
  `ghichu` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idcalamviec`),
  UNIQUE KEY `idcalamviec_UNIQUE` (`idcalamviec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calamviec`
--

LOCK TABLES `calamviec` WRITE;
/*!40000 ALTER TABLE `calamviec` DISABLE KEYS */;
/*!40000 ALTER TABLE `calamviec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chamcong`
--

DROP TABLE IF EXISTS `chamcong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chamcong` (
  `idchamcong` int(11) NOT NULL AUTO_INCREMENT,
  `nhanvien` int(11) NOT NULL,
  `tongngaycong` double NOT NULL,
  `tonggiolamthem` double DEFAULT NULL,
  `luongthuong` double DEFAULT NULL,
  `thuclanh` double DEFAULT NULL,
  `thanglam` int(11) NOT NULL,
  `ghichu` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idchamcong`),
  UNIQUE KEY `idchamcong_UNIQUE` (`idchamcong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chamcong`
--

LOCK TABLES `chamcong` WRITE;
/*!40000 ALTER TABLE `chamcong` DISABLE KEYS */;
/*!40000 ALTER TABLE `chamcong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chucvu` (
  `idchucvu` int(11) NOT NULL AUTO_INCREMENT,
  `tenchucvu` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `mota` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idchucvu`),
  UNIQUE KEY `idchucvu_UNIQUE` (`idchucvu`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES (1,'QuanLy',NULL);
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giolam`
--

DROP TABLE IF EXISTS `giolam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giolam` (
  `idgiolam` int(11) NOT NULL AUTO_INCREMENT,
  `nhanvien` int(11) NOT NULL,
  `calamviec` int(11) NOT NULL,
  `giovao` datetime NOT NULL,
  `giora` datetime NOT NULL,
  `lamho` bit(1) DEFAULT b'0',
  `ghichu` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idgiolam`),
  UNIQUE KEY `idgiolam_UNIQUE` (`idgiolam`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giolam`
--

LOCK TABLES `giolam` WRITE;
/*!40000 ALTER TABLE `giolam` DISABLE KEYS */;
/*!40000 ALTER TABLE `giolam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `luongnv`
--

DROP TABLE IF EXISTS `luongnv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `luongnv` (
  `idluongnv` int(11) NOT NULL AUTO_INCREMENT,
  `chucvu` int(11) NOT NULL,
  `luongcoban` double NOT NULL,
  PRIMARY KEY (`idluongnv`),
  UNIQUE KEY `idluongnv_UNIQUE` (`idluongnv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luongnv`
--

LOCK TABLES `luongnv` WRITE;
/*!40000 ALTER TABLE `luongnv` DISABLE KEYS */;
/*!40000 ALTER TABLE `luongnv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhanvien` (
  `idnhanvien` int(11) NOT NULL AUTO_INCREMENT,
  `hoten` varchar(60) CHARACTER SET utf8 DEFAULT NULL,
  `ngaysinh` date NOT NULL,
  `sdt` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `diachi` varchar(150) COLLATE utf8_unicode_ci NOT NULL,
  `chucvu` int(11) NOT NULL,
  `gioitinh` bit(1) NOT NULL,
  `ngayvaolam` date NOT NULL,
  `cmnd` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ngaycap` date DEFAULT NULL,
  `tendn` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `matkhau` varchar(300) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `luongnv` text CHARACTER SET utf8 NOT NULL,
  `hinhanh` text CHARACTER SET utf8,
  `noicap` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ghichu` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `trangthai` bit(1) DEFAULT NULL,
  PRIMARY KEY (`idnhanvien`),
  UNIQUE KEY `idnhanvien_UNIQUE` (`idnhanvien`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'to van tu','1997-02-17','01653429579','daklak',1,'','2016-02-02','241578987','2012-02-06','tovantu','dancaydat','togia@gmail.com','2000000','sd','xcxzc','ads',NULL),(2,'to van tu ca','1997-02-17','01653429579','gttytye',1,'','2016-02-02','125487968','2017-02-06','','','asd@gmail.com','2012010','anh_180217020206.png','fdfzxc','ads',NULL),(3,'to van tu','1997-02-17','01653429579','sdadas',1,'','2016-02-02','241578987','2012-02-06','','','togia@gmail.com','2000000','anh_180217023647.png','dsadas','ads',NULL);
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-25  9:52:12
