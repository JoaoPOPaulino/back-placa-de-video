# 🚀 Backend - Placas de Vídeo API

API REST desenvolvida em Quarkus para gerenciamento de e-commerce de placas de vídeo

## 🎯 Sobre o Projeto

Este é o **backend** do sistema Nexus GPU, uma API REST robusta desenvolvida com **Quarkus** para fornecer todos os serviços necessários para o e-commerce de placas de vídeo. A API oferece endpoints para gerenciamento de produtos, usuários, pedidos e todas as funcionalidades do sistema.

### 🔗 **Frontend Relacionado**
Este backend funciona em conjunto com o frontend Angular:
👉 **[Frontend - Nexus GPU](https://github.com/JoaoPOPaulino/PlacaDeVideo)**

## ✨ Funcionalidades da API

- 🛍️ **Gestão de Produtos** - CRUD completo de placas de vídeo
- 👤 **Gerenciamento de Usuários** - Autenticação e perfis
- 🛒 **Sistema de Pedidos** - Processamento de compras
- 📊 **Relatórios** - Estatísticas e dados analíticos
- 🔐 **Autenticação JWT** - Segurança e controle de acesso
- 📱 **API RESTful** - Endpoints padronizados

## 🛠️ Tecnologias Utilizadas

- **[Quarkus](https://quarkus.io/)** - Framework Java supersônico e subatômico
- **Java 17+** - Linguagem de programação
- **PostgreSQL** - Banco de dados relacional
- **Hibernate ORM** - Mapeamento objeto-relacional
- **RESTEasy** - Framework REST
- **Docker** - Containerização
- **Maven** - Gerenciamento de dependências

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado:

- **[Java 17+](https://adoptopenjdk.net/)** - JDK necessário
- **[Maven 3.8+](https://maven.apache.org/)** - Gerenciador de dependências
- **[Docker](https://www.docker.com/)** - Para containerização
- **[PostgreSQL](https://www.postgresql.org/)** - Banco de dados

### 🐘 **Configuração do PostgreSQL**

Certifique-se de ter um banco de dados PostgreSQL rodando com as seguintes configurações:

| Parâmetro | Valor |
|-----------|-------|
| **Nome do Banco** | `topicos1db` |
| **Usuário** | `topicos1` |
| **Senha** | `123456` |
| **Host** | `localhost` |
| **Porta** | `5432` |

## 🚀 Como Executar o Projeto

### 1. Clone o Repositório
```bash
git clone https://github.com/JoaoPOPaulino/back-placa-de-video.git
cd back-placa-de-video
```

### 2. Configure o Banco de Dados
```sql
-- Execute no PostgreSQL
CREATE DATABASE topicos1db;
CREATE USER topicos1 WITH PASSWORD '123456';
GRANT ALL PRIVILEGES ON DATABASE topicos1db TO topicos1;
```

### 3. Inicie o Docker
```bash
# Certifique-se de que o Docker está rodando
docker --version

# Se necessário, inicie o Docker Desktop ou o serviço
sudo systemctl start docker  # Linux
# ou abra o Docker Desktop no Windows/Mac
```

### 4. Execute o Projeto

#### 🔥 **Modo Desenvolvimento (Dev Mode)**
```bash
./mvnw compile quarkus:dev
```
ou
```bash
mvn compile quarkus:dev
```

#### 📦 **Modo Produção**
```bash
# Build da aplicação
./mvnw package

# Execução
java -jar target/quarkus-app/quarkus-run.jar
```

#### 🐳 **Com Docker**
```bash
# Build da imagem Docker
./mvnw package -Dquarkus.container-image.build=true

# Executar container
docker run -i --rm -p 8080:8080 \
  -e QUARKUS_DATASOURCE_JDBC_URL=jdbc:postgresql://host.docker.internal:5432/topicos1db \
  -e QUARKUS_DATASOURCE_USERNAME=topicos1 \
  -e QUARKUS_DATASOURCE_PASSWORD=123456 \
  [nome-da-imagem]
```

### 5. Verifique se Está Funcionando
```bash
# Teste básico da API
curl http://localhost:8080/health

# Swagger UI (se habilitado)
# Acesse: http://localhost:8080/q/swagger-ui
```

## 📁 Estrutura do Projeto

```
back-placa-de-video/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/seu/pacote/
│   │   │       ├── entity/        # Entidades JPA
│   │   │       ├── resource/      # Controllers REST
│   │   │       ├── service/       # Lógica de negócio
│   │   │       ├── repository/    # Repositórios de dados
│   │   │       └── dto/           # Data Transfer Objects
│   │   └── resources/
│   │       ├── application.properties  # Configurações
│   │       └── import.sql             # Dados iniciais
│   └── test/                          # Testes
├── pom.xml                           # Dependências Maven
└── Dockerfile                       # Container Docker
```

## ⚙️ Configuração

### 📄 **application.properties**
```properties
# Configuração do banco de dados
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=topicos1
quarkus.datasource.password=123456
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/topicos1db

# Hibernate
quarkus.hibernate-orm.database.generation=drop-and-create
quarkus.hibernate-orm.log.sql=true

# Porta da aplicação
quarkus.http.port=8080

# CORS (para desenvolvimento)
quarkus.http.cors=true
quarkus.http.cors.origins=http://localhost:4200
```

## 🔌 Principais Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/api/placas` | Lista todas as placas de vídeo |
| `GET` | `/api/placas/{id}` | Busca placa por ID |
| `POST` | `/api/placas` | Cria nova placa |
| `PUT` | `/api/placas/{id}` | Atualiza placa |
| `DELETE` | `/api/placas/{id}` | Remove placa |
| `GET` | `/api/usuarios` | Lista usuários |
| `POST` | `/api/auth/login` | Autenticação |

## 🧪 Executando Testes

```bash
# Testes unitários
./mvnw test

# Testes de integração
./mvnw verify

# Testes com relatório
./mvnw test jacoco:report
```

## 🚀 Deploy e Build

### **Build Nativo (GraalVM)**
```bash
# Instalar GraalVM (opcional)
./mvnw package -Pnative

# Executar binário nativo
./target/back-placa-de-video-1.0.0-SNAPSHOT-runner
```

### **Docker Build**
```bash
# Build da imagem
./mvnw package -Dquarkus.container-image.build=true

# Push para registry (se configurado)
./mvnw package -Dquarkus.container-image.push=true
```

## 🔧 Scripts Úteis

```bash
# Limpeza e rebuild completo
./mvnw clean compile

# Modo desenvolvimento com debug
./mvnw compile quarkus:dev -Ddebug=5005

# Profile de desenvolvimento
./mvnw compile quarkus:dev -Dquarkus.profile=dev

# Verificar dependências
./mvnw dependency:tree
```

## 📊 Monitoramento e Health Check

```bash
# Health check
curl http://localhost:8080/q/health

# Métricas (se habilitado)
curl http://localhost:8080/q/metrics

# OpenAPI/Swagger
curl http://localhost:8080/q/openapi
```

## 🐛 Troubleshooting

### **Problemas Comuns:**

**❌ Erro de Conexão com Banco**
```bash
# Verifique se o PostgreSQL está rodando
sudo systemctl status postgresql

# Teste a conexão
psql -h localhost -U topicos1 -d topicos1db
```

**❌ Porta 8080 em Uso**
```bash
# Encontre o processo usando a porta
lsof -i :8080

# Mate o processo ou use outra porta
./mvnw compile quarkus:dev -Dquarkus.http.port=8081
```

**❌ Docker não Iniciado**
```bash
# Inicie o Docker
sudo systemctl start docker

# Verifique o status
docker ps
```

## 👥 Equipe de Desenvolvimento

- **João Pedro de Oliveira** - [@JoaoPOPaulino](https://github.com/JoaoPOPaulino)
- **Luiz Cláudio** - Desenvolvedor

## 🎓 Contexto Acadêmico

- **Instituição:** UNITINS (Universidade Estadual do Tocantins)
- **Disciplina:** Tópicos de Programação II
- **Professor Orientador:** Jânio Junior

## 📄 Licença

Este projeto é exclusivamente **acadêmico** e foi desenvolvido para fins **educacionais**.
