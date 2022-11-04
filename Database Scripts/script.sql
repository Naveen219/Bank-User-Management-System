CREATE DATABASE IF NOT EXISTS gbuma;
USE gbuma;

CREATE TABLE IF NOT EXISTS `gbuma`.`customer_master` (
  `customer_number` VARCHAR(6) NOT NULL,
  `firstname` VARCHAR(30) NULL,
  `middlename` VARCHAR(30) NULL,
  `lastname` VARCHAR(30) NULL,
  `customer_city` VARCHAR(30) NULL,
  `customer_contact_no` VARCHAR(10) NULL,
  `occupation` VARCHAR(20) NULL,
  `customer_date_of_birth` DATE NULL,
  PRIMARY KEY (`customer_number`));
  
  
CREATE TABLE IF NOT EXISTS `gbuma`.`branch_master` (
  `branch_id` VARCHAR(6) NOT NULL,
  `branch_name` VARCHAR(30) NULL,
  `branch_city` VARCHAR(30) NULL,
  PRIMARY KEY (`branch_id`));


CREATE TABLE `loan_details` (
  `customer_number` varchar(6) DEFAULT NULL,
  `branch_id` varchar(6) DEFAULT NULL,
  `loan_amount` int DEFAULT NULL,
  KEY `loan_customer_key_idx` (`customer_number`),
  KEY `loan_branch_key_idx` (`branch_id`),
  CONSTRAINT `loan_branch_key` FOREIGN KEY (`branch_id`) REFERENCES `branch_master` (`branch_id`),
  CONSTRAINT `loan_customer_key` FOREIGN KEY (`customer_number`) REFERENCES `customer_master` (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci