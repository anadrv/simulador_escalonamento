## 🐾 Simulador de escalonamento de processos 🐾

Projeto desenvolvido para a Fase 01 da competência Desenvolver Simulador de Abstrações de Recursos de S.O. 



### 🐈 Sobre o projeto

O sistema simula uma CPU executando processos que chegam de forma periódica. Cada processo possui um identificador único e uma quantidade aleatória de instruções que precisam ser executadas.

A cada ciclo de clock, a CPU solicita ao escalonador o próximo processo que deve ser executado.

O projeto implementa três algoritmos de escalonamento:

* **FCFS (First Come, First Served)**
* **SJF (Shortest Job First)**
* **Round Robin**


## 🐈 Funcionamento

### 😺 Processo

Cada processo possui:

* **ID:** identificador único e incremental;
* **Quantidade de instruções:** valor aleatório entre 10 e 50.

A cada interação com a CPU, uma instrução é executada e a quantidade restante é reduzida em 1.

Quando a quantidade de instruções chega a zero, o processo é finalizado.


### 😺 Gerador de Processos

O `GeradorDeProcessos` é responsável por criar novos processos.

Os processos são gerados de forma periódica e recebem:

* um ID único;
* uma quantidade aleatória de instruções entre 10 e 50.

Existe uma pequena chance de um novo processo ser gerado a cada ciclo da CPU.


### 😺 Escalonador

O `Escalonador` mantém a fila de processos prontos e determina qual processo será executado pela CPU.

O algoritmo utilizado pode ser configurado entre:

* **FCFS:** executa os processos na ordem em que chegaram;
* **SJF:** seleciona o processo com a menor quantidade de instruções;
* **Round Robin:** cada processo recebe uma fatia de tempo definida pelo quantum.
  

### 😺 CPU

A CPU possui um laço infinito, no qual cada repetição representa um ciclo de clock.

Em cada ciclo:

1. Verifica se um novo processo deve ser gerado;
2. Adiciona o processo ao escalonador;
3. Solicita o próximo processo ao escalonador;
4. Executa uma instrução;
5. Verifica se o processo foi finalizado;
6. No Round Robin, verifica se o quantum foi atingido;
7. Aguarda um pequeno intervalo antes do próximo ciclo.
   

## 😺 Round Robin

No algoritmo Round Robin, cada processo recebe uma quantidade limitada de ciclos da CPU, definida pelo **quantum**.

Por exemplo, com `quantum = 2`:

```text
P1 → executa 2 ciclos
P2 → executa 2 ciclos
P3 → executa 2 ciclos
P1 → executa novamente
...
```

Caso um processo termine antes de utilizar todo o quantum, ele é finalizado e não retorna para a fila.

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

A quantidade de instruções e o momento de chegada dos processos são determinados aleatoriamente.

### 🐈 Tecnologias

* Java
* IntelliJ IDEA
* Git
* GitHub

### 🐈 Estrutura do projeto

```text
src/
├── Main.java
├── CPU.java
├── Processo.java
├── GeradorDeProcessos.java
├── Escalonador.java
└── AlgoritmoEscalonamento.java
```

### 🐈 Como executar

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Abra o projeto no IntelliJ IDEA.

3. Execute a classe `Main`.

4. Escolha o algoritmo de escalonamento.

5. Caso escolha Round Robin, informe o quantum.


