ALTER TABLE loja
    ADD COLUMN status BOOL default true,
    ADD COLUMN data_cadastro TIMESTAMP default now(),
    ADD COLUMN data_atualizacao TIMESTAMP default now(),
    ADD COLUMN data_exclusao TIMESTAMP,
    ADD COLUMN cnpj VARCHAR(14);