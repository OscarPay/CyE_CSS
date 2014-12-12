CREATE DATABASE  IF NOT EXISTS `scc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `scc`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win64 (x86_64)
--
-- Host: localhost    Database: scc
-- ------------------------------------------------------
-- Server version	5.6.21-log

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
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `clv_produc` int(6) NOT NULL AUTO_INCREMENT,
  `id_produc` varchar(20) NOT NULL,
  `nombre_produc` varchar(45) NOT NULL,
  `preciocom_produc` double NOT NULL,
  `precioven_produc` double NOT NULL,
  `clv_tipoproduc` int(3) NOT NULL,
  PRIMARY KEY (`clv_produc`),
  UNIQUE KEY `clv_produc_UNIQUE` (`clv_produc`),
  KEY `clv_tipoproduc_idx` (`clv_tipoproduc`),
  CONSTRAINT `clv_tipoproduc` FOREIGN KEY (`clv_tipoproduc`) REFERENCES `tipo_produc` (`clv_tipoproduc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'004','Papitas',4,5,1),(2,'008','abner',45,55,1);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentas`
--

DROP TABLE IF EXISTS `rentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rentas` (
  `clv_renta` int(11) NOT NULL AUTO_INCREMENT,
  `no_maquina` int(11) NOT NULL,
  `no_controles` int(11) DEFAULT NULL,
  `tipo_maquina` varchar(45) NOT NULL,
  `hora_entrada` varchar(45) NOT NULL,
  `hora_salida` varchar(45) NOT NULL,
  `tiempo_transcurrido` varchar(45) NOT NULL,
  `precio` varchar(45) NOT NULL,
  `fecha` varchar(45) NOT NULL,
  PRIMARY KEY (`clv_renta`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentas`
--

LOCK TABLES `rentas` WRITE;
/*!40000 ALTER TABLE `rentas` DISABLE KEYS */;
INSERT INTO `rentas` VALUES (40,2,NULL,'Computadora','13:48:53','13:49:04','00:00:10','0.031','10/diciembre/2014'),(41,1,NULL,'Computadora','13:48:58','13:49:04','00:00:05','0.017','10/diciembre/2014'),(42,1,2,'Xbox','13:48:46','13:49:07','00:00:20','0.088','10/diciembre/2014'),(43,3,NULL,'Computadora','13:48:39','13:49:11','00:00:30','0.086','10/diciembre/2014'),(44,4,NULL,'Computadora','13:48:36','13:49:22','00:00:45','0.128','10/diciembre/2014'),(45,2,3,'Xbox','13:48:30','13:49:31','00:01:00','0.333','10/diciembre/2014'),(46,1,NULL,'Computadora','15:53:37','15:53:48','00:00:10','0.031','10/diciembre/2014'),(47,2,NULL,'Computadora','15:53:34','15:53:55','00:00:20','0.058','10/diciembre/2014'),(48,1,1,'Xbox','15:53:30','15:54:01','00:00:30','0.086','10/diciembre/2014'),(49,3,NULL,'Computadora','15:53:26','15:54:07','00:00:40','0.114','10/diciembre/2014'),(50,4,NULL,'Computadora','15:53:20','15:54:13','00:00:50','0.144','10/diciembre/2014'),(51,2,4,'Xbox','15:53:14','15:54:16','00:01:00','0.424','10/diciembre/2014'),(52,1,NULL,'Computadora','21:25:05','21:25:38','00:00:30','0.089','10/diciembre/2014'),(53,1,NULL,'Computadora','21:25:49','21:26:30','00:00:40','0.114','10/diciembre/2014'),(54,1,NULL,'Computadora','23:20:28','23:20:59','00:00:30','0.083','10/diciembre/2014'),(55,1,NULL,'Computadora','23:49:08','23:49:29','00:00:20','0.058','10/diciembre/2014'),(56,2,NULL,'Computadora','12:37:45','12:38:16','00:00:30','0.083','11/diciembre/2014'),(57,1,NULL,'Computadora','12:42:08','12:42:40','00:00:30','0.089','11/diciembre/2014'),(58,2,NULL,'Computadora','12:55:53','12:56:26','00:00:30','0.089','11/diciembre/2014'),(59,3,NULL,'Computadora','12:56:22','12:57:04','00:00:40','0.114','11/diciembre/2014'),(60,1,4,'Xbox','12:56:31','12:57:22','00:00:50','0.354','11/diciembre/2014'),(61,1,NULL,'Computadora','13:32:18','13:32:49','00:00:30','0.083','11/diciembre/2014'),(62,1,NULL,'Computadora','13:33:31','13:33:42','00:00:10','0.031','11/diciembre/2014'),(63,2,4,'Xbox','13:45:37','13:46:38','00:01:00','0.417','11/diciembre/2014'),(64,4,NULL,'Computadora','13:45:44','13:46:45','00:01:00','0.169','11/diciembre/2014'),(65,3,NULL,'Computadora','13:45:51','13:46:52','00:01:00','0.169','11/diciembre/2014'),(66,1,1,'Xbox','13:45:58','13:46:59','00:01:00','0.169','11/diciembre/2014'),(67,2,NULL,'Computadora','13:46:01','13:47:02','00:01:00','0.169','11/diciembre/2014'),(68,1,NULL,'Computadora','13:46:06','13:47:07','00:01:00','0.169','11/diciembre/2014'),(69,2,1,'Xbox','14:03:51','14:04:22','00:00:30','0.083','11/diciembre/2014'),(70,2,4,'Xbox','14:05:13','14:05:44','00:00:30','0.215','11/diciembre/2014'),(71,1,3,'Xbox','14:05:24','14:05:45','00:00:20','0.117','11/diciembre/2014'),(72,2,4,'Xbox','14:32:07','14:32:39','00:00:30','0.215','11/diciembre/2014'),(73,3,NULL,'Computadora','14:32:25','14:32:56','00:00:30','0.086','11/diciembre/2014'),(74,1,2,'Xbox','14:32:17','14:33:04','00:00:45','0.196','11/diciembre/2014'),(75,1,4,'Xbox','14:33:23','14:33:34','00:00:10','0.076','11/diciembre/2014'),(76,2,3,'Xbox','15:12:26','15:12:57','00:00:30','0.172','11/diciembre/2014'),(77,2,2,'Xbox','16:04:23','16:04:56','00:00:30','0.129','11/diciembre/2014');
/*!40000 ALTER TABLE `rentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_produc`
--

DROP TABLE IF EXISTS `tipo_produc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_produc` (
  `clv_tipoproduc` int(3) NOT NULL AUTO_INCREMENT,
  `nombre_tipoproduc` varchar(45) NOT NULL,
  PRIMARY KEY (`clv_tipoproduc`),
  UNIQUE KEY `clv_tipoproduct_UNIQUE` (`clv_tipoproduc`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_produc`
--

LOCK TABLES `tipo_produc` WRITE;
/*!40000 ALTER TABLE `tipo_produc` DISABLE KEYS */;
INSERT INTO `tipo_produc` VALUES (1,'Dulceria'),(2,'Papeleria');
/*!40000 ALTER TABLE `tipo_produc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_usr`
--

DROP TABLE IF EXISTS `tipo_usr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_usr` (
  `clv_tipousr` int(2) NOT NULL AUTO_INCREMENT,
  `nombre_tipousr` varchar(45) NOT NULL,
  PRIMARY KEY (`clv_tipousr`),
  UNIQUE KEY `clv_tipousr_UNIQUE` (`clv_tipousr`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_usr`
--

LOCK TABLES `tipo_usr` WRITE;
/*!40000 ALTER TABLE `tipo_usr` DISABLE KEYS */;
INSERT INTO `tipo_usr` VALUES (1,'Administrador'),(2,'Encargado');
/*!40000 ALTER TABLE `tipo_usr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `clv_usr` int(3) NOT NULL AUTO_INCREMENT,
  `nombre_usr` varchar(45) NOT NULL,
  `correo_usr` varchar(45) NOT NULL,
  `contrasena_usr` varchar(40) NOT NULL,
  `telefono_usr` varchar(20) NOT NULL,
  `clv_tipousr` int(2) NOT NULL,
  PRIMARY KEY (`clv_usr`),
  UNIQUE KEY `clv_usr_UNIQUE` (`clv_usr`),
  KEY `clv_tipousr_idx` (`clv_tipousr`),
  CONSTRAINT `clv_tipousr` FOREIGN KEY (`clv_tipousr`) REFERENCES `tipo_usr` (`clv_tipousr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'oscar','nike-o_94@hotmail.com','tumama','99999999',1),(2,'abner ','renba@hotmail.com','soso','9992343',1),(3,'aew','renba2@hotmail.com','er','9999',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-12-11 16:47:26
