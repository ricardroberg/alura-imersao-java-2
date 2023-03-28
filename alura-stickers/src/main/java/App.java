import io.github.cdimascio.dotenv.Dotenv;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);

        // Carregando a chave API declarada em arquivo .ENV
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("APIKEY");

        Scanner sc = new Scanner(System.in);

        final String MOST_POPULAR_TV = "MostPopularTVs/";
        final String MOST_POPULAR_MOVIE = "MostPopularMovies/";
        final String TOP_250_TV = "Top250TVs/";
        final String TOP_250_MOVIE = "Top250Movies/";

        String SearchField = "";
        int opcao = 0;

        System.out.println("====================================================");
        System.out.println("1 - Exibir lista Top 250 Filmes");
        System.out.println("2 - Exibir lista Top 250 Séries TV");
        System.out.println("3 - Filmes mais populares");
        System.out.println("4 - Séries TV mais populares");
        System.out.println("====================================================");
        opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1 -> SearchField = TOP_250_MOVIE;
            case 2 -> SearchField = TOP_250_TV;
            case 3 -> SearchField = MOST_POPULAR_MOVIE;
            case 4 -> SearchField = MOST_POPULAR_TV;
        }

        // fazer uma conexão HTTP e buscar os top 250 filmes
        // String url = "https://imdb-api.com/pt/API/" + SearchField + api_key; // SITE OFF (acesso bloqueado por excesso de acessos)
        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();
//        System.out.println(body);

        // extrair só os dados que interessam (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        // exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            System.out.println("Título: " + filme.get("title"));
            System.out.println("Poster: " + filme.get("image"));
            System.out.println("\u001B[41m" + "Classificação: " + filme.get("imDbRating") + "\u001B[0m");
            System.out.println("\u2B50".repeat((int) Double.parseDouble(filme.get("imDbRating"))));
            System.out.println();
        }
        sc.close();
    }
}