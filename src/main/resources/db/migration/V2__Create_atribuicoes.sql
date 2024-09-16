CREATE TABLE atribuicao
(
    id       VARCHAR(20) PRIMARY KEY,
    nome     VARCHAR(50) NOT NULL,
    situacao BOOLEAN     NOT NULL DEFAULT TRUE
);
