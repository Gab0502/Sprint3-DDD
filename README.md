
# Sprint 3 - Domain Driven Design (DDD)

Este repositório contém a implementação de uma aplicação usando os princípios de Domain Driven Design (DDD). O projeto foi desenvolvido como parte do Sprint 3 de um estudo sobre arquitetura de software e boas práticas de desenvolvimento.

## Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Estrutura de Pastas](#estrutura-de-pastas)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Como Rodar o Projeto](#como-rodar-o-projeto)
- [Contribuições](#contribuições)
- [Licença](#licença)

## Sobre o Projeto

O objetivo deste projeto é aplicar os conceitos de Domain Driven Design (DDD) na construção de uma aplicação modular, escalável e de fácil manutenção. O projeto segue uma arquitetura baseada em camadas, separando as responsabilidades de domínio, aplicação, infraestrutura e interfaces.

## Estrutura de Pastas

Abaixo está a estrutura de pastas do projeto:

```
.
├── src
│   ├── domain           # Entidades, Repositórios e Regras de Negócio
│   ├── application      # Casos de uso e serviços
│   ├── infrastructure   # Conexões com banco de dados, frameworks e bibliotecas externas
│   └── interfaces       # Controladores, APIs e Interfaces de Usuário
├── tests                # Testes unitários e de integração
└── README.md
```

## Tecnologias Utilizadas

- **Node.js** - Runtime JavaScript para construção de aplicações server-side
- **Express** - Framework web para construção de APIs
- **TypeScript** - Superconjunto de JavaScript que adiciona tipagem estática
- **Jest** - Framework de testes em JavaScript para garantir a qualidade do código
- **MongoDB** - Banco de dados NoSQL utilizado para persistência de dados

## Como Rodar o Projeto

Siga os passos abaixo para rodar o projeto localmente:

### Pré-requisitos

- Node.js (v14+)
- MongoDB instalado e rodando

### Instalação

1. Clone o repositório:

   ```bash
   git clone https://github.com/Gab0502/Sprint3-DDD.git
   ```

2. Entre na pasta do projeto:

   ```bash
   cd Sprint3-DDD
   ```

3. Instale as dependências:

   ```bash
   npm install
   ```

4. Configure as variáveis de ambiente:

   Crie um arquivo `.env` na raiz do projeto e adicione as variáveis necessárias, como a URL do MongoDB e outras configurações relevantes.

5. Rode as migrações do banco de dados (se houver):

   ```bash
   npm run migrate
   ```

### Rodando o Projeto

Para rodar o projeto localmente, use o comando:

```bash
npm run dev
```

A aplicação estará disponível em [http://localhost:3000](http://localhost:3000).

### Testes

Para rodar os testes unitários, utilize o comando:

```bash
npm run test
```

## Contribuições

Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões, sinta-se à vontade para abrir uma _issue_ ou enviar um _pull request_.

### Como Contribuir

1. Faça um _fork_ do projeto
2. Crie uma nova _branch_ (`git checkout -b feature/nova-feature`)
3. Commit suas alterações (`git commit -m 'Adiciona nova feature'`)
4. Faça o _push_ para a _branch_ (`git push origin feature/nova-feature`)
5. Abra um _pull request_

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para mais detalhes.
