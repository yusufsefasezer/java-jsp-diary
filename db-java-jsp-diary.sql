-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: jspdiary
-- ------------------------------------------------------
-- Server version	8.0.34

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


-- Dumping database structure for jspDiary
CREATE DATABASE IF NOT EXISTS `jspDiary` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `jspDiary`;

--
-- Table structure for table `diary`
--


DROP TABLE IF EXISTS `diary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diary` (
  `diary_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NOT NULL,
  `date_of_diary` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` text NOT NULL,
  `visibility` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`diary_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diary`
--

LOCK TABLES `diary` WRITE;
/*!40000 ALTER TABLE `diary` DISABLE KEYS */;
INSERT INTO `diary` VALUES (1,1,'2023-12-23 11:43:07','mensaje 1',_binary ''),(2,1,'2023-12-23 11:43:11','mensaje 2',_binary ''),(3,1,'2023-12-23 11:43:13','mensaje 3',_binary ''),(4,2,'2023-12-23 11:43:31','mensaje 1',_binary ''),(5,2,'2023-12-23 11:43:35','mensaje 2',_binary ''),(6,2,'2023-12-23 11:43:38','mensaje 3',_binary ''),(7,3,'2023-12-23 11:43:52','mensaje 1',_binary ''),(8,3,'2023-12-23 11:43:55','mensaje 2',_binary ''),(9,3,'2023-12-23 11:43:58','mensaje 3',_binary ''),(10,4,'2023-12-23 11:44:13','mensaje 1',_binary ''),(11,4,'2023-12-23 11:44:16','mensaje 2',_binary ''),(12,4,'2023-12-23 11:44:19','mensaje 3',_binary ''),(13,5,'2023-12-23 11:44:49','mensaje 1',_binary ''),(14,5,'2023-12-23 11:44:51','mensaje 2',_binary ''),(15,5,'2023-12-23 11:44:53','mensaje 3',_binary ''),(16,6,'2023-12-23 11:45:07','mensaje 1',_binary ''),(17,6,'2023-12-23 11:45:10','mensaje 2',_binary ''),(18,6,'2023-12-23 11:45:12','mensaje 3',_binary '');
/*!40000 ALTER TABLE `diary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'berly','diaz','berly@gmail.com','f4a212318eb8a89a58f28646d5af2bf7'),(2,'amongas','zolis','amongas@gmail.com','dbe5ffed307a3ffe19a80f3e79b6ad00'),(3,'chalan','caceres','chalan@gmail.com','7ccd60d5c351346dd391f3d0b2f2d13f'),(4,'leopardo','montoya','leopardo@gmail.com','829821286308824dccc13c88970a2dcc'),(5,'ling','ling','lingling@gmail.com','f6d19652c8f635eb88a5c93c8ec52cd7'),(6,'asaltaAmongas','asaltaAmongas','asaltaAmongas@gmail.com','11ea5c54ccf95f19d7c66506ac15546c');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-23 11:47:36
