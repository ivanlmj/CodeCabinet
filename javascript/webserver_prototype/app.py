#!/usr/bin/python3

from flask import Flask, jsonify, render_template, request

app = Flask(__name__)

@app.route("/")
@app.route("/index")
def f_index():
    return render_template("index.html")

@app.route("/registry", methods = ["GET", "POST"])
def f_registry():
    if request.method == "GET":
        return render_template("registry.html")
    if request.method == "POST":
        name       = request.form["name"]
        birthdate  = request.form["birthdate"]
        profession = request.form["profession"]
        email      = request.form["email"]
        country    = request.form["country"]
        data = {
                "name":name, 
                "birthdate":birthdate, 
                "profession":profession,
                "email":email,
                "country":country
                }
        return jsonify(data)

if __name__ == "__main__":
    app.run(debug=True)
