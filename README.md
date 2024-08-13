# Nome do Projeto 

Este projeto visa desenvolver um sistema informatizado para gerenciar as matrículas de uma universidade. O sistema permitirá a Secretaria da universidade gerenciar currículos, professores e alunos, além de possibilitar aos alunos se matricularem e cancelarem suas matrículas em disciplinas de forma eficiente. Professores poderão consultar a lista de alunos matriculados e o sistema de cobranças será integrado para garantir a correta faturação das disciplinas.

## Integrantes
* Pedro Moreira Ramos ![User Icon](https://avatars.githubusercontent.com/u/117239949?s=20&v=4)
* Davi Aguilar Nunes Oliveira ![User Icon](https://avatars.githubusercontent.com/u/129971903?s=20&v=4)

## Orientador
* Cristiano de Macêdo Neto 

## Instruções de Utilização

Assim que a primeira versão do sistema estiver disponível, as instruções de utilização serão complementadas. Descreva como instalar eventuais dependências e como executar a aplicação.

## Histórias de Usuários

### 1. História de Usuário: Gerar Currículo 

**Como** Secretaria,
**Eu quero** gerar e atualizar o currículo das disciplinas para cada semestre,
**Para que** eu possa garantir que as disciplinas corretas sejam oferecidas e os alunos possam se matricular nelas.

#### Critérios de Aceitação
- A Secretaria pode adicionar novas disciplinas ao currículo.
- A Secretaria pode remover disciplinas do currículo.
- O currículo pode ser atualizado com novas informações sobre as disciplinas, como horários e professores.
- O sistema deve refletir as mudanças no currículo para o próximo semestre.

### 2. História de Usuário: Consultar Alunos por Disciplina 

**Como** Professor,
**Eu quero** consultar a lista de alunos matriculados em minhas disciplinas,
**Para que** eu possa saber quem são os alunos que frequentarão minhas aulas e acompanhar seu progresso.

#### Critérios de Aceitação
- O Professor pode visualizar a lista de alunos matriculados em cada disciplina que leciona.
- A lista deve incluir informações básicas dos alunos, como nome e número de matrícula.
- O Professor pode acessar essa lista a qualquer momento através do sistema.

### 3. História de Usuário: Matricular em Disciplina 

**Como** Aluno,
**Eu quero** me matricular em disciplinas obrigatórias e optativas para o semestre,
**Para que** eu possa completar os requisitos do meu curso e avançar na minha graduação.

#### Critérios de Aceitação
- O Aluno pode se matricular em até 4 disciplinas obrigatórias e 2 disciplinas optativas.
- O sistema deve validar que o aluno não exceda o limite de disciplinas.
- O Aluno deve receber uma confirmação de matrícula após completar o processo.
- O sistema deve permitir o cancelamento de matrículas até um prazo definido.

### 4. História de Usuário: Cancelar Matrícula 

**Como** Aluno,
**Eu quero** cancelar uma matrícula em uma disciplina,
**Para que** eu possa alterar minha escolha de disciplinas e ajustar minha carga horária conforme necessário.

#### Critérios de Aceitação
- O Aluno pode cancelar a matrícula em uma disciplina até um prazo definido.
- O sistema deve atualizar a lista de alunos matriculados na disciplina ao cancelar a matrícula.
- O Aluno deve receber uma confirmação do cancelamento da matrícula.

### 5. História de Usuário: Notificar Cobrança

**Como** Sistema de Cobranças,
**Eu quero** ser notificado sobre as disciplinas em que os alunos estão matriculados,
**Para que** eu possa gerar as cobranças corretamente e enviar os boletos aos alunos.

#### Critérios de Aceitação
- O Sistema de Matrículas deve enviar notificações ao Sistema de Cobranças com a lista de disciplinas e alunos matriculados.
- O Sistema de Cobranças deve receber todas as informações necessárias para calcular e gerar os boletos.
- O Sistema de Cobranças deve gerar relatórios de cobrança com base nas informações recebidas.

### 6. História de Usuário: Validar Login

**Como** Usuário do Sistema (Aluno ou Professor),
**Eu quero** fazer login no sistema com minhas credenciais,
**Para que** eu possa acessar as funcionalidades do sistema de matrículas, como matrícula, consulta de alunos e geração de relatórios.

#### Critérios de Aceitação
- O sistema deve validar o login com base no nome de usuário e senha fornecidos.
- Se as credenciais estiverem corretas, o usuário deve acessar as funcionalidades apropriadas.
- Se as credenciais estiverem incorretas, o sistema deve exibir uma mensagem de erro e solicitar a reentrada dos dados.