# import flask and sqlaclhemy
from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

# app configuration
app.config["SECRET_KEY"] = 'Es un Secreto'
app.config["SQLALCHEMY_DATABASE_URI"] = 'sqlite:///database\panaderia.db'
db = SQLAlchemy(app)

from panaderia import views
from panaderia import models