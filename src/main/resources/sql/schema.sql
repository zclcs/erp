create table if not exists BILL
(
    ID            BIGINT auto_increment
        primary key,
    COMPANY_ID    BIGINT,
    COMPANY_NAME  CHARACTER VARYING(255),
    DELIVERY_DATE CHARACTER VARYING(10),
    NAME          CHARACTER VARYING(255),
    TOTAL_AMOUNT  NUMERIC(10, 2)
);

create index if not exists BILL_COMPANY_ID_INDEX
    on BILL (COMPANY_ID);

create table if not exists CHILD_ORDER
(
    ID                 BIGINT auto_increment
        primary key,
    ORDERS_ID          BIGINT,
    PRODUCT_ID         BIGINT,
    PRODUCT_NAME       CHARACTER VARYING(255),
    SPECIFICATION      INTEGER,
    NUMBER             INTEGER,
    WEIGHT             INTEGER,
    PRICE              NUMERIC(10, 2),
    AMOUNT             NUMERIC(10, 2),
    REMARK             CHARACTER VARYING(255),
    CHILD_ORDER_STATUS INTEGER
);

create index if not exists CHILD_ORDER_ORDERS_ID_INDEX
    on CHILD_ORDER (ORDERS_ID);

create index if not exists CHILD_ORDER_PRODUCT_ID_INDEX
    on CHILD_ORDER (PRODUCT_ID);

create table if not exists CHILD_ORDER_BILL
(
    ID             BIGINT auto_increment
        primary key,
    CHILD_ORDER_ID BIGINT,
    BILL_ID        BIGINT
);

create index if not exists CHILD_ORDER_BILL_BILL_ID_INDEX
    on CHILD_ORDER_BILL (BILL_ID);

create index if not exists CHILD_ORDER_BILL_CHILD_ORDER_ID_INDEX
    on CHILD_ORDER_BILL (CHILD_ORDER_ID);

create table if not exists COMPANY
(
    ID     BIGINT auto_increment
        primary key,
    NAME   CHARACTER VARYING(255),
    REMARK CHARACTER VARYING(255)
);

create table if not exists ORDERS
(
    ID            BIGINT auto_increment
        primary key,
    COMPANY_ID    BIGINT,
    COMPANY_NAME  CHARACTER VARYING(255),
    DELIVERY_DATE DATE,
    ORDERS_STATUS INTEGER
);

create index if not exists ORDERS_COMPANY_ID_INDEX
    on ORDERS (COMPANY_ID);

create table if not exists PRODUCT
(
    ID     BIGINT auto_increment
        primary key,
    NAME   CHARACTER VARYING(255),
    REMARK CHARACTER VARYING(255)
);

create table if not exists PRODUCT_COMPANY
(
    ID     BIGINT auto_increment
        primary key,
    NAME   CHARACTER VARYING(255),
    REMARK CHARACTER VARYING(255)
);

create table if not exists PURCHASE
(
    ID                   BIGINT auto_increment
        primary key,
    PRODUCT_COMPANY_ID   BIGINT,
    PRODUCT_COMPANY_NAME CHARACTER VARYING(255),
    PURCHASE_DATE        DATE,
    PURCHASE_AMOUNT      NUMERIC(10, 2)
);

create table if not exists SYSTEM_CONFIG
(
    ID       BIGINT auto_increment
        primary key,
    SALESMAN CHARACTER VARYING(255),
    PHONE    CHARACTER VARYING(20),
    TITLE    CHARACTER VARYING(255)
);

INSERT INTO SYSTEM_CONFIG (SALESMAN, PHONE, TITLE)
SELECT '周卫星', '18826058749', '广州尊欧化工科技有限公司'
WHERE NOT EXISTS (SELECT 1 FROM SYSTEM_CONFIG WHERE ID = 1);

