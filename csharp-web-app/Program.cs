var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();
app.MapGet("/", () => Results.Content(
 """
 <!DOCTYPE html>
 <html>
 <head>
 <title>Dockerized C# Web App</title>
 </head>
 <body>
 <h1>Hello from Dockerized C#!</h1>
 <p>This ASP.NET Core application is running in GitHub Codespaces.</p>
 </body>
 </html>
 """,
 "text/html"
));
app.Run("http://0.0.0.0:8080");