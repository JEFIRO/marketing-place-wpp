ALTER TABLE loja

ADD COLUMN id_colaborador INT NOT NULL,
ADD COLUMN id_endereco INT NOT NULL,
ADD COLUMN id_produto INT NOT NULL,

ADD CONSTRAINT fk_colaborador FOREIGN KEY (id_colaborador) REFERENCES colaborado(id),
ADD CONSTRAINT fk_endereco FOREIGN KEY (id_endereco) REFERENCES endereco(id),
ADD CONSTRAINT fk_produto FOREIGN KEY (id_produto) REFERENCES produto(id);
