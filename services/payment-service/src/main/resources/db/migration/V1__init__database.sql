CREATE TYPE payment_method AS ENUM (
    'CREDIT_CARD',
    'UPI',
    'DEBIT_CARD',
    'NET_BANKING',
    'CASH_ON_DELIVERY'
);

-- Create the 'payment' table
CREATE TABLE payment (
    id UUID PRIMARY KEY,
    amount DECIMAL(19, 2) NOT NULL,
    payment_method VARCHAR(255) NOT NULL,
    order_id INTEGER NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);