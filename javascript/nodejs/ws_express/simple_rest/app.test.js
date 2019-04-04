const assert = require('assert');
const request = require('supertest');
const app = require('./app')

describe('GET: all tasks', function() {
    test('It should response 200.', (done) => {
        request(app).get('/api/v1.0/tasks').then(function(response) {
	    expect(response.statusCode).toBe(200);
	    done();
	});
    });
});


describe('GET: single task', function() {
    test('It should return response 200.', (done) => {
        request(app).get('/api/v1.0/tasks/1').then(function(response) {
	    expect(response.statusCode).toBe(200);
	    done();
	});
    });
});


describe('POST: create new task', function() {
    test('It should return response 200.', (done) => {
        request(app).post('/api/v1.0/tasks').send({
	    title: "Code Refactor",
	    user: "ivanleonczBR"
	}).expect(200).end(function(err, res) {
	    done();
	});
    });
});


describe('GET: created task', function() {
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
