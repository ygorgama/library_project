CREATE TABLE IF NOT EXISTS author (
    id bigint not null auto_increment PRIMARY KEY,
    first_name varchar(50) not null,
    last_name varchar(60) not null
);