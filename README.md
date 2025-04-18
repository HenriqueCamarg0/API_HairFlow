# API_HairFlow

## Sobre o Projeto

O **API_HairFlow** é uma solução desenvolvida para gerenciar e otimizar processos relacionados ao fluxo de trabalho em salões de beleza. Nosso objetivo é oferecer uma API robusta e escalável que facilite a integração com diferentes plataformas e sistemas.

## Desenvolvimento Atual

Até o momento, implementamos as seguintes funcionalidades principais:

- **Cadastro de Usuários**: Permite o registro e autenticação de clientes e profissionais.
- **Agendamento de Serviços**: Sistema para criação, edição e cancelamento de agendamentos.
- **Gerenciamento de Serviços**: Cadastro e manutenção de serviços oferecidos pelo salão.
- **Relatórios Básicos**: Geração de relatórios simples sobre agendamentos e serviços.

## Implementações Futuras

Estamos planejando as seguintes melhorias e novas funcionalidades:

- **Integração com Pagamentos Online**: Suporte para pagamentos diretamente pela plataforma.
- **Notificações em Tempo Real**: Envio de notificações para clientes e profissionais sobre atualizações de agendamentos.
- **Sistema de Avaliações**: Permitir que clientes avaliem os serviços e profissionais.
- **Dashboard Avançado**: Painel administrativo com métricas detalhadas e relatórios avançados.
- **Suporte Multilíngue**: Adicionar suporte para múltiplos idiomas.

## Estrutura do Projeto

A estrutura do projeto segue boas práticas de desenvolvimento, com organização modular e separação de responsabilidades. 

- `src/`: Contém o código-fonte principal da API.
- `tests/`: Inclui os testes automatizados para garantir a qualidade do código.
- `docs/`: Documentação detalhada sobre a API e seu uso.


📌 Endpoints
### Endpoints Implementados

#### Usuários
- `POST /users/register`: Registro de novos usuários.
- `POST /users/login`: Autenticação de usuários.
- `GET /users/{id}`: Obter informações de um usuário específico.
- `PUT /users/{id}`: Atualizar informações de um usuário.
- `DELETE /users/{id}`: Remover um usuário.

#### Agendamentos
- `POST /appointments`: Criar um novo agendamento.
- `GET /appointments`: Listar todos os agendamentos.
- `GET /appointments/{id}`: Obter detalhes de um agendamento específico.
- `PUT /appointments/{id}`: Atualizar um agendamento.
- `DELETE /appointments/{id}`: Cancelar um agendamento.

#### Serviços
- `POST /services`: Adicionar um novo serviço.
- `GET /services`: Listar todos os serviços disponíveis.
- `GET /services/{id}`: Obter detalhes de um serviço específico.
- `PUT /services/{id}`: Atualizar informações de um serviço.
- `DELETE /services/{id}`: Remover um serviço.

#### Relatórios
- `GET /reports/appointments`: Gerar relatório de agendamentos.
- `GET /reports/services`: Gerar relatório de serviços.

---

## ✒️ Autor
Henrique Camargo - Desenvolvedor - [GitHub](https://github.com/HenriqueCamarg0)