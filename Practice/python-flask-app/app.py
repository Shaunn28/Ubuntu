from flask import flask

app = flask(__name__)

@app.route("/")
def home():
        return "Hello from DOckerized Python FLask!"

if __name__ == "__main__":
    app.run(port=5000)