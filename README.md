# ControleDeAcesso
Controle de acesso para a comunidade externa acessar os projetos a serem apresentados no Mundo SENAI na instituição SESI/SENAI/IEL Pato Branco-PR.

Java 17
Spring Boot 3.1.2
Dependências: Spring Web, PostgreSQL Driver, Spring Data JPA, Spring Session e Thymeleaf

--

Comandos Banco de Dados:

CREATE TABLE pessoa(
id SERIAL PRIMARY KEY,
nome VARCHAR(255) NOT null,
cpf bigint not null,
telefone bigint,
email varchar(255),
senha varchar(255) NOT NULL
nome VARCHAR(255) NOT NULL UNIQUE,
cpf BIGINT NOT NULL,
telefone BIGINT,
email VARCHAR(255),
senha VARCHAR(255) NOT NULL
)
