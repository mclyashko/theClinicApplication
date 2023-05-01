CREATE TABLE RECORD
(
    ID           BIGSERIAL       NOT NULL
        CONSTRAINT RECORD_PKEY
            PRIMARY KEY,
    DATE_TIME    TIMESTAMP    NOT NULL,
    VERDICT      VARCHAR(255) NOT NULL,
    CLIENT_ID    BIGINT
        CONSTRAINT CLIENT_ID_REFERENCES_APP_USER
            REFERENCES APP_USER,
    PROCEDURE_ID BIGINT
        CONSTRAINT PROCEDURE_ID_REFERENCES_PROCEDURE
            REFERENCES PROCEDURE
);

INSERT INTO RECORD (date_time, verdict, client_id, procedure_id)
VALUES ('2007-10-12 12:30:00.000000', 'None', 1, 1);
INSERT INTO RECORD (date_time, verdict, client_id, procedure_id)
VALUES ('2022-11-29 10:10:00.000000', 'Вы Здоровы', 1, 3);
INSERT INTO RECORD (date_time, verdict, client_id, procedure_id)
VALUES ('2023-12-01 15:50:00.000000', 'Лучше проверить еще раз!', 2, 1);
INSERT INTO RECORD (date_time, verdict, client_id, procedure_id)
VALUES ('2022-12-31 15:50:00.000000', 'Все хорошо', 2, 1);
INSERT INTO RECORD (date_time, verdict, client_id, procedure_id)
VALUES ('2023-01-15 09:00:00.000000', 'None', 2, 2);
