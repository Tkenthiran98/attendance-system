Attendance System
This project is an attendance system that consists of a backend server built with Spring Boot and a frontend client built with Angular. The system allows users to log in, manage their attendance, and provides basic authentication and authorization mechanisms.

Table of Contents
Project Structure
Backend Setup
Frontend Setup
Client-Server Interaction
Endpoints
Technologies Used
 

attendance-system
├── server
│   ├── build.gradle
│   └── system
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── com
│       │   │   │       └── attendance
│       │   │   │           └── system
│       │   │   │               ├── controller
│       │   │   │               │   └── AuthController.java
│       │   │   │               ├── model
│       │   │   │               │   └── User.java
│       │   │   │               ├── security
│       │   │   │               │   └── SecurityConfig.java
│       │   │   │               └── service
│       │   │   │                   └── AuthService.java
│       │   │   └── resources
│       │   │       └── users.txt
│       │   └── test
│       └── build.gradle
├── client
│   ├── src
│   │   ├── app
│   │   │   ├── auth.guard.ts
│   │   │   ├── auth.service.ts
│   │   │   ├── home
│   │   │   │   └── home.component.ts
│   │   │   ├── login
│   │   │   │   ├── login.component.html
│   │   │   │   └── login.component.ts
│   │   │   ├── app.component.ts
│   │   │   ├── app.module.ts
│   │   │   └── app-routing.module.ts
│   └── package.json
├── docs
│   └── documentation.md
└── README.md

Backend Setup

  Clone the repository
  git clone https://github.com/Tkenthiran98/attendance-system.git
     cd attendance-system/server
Backend directory structure

AuthController.java: Handles authentication requests.
User.java: Represents the user model.
SecurityConfig.java: Configures Spring Security.
AuthService.java: Provides authentication services.
users.txt: Stores user credentials.


Frontend Setup

  Navigate to the client directory
  Install dependencies
     npm install
  Run the frontend
     ng serve
The frontend application will start on `http://localhost:4200`.

Frontend directory structure

auth.service.ts: Handles authentication logic.
auth.guard.ts: Protects routes based on authentication status.
login.component.ts and login.component.html: Handles user login.
home.component.ts and home.component.html: Represent the home component.
app-routing.module.ts: Defines application routes.
app.module.ts: Configures the Angular module.


Client-Server Interaction

AuthService (auth.service.ts)
Login method: Sends a login request to the backend and stores the JWT token on success.
Logout method: Clears the JWT token and redirects to the login page.
isLoggedIn method: Checks if the user is logged in by verifying the presence of a JWT token.

LoginComponent (login.component.ts and login.component.html)
Form validation: Validates username and password input fields.
Login logic: Calls the AuthService's login method and handles success and error messages.
Redirect logic: Redirects to the home page on successful login.

AuthGuard (auth.guard.ts)
Route protection: Prevents access to routes if the user is not authenticated.

Endpoints
Backend
POST /api/auth/login: Authenticates the user and returns a JWT token.

Frontend
/login: Login page for the user.
/home: Home page, accessible only if authenticated.

Technologies Used
Backend: Spring Boot, Spring Security, JWT, Gradle
Frontend: Angular, TypeScript, Bootstrap
Build Tools: Gradle, npm
Editor: Vs code 