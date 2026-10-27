from flask import Flask, jsonify

app = Flask(__name__)

@app.get("/")
def home():
    return """
    <!doctype html>
    <html lang="en">
      <head><meta charset="utf-8"><title>Python Docker Practice</title></head>
      <body>
        <h1>Hello from a Python web container!</h1>
        <p>The Flask application is running.</p>
        <p>Try <a href="/health">/health</a> for a JSON response.</p>
      </body>
    </html>
    """

@app.get("/health")
def health():
    return jsonify(status="ok", app="python-web-practice")

if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)
