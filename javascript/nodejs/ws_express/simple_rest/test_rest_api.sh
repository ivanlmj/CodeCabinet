#!/bin/bash

# GET:
echo -e "\n> GET:"
curl http://localhost:3000/api/v1.0/tasks
echo -e "\n"
read -p "Press any key for the next request..."

# POST
echo -e "\n> POST"
curl -X POST --data "title=Code Refactor&user=ivanleoncz" http://localhost:3000/api/v1.0/tasks
echo -e "\n"
read -p "Press any key for the next request..."

# GET
echo -e "\n> GET"
curl http://localhost:3000/api/v1.0/tasks
echo -e "\n"
read -p "Press any key for the next request..."

# GET: 5
echo -e "\n> GET:    TASK (5)"
curl http://localhost:3000/api/v1.0/tasks/5
echo -e "\n"
read -p "Press any key for the next request..."

# PUT: 5
echo -e "\n> PUT:    TASK (5)"
curl -X PUT --data "title=Code Refactor for API&user=ivanleoncz" http://localhost:3000/api/v1.0/tasks/5
echo -e "\n"
read -p "Press any key for the next request..."

# GET: 5
echo -e "\n> GET:    TASK (5)"
curl http://localhost:3000/api/v1.0/tasks/5
echo -e "\n"
read -p "Press any key for the next request..."

# DELETE: 5
echo -e "\n> DELETE: TASK (5)"
curl -X DELETE http://localhost:3000/api/v1.0/tasks/5
echo -e "\n"
read -p "Press any key for the next request..."

# GET
echo -e "\n> GET"
curl http://localhost:3000/api/v1.0/tasks
echo -e "\n"
echo "Bye!"
