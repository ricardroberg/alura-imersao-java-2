import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClientHttp {

    public String searchData(String url) {
        try {

            URI urlAddress = URI.create(url);
            var client = java.net.http.HttpClient.newHttpClient();
            var request = HttpRequest.newBuilder(urlAddress).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String body = response.body();
            return body;

        } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }
}
