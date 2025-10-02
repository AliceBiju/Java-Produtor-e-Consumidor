# Projeto: Produtor-Consumidor com Threads em Java

Este projeto demonstra a utilização de threads em Java para implementar o problema clássico do **produtor-consumidor**. O objetivo é criar duas threads (T1 e T2) que compartilham uma lista de inteiros e interagem entre si para preencher e consumir os valores de forma concorrente.

---

## Estrutura do Projeto

O projeto é composto pelas seguintes classes:

- **`SharedList.java`**: Classe responsável pela lista compartilhada entre as threads, com métodos sincronizados para adicionar e consumir valores da lista.
- **`ProducerThread.java`**: Thread que adiciona valores inteiros à lista compartilhada.
- **`ConsumerThread.java`**: Thread que consome e imprime os valores da lista compartilhada.
- **`Main.java`**: Classe principal que inicializa e executa as threads produtoras e consumidoras.

---

## Diagrama do Fluxo de Execução

- **T1 (Produtora)**: Adiciona valores inteiros à lista compartilhada.
- **T2 (Consumidora)**: Retira valores da lista e os imprime.
- Ambas as threads interagem de forma sincronizada, utilizando os métodos `wait()` e `notify()` para garantir que uma thread aguarde pela outra quando a lista estiver cheia ou vazia.

---

## Como Funciona

### Produtor (T1)
- A thread T1 adiciona valores inteiros à lista compartilhada (de 1 a 20).
- Caso a lista atinja o limite máximo de 10 valores, a thread T1 aguarda até que a thread T2 consuma algum valor.
- A cada valor adicionado, T1 notifica T2 de que um novo valor está disponível para consumo.

### Consumidor (T2)
- A thread T2 consome os valores da lista e os imprime.
- Caso a lista esteja vazia, a thread T2 aguarda até que a thread T1 adicione novos valores.
- A cada valor consumido, T2 notifica T1 de que há espaço disponível na lista para adicionar novos valores.

---

## Requisitos

- Java **8** ou versão mais recente instalada no sistema.

---

## Como Executar

### 1. Compile os arquivos `.java`:
javac *.java

### 1. Executar o programa:
java Main

---

## Saída esperada

Ao executar o programa, você verá algo semelhante a isso no console, com valores sendo adicionados e consumidos pela T1 e T2:

- T1: Valor 1 adicionado.
- T2: Valor 1 consumido.
- T1: Valor 2 adicionado.
- T2: Valor 2 consumido.

