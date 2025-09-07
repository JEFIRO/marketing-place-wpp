CREATE TABLE loja_produto
(
    id_loja    BIGINT,
    id_produto BIGINT,
    PRIMARY KEY (id_loja, id_produto),
    FOREIGN KEY (id_loja) REFERENCES loja (id),
    FOREIGN KEY (id_produto) REFERENCES produto (id)
);
