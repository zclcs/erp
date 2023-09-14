alter table PUBLIC.BILL
    alter column ID restart with 50000;
alter table PUBLIC.CHILD_ORDER
    alter column ID restart with 50000;
alter table PUBLIC.CHILD_ORDER_BILL
    alter column ID restart with 50000;
alter table PUBLIC.COMPANY
    alter column ID restart with 50000;
alter table PUBLIC.ORDERS
    alter column ID restart with 50000;
alter table PUBLIC.PRODUCT
    alter column ID restart with 50000;
alter table PUBLIC.PRODUCT_COMPANY
    alter column ID restart with 50000;
alter table PUBLIC.PURCHASE
    alter column ID restart with 50000;