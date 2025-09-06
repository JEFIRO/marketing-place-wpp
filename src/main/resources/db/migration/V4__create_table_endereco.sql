CREATE TABLE endereco(
    id int PRIMARY KEY AUTO_INCREMENT,
    cep varchar(9),
    rua varchar(255),
    numero varchar(30),
    complemento varchar(255),
    bairro varchar(100),
    cidade varchar(100),
    estado varchar(100)
);
