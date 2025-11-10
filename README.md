# Todo API (Spring Boot) – README

A simple RESTful **Todo API** built with **Spring Boot**, ideal for teaching students how to build real backend applications using Java, REST, and IntelliJ IDEA Community Edition.

This README explains:

✅ How to clone the project from GitHub  
✅ How to open it in IntelliJ Community  
✅ How to build & run it with Maven  
✅ How to call the API from browser, Postman, or HTML/JS frontend  

https://start.spring.io/

---

# ✅ 1. Clone the project from GitHub

Open a terminal (PowerShell / CMD / Git Bash):

```sh
git clone https://github.com/<your-username>/todo-api.git
cd todo-api
```

*(Replace `<your-username>` with your actual GitHub account.)*

---

# ✅ 2. Open the project in IntelliJ IDEA Community Edition

1. Start IntelliJ  
2. Click **File → Open**  
3. Select the folder:  
   ```
   todo-api/
   ```  
4. IntelliJ will detect `pom.xml` and automatically import the Maven project  
5. Wait until Maven dependencies download (a small notification will appear)

✅ The project will appear in the left Project Explorer  
✅ IntelliJ Community fully supports Spring Boot (no Ultimate needed for basic use)

---

# ✅ 3. Project Structure

```
todo-api/
 ├── pom.xml
 ├── src/main/java/com/coolcsn/todo_api
 │     ├── TodoApiApplication.java
 │     ├── controller/
 │     │       └── TodoController.java
 │     ├── service/
 │     │       ├── TodoService.java
 │     │       └── InMemoryTodoService.java
 │     ├── model/
 │     │       └── Todo.java
 │     └── dto/
 │             ├── CreateTodoRequest.java
 │             └── UpdateTodoRequest.java
 └── src/main/resources
        └── application.properties
```

---

# ✅ 4. How to run the API from IntelliJ Community

### Option A — Run using Spring Boot launcher

1. Open `TodoApiApplication.java`
2. Click the green ▶ (Run) icon in the left gutter
3. Choose **Run 'TodoApiApplication'**

The console should show:

```
Started TodoApiApplication in X seconds
Tomcat started on port(s): 8080
```

✅ Application is now running at:  
http://localhost:8080

---

# ✅ 5. How to run from Terminal (Maven)

Inside the project:

```sh
mvn spring-boot:run
```

or build a JAR:

```sh
mvn clean package
java -jar target/todo-api-0.0.1-SNAPSHOT.jar
```

---

# ✅ 6. REST API Endpoints

### ✅ Get all todos
```
GET http://localhost:8080/api/todos
```

### ✅ Create a new todo
```
POST http://localhost:8080/api/todos
Content-Type: application/json

{
  "title": "Buy milk"
}
```

### ✅ Update todo title
```
PUT http://localhost:8080/api/todos/1
Content-Type: application/json

{
  "title": "Buy bread"
}
```

### ✅ Mark completed / uncompleted
```
PATCH http://localhost:8080/api/todos/1
Content-Type: application/json

{
  "completed": true
}
```

### ✅ Delete a todo
```
DELETE http://localhost:8080/api/todos/1
```

---

# ✅ 7. Testing the API (Multiple Options)

### ✅ Option A — Browser
Just open:

```
http://localhost:8080/api/todos
```

### ✅ Option B — Postman / Insomnia  
Send GET/POST/PUT/PATCH/DELETE requests easily.

### ✅ Option C — Simple HTML/JS Frontend  
Example:

```html
<script>
fetch("http://localhost:8080/api/todos")
  .then(r => r.json())
  .then(console.log);
</script>
```

---

# ✅ 8. Common Issues

| Problem | Solution |
|--------|----------|
| "Port 8080 already in use" | Close the app / use another port in `application.properties` |
| Maven not found | Install Maven or use IntelliJ's bundled Maven |
| Cannot run from IntelliJ | Make sure SDK = **Java 17** |

---

# ✅ 9. Requirements

- **Java 17+**
- **IntelliJ IDEA Community**
- **Maven 3.8+**

---

# ✅ 10. License

MIT License — free to use for teaching and demonstration.

---

# ✅ 11. Author

Stoyan Cheresharov  
Associate Professor  
Plovdiv University “Paisii Hilendarski”  
