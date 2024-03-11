CREATE TABLE customers (
    id UUID PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    balance NUMERIC(19,2),
    password VARCHAR(255),
    cpf VARCHAR(255) UNIQUE
);