CREATE TABLE companies(
    id UUID PRIMARY KEY ,
    name varchar(150) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
);
