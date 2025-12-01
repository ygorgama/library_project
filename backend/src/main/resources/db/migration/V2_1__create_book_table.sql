CREATE TABLE IF NOT EXISTS book (
    id bigint not null auto_increment primary key,
    name varchar(200) not null unique,
    quantity int not null,
    price float(10, 2) not null,
    author_id bigint,
    REFERENCES author(author_id)
    ON DELETE CASCADE,
    ON UPDATE CASCADE
)