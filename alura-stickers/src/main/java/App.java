import io.github.cdimascio.dotenv.Dotenv;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // Carregando a chave API declarada em arquivo .ENV
        Dotenv dotenv = Dotenv.load();
        String apiKey = dotenv.get("NASAKEY");
        String mainURL = "https://api.nasa.gov/planetary/apod?api_key=";
        String url = mainURL + apiKey + "&start_date=2023-03-29&end_date=2023-03-29";
//        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&start_date=2023-03-29&end_date=2023-03-29";
//        String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";


        var http = new ClientHttp();
        String json = http.searchData(url);

        // exibir e manipular os dados
        ContentExtractor extractor = new NasaContentExtractor();
//        ContentExtractor extractor = new IMDBContentExtractor();
        List<Content> contents = extractor.contentExtrator(json);

        StickersGenerator newSticker = new StickersGenerator();

        for (Content content : contents) {
            InputStream inputStream = new URL(content.getImageURL()).openStream();
            String fileName = content.getTitle().replace(": ", "-") + ".png";

            newSticker.create(inputStream, fileName);

            System.out.println(content.getTitle());
            System.out.println();
        }
//        sc.close();
    }
}