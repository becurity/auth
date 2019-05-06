CREATE TABLE USER(
                     ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                     FIRST_NAME VARCHAR(64),
                     LAST_NAME VARCHAR(64),
                     EMAIL VARCHAR(64) NOT NULL,
                     PASSWORD VARCHAR(64) NOT NULL,
);
