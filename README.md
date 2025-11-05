# Task Manager API

API REST para gerenciamento de tarefas desenvolvida com Spring Boot. Este projeto demonstra a implementação de um CRUD completo (Create, Read, Update, Delete) seguindo as melhores práticas de arquitetura em camadas.

## Tecnologias

- **Java 21** - Linguagem de programação
- **Spring Boot 3.5.7** - Framework Java
- **Spring Data JPA** - Persistência de dados
- **H2 Database** - Banco de dados em memória (para desenvolvimento)
- **Lombok** - Redução de boilerplate
- **Maven** - Gerenciamento de dependências

## Funcionalidades

- Criar tarefas
- Listar todas as tarefas
- Buscar tarefa por ID
- Atualizar tarefa
- Deletar tarefa

## Arquitetura

O projeto segue a arquitetura em camadas:

```
src/main/java/com/joaomarin/demo/
├── model/
│   └── Task.java              # Entidade JPA
├── repository/
│   └── TaskRepository.java    # Interface de acesso aos dados
├── service/
│   └── TaskService.java       # Lógica de negócio
└── controller/
    └── TaskController.java    # Endpoints REST
```

## Endpoints da API

### 1. Criar uma tarefa

```http
POST http://localhost:8080/tasks
Content-Type: application/json

{
  "title": "Estudar Spring Boot",
  "description": "Fazer o projeto de tasks"
}
```

**Resposta:**
```
Tarefa criada com sucesso!
```

### 2. Listar todas as tarefas

```http
GET http://localhost:8080/tasks
```

**Resposta:**
```json
[
  {
    "id": 1,
    "title": "Estudar Spring Boot",
    "description": "Fazer o projeto de tasks",
    "completed": false
  },
  {
    "id": 2,
    "title": "Fazer exercícios",
    "description": "Praticar loops",
    "completed": true
  }
]
```

### 3. Buscar tarefa por ID

```http
GET http://localhost:8080/tasks/1
```

**Resposta:**
```json
{
  "id": 1,
  "title": "Estudar Spring Boot",
  "description": "Fazer o projeto de tasks",
  "completed": false
}
```

### 4. Atualizar uma tarefa

```http
PUT http://localhost:8080/tasks/1
Content-Type: application/json

{
  "completed": true
}
```

**Resposta:**
```
Tarefa atualizada!
```

### 5. Deletar uma tarefa

```http
DELETE http://localhost:8080/tasks/1
```

**Resposta:**
```
Tarefa deletada!
```

## Como executar

### Pré-requisitos

- Java 21 ou superior
- Maven 3.6+ (ou use o Maven Wrapper incluído)

### Executando o projeto

1. Clone o repositório:
```bash
git clone <seu-repositorio>
cd demo
```

2. Execute o projeto:
```bash
# Windows
.\mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run
```

3. A API estará disponível em: `http://localhost:8080`

### Testando a API

Após iniciar a aplicação, você pode testar os endpoints usando:

**Opção 1: Postman**
- Baixe o Postman em: https://www.postman.com/downloads/
- Crie uma nova requisição
- Configure o método HTTP (GET, POST, PUT, DELETE)
- Adicione a URL: `http://localhost:8080/tasks`
- Para POST e PUT, adicione o body em JSON no tab "Body" → "raw" → "JSON"

**Opção 2: Insomnia**
- Baixe o Insomnia em: https://insomnia.rest/download
- Similar ao Postman, interface mais simples

**Opção 3: curl (Terminal)**
```bash
# Criar tarefa
curl -X POST http://localhost:8080/tasks -H "Content-Type: application/json" -d "{\"title\":\"Teste\",\"description\":\"Descrição\"}"

# Listar todas
curl http://localhost:8080/tasks

# Buscar por ID
curl http://localhost:8080/tasks/1

# Atualizar
curl -X PUT http://localhost:8080/tasks/1 -H "Content-Type: application/json" -d "{\"completed\":true}"

# Deletar
curl -X DELETE http://localhost:8080/tasks/1
```

**Opção 4: Thunder Client (VS Code/Cursor)**
- Instale a extensão "Thunder Client" no VS Code/Cursor
- Clique no ícone do Thunder Client na barra lateral
- Crie requisições diretamente no editor

### Executando os testes

```bash
.\mvnw.cmd test
```

## Deploy e Uso em Produção

**Importante:** `localhost:8080` só funciona na sua máquina. Para que outras pessoas possam usar a API, é necessário fazer o deploy em um servidor na internet.

### Opções de Deploy Gratuitas

**1. Railway (Recomendado - Muito fácil)**
- Acesse: https://railway.app
- Conecte seu repositório GitHub
- Railway detecta automaticamente Spring Boot e faz o deploy
- Você recebe uma URL pública como: `https://seu-projeto.railway.app`

**2. Render**
- Acesse: https://render.com
- Crie um novo "Web Service"
- Conecte seu repositório GitHub
- Build Command: `./mvnw clean package`
- Start Command: `java -jar target/demo-0.0.1-SNAPSHOT.jar`

**3. Heroku**
- Acesse: https://www.heroku.com
- Instale o Heroku CLI
- Crie um arquivo `Procfile` na raiz do projeto com: `web: java -jar target/demo-0.0.1-SNAPSHOT.jar`

**Após o deploy:**
- Substitua `http://localhost:8080` pela URL pública fornecida
- Exemplo: `https://seu-projeto.railway.app/tasks`

### Nota sobre Banco de Dados em Produção

Para produção, recomenda-se usar um banco de dados persistente (PostgreSQL, MySQL) ao invés do H2 em memória. As plataformas de deploy geralmente oferecem bancos de dados gratuitos.

## Modelo de Dados

### Task

| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | Long | Identificador único (gerado automaticamente) |
| title | String | Título da tarefa |
| description | String | Descrição da tarefa |
| completed | Boolean | Status de conclusão (padrão: false) |

## Casos de Uso

Esta API pode ser utilizada por:

- **Aplicativos Mobile** - App de gerenciamento de tarefas
- **Aplicações Web** - Sistemas como Trello, Todoist
- **Integrações** - Comunicação entre sistemas via API REST

## Notas

- O banco de dados H2 é utilizado em memória para desenvolvimento
- Para produção, recomenda-se a configuração de PostgreSQL ou MySQL
- Os dados são perdidos ao reiniciar a aplicação (banco em memória)

## Autor

João Pedro De Souza Marin
