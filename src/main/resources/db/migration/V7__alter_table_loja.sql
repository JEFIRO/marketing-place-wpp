ALTER TABLE loja
    ADD COLUMN id_colaborador BIGINT,
    ADD COLUMN id_endereco BIGINT,
    ADD CONSTRAINT fk_loja_colaborador FOREIGN KEY (id_colaborador) REFERENCES colaborado(id),
    ADD CONSTRAINT fk_loja_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id);
