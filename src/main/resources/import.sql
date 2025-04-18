-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- Fabricantes
INSERT INTO fabricante (nome) VALUES ('NVIDIA');
INSERT INTO fabricante (nome) VALUES ('AMD');
INSERT INTO fabricante (nome) VALUES ('Intel');
INSERT INTO fabricante (nome) VALUES ('ASUS');
INSERT INTO fabricante (nome) VALUES ('Gigabyte');
INSERT INTO fabricante (nome) VALUES ('MSI');
INSERT INTO fabricante (nome) VALUES ('EVGA');
INSERT INTO fabricante (nome) VALUES ('Zotac');
INSERT INTO fabricante (nome) VALUES ('Sapphire');
INSERT INTO fabricante (nome) VALUES ('PowerColor');



-- Especificações Técnicas
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('8 GB GDDR6', '1.8 GHz', '256-bit', '220W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('12 GB GDDR6', '2.1 GHz', '192-bit', '185W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('16 GB GDDR6X', '2.4 GHz', '320-bit', '350W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('10 GB GDDR6', '1.9 GHz', '320-bit', '250W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('24 GB GDDR6X', '2.5 GHz', '384-bit', '450W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('20 GB GDDR6', '2.3 GHz', '320-bit', '400W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('6 GB GDDR6', '1.6 GHz', '192-bit', '160W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('4 GB GDDR5', '1.3 GHz', '128-bit', '75W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('8 GB GDDR6', '1.7 GHz', '128-bit', '120W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('12 GB GDDR6X', '2.0 GHz', '256-bit', '300W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('16 GB GDDR6', '2.2 GHz', '256-bit', '320W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('2 GB GDDR5', '1.1 GHz', '64-bit', '50W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('8 GB GDDR5', '1.5 GHz', '256-bit', '180W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('6 GB GDDR5', '1.4 GHz', '192-bit', '150W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('10 GB GDDR6X', '1.9 GHz', '320-bit', '300W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('24 GB GDDR6', '2.6 GHz', '384-bit', '480W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('8 GB GDDR6', '2.0 GHz', '128-bit', '140W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('4 GB GDDR6', '1.4 GHz', '128-bit', '90W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('6 GB GDDR6X', '2.1 GHz', '192-bit', '210W');
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('12 GB GDDR6X', '2.4 GHz', '384-bit', '370W');





-- Placas de Vídeo
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RTX 3060', 2499.99, 1, 1, 'INTERMEDIARIA', 15, 'rtx3060.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RX 6700 XT', 2899.90, 2, 2, 'INTERMEDIARIA', 8, 'rx6700xt.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 4090', 14999.90, 3, 1, 'ALTO_DESEMPENHO', 3);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('Arc A770', 2199.00, 4, 3, 'ENTRADA', 12, 'arcA770.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 4070 Ti', 5999.99, 5, 1, 'ALTO_DESEMPENHO', 5);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 7900 XTX', 7999.90, 6, 2, 'ALTO_DESEMPENHO', 4);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('GTX 1660 Super', 1299.90, 7, 1, 'ENTRADA', 10, 'gtx1660Super.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('GT 1030', 499.90, 8, 1, 'ENTRADA', 25);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 550', 599.90, 9, 2, 'ENTRADA', 20);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 3080 Ti', 8999.99, 10, 1, 'ALTO_DESEMPENHO', 6);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 6800 XT', 6899.90, 11, 2, 'ALTO_DESEMPENHO', 5);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('GT 710', 399.90, 12, 1, 'ENTRADA', 30);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('GTX 1070', 1099.90, 13, 4, 'INTERMEDIARIA', 7);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 580', 999.90, 14, 2, 'INTERMEDIARIA', 9);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque,nomeImagem) VALUES ('RTX 3080', 7299.90, 15, 1, 'ALTO_DESEMPENHO', 4, 'rtx3080.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 5000 ADA', 18999.90, 16, 1, 'ALTO_DESEMPENHO', 2);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 7600', 2299.90, 17, 2, 'INTERMEDIARIA', 10);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('Arc A580', 1399.00, 18, 3, 'ENTRADA', 15);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 4060 Ti', 3499.90, 19, 1, 'INTERMEDIARIA', 10);
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 7900 GRE', 5999.90, 20, 2, 'ALTO_DESEMPENHO', 6);



-- Usuarios
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('João Silva', 'joao@email.com', 'joao', 'yEaSZv1mx2Hf11tomtEAY3HUG2hrQS2ACE17U1PeCoA7PFIhHARbDredPke5UTKwvMVA+jod2rMVKSoDzm8p3Q==', 'USER');
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Maria Souza', 'maria@email.com', 'maria', 'DzdKfFtHned4y7fLASqK0gH9EqUAMZgn6HuhapPc6l0ycYnZ/AZB2mFjbV5ADHvCpr8u3Vm8SkIIJ55gmKQDdA==', 'USER');
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Admin Sistema', 'admin@email.com', 'admin', 'cQa5YaODDHhULIAmdDvDQ/YyU9jAzqqhz1hzmFU7LB1CHLRrUEgu9r/O5cyup6ghql/1J5J60tVChoWwa5XL6Q==', 'ADMIN');
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Carlos Oliveira', 'carlos@email.com', 'carlos', 'LwO8H16RGVo7K04ST5Lqh58GC1xsha5nCcMJPay3CBfjQ8bN0Jk3+COFXk5NdoGHnxM8KC/p1ehsgQyrbybqjQ==', 'USER');
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Ana Santos', 'ana@email.com', 'ana', 'IJ0d+ackrKX8mdfSDEnwvRxOTd6BNvnlyvWiBlX3Y5ecWIZs+KUWspDHcydPRPqDRpb32/K4hRUJgqqGpL5y2g==', 'USER');


-- Telefones
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '987654321');
INSERT INTO telefone (codigo_area, numero) VALUES ('21', '998877665');
INSERT INTO telefone (codigo_area, numero) VALUES ('31', '912345678');
INSERT INTO telefone (codigo_area, numero) VALUES ('41', '987654321');
INSERT INTO telefone (codigo_area, numero) VALUES ('51', '998877665');
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '912345678');
INSERT INTO telefone (codigo_area, numero) VALUES ('21', '987654321');
INSERT INTO telefone (codigo_area, numero) VALUES ('31', '998877665');
INSERT INTO telefone (codigo_area, numero) VALUES ('41', '912345678');
INSERT INTO telefone (codigo_area, numero) VALUES ('51', '987654321');
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '111111111');
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '222222222');
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '333333333');
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '444444444');
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '555555555');

-- Endereços
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('01001000', 'SP', 'São Paulo', 'Q1', 'Rua Augusta', 100);

INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('20040002', 'RJ', 'Rio de Janeiro', 'Q2', 'Av. Rio Branco', 200);

INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('30120010', 'MG', 'Belo Horizonte', 'Q3', 'Av. Afonso Pena', 300);

INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('40010010', 'BA', 'Salvador', 'Q4', 'Rua Chile', 400);

INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('90040001', 'RS', 'Porto Alegre', 'Q5', 'Rua dos Andradas', 500);

INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('70040903', 'DF', 'Brasília', 'Q6', 'SQS 102', 600);

-- Telefone/Usuario
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (1, 1);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (1, 2);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (2, 3);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (3, 4);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (4, 5);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (5, 6);


-- Endereço/Usuario
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (1, 1);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (2, 2);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (2, 3);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (3, 4);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (4, 5);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (5, 6);


-- Usuário com muitos telefones
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Teste Telefones', 'teste@email.com', 'teste', 'ncg8QgCKC47UwbAXpJhFadrqXg/mrlJW1Eh2En4J8Wf9N7+eEzNk5xwolTs5Jlg4VQKY1lWLUwYGJw6yu/eD+g==', 'USER');

INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 11);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 12);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 13);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 14);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 15);


-- Usuário sem telefone
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Sem Telefone', 'semtel@email.com', 'semtel', '+LtZs51LBOk4auZNQfaKRQlaTG0b6Zt8e7o2hDjHSRQy9Vlmy9uMQFBmc2Ghg6xwBpn+ZpvTJ6I6nug4l/ncDg==', 'USER');


