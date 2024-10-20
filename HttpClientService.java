import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;

public class HttpClientService {

    private static final String URL_BASE = "https://jsonplaceholder.typicode.com";
    private HttpClient client;

    public HttpClientService() {
        this.client = HttpClient.newHttpClient();
    }

    public void get(String endpoint) throws IOException, InterruptedException {
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + endpoint))
                .GET()
                .build();

        HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());

        System.out.println("GET Status da Resposta: " + resposta.statusCode());
        System.out.println("GET Corpo da Resposta: " + resposta.body());
    }

    public void post(String endpoint, String json) throws IOException, InterruptedException {
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + endpoint))
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());

        System.out.println("POST Status da Resposta: " + resposta.statusCode());
        System.out.println("POST Corpo da Resposta: " + resposta.body());
    }

    public void put(String endpoint, String json) throws IOException, InterruptedException {
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + endpoint))
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());

        System.out.println("PUT Status da Resposta: " + resposta.statusCode());
        System.out.println("PUT Corpo da Resposta: " + resposta.body());
    }

    public void delete(String endpoint) throws IOException, InterruptedException {
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(URL_BASE + endpoint))
                .DELETE()
                .build();

        HttpResponse<String> resposta = client.send(requisicao, HttpResponse.BodyHandlers.ofString());

        System.out.println("DELETE Status da Resposta: " + resposta.statusCode());
        System.out.println("DELETE Corpo da Resposta: " + resposta.body());
    }
}
