import java.util.Scanner;

public class PostService {

    private Scanner scanner;

    public PostService() {
        this.scanner = new Scanner(System.in);
    }

    public String gerarPostManual() {
        System.out.println("Digite o título do post:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o conteúdo do post:");
        String conteudo = scanner.nextLine();
        System.out.println("Digite o ID do usuário:");
        int usuarioId = scanner.nextInt();
        scanner.nextLine();
        
        return """
                {
                    "title": "%s",
                    "body": "%s",
                    "userId": %d
                }
                """.formatted(titulo, conteudo, usuarioId);
    }

    public String gerarPutManual(int id) {
        System.out.println("Atualizando post com ID: " + id);
        System.out.println("Digite o novo título do post:");
        String titulo = scanner.nextLine();
        System.out.println("Digite o novo conteúdo do post:");
        String conteudo = scanner.nextLine();
        System.out.println("Digite o ID do usuário:");
        int usuarioId = scanner.nextInt();
        scanner.nextLine();
        
        return """
                {
                    "id": %d,
                    "title": "%s",
                    "body": "%s",
                    "userId": %d
                }
                """.formatted(id, titulo, conteudo, usuarioId);
    }
}
