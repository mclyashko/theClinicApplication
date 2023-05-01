CREATE TABLE APP_USER
(
    ID             BIGSERIAL       NOT NULL
        CONSTRAINT APP_USER_PKEY
            PRIMARY KEY,
    APP_USER_ROLE  VARCHAR(255) NOT NULL,
    DATE_OF_BIRTH  TIMESTAMP    NOT NULL,
    EMAIL          VARCHAR(255) NOT NULL
        CONSTRAINT EMAIL_UNIQUE
            UNIQUE,
    GENDER         VARCHAR(255) NOT NULL,
    NAME           VARCHAR(255) NOT NULL,
    PASSWORD       VARCHAR(255) NOT NULL,
    PATRONYMIC     VARCHAR(255) NOT NULL,
    PHONE_NUMBER   VARCHAR(11)  NOT NULL
        CONSTRAINT PHONE_NUMBER_UNIQUE
            UNIQUE,
    SURNAME        VARCHAR(255) NOT NULL,
    ARTIST_INFO_ID BIGINT
        CONSTRAINT ARTIST_INFO_ID_REFERENCES_ARTIST_INFO
            REFERENCES ARTIST_INFO
);

INSERT INTO APP_USER (app_user_role, date_of_birth, email, gender, name, password, patronymic,
                      phone_number, surname, artist_info_id)
VALUES ('PATIENT', '2011-11-11 00:00:00.000000', '1@1.ru', 'MALE', '1',
        '$2a$10$Thvior7hWs6.AHvSEck3Sew5lS3ngyM3sSY6roGrpHWv5DxClPY5e', '1', '11111111111', '1',
        null);
INSERT INTO APP_USER (app_user_role, date_of_birth, email, gender, name, password, patronymic,
                      phone_number, surname, artist_info_id)
VALUES ('PATIENT', '2022-12-22 00:00:00.000000', '2@2.ru', 'MALE', '2',
        '$2a$10$5smK3iU.NFD4sFgwGBmq1.6pqjvD.DXIn5jRmFMMm5niyQgUayUzi', '2', '22222222222', '2',
        null);
INSERT INTO APP_USER (app_user_role, date_of_birth, email, gender, name, password, patronymic,
                      phone_number, surname, artist_info_id)
VALUES ('PATIENT', '2003-12-31 00:00:00.000000', '3@3.ru', 'MALE', '3',
        '$2a$10$JrVYf0PlEUqK7Gy0HHU.feh2iC1jl7EHNRllXx.E58THjA2ilV2Le', '3', '33333333333', '3',
        null);
INSERT INTO APP_USER (app_user_role, date_of_birth, email, gender, name, password, patronymic,
                      phone_number, surname, artist_info_id)
VALUES ('DOCTOR', '2006-06-06 00:00:00.000000', '6@6.ru', 'FEMALE', '6',
        '$2a$10$p.SoAYXZY54YxXgMrbF10uPzbHndHDMhtqQIJcywP8/EN8xkceCj.', '6', '66666666666', '6', 3);
INSERT INTO APP_USER (app_user_role, date_of_birth, email, gender, name, password, patronymic,
                      phone_number, surname, artist_info_id)
VALUES ('DOCTOR', '2005-12-31 00:00:00.000000', '5@5.ru', 'MALE', '5',
        '$2a$10$wzVvixqcbrSPuOSDPd9tW.ycOfGCo/BBKilLS1y27b1CFN4HNRd.K', '5', '55555555555', '5', 2);
INSERT INTO APP_USER (app_user_role, date_of_birth, email, gender, name, password, patronymic,
                      phone_number, surname, artist_info_id)
VALUES ('DOCTOR', '2004-04-04 00:00:00.000000', '4@4.ru', 'FEMALE', '4',
        '$2a$10$8SuebndPN1PNZJsMqJiPvOoitsyI8eKnE43nC2wTnAWfkjqL/8hna', '4', '44444444444', '4', 1);
