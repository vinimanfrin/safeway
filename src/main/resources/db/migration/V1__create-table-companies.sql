CREATE TABLE companies (
    id UUID PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    balance NUMERIC(19,2),
    password VARCHAR(255),
    cnpj VARCHAR(255) UNIQUE,
    fee NUMERIC(19,2)
);