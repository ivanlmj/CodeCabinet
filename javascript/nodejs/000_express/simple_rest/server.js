const app = require('./app');
const port = 3000;

app.listen(port, function() {
    console.log("Server is running: http://localhost:%s", port);
});
