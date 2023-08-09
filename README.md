# ControleDeAcesso
Controle de acesso para a comunidade externa acessar os projetos a serem apresentados no Mundo SENAI na instituição SESI/SENAI/IEL Pato Branco-PR.

Java 17
Spring Boot 3.1.2
Dependências: Spring Web, PostgreSQL Driver, Spring Data JPA, Spring Session e Thymeleaf

--

Comandos para criação das tabelas do Banco de Dados:

CREATE TABLE pessoa(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL UNIQUE,
	cpf bigint NOT NULL UNIQUE,
	telefone bigint,
	email varchar(255), 
	senha varchar(255) NOT NULL)
