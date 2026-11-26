CREATE TABLE users(
    id UUID primary key,
    company_id UUID NOT NULL REFERENCES companies(id),
    full_name varchar(50) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    phone varchar(13) NOT NULL UNIQUE ,
    role varchar(30) NOT NULL,
    password_hash varchar(64) NOT NULL,
    is_active boolean,
    created_at TIMESTAMPTZ NOT NULL,
    updated_at TIMESTAMPTZ NOT NULL
);