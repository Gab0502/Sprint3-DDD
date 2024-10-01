
# Projeto Sprint 3 - Design Orientado ao Domínio (DDD)

## Membros da Equipe

- **Enricco Rossi de Souza Carvalho Miranda**  
  ID: 551717

- **Gabriel Marquez Trevisan**  
  ID: 99227

- **Guilherme Silva dos Santos**  
  ID: 551168

- **Kayque Moraes Dias**  
  ID: 97592

- **Samuel Ramos de Almeida**  
  ID: 99134

## Visão Geral

### 1. SOLUÇÃO PROPOSTA

Dado que 100% dos alunos de outros estados que fazem EAD não conseguem completar a formação devido à falta de exercícios práticos, nós, da **Mediverso**, acreditamos na transformação da medicina por meio da tecnologia, dados e colaboração. Para isso, estamos desenvolvendo uma plataforma de gamificação que integra alunos e professores, propondo os seguintes valores e diferenciais:

### Valores e Diferenciais para os Alunos:

- **Acessibilidade**  
  Estudantes de outros estados ou que não têm fácil acesso a equipamentos poderão, à distância, treinar suas habilidades práticas.

- **Realismo**  
  Com o uso da tecnologia de realidade virtual, conseguimos nos aproximar ao máximo da realidade médica.

- **Repetição**  
  O aluno poderá realizar simulações ilimitadas para aprimorar suas técnicas.

- **Comunidade**  
  Criaremos uma comunidade para promover a comunicação entre os alunos, permitindo a troca de experiências e dicas.

---

### 2. PRINCIPAIS FUNCIONALIDADES

### Experiência em "Real-Time"
- Realização de simulações práticas em ambientes virtuais, permitindo que os alunos pratiquem procedimentos médicos de forma segura e realista.

### Resultado Imediato
- Fornecimento de resultados instantâneos após cada simulação, com dicas e correções para melhoria e aprimoramento do desempenho.

### Acessibilidade
- Atendimento às necessidades de todos os alunos, incluindo legendas, audiodescrição e interfaces intuitivas.

### Gravações das Cirurgias
- Criação de uma "biblioteca digital" com vídeos de cada simulação, incluindo a pontuação do aluno referente aos exercícios realizados.

### Premiação
- Mecanismo de premiação com placares, insígnias, incentivando a melhoria contínua de cada aluno.



# Visão Geral dos Controladores

Este projeto implementa diversos controladores, cada um responsável por uma parte específica da lógica de negócios da aplicação. Abaixo, uma explicação detalhada de cada controlador e suas respectivas responsabilidades.


---

## 1. AuthContextController
- **Responsabilidade:** Gerencia a autenticação de usuários, permitindo que façam login no sistema.
- **Principais Métodos:**
  - `login(String email, String senha)`: Recebe as credenciais de um usuário e tenta realizar o login. Se bem-sucedido, retorna um contexto de autenticação.
- **Uso:** Essencial para verificar as credenciais dos usuários e permitir o acesso à plataforma.

---

## 2. EntregaController
- **Responsabilidade:** Controla a criação, listagem e busca de entregas (atividades ou tarefas) feitas pelos usuários.
- **Principais Métodos:**
  - `createEntrega(int tarefaId, int placarId)`: Cria uma nova entrega associada a uma tarefa e um placar.
  - `getEntregaById(int id)`: Busca uma entrega específica pelo seu ID.
  - `listAllEntregas()`: Lista todas as entregas registradas no sistema.
- **Uso:** Fundamental para o gerenciamento das atividades que os usuários precisam realizar no sistema.

---

## 3. JogoController
- **Responsabilidade:** Gerencia os jogos na plataforma, permitindo a listagem de todos os jogos e a busca de jogos por ID.
- **Principais Métodos:**
  - `getAllJogos()`: Lista todos os jogos disponíveis.
  - `getJogoById(int id)`: Busca um jogo específico pelo seu ID.
- **Uso:** Essencial para permitir que os usuários interajam com diferentes jogos dentro da plataforma.

---

## 4. PlacarController
- **Responsabilidade:** Gerencia a criação e visualização de placares, relacionados às pontuações dos usuários em jogos ou atividades.
- **Principais Métodos:**
  - `createPlacar(int userId, int jogoId, int pontuacao, String replayPath)`: Cria um novo placar para um usuário específico.
  - `getAllPlacares()`: Lista todos os placares registrados.
  - `getPlacarById(int id)`: Busca um placar específico pelo ID.
  - `getPlacarByUserId(int userId)`: Retorna todos os placares de um usuário específico.
- **Uso:** Ajuda a manter o controle e a exibição das pontuações dos usuários, o que é importante para a gamificação da plataforma.

---

## 5. TurmaController
- **Responsabilidade:** Gerencia as turmas na plataforma, permitindo a busca de turmas por ID ou pelo ID do professor.
- **Principais Métodos:**
  - `getTurmaById(int turmaId)`: Busca uma turma específica pelo ID.
  - `getTurmaByProfessorId(int professorId)`: Busca uma turma pelo ID do professor responsável.
- **Uso:** Essencial para organizar os alunos em grupos (turmas), facilitando o gerenciamento de suas atividades e interações.

---

## 6. TurmaUserController
- **Responsabilidade:** Lida com a relação entre turmas e usuários, listando os usuários associados a uma turma específica.
- **Principais Métodos:**
  - `getUsersByTurmaId(int turmaId)`: Retorna todos os usuários associados a uma turma específica.
- **Uso:** Facilita a gestão dos usuários dentro das turmas, permitindo identificar quais alunos estão associados a cada turma.

---

## 7. UserController
- **Responsabilidade:** Gerencia os usuários da plataforma, permitindo a criação, listagem e busca de usuários.
- **Principais Métodos:**
  - `createUser(String nome, String email, String senha)`: Cria um novo usuário no sistema.
  - `getAllUsers()`: Lista todos os usuários registrados.
  - `getUserById(int id)`: Busca um usuário específico pelo ID.
- **Uso:** Central para a administração de contas de usuários, permitindo a criação de novos perfis e a gestão de informações de usuários já existentes.

## Estrutura de Diretórios

```plaintext
sprint3/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/
│   │   │   │   ├── example/
│   │   │   │   │   ├── br/
│   │   │   │   │   │   ├── mediverso/
│   │   │   │   │   │   │   ├── controllers/
│   │   │   │   │   │   │   │   ├── AuthContextController.java
│   │   │   │   │   │   │   │   ├── EntregaController.java
│   │   │   │   │   │   │   │   ├── JogoController.java
│   │   │   │   │   │   │   │   ├── PlacarController.java
│   │   │   │   │   │   │   │   ├── TurmaController.java
│   │   │   │   │   │   │   │   ├── TurmaUserController.java
│   │   │   │   │   │   │   │   ├── UserController.java
│   │   │   │   │   │   │   ├── DAO/
│   │   │   │   │   │   │   ├── models/
│   │   │   │   │   │   │   ├── pages/
│   │   │   │   │   │   │   ├── services/
│   │   │   │   │   │   ├── Main.java
│   ├── test/
|    └── test/
|        └── java/
|           └── org/
|                └── example/
|                   └── br/
|                        └── mediverso/
|                            ├── controller/
|                            │   ├── AuthContextControllerTest.java
|                            │   ├── EntregaControllerTest.java
|                            │   ├── JogoControllerTest.java
|                            │   ├── PlacarControllerTest.java
|                            │   ├── TurmaControllerTest.java
|                            │   ├── UserControllerTest.java
|                            │   └── stubs/
|                            │       ├── EntregaControllerStub.java
|                            │       ├── JogoControllerStub.java
|                            │       ├── loginServiceStub.java
|                            │       ├── PlacarControllerStub.java
|                            │       ├── TurmaControllerStub.java
|                            │       └── UserControllerStub.java
├── target/
├── pom.xml
```

## Pré-requisitos
- **Java JDK 22**: É necessário ter o Java instalado. Você pode baixá-lo no [site oficial da Oracle](https://www.oracle.com/java/technologies/javase-downloads.html).
- **Maven**: O Apache Maven é necessário para construir e gerenciar o projeto. Instale o Maven seguindo as instruções [aqui](https://maven.apache.org/install.html).
- **IDE**: É recomendado o uso do IntelliJ IDEA, pois o projeto já está configurado para essa IDE.

## Iniciando o Projeto

1. **Clonar o repositório**:
   ```bash
   git clone <url-do-repositorio>
   ```

2. **Navegar até o diretório do projeto**:
   ```bash
   cd Sprint3-DDD/sprint3
   ```

3. **Construir o projeto com Maven**:
   ```bash
   mvn clean install
   ```


## Detalhes da Arquitetura

- **DDD (Domain-Driven Design)**: A arquitetura do projeto segue os princípios do DDD, com a separação clara das responsabilidades, como:
  - **Models**: Entidades: Representações dos principais objetos de domínio do sistema. As entidades são modeladas dentro da pasta models e incluem objetos como User, Turma, Placar, etc..
  - **Services**:  As classes de serviço encapsulam a lógica de negócios e operam sobre as entidades. Elas estão organizadas na pasta services, e cada serviço é responsável por uma operação específica no sistema. Exemplo: CreateUserService, GetJogos, CreatePlacarService.
  - **Repositórios (DAO)**:Os repositórios são responsáveis pela persistência e recuperação de dados. Eles interagem com a camada de dados para realizar operações de CRUD (Create, Read, Update, Delete). Esses repositórios estão organizados na pasta DAO.
  - **Controllers**: Os controladores agem como pontos de entrada para a aplicação. Eles recebem as requisições do cliente (geralmente via API), processam a lógica de negócios através dos serviços e retornam os resultados. Exemplo: UserController, TurmaController, EntregaController.
  - **Páginas**: A camada de pages é possivelmente usada para renderizar o conteúdo das páginas, como a interface do usuário.

## Detalhes sobre o DAO

### `ConnectionService.java`
- **Função:** Gerencia a conexão com o banco de dados SQLite.
- **Descrição:**  
  Utiliza JDBC para estabelecer e retornar uma conexão com o banco de dados. Em caso de falha, uma mensagem de erro é exibida, indicando o motivo da falha. O caminho do banco de dados é definido em uma constante e o método `getConnection()` retorna a conexão ativa.

### `GenerateDb.java`
- **Função:** Cria as tabelas do banco de dados e insere dados iniciais.
- **Descrição:**
  - **Criação das tabelas:**  
    Verifica se as tabelas já existem no banco de dados antes de criá-las. Se a tabela não existir, ela é criada com base nos esquemas definidos. Entre as tabelas criadas estão `tbUser`, `tbTurma`, `tbJogos`, `tbPlacar`, entre outras.
  
  - **Inserção de dados iniciais:**  
    Caso as tabelas estejam vazias, são inseridos dados fictícios iniciais, como usuários, turmas, e jogos. Isso garante que a aplicação tenha dados de exemplo para rodar logo após a criação do banco de dados.
  
  - **Relacionamentos:**  
    A classe também implementa chaves estrangeiras para garantir a integridade referencial entre as tabelas. Por exemplo, `tbTurmaUser` referencia `tbUser` e `tbTurma`, enquanto `tbPlacar` referencia `tbJogos` e `tbUser`, garantindo que as operações de CRUD respeitem as relações entre as entidades.

## Explicação dos Arquivos de Teste

### controller/
Contém os testes unitários de cada controlador, onde cada arquivo testa funcionalidades específicas do controlador correspondente.

#### Arquivos de Teste (JUnit):
- **AuthContextControllerTest.java**: Testa o processo de autenticação no `AuthContextController`, verificando cenários de sucesso e falha de login.
- **EntregaControllerTest.java**: Testa a criação e recuperação de entregas no `EntregaController`.
- **JogoControllerTest.java**: Verifica as funcionalidades de listagem e recuperação de jogos no `JogoController`.
- **PlacarControllerTest.java**: Testa o gerenciamento de placares, como a criação e recuperação de placares para um usuário ou jogo específico.
- **TurmaControllerTest.java**: Valida a criação e busca de turmas no `TurmaController`.
- **UserControllerTest.java**: Verifica a criação e recuperação de usuários no `UserController`.

### Arquivos de Stubs:

- **controller/stubs/**  
  Contém classes de simulação (stubs) para os controladores, usados para isolar a lógica de negócio de dependências externas como banco de dados e serviços.

#### Stubs:
- **EntregaControllerStub.java**: Simula o comportamento do `EntregaController` em testes.
- **JogoControllerStub.java**: Simula o comportamento do `JogoController` para testes isolados.
- **loginServiceStub.java**: Simula o serviço de login com respostas pré-determinadas.
- **PlacarControllerStub.java**: Simula o comportamento do `PlacarController` para testes sem interagir com o banco de dados real.
- **TurmaControllerStub.java**: Simula o comportamento do `TurmaController` em testes.
- **UserControllerStub.java**: Simula o comportamento do `UserController`, permitindo verificar a lógica sem acessar o banco de dados.

### Comentários Gerais sobre os Testes com JUnit

- **Uso do JUnit:**  
  Os testes utilizam a anotação `@Test` para definir métodos de teste, com asserções como `assertEquals`, `assertTrue`, `assertNotNull` para validar os resultados esperados.

- **Simulações com Stubs:**  
  Os stubs substituem implementações reais durante os testes, isolando a lógica de negócio de serviços e dependências externas, garantindo que o foco dos testes seja exclusivamente na lógica dos controladores.

### Maven
O arquivo `pom.xml` é o coração do sistema de build Maven. Ele contém:
- As dependências do projeto, como frameworks e bibliotecas externas.
- Plugins do Maven utilizados no processo de construção, execução e empacotamento da aplicação.
- Configurações do ciclo de vida do Maven, como testes, empacotamento e fases de compilação.
