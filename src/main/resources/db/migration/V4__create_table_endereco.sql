CREATE TABLE endereco(
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         cep VARCHAR(9),
                         rua VARCHAR(255),
                         numero VARCHAR(30),
                         complemento VARCHAR(255),
                         bairro VARCHAR(100),
                         cidade VARCHAR(100),
                         estado VARCHAR(100)
);