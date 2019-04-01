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
