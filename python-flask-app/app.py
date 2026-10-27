from flask import Flask
app = Flask(__name__)
@app.route("/")
def home():
 return """
 <!DOCTYPE html>
 <html>
 <head>
 <title>Dockerized Python App</title>
 </head>
 <body>
 <h1>Hello from Dockerized Python!</h1>
 <p>This Flask application is running in GitHub Codespaces.</p>
 </body>
 </html>
 """
if __name__ == "__main__":
 app.run(host="0.0.0.0", port=5000)
