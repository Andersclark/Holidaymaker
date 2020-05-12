CREATE DATABASE  IF NOT EXISTS `holidaymaker` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `holidaymaker`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: holidaymaker
-- ------------------------------------------------------
-- Server version	5.7.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookings` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `registration_date` date NOT NULL,
  `room` int(11) NOT NULL,
  `customer` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `room_id_idx` (`room`),
  KEY `customer_id_idx` (`customer`),
  CONSTRAINT `customer_id` FOREIGN KEY (`customer`) REFERENCES `customers` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `room_id` FOREIGN KEY (`room`) REFERENCES `rooms` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookings`
--

LOCK TABLES `bookings` WRITE;
/*!40000 ALTER TABLE `bookings` DISABLE KEYS */;
INSERT INTO `bookings` VALUES (2,'2020-06-05','2020-06-06','2020-05-07',19,1),(3,'2020-07-03','2020-07-04','2020-05-07',10,2),(4,'2020-06-20','2020-06-24','2020-05-07',20,3),(5,'2020-06-21','2020-06-24','2020-05-07',20,1),(6,'2020-06-21','2020-06-24','2020-05-07',20,2),(7,'2020-08-01','2020-08-04','2020-05-06',10,1),(8,'2020-06-01','2020-06-04','2020-05-06',10,1),(9,'2020-06-08','2020-06-12','2020-05-02',6,3),(11,'2020-06-08','2020-06-12','2020-05-02',4,5),(12,'2020-06-27','2020-06-29','2020-05-08',1,1),(13,'2020-06-10','2020-07-21','2020-05-12',11,1),(14,'2020-07-01','2020-07-05','2020-05-12',17,3);
/*!40000 ALTER TABLE `bookings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'Johan','Doe','johan.doe@svennemejl.dk','+46737039956'),(2,'Jane','Doe','jj.dd@cc.net','123123213'),(3,'Lennart','Johansson','asdkj@asdasd.se','123123'),(4,'Anders','Clark','anders.clark@gmail.com','+46737038814'),(5,'Tom','Bombadill','tommie.gun@lotr.com','10930478391462');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) NOT NULL,
  `pool` tinyint(4) DEFAULT NULL,
  `evening_entertainment` tinyint(4) DEFAULT NULL,
  `daycare` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'231 Massachusetts Drive, New York, New York, United States of America ',1,0,0),(2,'Rönnblomsgatan 11, 21216 Malmö, Sweden',0,1,0),(3,'Carrer de Pere Ferro, 0 S N, 07800 Eivissa, Illes Balears, Spain',1,1,0),(4,'Rue des Granges 6, 1204 Genève, Switzerland',0,1,1),(5,'4 Albion Pl, Northampton NN1 1UD, Great Britain',1,1,1);
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rooms`
--

DROP TABLE IF EXISTS `rooms`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rooms` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` int(11) NOT NULL,
  `beds` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `location_id_idx` (`location`),
  CONSTRAINT `location_id` FOREIGN KEY (`location`) REFERENCES `locations` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rooms`
--

LOCK TABLES `rooms` WRITE;
/*!40000 ALTER TABLE `rooms` DISABLE KEYS */;
INSERT INTO `rooms` VALUES (1,1,1,200),(2,1,3,500),(3,1,1,300),(4,1,2,400),(5,2,1,700),(6,2,1,900),(7,2,5,2000),(8,2,2,1000),(9,3,2,1000),(10,3,1,700),(11,3,10,7000),(12,4,2,1000),(13,4,1,500),(14,4,1,500),(15,4,2,700),(16,5,2,1250),(17,5,1,750),(18,5,1,450),(19,5,4,1050),(20,5,2,850);
/*!40000 ALTER TABLE `rooms` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-12 11:26:43
