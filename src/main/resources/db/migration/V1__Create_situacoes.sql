CREATE TABLE situacao
(
    id   VARCHAR(20) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
);

INSERT INTO situacao (id, nome)
VALUES ('SIT_ATIVO', 'Ativo');
INSERT INTO situacao (id, nome)
VALUES ('SIT_BLOQUEADO', 'Bloqueado');
