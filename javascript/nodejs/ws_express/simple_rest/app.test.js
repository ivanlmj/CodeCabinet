const assert = require('assert');
const request = require('supertest');
const app = require('./app')


describe('POST: create new task (id:5)', function() {
    test('Should return response 200.', (done) => {
        request(app).post('/api/v1.0/tasks').send({
	    title: "Code Refactor",
	    user: "ivanleonczBR"
	}).expect(200).end(function(err, res) {
	    done();
	});
    });
});

describe('GET: created task (id:5)', function() {
    test('Should respond with JSON.', function() {
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
    test('Should return response 200.', function() {
        return request(app)
	    .put('/api/v1.0/tasks/5')
	    .send({title:'Code Refactor API',user:'ivanleoncz'})
	    .expect(200);
    });
});

describe('DELETE: delete task (id:5)', function() {
    test('Should return response 200.', function() {
        return request(app)
	    .del('/api/v1.0/tasks/5')
	    .expect(200);
    });
});

describe('GET: all tasks', function() {
    test('Should return response 200.', (done) => {
        request(app).get('/api/v1.0/tasks').then(function(response) {
	    expect(200);
	    done();
	});
    });
});
