-- V1__Create_Orders_And_OrderProducts_Tables.sql

-- Create the 'payment_method' type
CREATE TYPE payment_method AS ENUM (
    'CREDIT_CARD',
    'UPI',
    'DEBIT_CARD',
    'NET_BANKING',
    'CASH_ON_DELIVERY'
);

-- Create the 'orders' table
CREATE TABLE orders (
    id SERIAL PRIMARY KEY,
    customer_id VARCHAR(255) NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    payment_method payment_method NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Create the 'order_products' table
CREATE TABLE order_product (
    id SERIAL PRIMARY KEY,
    product_id INTEGER NOT NULL,
    quantity DOUBLE PRECISION NOT NULL,
    order_id INTEGER CONSTRAINT fk_order_product REFERENCES orders
);


