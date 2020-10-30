CREATE TABLE AUTHOR
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(100)  NOT NULL,
    surname     VARCHAR(150)  NOT NULL,
    description VARCHAR(2000) NULL,
    born_date   timestamp
);

CREATE TABLE BOOK
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    author_id    BIGINT        NOT NULL,
    title        VARCHAR(150)  NOT NULL,
    description  VARCHAR(2000) NULL,
    release_date timestamp
);

CREATE TABLE ADDRESS
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    town        VARCHAR(100)  NOT NULL,
    street      VARCHAR(150)  NOT NULL,
    postal_code VARCHAR(2000) NOT NULL
);

CREATE TABLE LIBRARY
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    address_id      BIGINT        NOT NULL,
    library_name    VARCHAR(200)  NOT NULL,
    library_details VARCHAR(2000) NULL
);

CREATE TABLE USERS
(
    username VARCHAR(50) PRIMARY KEY,
    password varchar(200) NOT NULL,
    enabled  BOOLEAN      NOT NULL
);

CREATE TABLE AUTHORITIES
(
    username VARCHAR(50) PRIMARY KEY ,
    authority VARCHAR(50)
);

ALTER TABLE LIBRARY
    ADD CONSTRAINT library_address_id
        FOREIGN KEY (address_id) REFERENCES ADDRESS (id);

ALTER TABLE AUTHORITIES
    ADD CONSTRAINT username
        FOREIGN KEY (username) REFERENCES USERS (username);

ALTER TABLE BOOK
    ADD CONSTRAINT book_author_id
        FOREIGN KEY (author_id) REFERENCES AUTHOR (id);