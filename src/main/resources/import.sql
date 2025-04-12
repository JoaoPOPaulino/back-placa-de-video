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
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 3060', 2499.99, 'rtx3060.jpg', 1, 1, 'INTERMEDIARIA', 15);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 6700 XT', 2899.90, 'rx6700xt.jpg', 2, 2, 'INTERMEDIARIA', 8);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 4090', 14999.90, 'rtx4090.jpg', 3, 1, 'ALTO_DESEMPENHO', 3);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('Arc A770', 2199.00, 'arca770.jpg', 4, 3, 'ENTRADA', 12);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 4070 Ti', 5999.99, 'rtx4070ti.jpg', 5, 1, 'ALTO_DESEMPENHO', 5);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 7900 XTX', 7999.90, 'rx7900xtx.jpg', 6, 2, 'ALTO_DESEMPENHO', 4);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('GTX 1660 Super', 1299.90, 'gtx1660super.jpg', 7, 1, 'ENTRADA', 10);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('GT 1030', 499.90, 'gt1030.jpg', 8, 1, 'ENTRADA', 25);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 550', 599.90, 'rx550.jpg', 9, 2, 'ENTRADA', 20);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 3080 Ti', 8999.99, 'rtx3080ti.jpg', 10, 1, 'ALTO_DESEMPENHO', 6);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 6800 XT', 6899.90, 'rx6800xt.jpg', 11, 2, 'ALTO_DESEMPENHO', 5);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('GT 710', 399.90, 'gt710.jpg', 12, 1, 'ENTRADA', 30);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('GTX 1070', 1099.90, 'gtx1070.jpg', 13, 4, 'INTERMEDIARIA', 7);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 580', 999.90, 'rx580.jpg', 14, 2, 'INTERMEDIARIA', 9);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 3080', 7299.90, 'rtx3080.jpg', 15, 1, 'ALTO_DESEMPENHO', 4);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 5000 ADA', 18999.90, 'rtx5000ada.jpg', 16, 1, 'ALTO_DESEMPENHO', 2);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 7600', 2299.90, 'rx7600.jpg', 17, 2, 'INTERMEDIARIA', 10);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('Arc A580', 1399.00, 'arca580.jpg', 18, 3, 'ENTRADA', 15);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RTX 4060 Ti', 3499.90, 'rtx4060ti.jpg', 19, 1, 'INTERMEDIARIA', 10);
INSERT INTO placaDeVideo (nome, preco, nome_imagem, id_especificacao_tecnica, id_fabricante, categoria, estoque) VALUES ('RX 7900 GRE', 5999.90, 'rx7900gre.jpg', 20, 2, 'ALTO_DESEMPENHO', 6);

