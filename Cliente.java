import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    private static final String HOST = "localhost";
    private static final int PORTA = 5000;

    public static void main(String[] args) {
        System.out.println("=== CLIENTE TCP CHAT ===");
        System.out.println("Conectando ao servidor " + HOST + ":" + PORTA + "...");

        try (
            Socket socket = new Socket(HOST, PORTA);
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("Conectado com sucesso!");
            
            
            String boasVindas = leitor.readLine();
            System.out.println("[SERVIDOR] " + boasVindas);
            System.out.println("\nDigite suas mensagens (ou 'sair' para encerrar):");
            System.out.println("----------------------------------------");

            String mensagem;
            while (true) {
                System.out.print("Voce: ");
                mensagem = scanner.nextLine();
                
                
                escritor.println(mensagem);
                
                if ("sair".equalsIgnoreCase(mensagem.trim())) {
                   
                    String respostaFinal = leitor.readLine();
                    if (respostaFinal != null) {
                        System.out.println("[SERVIDOR] " + respostaFinal);
                    }
                    break;
                }
                
                
                String resposta = leitor.readLine();
                if (resposta != null) {
                    System.out.println("[SERVIDOR] " + resposta);
                } else {
                    System.out.println("Servidor desconectado.");
                    break;
                }
                System.out.println(); 
            }
            
            System.out.println("Conexão encerrada.");
            
        } catch (ConnectException e) {
            System.err.println("Erro: Nao foi possível conectar ao servidor.");
            System.err.println("Verifique se o servidor está executando na porta " + PORTA);
        } catch (IOException e) {
            System.err.println("Erro na comunicao: " + e.getMessage());
        }
    }
}
