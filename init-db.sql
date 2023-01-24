CREATE SCHEMA IF NOT EXISTS product_store;

CREATE SEQUENCE IF NOT EXISTS product_store.product_store_id_seq;

CREATE TABLE IF NOT EXISTS product_store.order
(
    id                  integer NOT NULL DEFAULT nextval('product_store.product_store_id_seq'),
    date                date NOT NULL,
    cost                numeric NOT NULL,
    primary key(id)
);

CREATE TABLE IF NOT EXISTS product_store.product
(
    id                  integer NOT NULL DEFAULT nextval('product_store.product_store_id_seq'),
    fk_order_id         integer constraint data_source_fk_connection_id_fkey
                        references product_store.order,
    name                text NOT NULL UNIQUE,
    cost                numeric NOT NULL,
    primary key(id)
);

