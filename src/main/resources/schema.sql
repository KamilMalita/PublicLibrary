CREATE TABLE AUTHOR(
    id BIGINT AUTO_INCREMENT PRIMARY KEY ,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(150) NOT NULL,
    description VARCHAR(2000) NULL,
    born_date timestamp
);

CREATE TABLE BOOK(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    author_id BIGINT,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(2000) NULL,
    release_date timestamp
);

ALTER TABLE BOOK
    ADD CONSTRAINT book_author_id
    FOREIGN KEY (author_id) REFERENCES AUTHOR(id);