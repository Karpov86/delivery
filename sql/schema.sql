create table orders
(
    id   bigint auto_increment
        primary key,
    data datetime(6) null
);

create table dishes
(
    id       bigint auto_increment
        primary key,
    category varchar(255)   null,
    sale     bit            null,
    price    decimal(19, 2) null,
    title    varchar(255)   null,
    order_id bigint         null,
    constraint FK9i7bdexxjb8go3rndk0ucj4gb
        foreign key (order_id) references orders (id)
);

create table personal_info
(
    id           bigint auto_increment
        primary key,
    email        varchar(255) null,
    phone_number varchar(255) null
);

create table addresses
(
    id               bigint auto_increment
        primary key,
    city             varchar(255) null,
    entrance_number  varchar(255) null,
    flat_number      varchar(255) null,
    house_number     varchar(255) null,
    stage_number     varchar(255) null,
    street           varchar(255) null,
    personal_info_id bigint       null,
    constraint FKghmnubj4avnwxgn4hvhnx1jnp
        foreign key (personal_info_id) references personal_info (id)
);

create table credit_cards
(
    id               bigint auto_increment
        primary key,
    data             varchar(255) null,
    number           varchar(255) null,
    vcc              varchar(255) null,
    personal_info_id bigint       null,
    constraint FKf4lqueasbu48c75vvcmk7bb3c
        foreign key (personal_info_id) references personal_info (id)
);

create table users
(
    id               bigint auto_increment
        primary key,
    login            varchar(255) null,
    password         varchar(255) null,
    role             varchar(255) null,
    personal_info_id bigint       null,
    constraint FK3gv2nmhlal71u42s59b0ruwjl
        foreign key (personal_info_id) references personal_info (id)
);



