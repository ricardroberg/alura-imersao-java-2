import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NasaContentExtractor implements ContentExtractor {

    public List<Content> contentExtrator(String json) {

        // extrair só os dados que interessam (titulo, poster)
        var parser = new JsonParser();
        List<Map<String, String>> attributesList = parser.parse(json);

        List<Content> contents = new ArrayList<>();

        // popular a lista de conteudos
        for (Map<String, String> attributes : attributesList) {

            String title = attributes.get("title");
            String imageUrl = attributes.get("url");

            Content content = new Content(title, imageUrl);
            contents.add(content);
        }

        return contents;

    }
}
