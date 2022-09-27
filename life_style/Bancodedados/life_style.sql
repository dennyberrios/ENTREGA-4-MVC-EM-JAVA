CREATE DATABASE IF NOT EXISTS life_style;

USE life_style;

CREATE TABLE destino (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(40),
    dataIda DATE DEFAULT NULL,
    dataVolta DATE DEFAULT NULL,
    valor varchar(80) NOT NULL
);

CREATE TABLE hospedagem (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nomeHotel VARCHAR(50) NOT NULL,
    endereco VARCHAR(80) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    valor varchar(80) NOT NULL,
    checkIn DATE DEFAULT NULL,
    checkOut DATE DEFAULT NULL,
    telefoneHotel VARCHAR(15) NOT NULL
);

CREATE TABLE cliente (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cpf VARCHAR(15) NOT NULL UNIQUE,
    nome VARCHAR(80),
    rua VARCHAR(50) NOT NULL,
    bairro VARCHAR(50) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);