const express = require('express');
const bodyParser = require('body-parser');
const port = 3000;

var app = express();
var router = express.Router();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: true}));

var tasks = [
	{id: '1', task: "Create REST API with ExpressJS", user:"ivanleonczBR"},
	{id: '2', task: "Build Front-end in AngularJS", user:"erikaUS"},
	{id: '3', task: "Integrate Mobile App with REST API", user:"emiliaDE"},
	{id: '4', task: "Design Tests for Mobile App", user:"charlesUK"}
];

router.get('/tasks', function(req, res) {
    console.log('Tasks (GET): ALL');
    res.send(tasks);
});

router.get('/tasks/:task_id', function(req, res) {
    console.log('Tasks (GET): ' + req.params.task_id);
    // tasks start in 1, not 0
    res.send(tasks[req.params.task_id - 1]);
});

router.post('/tasks/', function(req, res) {
    console.log('Tasks (POST): ' + req.body.task);
    const idx = parseInt(tasks[tasks.length - 1].id) + 1;
    const task_desc = req.body.task;
    const task_user = req.body.user;
    tasks.push({id: idx.toString(), task:task_desc, user:task_user});
    res.send("Done!");
});

router.put('/tasks/:task_id', function(req, res) {
    console.log('Tasks (PUT): ' + req.params.task_id);
    const idx = req.params.task_id - 1;
    const task_desc = req.body.task;
    const task_user = req.body.user;
    tasks[idx].task = task_desc;
    tasks[idx].user = task_user;
    res.send("Done!");
});

router.delete('/tasks/:task_id', function(req, res) {
    console.log('Tasks (DELETE): ' + req.params.task_id);
    tasks.pop(parseInt(req.params.task_id) -1)
    res.send("Done!");
});

app.use('/api/v1.0', router);

app.listen(port, function() {
    console.log("Server is running: http://localhost:%s", port);
});




