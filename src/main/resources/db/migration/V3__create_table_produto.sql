CREATE TABLE produto(
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        nome VARCHAR(255) NOT NULL,
                        descricao VARCHAR(255),
                        imagem VARCHAR(255) NOT NULL,
                        quantidade INT,
                        preco DECIMAL(10,2) NOT NULL,
                        promocao DECIMAL(10,2),
                        disponivel BOOLEAN NOT NULL
);