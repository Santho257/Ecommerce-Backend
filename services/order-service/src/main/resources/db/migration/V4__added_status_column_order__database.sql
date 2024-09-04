CREATE TYPE IF NOT EXISTS Status AS ENUM(
    'ORDERED',
    'PAYMENT_FAILED',
    'SHIPPED',
    'OUT_FOR_DELIVERY',
    'DELIVERED',
    'CANCELED'
);

ALTER TABLE IF EXISTS orders
ADD COLUMN status Status;

CREATE TABLE IF NOT EXISTS orders (
    id INTEGER not null PRIMARY KEY,
    customer_id VARCHAR(255) NOT NULL,
    status Status NOT NULL,
    amount DECIMAL(19, 2) NOT NULL,
    payment_method payment_method NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);