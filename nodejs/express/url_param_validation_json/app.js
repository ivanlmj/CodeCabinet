const express = require('express')
const app = express()
const port = 3000


var candidate = {
    name: "ivanleoncz",
    role: "Software Developer",
    birthdate: "1988-09-14",
    skills : ["Python", "Flask", "Django", "JavaScript", "Express.js" "SQL"]
}

app.get('/', (req, res) => res.send('Hello World!'))

app.get('/username/:username', function(req, res) {
    if (req.params.username === candidate.name) {
    	res.setHeader('Content-Type', 'application/json');
    	res.end(JSON.stringify(candidate));
    } else {
        res.send("Unkown user!")
    }
})

app.listen(port, () => console.log(`App listening on port ${port}.`))
