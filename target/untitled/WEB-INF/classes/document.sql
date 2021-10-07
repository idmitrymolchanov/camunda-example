DROP TABLE IF EXISTS DOCUMENT;

CREATE TABLE DOCUMENT
(
    id BIGINT,
    name VARCHAR(255),
    mark VARCHAR(30),
    created BOOLEAN,
    signature BOOLEAN,
    signature_level VARCHAR(30)
);

INSERT INTO DOCUMENT (id, name, mark, created, signature, signature_level) VALUES (1, 'test_name', 'high', true, false, null);