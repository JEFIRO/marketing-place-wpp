ALTER TABLE produto
    ADD COLUMN added_by BIGINT,
    ADD CONSTRAINT fk_produto_colaborado FOREIGN KEY (added_by) REFERENCES colaborado(id);
