create database dmart;

create table tbl_products (id serial primary key, price bigint unsigned, status boolean, vendor_id bigint unsigned);

alter table tbl_products add foreign key (vendor_id) references tbl_vendors(id);

create table tbl_orders (id serial primary key, vendor_id bigint unsigned, ordered_date timestamp default current_timestamp);

alter table tbl_orders add foreign key(vendor_id) references tbl_vendors(id);

create table tbl_order_details (id serial primary key, order_id bigint unsigned,
 product_id bigint unsigned, quantity bigint unsigned, unit_id bigint unsigned);

alter table tbl_order_details add foreign key(order_id) references tbl_orders(id);
alter table tbl_order_details add foreign key(product_id) references tbl_products(id);
alter table tbl_order_details add foreign key(unit_id) references tbl_units(id);

create table tbl_vendors( id serial primary key, name varchar(100), address varchar(50), email varchar(100), contact_no varchar(50));

create table tbl_units(id serial primary key, description varchar(20), code varchar(20));

create table tbl_request_order (id serial primary key, request_date timestamp default current_timestamp, product_id bigint unsigned,
qty bigint unsigned, unit_id bigint unsigned);

alter table tbl_request_order add foreign key(product_id) references tbl_products(id);
alter table tbl_request_order add foreign key(unit_id) references tbl_units(id);

create table mst_roles(id serial primary key,
role_name varchar(100));

insert into mst_roles(role_name)
values('admin'),('user');

create table tbl_users(id serial primary key,
username varchar(100), password varchar(100), email varchar(100),
 role_id bigint unsigned, created_date timestamp default current_timestamp,
status boolean);

alter table tbl_users add foreign key (role_id) references
mst_roles(id);

insert into tbl_users(username, password, email,role_id, status)
values('admin','$2a$10$F4O3kX4K4aYk2eytHvnQCuQGx9pCAE2V2OxDpmhS18Of/XXnlHM16',
'reganshakya@gmail.com',1,1);

create table tbl_customer(id serial primary key, first_name varchar(50), last_name varchar(50), address varchar(50),
email varchar(100), contact_no varchar(25));

alter table tbl_products add column  created_date timestamp default current_timestamp;

alter table tbl_request_order add column customer_id bigint unsigned;

alter table tbl_request_order add foreign key (customer_id) references tbl_customer(id);

alter table tbl_request_order add column delivery_date date;

create table tbl_request_order_detail(id serial primary key, request_order_id bigint unsigned, product_id bigint unsigned, unit_id bigint unsigned);

alter table tbl_request_order_detail add foreign key(order_id) references tbl_request_order(id);
alter table tbl_request_order_detail add foreign key(product_id) references tbl_products(id);
alter table tbl_request_order_detail add foreign key(unit_id) references tbl_units(id);



alter table tbl_products add column quantity bigint unsigned;

alter table tbl_order_details add column created_date timestamp default current_timestamp;

create table tbl_supplier_product (id serial primary key, supplier_id bigint unsigned, product_id bigint unsigned);

alter table tbl_supplier_product add foreign key (supplier_id) references tbl_supplier (id);
alter table tbl_supplier_product add foreign key (product_id) references tbl_products (id);


create table tbl_stock (id serial primary key, product_id bigint unsigned, quantity bigint unsigned,
 rate bigint unsigned, created_date timestamp default current_timestamp);

alter table tbl_stock add foreign key(product_id) references tbl_products(id);