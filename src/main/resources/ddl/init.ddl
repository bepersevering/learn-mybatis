-- dev.T_ARG_PRODUCT definition

CREATE TABLE `T_ARG_PRODUCT`
(
    `ID`           varchar(100) NOT NULL,
    `NAME`         varchar(128) NOT NULL,
    `DESCRIPTION`  varchar(255)   DEFAULT NULL,
    `PRICE`        decimal(10, 0) DEFAULT NULL,
    `GMT_CREATED`  timestamp NULL DEFAULT NULL,
    `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
    `IS_VALID`     tinyint        DEFAULT '1',
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- dev.T_ARG_CUSTOMER definition

CREATE TABLE `T_ARG_CUSTOMER`
(
    `ID`           varchar(100) NOT NULL,
    `NAME`         varchar(100) DEFAULT NULL,
    `PHONE`        varchar(32)  DEFAULT NULL,
    `GENDER`       tinyint      DEFAULT '0',
    `ADDRESS_INFO` varchar(521) DEFAULT NULL,
    `GMT_CREATED`  timestamp NULL DEFAULT NULL,
    `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
    `IS_VALID`     tinyint      DEFAULT '1',
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- dev.T_ARG_ORDER definition

CREATE TABLE `T_ARG_ORDER`
(
    `ID`           varchar(100) CHARACTER NOT NULL,
    `CUSTOMER_ID`  varchar(100) CHARACTER DEFAULT NULL,
    `GMT_CREATED`  timestamp NULL DEFAULT NULL,
    `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
    `IS_VALID`     varchar(100) CHARACTER DEFAULT NULL,
    PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- dev.T_ORDER_ITEM definition

CREATE TABLE `T_ORDER_ITEM`
(
    `ID`           varchar(100) CHARACTER NOT NULL,
    `ORDER_ID`     varchar(100) CHARACTER NOT NULL,
    `PRODUCT_ID`   varchar(100) CHARACTER NOT NULL,
    `AMOUNT`       int            DEFAULT NULL,
    `PRICE`        decimal(10, 0) DEFAULT NULL,
    `GMT_CREATED`  timestamp NULL DEFAULT NULL,
    `GMT_MODIFIED` timestamp NULL DEFAULT NULL,
    `IS_VALID`     tinyint        DEFAULT NULL,
    PRIMARY KEY (`ID`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE INDEX T_CUSTOMER_NAME_PHONE_GENDER_IDX ON T_ARG_CUSTOMER (NAME, PHONE, GENDER);

CREATE INDEX T_ORDER_CUSTOMER_ID_IDX ON T_ARG_ORDER (CUSTOMER_ID);

CREATE INDEX T_PRODUCT_NAME_PRICE_IDX ON T_ARG_PRODUCT (NAME, PRICE);

CREATE INDEX T_ORDER_ITEM_CUSTOMER_ID_IDX ON T_ARG_ORDER_ITEM (ORDER_ID, PRODUCT_ID, AMOUNT, PRICE);

