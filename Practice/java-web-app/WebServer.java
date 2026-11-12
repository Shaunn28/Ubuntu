import java.io.IOException; 
import java.io.OutputStream; 
import java.net.InetSocketAddress; 
import java.nio.charset.StandardCharsets; 
import com.sun.net.httpserver.HttpServer; 

public class WebServer { 
    public static void main(String[] args) throws IOException { 
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0); 
        server.createContext("/", exchange -> 
        { String response = "Hello from Dockerized Java Web Server!"; 
        byte[] bytes = response.getBytes(StandardCharsets.UTF_8); 
        exchange.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8"); 
        exchange.sendResponseHeaders(200, bytes.length); 
        try (OutputStream os = exchange.getResponseBody()) { 
            os.write(bytes); 
        } 
    }); 
    server.start(); 
    System.out.println("Java Web Server listening on port 8080"); 
    } 
}