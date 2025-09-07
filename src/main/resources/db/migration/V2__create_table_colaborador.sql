CREATE TABLE colaborado(
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           nome VARCHAR(255) NOT NULL,
                           email VARCHAR(255),
                           telefone VARCHAR(50),
                           role VARCHAR(50) NOT NULL,
                           id_loja BIGINT
);
