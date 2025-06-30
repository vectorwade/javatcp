import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Servidor {
    private static final int PORTA = 5000;
    private static final List<String> RESPOSTAS = List.of(
        "Interessante... continue.",
        "Essa é uma boa pergunta.",
        "Você sempre pensa assim?",
        "Conte-me mais sobre isso.",
        "Que experiência fascinante!",
        "Isso me faz pensar...",
        "Muito bem observado!",
        "Entendo seu ponto de vista.",
        "Isso é realmente intrigante.",
        "Continue, estou ouvindo..."
    );
    
    private static final Random random = new Random();
    private static final AtomicInteger clienteContador = new AtomicInteger(0);

    public static void main(String[] args) {
        System.out.println("=== SERVIDOR TCP CHAT ===");
        System.out.println("Servidor iniciado na porta " + PORTA);
        System.out.println("Aguardando conexões...\n");

        try (ServerSocket servidorSocket = new ServerSocket(PORTA)) {
            while (true) {
                Socket clienteSocket = servidorSocket.accept();
                
                // Criar nova thread para cada cliente
                int numeroCliente = clienteContador.incrementAndGet();
                Thread threadCliente = new Thread(new ManipuladorCliente(clienteSocket, numeroCliente));
                threadCliente.start();
                
                System.out.println("[SERVIDOR] Cliente #" + numeroCliente + 
                    " conectado de " + clienteSocket.getInetAddress().getHostAddress() + 
                    ":" + clienteSocket.getPort());
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }

    static class ManipuladorCliente implements Runnable {
        private final Socket clienteSocket;
        private final int numeroCliente;

        public ManipuladorCliente(Socket socket, int numero) {
            this.clienteSocket = socket;
            this.numeroCliente = numero;
        }

        @Override
        public void run() {
            try (
                BufferedReader leitor = new BufferedReader(
                    new InputStreamReader(clienteSocket.getInputStream()));
                PrintWriter escritor = new PrintWriter(
                    clienteSocket.getOutputStream(), true)
            ) {
                String mensagem;
                
                // Enviar mensagem de boas-vindas
                escritor.println("Bem-vindo ao servidor! Digite 'sair' para encerrar.");
                
                while ((mensagem = leitor.readLine()) != null) {
                    System.out.println("[Cliente #" + numeroCliente + "] " + mensagem);
                    
                    if ("sair".equalsIgnoreCase(mensagem.trim())) {
                        escritor.println("Conexão encerrada. Até logo!");
                        break;
                    }
                    
                    // Enviar resposta aleatória
                    String resposta = RESPOSTAS.get(random.nextInt(RESPOSTAS.size()));
                    escritor.println(resposta);
                }
                
            } catch (IOException e) {
                System.err.println("Erro na comunicação com cliente #" + numeroCliente + ": " + e.getMessage());
            } finally {
                try {
                    clienteSocket.close();
                    System.out.println("[SERVIDOR] Cliente #" + numeroCliente + " desconectado.");
                } catch (IOException e) {
                    System.err.println("Erro ao fechar conexão do cliente #" + numeroCliente);
                }
            }
        }
    }
}
