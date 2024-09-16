CREATE TABLE cartorio
(
    id          INT PRIMARY KEY CHECK (id > 0),
    nome        VARCHAR(150) NOT NULL,
    observacao  VARCHAR(250),
    situacao_id VARCHAR(20)  NOT NULL,
    FOREIGN KEY (situacao_id) REFERENCES situacao (id)
);

CREATE TABLE cartorio_atribuicao
(
    cartorio_id   INT,
    atribuicao_id VARCHAR(20),
    PRIMARY KEY (cartorio_id, atribuicao_id),
    FOREIGN KEY (cartorio_id) REFERENCES cartorio (id),
    FOREIGN KEY (atribuicao_id) REFERENCES atribuicao (id)
);
