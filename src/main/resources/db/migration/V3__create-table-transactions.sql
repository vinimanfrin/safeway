CREATE TABLE transactions (
    id UUID PRIMARY KEY,
    company_id UUID,
    customer_id UUID,
    type VARCHAR(255),
    value NUMERIC(19,2),
    date_time TIMESTAMP
);

