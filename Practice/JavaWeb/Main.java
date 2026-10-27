import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = Integer.parseInt(System.getenv().getOrDefault("PORT", "8080"));
        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", port), 0);

        server.createContext("/", exchange -> {
            String html = "<!doctype html><html lang=\"en\"><head><meta charset=\"utf-8\"><title>Java Docker Practice</title></head><body><h1>Hello from a Java web container!</h1><p>If you can read this, the Java HTTP server is running.</p><p><a href=\"/health\">Health endpoint</a></p></body></html>";
            byte[] response = html.getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
            exchange.sendResponseHeaders(200, response.length);
            try (OutputStream output = exchange.getResponseBody()) { output.write(response); }
        });

        server.createContext("/health", exchange -> {
            byte[] response = "{\"status\":\"ok\",\"app\":\"java-web-practice\"}".getBytes(StandardCharsets.UTF_8);
            exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
            exchange.sendResponseHeaders(200, response.length);
            try (OutputStream output = exchange.getResponseBody()) { output.write(response); }
        });

        server.start();
        System.out.println("Java web practice listening on port " + port);
    }
}
