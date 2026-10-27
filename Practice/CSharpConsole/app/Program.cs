Console.WriteLine("Hello from C# inside Docker!");
Console.WriteLine("This is a console application, not a web API.");

int containers = 3;
int images = 2;

Console.WriteLine(
    $"Practice calculation: {containers} containers + {images} images = {containers + images}");

string mode = Environment.GetEnvironmentVariable("APP_MODE") ?? "practice";
Console.WriteLine($"APP_MODE={mode}");