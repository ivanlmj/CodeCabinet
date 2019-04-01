const request = require('supertest');
const app = require('./app')

describe('GET all tasks', function() {
    test('It should response 200.', (done) => {
        request(app).get('/api/v1.0/tasks').then(function(response) {
	    expect(response.statusCode).toBe(200);
	    done();
	});
    });
});


describe('GET single task', function() {
    test('It should return response 200.', (done) => {
        request(app).get('/api/v1.0/tasks/1').then(function(response) {
	    expect(response.statusCode).toBe(200);
	    done();
	});
    });
});


describe('POST/Create new task', function() {
    test('It should return response 200.', (done) => {
        request(app).post('/api/v1.0/tasks').send({
	    title: "Code  Refactor",
	    user: "ivanleonczBR"
	}).expect(200).end(function(err, res) {
	    done();
	});
    });
});
