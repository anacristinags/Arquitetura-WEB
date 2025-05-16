# 🧪 Testes Unitários e Mocking em Spring Boot
## Objetivo
O objetivo é implementar e validar testes unitários para um controlador de usuários em uma aplicação Spring Boot utilizando JUnit e Mockito.

## 🧱 Estrutura da Aplicação

- **User**: entidade que representa o usuário.  
- **UserService**: serviço que gerencia as regras de negócio, mockado nos testes.  
- **UserController**: camada de API REST que expõe os endpoints.  
- **UserControllerTest**: testes unitários.

## 🔬 Testes Implementados

### Casos de teste cobertos em `UserControllerTest`:

- **testGetAllUsers**:  
  Verifica se o endpoint `GET /users` retorna uma lista de usuários conforme esperado.

- **testGetUserById**:  
  Confirma se o endpoint `GET /users/{id}` responde com os dados corretos para um usuário existente.

- **testCreateUser**:  
  Avalia a criação de um novo usuário via `POST /users`, checando se o retorno contém os dados inseridos.

---

## 📋 Resultado da Execução dos Teste

Exemplo do output bruto da execução dos testes:
```bash
%TESTC 3 v2
%TSTTREE2,com.example.teste.UserControllerTest,true,3,false,1,UserControllerTest,,[engine:junit-jupiter]/[class:com.example.teste.UserControllerTest]
%TSTTREE3,testGetAllUsers(com.example.teste.UserControllerTest),false,1,false,2,testGetAllUsers(),,[engine:junit-jupiter]/[class:com.example.teste.UserControllerTest]/[method:testGetAllUsers()]
%TSTTREE4,testCreateUser(com.example.teste.UserControllerTest),false,1,false,2,testCreateUser(),,[engine:junit-jupiter]/[class:com.example.teste.UserControllerTest]/[method:testCreateUser()]
%TSTTREE5,testGetUserById(com.example.teste.UserControllerTest),false,1,false,2,testGetUserById(),,[engine:junit-jupiter]/[class:com.example.teste.UserControllerTest]/[method:testGetUserById()]
%TESTS 3,testGetAllUsers(com.example.teste.UserControllerTest)
%TESTE 3,testGetAllUsers(com.example.teste.UserControllerTest)
%TESTS 4,testCreateUser(com.example.teste.UserControllerTest)
%TESTE 4,testCreateUser(com.example.teste.UserControllerTest)
%TESTS 5,testGetUserById(com.example.teste.UserControllerTest)
%TESTE 5,testGetUserById(com.example.teste.UserControllerTest)
%RUNTIME3506
```

**Significado dos resultados:**

- Foram executados 3 testes (cada método testado uma vez).  
- Todos os testes foram concluídos com sucesso (indicado por `false` em erros/falhas).  
- O tempo total para rodar todos os testes foi cerca de 3,5 segundos.

---

## 🚀 Instruções para Executar os Testes

- Para executar os testes pelo terminal, utilize:

```bash
./mvnw test
```
