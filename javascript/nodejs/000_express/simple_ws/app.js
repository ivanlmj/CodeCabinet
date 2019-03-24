var express = require('express');
var app = express();
var port = 3000;

app.get('/', function(req, res) {
    res.send('Hello World!');
});

app.get('/username/:user_name', function(req, res) {
    res.status(200);
    res.set('Content-type', 'text/html');
    res.send('<h1>Hello, ' + req.params.user_name + '!</h1>');
});

app.listen(port, function() {
    console.log("Server is running. Open your browser at http://localhost:%s", port);
});
