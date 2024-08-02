DROP TABLE if exists order_product;
DROP TABLE if exists orders;

-- Create the 'orders' table
CREATE TABLE if not exists orders (
    id INTEGER not null PRIMARY KEY,
    customer_id VARCHAR(255) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    payment_method payment_method NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
-- Create the 'order_products' table
CREATE TABLE if not exists order_product (
    id INTEGER not null PRIMARY KEY,
    product_id INTEGER NOT NULL,
    quantity DOUBLE PRECISION NOT NULL,
    order_id INTEGER CONSTRAINT fk_order_product REFERENCES orders
);


CREATE SEQUENCE if not exists order_seq INCREMENT BY 50;
CREATE SEQUENCE if not exists order_product_seq INCREMENT BY 50;

