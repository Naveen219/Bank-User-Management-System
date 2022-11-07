CREATE DATABASE IF NOT EXISTS gbuma;
USE gbuma;

CREATE TABLE IF NOT EXISTS `customer_master` (
  `customer_number` varchar(6) NOT NULL,
  `firstname` varchar(30) DEFAULT NULL,
  `middlename` varchar(30) DEFAULT NULL,
  `lastname` varchar(30) DEFAULT NULL,
  `customer_city` varchar(15) DEFAULT NULL,
  `customer_contact_no` varchar(10) DEFAULT NULL,
  `occupation` varchar(20) DEFAULT NULL,
  `customer_date_of_birth` date DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
CREATE TABLE IF NOT EXISTS `branch_master` (
  `branch_id` varchar(6) NOT NULL,
  `branch_name` varchar(30) DEFAULT NULL,
  `branch_city` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`branch_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `loan_details` (
  `customer_number` varchar(6) DEFAULT NULL,
  `branch_id` varchar(6) DEFAULT NULL,
  `loan_amount` int DEFAULT NULL,
  KEY `loan_customer_key_idx` (`customer_number`),
  KEY `loan_branch_key_idx` (`branch_id`),
  CONSTRAINT `loan_branch_key` FOREIGN KEY (`branch_id`) REFERENCES `branch_master` (`branch_id`),
  CONSTRAINT `loan_customer_key` FOREIGN KEY (`customer_number`) REFERENCES `customer_master` (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `account_master` (
  `account_number` varchar(6) NOT NULL,
  `customer_number` varchar(6) DEFAULT NULL,
  `branch_id` varchar(6) DEFAULT NULL,
  `opening_balance` int DEFAULT NULL,
  `account_opening_date` date DEFAULT NULL,
  `account_type` varchar(10) DEFAULT NULL,
  `account_status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`account_number`),
  KEY `account_master_customer_master_key_idx` (`customer_number`),
  KEY `account_master_branch_master_Fkey_idx` (`branch_id`),
  CONSTRAINT `account_master_branch_master_Fkey` FOREIGN KEY (`branch_id`) REFERENCES `branch_master` (`branch_id`),
  CONSTRAINT `account_master_customer_master_Fkey` FOREIGN KEY (`customer_number`) REFERENCES `customer_master` (`customer_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE IF NOT EXISTS `transaction_details` (
  `transaction_number` varchar(6) NOT NULL,
  `account_number` varchar(6) DEFAULT NULL,
  `date_of_transaction` date DEFAULT NULL,
  `medium_of_transaction` varchar(20) DEFAULT NULL,
  `transaction_type` varchar(20) DEFAULT NULL,
  `transaction_amount` int DEFAULT NULL,
  PRIMARY KEY (`transaction_number`),
  KEY `transaction_details_account_number_Fkey_idx` (`account_number`),
  CONSTRAINT `transaction_details_account_number_Fkey` FOREIGN KEY (`account_number`) REFERENCES `account_master` (`account_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;








/*
Inserting data into the branch table
 */
 
 
INSERT INTO `gbuma`.`branch_master` (`branch_id`, `branch_name`, `branch_city`) VALUES ('b001', 'Asif Ali Road', 'Delhi');
INSERT INTO `gbuma`.`branch_master` (`branch_id`, `branch_name`, `branch_city`) VALUES ('b002', 'Delhi Contt', 'Delhi');
INSERT INTO `gbuma`.`branch_master` (`branch_id`, `branch_name`, `branch_city`) VALUES ('b003', 'Jadacapur', 'Kolkata');
INSERT INTO `gbuma`.`branch_master` (`branch_id`, `branch_name`, `branch_city`) VALUES ('b004', 'Mandvi', 'Mumbai');
INSERT INTO `gbuma`.`branch_master` (`branch_id`, `branch_name`, `branch_city`) VALUES ('b005', 'Mahe', 'Mumbai');
