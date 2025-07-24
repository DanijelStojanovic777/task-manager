# *Task Manager* - Java Spring Boot Backend

A simple Task Manager application for managing tasks and users, created as a *demo project* to showcase backend skills with Java and Spring Boot.

---

## *Technologies Used*
- Java 17
- Spring Boot (in-memory repositories, no external database)
- REST API (CRUD for User and Task)
- Lombok (for cleaner code)
- Maven (build tool)
- Postman (API testing)

---

## *Project Structure*
- **model/** - User, Task, Status, Priority classes (and enums)
- **repository/** - In-memory repositories for User and Task
- **service/** - Business logic, validation, linking tasks and users
- **controller/** - REST endpoints for User and Task
- **exception/** - (will be added) Global error handler for better responses

---

## *How to Run the Project*

1. *Clone the repository:*

    git clone https://github.com/[your-username]/task-manager.git

3. *Run from IntelliJ IDEA* (or terminal):

   ./mvnw spring-boot:run

   The application will be available at *localhost:8080*.

---

# API Endpoints

 ### **User**
- POST /api/users - Create a user
- GET /api/users - List all users
- GET /api/users/{id} - Get user by ID
- DELETE /api/users/{id} - Delete user

 ### **Task**
- POST /api/tasks - Create a task (dueDate is auto-set if not provided)
- GET /api/tasks - List all tasks
- GET /api/tasks/{id} - Get task by ID
- DELETE /api/tasks/{id} - Delete task
- GET /api/tasks/user/{userId} - Get all tasks for a user

---

# *Example JSON Payloads*

### **User:**
```json
{
"name": "Dusan",
"email": "Dusan@example.com"
}
```
### *Task:*
```json
{
  "title": "New task",
  "description": "Testing backend",
  "status": "NEW",
  "priority": "HIGH",
  "dueDate": "2025-08-01",
  "assignedUser": { "id": 1 }
}
```
  (If you do not provide dueDate, it will be automatically set to today + 7 days)

---

## *Project Highlights*

  -Automatic dueDate assignment
  -Task assignment to users with user existence validation
  -Clean, readable code and structure
  -API tested with Postman

Note: This project was created as a technical demo for interviews and learning purposes

---

## Author

  Danijel Stojanovic
  danijel_s97@outlook.com
  LinkedIn: https://www.linkedin.com/in/danijel-stojanovic-50278a92/













