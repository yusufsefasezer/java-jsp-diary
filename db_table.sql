CREATE DATABASE IF NOT EXISTS `jspDiary`;
USE `jspDiary`;


CREATE TABLE IF NOT EXISTS `diary` (
  `diary_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `date_of_diary` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `content` text NOT NULL,
  `visibility` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`diary_id`)
);


CREATE TABLE IF NOT EXISTS `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `user_name` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
);


CREATE TABLE `user_roles` (
  `user_name` varchar(100) NOT NULL,
  `role_name` varchar(15) NOT NULL,
  PRIMARY KEY (`user_name`,`role_name`)
);