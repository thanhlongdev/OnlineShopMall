create database if not exists OnlineShopMall;

use OnlineShopMall;

create table user (
	username varchar(10),
    password varchar(100) not null,
    salt_code varchar(50) not null,
    full_name varchar(100) charset utf8 not null,
    gender bit not null default 0,
    email varchar(100) not null,
    phone varchar(10) null,
    date_create bigint not null,
    forget_password VARCHAR(200) null,
    active_mail varchar(200) null,
    constraint pk_user primary key (username),
    constraint uc_user unique (email, phone)
);

create table login_history (
	id int auto_increment,
    date_login bigint not null,
    username varchar(10) not null,
    constraint pk_login_history primary key (id)
);

create table customer (
	id int auto_increment,
    full_name varchar(100) charset utf8 not null,
    email varchar(100) not null,
    phone varchar(10) null,
    password varchar(100) not null,
    salt_code varchar(50) not null,
    date_create bigint not null,
    forget_password varchar(200) null,
    active_email varchar(200) null,
    constraint pk_customer primary key (id),
    constraint uc_customer unique (email, phone)
);

create table catalog (
	id int auto_increment,
    name varchar(100) charset utf8 not null,
    parent_id int not null,
    constraint pk_catalog primary key (id)
);

create table product (
	id int auto_increment,
    name varchar(200) charset utf8,
    decription text charset utf8 not null,
    price decimal(15,2) not null,
    discount int null,
    image_link varchar(100) not null,
    date_create bigint not null,
    catalog_id int not null,
    constraint pk_product primary key (id)
);

create table invoice (
	id int auto_increment,
    date_create bigint not null,
    customer_id int not null,
    user_id varchar(10) not null,
    status bit default 0,
    message VARCHAR(200),
    constraint pk_invoice primary key (id)
);

create table invoice_detail (
	invoice_id int not null,
    product_id int not null,
    price decimal(15,2) not null,
    quanty int not null,
    constraint pk_invoice_detail primary key (invoice_id, product_id)
);


alter table login_history add constraint fk_login_history_user foreign key login_history(username) references user(username);

alter table product add constraint fk_product_catalog foreign key product(catalog_id) references catalog(id);

alter table invoice add constraint fk_invoice_customer foreign key invoice(customer_id) references customer(id);
alter table invoice add constraint fk_invoice_user foreign key invoice(user_id) references user(username);

alter table invoice_detail add constraint fk_invoice_detail_invoice foreign key invoice_detail(invoice_id) references invoice(id);
alter table invoice_detail add constraint fk_invoice_detail_product foreign key invoice_detail(product_id) references product(id);