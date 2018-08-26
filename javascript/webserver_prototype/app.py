#!/usr/bin/python3

import os

from flask import Flask, jsonify, render_template, request
from werkzeug import secure_filename

app = Flask(__name__)

FILE_FOLDER = "/tmp"


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
        filestore  = request.files["resume"]
        filename   = secure_filename(filestore.filename)
        dest = os.path.join(FILE_FOLDER, filename)
        filestore.save(dest)
        data = {
                "name":name, 
                "birthdate":birthdate, 
                "profession":profession,
                "email":email,
                "country":country,
                "resume":filename
                }
        return jsonify(data)


if __name__ == "__main__":
    app.run(debug=True)
