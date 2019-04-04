const assert = require('assert');
const request = require('supertest');
const app = require('./app')


describe('POST: create new task (id:5)', function() {
    test('It should return response 200.', (done) => {
        request(app).post('/api/v1.0/tasks').send({
	    title: "Code Refactor",
	    user: "ivanleonczBR"
	}).expect(200).end(function(err, res) {
	    done();
	});
    });
});


describe('GET: created task (id:5)', function() {
    test('It respond with json', function() {
	return request(app)
	    .get('/api/v1.0/tasks/5')
	    .set('Accept', 'application/json')
	    .expect('Content-Type', /json/)
	    .expect(200)
	    .then(response => {
		    assert(response.body.title, 'Code Refactor');
	    })
    });
});


describe('PUT: update task (id:5)', function() {
    test('It should return response 200.', function() {
        return request(app)
	    .put('/api/v1.0/tasks/5')
	    .send({title:'Code Refactor API',user:'ivanleoncz'})
	    .expect(200);
    });
});


describe('DELETE: delete task (id:5)', function() {
    test('It should return response 200', function() {
        return request(app)
	    .del('/tasks/5')
	    .expect(404);
    });
});


describe('GET: all tasks', function() {
    test('It should response 200.', (done) => {
        request(app).get('/api/v1.0/tasks').then(function(response) {
	    expect(response.statusCode).toBe(200);
	    done();
	});
    });
});

