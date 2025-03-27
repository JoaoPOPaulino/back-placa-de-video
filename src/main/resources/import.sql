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




-- Placas de Vídeo
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 3060', 2499.99, 'rtx3060.jpg', 1, 1, 'INTERMEDIARIA', 15);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 6700 XT', 2899.90, 'rx6700xt.jpg', 2, 2, 'INTERMEDIARIA', 8);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 4090', 14999.90, 'rtx4090.jpg', 3, 1, 'ALTO_DESEMPENHO', 3);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('Arc A770', 2199.00, 'arca770.jpg', 4, 3, 'ENTRADA', 12);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 4070 Ti', 5999.99, 'rtx4070ti.jpg', 5, 1, 'ALTO_DESEMPENHO', 5);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 7900 XTX', 7999.90, 'rx7900xtx.jpg', 6, 2, 'ALTO_DESEMPENHO', 4);
