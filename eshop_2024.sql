--create database eshop_2024;

use eshop_2024;
go;

create table Account
(
    id           int identity (1,1) primary key,
    [user]       varchar(255),
    password     varchar(255),
    email        nvarchar(255),
    phone        int,
    describe     nvarchar(255),
    created_date date,
    role         nvarchar(255),
);

create table category
(
    id          int identity (1,1) primary key,
    name        nvarchar(255),
    description nvarchar(255),
)

create table sub_category
(
    id          int identity (1,1) primary key,
    name        nvarchar(255),
    category_id int foreign key references category (id)
);

create table product
(
    id             int identity (1,1) primary key,
    name           nvarchar(255),
    price          float,
    category_id    int foreign key references category (id),
    sub_category   nvarchar(255),
    description    nvarchar(255),
    content        nvarchar(255),
    hidden_content nvarchar(255),
    created_date   date,
    created_by     nvarchar(255),
)

create table images
(
    id         int identity (1,1) primary key,
    url        nvarchar(255),
    product_id int foreign key references product (id),
);

create table [order]
(
    id           int identity (1,1) primary key,
    total        float,
    buyer        nvarchar(255),
    buyer_id     int foreign key references Account (id),
    receiver     nvarchar(255),
    receiver_id  int foreign key references Account (id),
    created_date date,
    created_by   nvarchar(255)
);

create table order_detail
(
    id         int identity (1,1) primary key,
    quantity   int,
    price      float,
    product_id int foreign key references product (id),
    order_id   int foreign key references [order] (id)
)

create table wallet
(
    id         int identity (1,1) primary key,
    amount     float default 0,
    account_id int foreign key references Account (id),
);

create table [transaction]
(
    id               int identity (1,1) primary key,
    transaction_date date,
    amount           float default 0,
    order_id         int foreign key references [order] (id),
    wallet_id        int foreign key references wallet (id),
);










