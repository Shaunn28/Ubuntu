import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import com.sun.net.httpserver.HttpServer;
public class WebServer {
 public static void main(String[] args) throws IOException {
 HttpServer server = HttpServer.create(
 new InetSocketAddress("0.0.0.0", 8080), 0
 );
 server.createContext("/", exchange -> {
 String response = """
 <!DOCTYPE html>
 <html>
 <head>
 <title>Dockerized Java Web App</title>
 </head>
 <body>
 <h1>Hello from Dockerized Java!</h1>
 <p>This Java web server is running in GitHub Codespaces.</p>
 </body>
 </html>
 """;
 byte[] content = response.getBytes(StandardCharsets.UTF_8);
 exchange.getResponseHeaders().set(
 "Content-Type", "text/html; charset=UTF-8"
 );
 exchange.sendResponseHeaders(200, content.length);
 try (OutputStream output = exchange.getResponseBody()) {
 output.write(content);
 }
 });
 server.start();
 System.out.println("Web server running on port 8080");
 }
}
