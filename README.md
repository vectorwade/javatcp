# TCP Chat Java - Sistema de Comunicação Distribuída

## 📋 Descrição
Sistema de chat em Java implementando comunicação TCP entre múltiplos clientes e um servidor. O projeto demonstra conceitos de sistemas distribuídos, programação concorrente e sockets.



### Servidor
- Escuta na porta **5000**
- Suporta **múltiplos clientes simultâneos** usando threads
- Exibe IP de cada cliente conectado
- Responde com mensagens aleatórias predefinidas
- Gerencia desconexões de forma segura

### Cliente
- Conecta ao servidor via TCP
- Interface interativa via terminal
- Comunicação bidirecional em tempo real
- Encerramento limpo com comando "sair"



## 🚀 Como Executar

### Opção 1: Scripts Automatizados (Windows)

1. **Compilar o projeto:**
   ```batch
   compilar.bat
   ```

2. **Executar o servidor:**
   ```batch
   executar-servidor.bat
   ```

3. **Executar cliente(s)** (em terminais separados):
   ```batch
   executar-cliente.bat
   ```

### Opção 2: Comandos Manuais

1. **Compilar:**
   ```bash
   javac -d build *.java
   ```

2. **Executar servidor:**
   ```bash
   java -cp build Servidor
   ```

3. **Executar cliente:**
   ```bash
   java -cp build Cliente
   ```

### Opção 3: Usando VS Code

1. Abra o projeto no VS Code
2. Use `Ctrl+Shift+P` → "Java: Run Java"
3. Selecione `Servidor.java` primeiro
4. Em seguida execute `Cliente.java` em terminal separado

## 💬 Como Usar

1. **Inicie o servidor** primeiro
2. **Execute um ou mais clientes** em terminais separados
3. **Digite mensagens** no cliente e pressione Enter
4. **Receba respostas** automáticas do servidor
5. **Digite "sair"** para encerrar a conexão

### Exemplo de Sessão:


### Compilar

```bash
javac servidor/Servidor.java
javac cliente/Cliente.java
```

### Executar

```bash
java servidor.Servidor
java cliente.Cliente
```

Digite mensagens e veja as respostas do servidor. Digite `sair` para encerrar.

## Autoria

Victor Carvalho - Projeto para disciplina de Sistemas Distribuídos.
