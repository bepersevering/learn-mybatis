-- --------------------------------------------------------
-- 主机:                           192.168.x.x
-- 服务器版本:                        8.0.32-0buntu0.20.04.1 - (Ubuntu)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 导出  表 order.T_ARG_CUSTOMER 结构
CREATE TABLE IF NOT EXISTS `T_ARG_CUSTOMER` (
    `ID` varchar(100) NOT NULL,
    `NAME` varchar(100) DEFAULT NULL,
    `PHONE` varchar(32) DEFAULT NULL,
    `GENDER` tinyint DEFAULT '0',
    `ADDRESS_INFO` varchar(521) DEFAULT NULL,
    `GMT_CREATED` timestamp NULL DEFAULT NULL,
    `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
    `IS_VALID` tinyint DEFAULT '1',
    PRIMARY KEY (`ID`),
    KEY `T_CUSTOMER_NAME_PHONE_GENDER_IDX` (`NAME`,`PHONE`,`GENDER`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 数据导出被取消选择。

-- 导出  表 order.T_ARG_ORDER 结构
CREATE TABLE IF NOT EXISTS `T_ARG_ORDER` (
    `ID` varchar(100) NOT NULL,
    `CUSTOMER_ID` varchar(100) DEFAULT NULL,
    `GMT_CREATED` timestamp NULL DEFAULT NULL,
    `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
    `IS_VALID` varchar(100) DEFAULT NULL,
    PRIMARY KEY (`ID`),
    KEY `T_ORDER_CUSTOMER_ID_IDX` (`CUSTOMER_ID`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 数据导出被取消选择。

-- 导出  表 order.T_ARG_ORDER_ITEM 结构
CREATE TABLE IF NOT EXISTS `T_ARG_ORDER_ITEM` (
    `ID` varchar(100) NOT NULL,
    `ORDER_ID` varchar(100) NOT NULL,
    `PRODUCT_ID` varchar(100) NOT NULL,
    `AMOUNT` int DEFAULT NULL,
    `PRICE` decimal(10,0) DEFAULT NULL,
    `GMT_CREATED` timestamp NULL DEFAULT NULL,
    `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
    `IS_VALID` tinyint DEFAULT NULL,
    PRIMARY KEY (`ID`),
    KEY `T_ORDER_ITEM_CUSTOMER_ID_IDX` (`ORDER_ID`,`PRODUCT_ID`,`AMOUNT`,`PRICE`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 数据导出被取消选择。

-- 导出  表 order.T_ARG_PRODUCT 结构
CREATE TABLE IF NOT EXISTS `T_ARG_PRODUCT` (
    `ID` varchar(100) NOT NULL,
    `NAME` varchar(128) NOT NULL,
    `DESCRIPTION` varchar(255) DEFAULT NULL,
    `PRICE` decimal(10,0) DEFAULT NULL,
    `GMT_CREATED` timestamp NULL DEFAULT NULL,
    `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
    `IS_VALID` tinyint DEFAULT '1',
    PRIMARY KEY (`ID`),
    KEY `T_PRODUCT_NAME_PRICE_IDX` (`NAME`,`PRICE`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 数据导出被取消选择。

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

