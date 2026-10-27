var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

app.MapGet("/", () => Results.Content("""
    <!doctype html>
    <html lang="en">
    <head><meta charset="utf-8"><title>C# Docker Practice</title></head>
    <body>
      <h1>Hello from a C# web container!</h1>
      <p>The ASP.NET Core application is running.</p>
      <p>Try <a href="/health">/health</a> for a JSON response.</p>
    </body>
    </html>
    """, "text/html"));

app.MapGet("/health", () => Results.Ok(new
{
    status = "ok",
    app = "csharp-web-practice"
}));

app.Run();