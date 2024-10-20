import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClientService httpClientService = new HttpClientService();
        PostService postService = new PostService();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nEscolha uma operação:");
            System.out.println("1. Fazer requisição GET /posts");
            System.out.println("2. Fazer requisição POST /posts (Criar novo post)");
            System.out.println("3. Fazer requisição PUT /posts/1 (Atualizar post com ID 1)");
            System.out.println("4. Fazer requisição DELETE /posts/1 (Deletar post com ID 1)");
            System.out.println("5. Sair");
            System.out.print("Digite o número da opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Executando GET /posts...");
                    httpClientService.get("/posts");
                    break;
                case 2:
                    System.out.println("Executando POST /posts (Criando novo post)...");
                    String novoPost = postService.gerarPostManual();
                    httpClientService.post("/posts", novoPost);
                    break;
                case 3:
                    System.out.println("Executando PUT /posts/1 (Atualizando post com ID 1)...");
                    String postAtualizado = postService.gerarPutManual(1);
                    httpClientService.put("/posts/1", postAtualizado);
                    break;
                case 4:
                    System.out.println("Executando DELETE /posts/1...");
                    httpClientService.delete("/posts/1");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
