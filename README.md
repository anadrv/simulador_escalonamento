# 🐾 Simulador de Escalonamento de Processos 🐾

Projeto desenvolvido para a Fase 01 da competência **Desenvolver Simulador de Abstrações de Recursos de S.O.**

## 🐈 Sobre o projeto

O sistema simula o funcionamento de uma CPU responsável pela execução de processos que chegam de forma periódica.

Cada processo possui um identificador único e uma quantidade de instruções, que são executadas uma por vez a cada ciclo de clock. Quando todas as instruções são executadas, o processo é finalizado.

O simulador implementa três algoritmos de escalonamento:

* **FCFS (First Come, First Served)**
* **SJF (Shortest Job First)**
* **Round Robin**

## 🐈 Funcionamento

A simulação ocorre em ciclos de clock. A cada ciclo, a CPU pode receber novos processos, solicita ao escalonador o próximo processo e executa uma instrução.

O fluxo da simulação é:

1. Verificar se um novo processo deve ser gerado;
2. Adicionar o processo à fila de prontos;
3. Selecionar o próximo processo de acordo com o algoritmo escolhido;
4. Executar uma instrução;
5. Atualizar a quantidade de instruções restantes;
6. Verificar se o processo foi finalizado;
7. No Round Robin, verificar o término do quantum;
8. Avançar para o próximo ciclo.

A CPU permanece em execução por meio de um laço contínuo, permitindo a chegada e execução de novos processos durante a simulação.

### 😺 Geração de processos

Os processos são criados pelo `GeradorDeProcessos`.

Cada processo recebe:

* um **ID único e incremental**;
* uma quantidade aleatória de **10 a 50 instruções**.

A geração ocorre de forma periódica, com uma pequena probabilidade de criação a cada ciclo da CPU.

### 😺 Escalonamento

O `Escalonador` mantém a fila de processos prontos e utiliza o algoritmo selecionado para determinar qual processo receberá a CPU.

* **FCFS:** seleciona o processo que está há mais tempo na fila;
* **SJF:** seleciona o processo com menor quantidade de instruções;
* **Round Robin:** alterna entre os processos utilizando uma fatia de tempo definida pelo quantum.

### 😺 Round Robin

No Round Robin, cada processo recebe um número limitado de ciclos da CPU, definido pelo **quantum**.

Por exemplo, com `quantum = 2`:

```text
P1 → 2 ciclos
P2 → 2 ciclos
P3 → 2 ciclos
P1 → novamente
...
```

Quando o quantum termina e o processo ainda não foi finalizado, ele retorna ao final da fila para aguardar uma nova oportunidade de execução.

Caso o processo termine antes do quantum, ele é removido da fila.

### 😺 Exemplo de execução

```text
Escolha o algoritmo: 1

Algoritmo escolhido: FCFS

- CICLO 1 -
CPU ociosa.

- CICLO 2 -
CPU ociosa.

- CICLO 3 -
Novo processo: P1 | Instruções: 36
Executando processo P1
Instruções restantes: 35

- CICLO 4 -
Executando processo P1
Instruções restantes: 34
```

Como a geração dos processos é aleatória, a quantidade de instruções e o momento de chegada podem variar a cada execução.

## 🐈 Estrutura do projeto

As classes foram separadas de acordo com suas responsabilidades dentro da simulação, reduzindo o acoplamento e facilitando a manutenção e evolução do projeto.

```text
src/
├── Main.java
├── CPU.java
├── Processo.java
├── GeradorDeProcessos.java
├── Escalonador.java
└── AlgoritmoEscalonamento.java
```

### 😺 `Main.java`

Ponto de entrada da aplicação. Responsável por inicializar os componentes, configurar o algoritmo e definir o quantum quando necessário.

### 😺 `Processo.java`

Representa o processo e mantém seu estado, incluindo ID e quantidade de instruções. Também controla a execução e verifica sua finalização.

### 😺 `GeradorDeProcessos.java`

Responsável pela criação dos processos, geração dos IDs e definição aleatória da quantidade de instruções.

### 😺 `Escalonador.java`

Gerencia a fila de processos prontos e disponibiliza os processos para serem selecionados pelo algoritmo de escalonamento.

### 😺 `AlgoritmoEscalonamento.java`

Implementa a lógica de seleção dos processos para os algoritmos **FCFS, SJF e Round Robin**.

### 😺 `CPU.java`

Coordena a execução da simulação, controlando os ciclos de clock, a execução dos processos, a finalização e o quantum do Round Robin.

## 🐈 Tecnologias

* Java
* IntelliJ IDEA
* Git
* GitHub

## 🐈 Como executar

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto no **IntelliJ IDEA**.

3. Execute a classe `Main`.

4. Escolha o algoritmo de escalonamento.

5. Caso escolha **Round Robin**, informe o quantum.
