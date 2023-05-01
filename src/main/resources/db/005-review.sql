CREATE TABLE REVIEW
(
    ID         BIGSERIAL NOT NULL PRIMARY KEY,
    OWNER_ID   BIGINT    NOT NULL,
    RATING     SMALLINT,
    COMMENTARY VARCHAR(1023),
    PUBLISHING_TIME TIMESTAMP,
    FOREIGN KEY (OWNER_ID) REFERENCES APP_USER (ID)
);

INSERT INTO REVIEW
    (OWNER_ID, RATING, COMMENTARY, PUBLISHING_TIME)
VALUES (1,
        5,
        'Все очень хорошо',
        '2022-11-11'::timestamp),
       (2,
        4,
        'Есть над чем работать',
        '2022-03-31'::timestamp);