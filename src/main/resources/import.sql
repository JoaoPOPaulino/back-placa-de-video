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
INSERT INTO fabricante (nome) VALUES ('Teste');

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
INSERT INTO especificacaoTecnica (memoria, clock, barramento, consumoEnergia) VALUES ('Teste', 'Teste', 'Teste', 'Teste');

-- Placas de Vídeo
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem, descricao) VALUES ('RTX 3060', 2499.99, 1, 1, 'INTERMEDIARIA', 15, 'rtx3060.jpg', 'Placa de vídeo intermediária com excelente desempenho para jogos em 1080p e 1440p.');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem, descricao) VALUES ('RX 6700 XT', 2899.90, 2, 2, 'INTERMEDIARIA', 8, 'rx6700xt.jpg', 'Ideal para jogos em 1440p com ray tracing e ótimo custo-benefício.');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem, descricao) VALUES ('RTX 4090', 14999.90, 3, 1, 'ALTO_DESEMPENHO', 3, 'rtx4090.jpg', 'Placa topo de linha para jogos em 4K e tarefas de renderização intensivas.');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('Arc A770', 2199.00, 4, 3, 'ENTRADA', 12, 'arcA770.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RTX 4070 Ti', 5999.99, 5, 1, 'ALTO_DESEMPENHO', 5, 'rtx4070ti.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RX 7900 XTX', 7999.90, 6, 2, 'ALTO_DESEMPENHO', 4, 'rx7900xtx.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('GTX 1660 Super', 1299.90, 7, 1, 'ENTRADA', 10, 'gtx1660Super.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('GT 1030', 499.90, 8, 1, 'ENTRADA', 25, 'gt1030.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RX 550', 599.90, 9, 2, 'ENTRADA', 20, 'rx550.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RTX 3080 Ti', 8999.99, 10, 1, 'ALTO_DESEMPENHO', 6, 'rtx3080ti.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RX 6800 XT', 6899.90, 11, 2, 'ALTO_DESEMPENHO', 5, 'rx6800xt.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('GT 710', 399.90, 12, 1, 'ENTRADA', 30, 'gt710.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('GTX 1070', 1099.90, 13, 4, 'INTERMEDIARIA', 7, 'gtx1070.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RX 580', 999.90, 14, 2, 'INTERMEDIARIA', 9, 'rx580.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RTX 3080', 7299.90, 15, 1, 'ALTO_DESEMPENHO', 4, 'rtx3080.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RTX 5000 ADA', 18999.90, 16, 1, 'ALTO_DESEMPENHO', 2, 'rtx5000ada.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RX 7600', 2299.90, 17, 2, 'INTERMEDIARIA', 10, 'rx7600.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('Arc A580', 1399.00, 18, 3, 'ENTRADA', 15, 'ARCa580.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RTX 4060 Ti', 3499.90, 19, 1, 'INTERMEDIARIA', 10, 'rtx4060ti.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('RX 7900 GRE', 5999.90, 20, 2, 'ALTO_DESEMPENHO', 6, 'rx7900gre.jpg');
INSERT INTO placaDeVideo (nome, preco, id_especificacao_tecnica, id_fabricante, categoria, estoque, nomeImagem) VALUES ('Teste', 0.50, 21, 11, 'ALTO_DESEMPENHO', 6, 'teste.png');

-- Usuarios
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('João Silva', 'joao@email.com', 'joao', 'TRwn0XU29Gwl2sagG00bvjrNJvLuYo+dbOBJ7R3xFpU4m/FAUc5q8OoGbVNwPF7F5713RaYkN4qyufNCDHm/mA==', 'USER');
-- senha 123
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Maria Souza', 'maria@email.com', 'maria', '1BTSU7LatsY6BK9FYiXT9du++eWLisRMBwGyxbRSh0ZpH0p3jIIAWh1+Ta/zBagkeJa/NwPo5XngKb/REUH74g==', 'USER');
-- senha 111
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Admin Sistema', 'admin@email.com', 'admin', 'xyolfJJXZD9DlkfB2efO5EsTaPo0oB0Z3wcZ4c7guhVnzpswUQ42+7knYc7eAG40zmXrKe7b41Evi8pyZLd//A==', 'ADMIN');
-- senha 222
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Carlos Oliveira', 'carlos@email.com', 'carlos', 'BRVpCk1+DGvzjp5/FB65aArxUVaByFDm4xJtI8bKZrZEpEj4slXG0OrjrxCz5BvV9euVpFYG+Ba897WGPQlD1g==', 'USER');
-- senha 333
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Ana Santos', 'ana@email.com', 'ana', '7b6H1t+j+wF78ubzUKE1nywHSSZ2mUzrEDKwmAoBCiYuJ/3DWGT3QvQfhmaX+iwYJrYAb2PUOG9XV8fkiXW+fQ==', 'USER');
-- senha 444
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Teste Telefones', 'teste@email.com', 'teste', '93QL7Y9NhbbGlrUMBFlozccxq5sw0v4kcfkoApn8hB5eVW9YCN8OsamwEyCIhjkdik/U9Khf+107XnTFnu/xkw==', 'USER');
-- senha 555
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Sem Telefone', 'semtel@email.com', 'semtel', 'H7rfcAXwQxE81ZnB/uXhEsJMEceqnOqy32gmn86SkaQ3iFbv4zHEt/kD4iwa+C8dVp99fGX2lPqFWRtSG5hzDw==', 'USER');
-- senha 666
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('jp', 'joaopedrojpjp4@gmail.com', 'jpuser', 'aQu9iDxdP/UCaZL+pAjhK0OTAGBBCb+WHXaCfyRnK20cuQARzBRTYhx8/x3iTU4mk7RZZgclleVkk3VE9h/2sA==', 'USER');
-- senha: jpuser
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('jp', 'jpp@email.com', 'jpadmin', 'AMeHn4LlleJ3bhBYsIegH+ePHp+t7XprZ2pACpKh3XtZqun1vZvKmMNYYYHbI5XL75EYZfxWuc8TWwbCeeqv9w==', 'ADMIN');
-- senha: jpadmin
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('testeete', 'testtee@email.com', 'teste123', 'aQu9iDxdP/UCaZL+pAjhK0OTAGBBCb+WHXaCfyRnK20cuQARzBRTYhx8/x3iTU4mk7RZZgclleVkk3VE9h/2sA==', 'USER');
-- senha: jpuser

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
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 11);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 12);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 13);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 14);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (6, 15);

-- Endereço/Usuario
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (1, 1);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (2, 2);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (2, 3);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (3, 4);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (4, 5);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (5, 6);

-- Avaliações
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(1, 1, 'CINCO', 'Ótima placa para jogos modernos, roda tudo no ultra!', '2024-10-01 14:30:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(2, 1, 'QUATRO', 'Bom desempenho, mas o preço está um pouco alto.', '2024-10-05 09:15:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(4, 2, NULL, 'Estou gostando bastante, mas ainda testando.', '2024-11-10 18:45:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(5, 3, 'CINCO', 'Monstro de desempenho, vale cada centavo!', '2024-12-01 12:00:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(1, 4, 'TRES', 'Boa para entrada, mas esperava mais potência.', '2025-01-15 16:20:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(2, 5, 'QUATRO', 'Excelente para 4K, mas consome muita energia.', '2025-02-01 10:30:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(6, 7, NULL, 'Funciona bem para jogos leves, bom custo-benefício.', '2025-03-01 14:00:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(8, 8, 'DOIS', 'Muito básica, não recomendo para jogos.', '2025-04-10 08:50:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(10, 10, 'CINCO', 'Perfeita para renderização e jogos pesados.', '2025-05-01 19:30:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(5, 15, 'QUATRO', 'Ótima placa, mas o cooler é um pouco barulhento.', '2025-06-01 11:10:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(3, 2, 'QUATRO', 'Boa performance em jogos em 1440p, mas esquenta bastante', '2024-10-08 15:22:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(4, 3, 'CINCO', 'Absolutamente incrível para jogos em 4K e edição de vídeo', '2024-10-12 09:45:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(5, 6, 'QUATRO', 'AMD acertou com esta placa, competidora direta das RTX', '2024-10-18 17:30:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(6, 9, 'TRES', 'Boa para o básico, mas não espere milagres', '2024-10-22 11:20:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(7, 11, 'CINCO', 'Melhor custo-benefício na categoria alto desempenho', '2024-10-25 14:15:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(8, 12, 'UM', 'Muito fraca, não atende às expectativas mínimas', '2024-10-30 10:00:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(9, 13, 'QUATRO', 'Placa veterana que ainda entrega bom desempenho', '2024-11-05 16:45:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(1, 14, 'TRES', 'Boa, mas já está mostrando a idade em jogos novos', '2024-11-12 13:10:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(2, 16, 'CINCO', 'Monstro absoluto para trabalho profissional', '2024-11-18 18:20:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(3, 17, 'QUATRO', 'Ótima opção intermediária da AMD', '2024-11-22 12:30:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(4, 18, 'DOIS', 'Performance abaixo do esperado para o preço', '2024-11-28 09:15:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(5, 19, 'QUATRO', 'Excelente upgrade da série 3060', '2024-12-03 14:50:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(6, 20, 'CINCO', 'AMD acertou em cheio com esta versão GRE', '2024-12-10 17:25:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(7, 1, 'CINCO', 'Depois de 3 meses de uso, continua impecável', '2024-12-15 11:40:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(8, 2, 'TRES', 'Boa, mas drivers ainda precisam melhorar', '2024-12-20 10:05:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(9, 3, 'CINCO', 'Não existe jogo que esta placa não rode no máximo', '2024-12-25 15:30:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(1, 5, 'QUATRO', 'Potência bruta, mas o preço é salgado', '2025-01-05 14:15:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(2, 7, 'TRES', 'Cumpriu bem para jogos mais antigos', '2025-01-12 09:50:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(3, 10, 'CINCO', 'Perfeita para meu setup de streaming', '2025-01-18 16:35:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(4, 15, 'QUATRO', 'NVIDIA continua dominando o mercado high-end', '2025-01-25 12:20:00');
INSERT INTO avaliacao (id_usuario, id_placa_de_video, nota, comentario, dataCriacao) VALUES
(5, 19, 'CINCO', 'Melhor placa intermediária que já tive', '2025-02-01 18:10:00');


-- Novos usuários (11 a 25)
INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Pedro Almeida', 'pedro@email.com', 'pedro', 'XUv4J7Kz9PwQmRnVpYsWt2x5z8BvCdEfGhIjKlMnOp0qRsTuVwXyZ1A3B4C5D6E7F8G9H0I1J2K3L4M5N6O7P8Q9R0S1T2U3V4W5X6Y7Z8', 'USER');
-- senha: pedro123

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Fernanda Lima', 'fernanda@email.com', 'fernanda', 'YhV5K8L0aQxSnWt3y6z9BvCdEfGhIjKlMnOp0qRsTuVwXyZ1A3B4C5D6E7F8G9H0I1J2K3L4M5N6O7P8Q9R0S1T2U3V4W5X6Y7Z8', 'USER');
-- senha: fernanda456

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Ricardo Oliveira', 'ricardo@email.com', 'ricardo', 'ZiW6L9M1bRyToXu4a7c0DvEfGhIjKlMnOp0qRsTuVwXyZ1A3B4C5D6E7F8G9H0I1J2K3L4M5N6O7P8Q9R0S1T2U3V4W5X6Y7Z8', 'USER');
-- senha: ricardo789

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Camila Santos', 'camila@email.com', 'camila', 'AjX7M0N2cSzUpYv5b8d1EwFgHhIiJlKmNoPq0rStUvXwYyZ2A3B4C5D6E7F8G9H0I1J2K3L4M5N6O7P8Q9R0S1T2U3V4W5X6Y7Z8', 'USER');
-- senha: camila101

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Lucas Pereira', 'lucas@email.com', 'lucas', 'BkY8N1O3dTaVqZw6c9e2FxGgHhIiJlKmNoPq0rStUvXwYyZ2A3B4C5D6E7F8G9H0I1J2K3L4M5N6O7P8Q9R0S1T2U3V4W5X6Y7Z8', 'USER');
-- senha: lucas202

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Juliana Costa', 'juliana@email.com', 'juliana', 'ClZ9O2P4eUbWrAx7d0f3GyHhIiJlKmNoPq0rStUvXwYyZ2A3B4C5D6E7F8G9H0I1J2K3L4M5N6O7P8Q9R0S1T2U3V4W5X6Y7Z8', 'USER');
-- senha: juliana303

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Marcos Ribeiro', 'marcos@email.com', 'marcos', 'Dm0P3Q5fVcXsBy8e1g4HzIiJlKmNoPq0rStUvXwYyZ2A3B4C5D6E7F8G9H0I1J2K3L4M5N6O7P8Q9R0S1T2U3V4W5X6Y7Z8', 'USER');
-- senha: marcos404

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Patricia Alves', 'patricia@email.com', 'patricia', 'En1Q4R6gWdYtCz9f2h5I0JjKlMmNnPoQr1sTuVwXxYyZ3A4B5C6D7E8F9G0H1I2J3K4L5M6N7O8P9Q0R1S2T3U4V5W6X7Y8Z9', 'USER');
-- senha: patricia505

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Gustavo Ferreira', 'gustavo@email.com', 'gustavo', 'Fo2R5S7hXeZuD0g3i6J1KkLlMmNnPoQr1sTuVwXxYyZ3A4B5C6D7E8F9G0H1I2J3K4L5M6N7O8P9Q0R1S2T3U4V5W6X7Y8Z9', 'USER');
-- senha: gustavo606

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Isabela Martins', 'isabela@email.com', 'isabela', 'Gp3S6T8iYfAvE1h4j7K2LlMmNnPoQr1sTuVwXxYyZ3A4B5C6D7E8F9G0H1I2J3K4L5M6N7O8P9Q0R1S2T3U4V5W6X7Y8Z9', 'USER');
-- senha: isabela707

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Roberto Nunes', 'roberto@email.com', 'roberto', 'Hq4T7U9jZgBwF2i5k8L3MmNnOoPpRr2sTuVvWwXxYyZ4A5B6C7D8E9F0G1H2I3J4K5L6M7N8O9P0Q1R2S3T4U5V6W7X8Y9Z0', 'USER');
-- senha: roberto808

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Amanda Dias', 'amanda@email.com', 'amanda', 'Ir5U8V0kAhCxG3j6l9M4NnOoPpRr2sTuVvWwXxYyZ4A5B6C7D8E9F0G1H2I3J4K5L6M7N8O9P0Q1R2S3T4U5V6W7X8Y9Z0', 'USER');
-- senha: amanda909

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Felipe Rocha', 'felipe@email.com', 'felipe', 'Js6V9W1lBiDyH4k7m0N5OoPpQqSs3tUvVwWxXyYzZ5A6B7C8D9E0F1G2H3I4J5K6L7M8N9O0P1Q2R3S4T5U6V7W8X9Y0Z1', 'USER');
-- senha: felipe010

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Tatiane Gomes', 'tatiane@email.com', 'tatiane', 'Kt7W0X2mCjEzI5l8n1O6PpQqSs3tUvVwWxXyYzZ5A6B7C8D9E0F1G2H3I4J5K6L7M8N9O0P1Q2R3S4T5U6V7W8X9Y0Z1', 'ADMIN');
-- senha: tatiane111

INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Rodrigo Barbosa', 'rodrigo@email.com', 'rodrigo', 'Lu8X1Y3nDkFaJ6m9o2P7QqRrTt4uVvWwXxYyZz0A1B2C3D4E5F6G7H8I9J0K1L2M3N4O5P6Q7R8S9T0U1V2W3X4Y5Z6', 'ADMIN');
-- senha: rodrigo222

-- Novos telefones (16 a 30)
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '666666666');
INSERT INTO telefone (codigo_area, numero) VALUES ('21', '777777777');
INSERT INTO telefone (codigo_area, numero) VALUES ('31', '888888888');
INSERT INTO telefone (codigo_area, numero) VALUES ('41', '999999999');
INSERT INTO telefone (codigo_area, numero) VALUES ('51', '101010101');
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '121212121');
INSERT INTO telefone (codigo_area, numero) VALUES ('21', '131313131');
INSERT INTO telefone (codigo_area, numero) VALUES ('31', '141414141');
INSERT INTO telefone (codigo_area, numero) VALUES ('41', '151515151');
INSERT INTO telefone (codigo_area, numero) VALUES ('51', '161616161');
INSERT INTO telefone (codigo_area, numero) VALUES ('11', '171717171');
INSERT INTO telefone (codigo_area, numero) VALUES ('21', '181818181');
INSERT INTO telefone (codigo_area, numero) VALUES ('31', '191919191');
INSERT INTO telefone (codigo_area, numero) VALUES ('41', '202020202');
INSERT INTO telefone (codigo_area, numero) VALUES ('51', '212121212');

-- Novos endereços (7 a 15)
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('80010010', 'PR', 'Curitiba', 'Q7', 'Rua XV de Novembro', 700);
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('50010010', 'PE', 'Recife', 'Q8', 'Rua do Riachuelo', 800);
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('60010010', 'CE', 'Fortaleza', 'Q9', 'Rua Barão do Rio Branco', 900);
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('30010010', 'MG', 'Belo Horizonte', 'Q10', 'Av. Amazonas', 1000);
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('13010010', 'SP', 'Campinas', 'Q11', 'Rua José Paulino', 1100);
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('14010010', 'SP', 'Ribeirão Preto', 'Q12', 'Av. Independência', 1200);
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('29010010', 'ES', 'Vitória', 'Q13', 'Rua Sete de Setembro', 1300);
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('57010010', 'AL', 'Maceió', 'Q14', 'Rua do Comércio', 1400);
INSERT INTO endereco (cep, estado, cidade, quadra, rua, numero) VALUES
('88010010', 'SC', 'Florianópolis', 'Q15', 'Rua Felipe Schmidt', 1500);

-- Relacionando telefones com usuários
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (11, 16);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (12, 17);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (13, 18);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (14, 19);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (15, 20);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (16, 21);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (17, 22);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (18, 23);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (19, 24);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (20, 25);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (21, 26);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (22, 27);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (23, 28);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (24, 29);
INSERT INTO usuario_telefone (id_usuario, id_telefone) VALUES (25, 30);

-- Relacionando endereços com usuários
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (11, 7);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (12, 8);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (13, 9);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (14, 10);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (15, 11);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (16, 12);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (17, 13);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (18, 14);
INSERT INTO usuario_endereco (id_usuario, id_endereco) VALUES (19, 15);


INSERT INTO usuario (nome, email, login, senha, perfil) VALUES
('Luis', 'ambientallix.comercial01@gmail.com', 'luis', 'aQu9iDxdP/UCaZL+pAjhK0OTAGBBCb+WHXaCfyRnK20cuQARzBRTYhx8/x3iTU4mk7RZZgclleVkk3VE9h/2sA==', 'USER');