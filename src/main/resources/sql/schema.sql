create table if not exists BILL
(
    ID            BIGINT auto_increment,
    COMPANY_ID    BIGINT,
    DELIVERY_DATE CHARACTER VARYING(10),
    NAME          CHARACTER VARYING(255),
    constraint BILL_PK
        primary key (ID)
);

create index if not exists BILL_COMPANY_ID_INDEX
    on BILL (COMPANY_ID);

create index if not exists BILL_DELIVERY_DATE_INDEX
    on BILL (DELIVERY_DATE);

create table if not exists CHILD_ORDER
(
    ID            BIGINT auto_increment,
    ORDERS_ID     BIGINT,
    PRODUCT_ID    BIGINT,
    SPECIFICATION INTEGER,
    NUMBER        INTEGER,
    WEIGHT        INTEGER,
    PRICE         NUMERIC(10, 2),
    AMOUNT        NUMERIC(10, 2),
    REMARK        CHARACTER VARYING(255),
    constraint CHILD_ORDER_PK
        primary key (ID)
);

create index if not exists CHILD_ORDER_ORDERS_ID_INDEX
    on CHILD_ORDER (ORDERS_ID);

create index if not exists CHILD_ORDER_PRODUCT_ID_INDEX
    on CHILD_ORDER (PRODUCT_ID);

create table if not exists CHILD_ORDER_BILL
(
    ID             BIGINT auto_increment,
    CHILD_ORDER_ID BIGINT,
    BILL_ID        BIGINT,
    constraint CHILD_ORDER_BILL_PK
        primary key (ID)
);

create index if not exists CHILD_ORDER_BILL_BILL_ID_INDEX
    on CHILD_ORDER_BILL (BILL_ID);

create index if not exists CHILD_ORDER_BILL_CHILD_ORDER_ID_INDEX
    on CHILD_ORDER_BILL (CHILD_ORDER_ID);

create table if not exists COMPANY
(
    ID     BIGINT auto_increment,
    NAME   CHARACTER VARYING(255),
    REMARK CHARACTER VARYING(255),
    constraint COMPANY_PK
        primary key (ID)
);

create unique index if not exists COMPANY_NAME_UINDEX
    on COMPANY (NAME);

create table if not exists ORDERS
(
    ID            BIGINT auto_increment,
    COMPANY_ID    BIGINT,
    DELIVERY_DATE DATE,
    constraint ORDERS_PK
        primary key (ID)
);

create index if not exists ORDERS_COMPANY_ID_INDEX
    on ORDERS (COMPANY_ID);

create index if not exists ORDERS_DELIVERY_DATE_INDEX
    on ORDERS (DELIVERY_DATE);

create table if not exists PRODUCT
(
    ID     BIGINT auto_increment,
    NAME   CHARACTER VARYING(255),
    REMARK CHARACTER VARYING(255),
    constraint PRODUCT_PK
        primary key (ID)
);

create unique index if not exists PRODUCT_NAME_UINDEX
    on PRODUCT (NAME);

create table if not exists PRODUCT_COMPANY
(
    ID     BIGINT auto_increment,
    NAME   CHARACTER VARYING(255),
    REMARK CHARACTER VARYING(255),
    constraint PRODUCT_COMPANY_PK
        primary key (ID)
);

create unique index if not exists PRODUCT_COMPANY_NAME_UINDEX
    on PRODUCT_COMPANY (NAME);

create table if not exists PURCHASE
(
    ID                 BIGINT auto_increment,
    PRODUCT_COMPANY_ID BIGINT,
    PURCHASE_DATE      DATE,
    PURCHASE_AMOUNT    NUMERIC(10, 2),
    constraint PURCHASE_PK
        primary key (ID)
);

create index if not exists PURCHASE_PRODUCT_COMPANY_ID_INDEX
    on PURCHASE (PRODUCT_COMPANY_ID);

create index if not exists PURCHASE_PURCHASE_DATE_INDEX
    on PURCHASE (PURCHASE_DATE);

create table if not exists SYSTEM_CONFIG
(
    ID       BIGINT auto_increment
        primary key,
    SALESMAN CHARACTER VARYING(255),
    PHONE    CHARACTER VARYING(20),
    TITLE    CHARACTER VARYING(255)
);

INSERT INTO SYSTEM_CONFIG (SALESMAN, PHONE, TITLE)
SELECT '周卫星', '18826058749', '江门市广亿新材料有限公司'
WHERE NOT EXISTS (SELECT 1 FROM SYSTEM_CONFIG WHERE ID = 1);
