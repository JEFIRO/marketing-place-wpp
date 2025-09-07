ALTER TABLE colaborado
    ADD COLUMN id_loja BIGINT,
    ADD CONSTRAINT fk_colaborador_loja FOREIGN KEY (id_loja) REFERENCES loja(id);
