# Guia: Subindo o Projeto no GitHub

## Passo 1: Verificar se Git está instalado

Abra o PowerShell e digite:
```bash
git --version
```

**Se aparecer erro:**
- Baixe o Git: https://git-scm.com/download/win
- Instale e reinicie o terminal

---

## Passo 2: Configurar Git (se for primeira vez)

```bash
git config --global user.name "Seu Nome"
git config --global user.email "seu-email@exemplo.com"
```

---

## Passo 3: Inicializar o repositório

No terminal, na pasta do projeto (`C:\Users\joaop\Downloads\demo\demo`):

```bash
# Inicializar git
git init

# Adicionar todos os arquivos
git add .

# Fazer o primeiro commit
git commit -m "Initial commit: Task Manager API - CRUD completo com Spring Boot"
```

---

## Passo 4: Criar repositório no GitHub

1. Acesse: https://github.com
2. Faça login (ou crie conta)
3. Clique no botão **"+"** (canto superior direito) → **"New repository"**
4. Preencha:
   - **Repository name:** `task-manager-api` (ou o nome que quiser)
   - **Description:** "API REST para gerenciamento de tarefas desenvolvida com Spring Boot"
   - **Public** (ou Private, sua escolha)
   - **NÃO marque** "Add a README file" (já temos um)
   - **NÃO marque** "Add .gitignore" (já temos um)
5. Clique em **"Create repository"**

---

## Passo 5: Conectar e fazer push

Depois de criar o repositório, o GitHub vai mostrar comandos. Use estes:

```bash
# Adicionar o repositório remoto (substitua SEU_USUARIO pelo seu usuário do GitHub)
git remote add origin https://github.com/SEU_USUARIO/task-manager-api.git

# Renomear branch para main (se necessário)
git branch -M main

# Fazer push
git push -u origin main
```

**Importante:** Vai pedir usuário e senha. Use seu **Personal Access Token** (não a senha normal):
- Vá em: https://github.com/settings/tokens
- Clique em "Generate new token" → "Generate new token (classic)"
- Dê um nome: "Task Manager API"
- Selecione escopo: `repo` (marque todas as opções)
- Clique em "Generate token"
- **COPIE O TOKEN** (ele só aparece uma vez!)
- Use esse token como senha quando pedir

---

## Comandos Rápidos (Copiar e Colar)

```bash
# 1. Inicializar
git init

# 2. Adicionar arquivos
git add .

# 3. Commit
git commit -m "Initial commit: Task Manager API - CRUD completo com Spring Boot"

# 4. Adicionar remote (SUBSTITUA SEU_USUARIO)
git remote add origin https://github.com/SEU_USUARIO/task-manager-api.git

# 5. Renomear branch
git branch -M main

# 6. Push
git push -u origin main
```

---

## Se der erro de autenticação

Use o token ao invés da senha:
1. Gere token: https://github.com/settings/tokens
2. Quando pedir senha, cole o token

---

## Depois de subir

Atualize o README.md com o link do seu repositório:
- Procure por: `git clone <seu-repositorio>`
- Substitua por: `git clone https://github.com/SEU_USUARIO/task-manager-api.git`

---

## Próximos passos (opcional)

1. Fazer deploy no Railway/Render para ter URL pública
2. Adicionar badge no README
3. Adicionar mais informações no README


