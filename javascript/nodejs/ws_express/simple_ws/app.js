var express = require('express');
var path = require('path');
var port = 3000;

var app = express();
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

app.get('/', function(req, res) {
    res.render('index', {username: 'ivanleoncz'});
});

app.get('/username/:user_name', function(req, res) {
    res.status(200);
    res.set('Content-type', 'text/html');
    res.send('<h1>Hello, ' + req.params.user_name + '!</h1>');
});

app.listen(port, function() {
    console.log("Server is running. Open your browser at http://localhost:%s", port);
});
