var builder = WebApplication.CreateBuilder(args); 
var app = builder.Build(); 
app.MapGet("/", () => Results.Content("Hello from Dockerized C# Web App!", "text/plain")); 
app.Run();