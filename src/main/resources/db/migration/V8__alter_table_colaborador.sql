ALTER TABLE colaborado
    ADD CONSTRAINT fk_colaborador_loja FOREIGN KEY (id_loja) REFERENCES loja(id);
