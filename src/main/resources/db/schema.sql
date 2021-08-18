create table passport (
    id serial primary key,
    serial integer,
    number integer,
    created timestamp without time zone not null default now(),
    UNIQUE (serial, number)
);