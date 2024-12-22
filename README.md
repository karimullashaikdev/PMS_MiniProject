# Project Management Mini Application

## Overview
The Project Management Mini Application is a web-based tool developed using Java, Spring Boot, MySQL, and Hibernate. This application helps users create and manage projects, track progress, and collaborate with team members. It allows features such as project creation, task assignment, and status updates, making project management streamlined and efficient.

## Features
- **User Authentication**: Secure login and user roles (admin, project manager, etc.).
- **Project Management**: Create, edit, and delete projects.
- **Task Assignment**: Assign tasks to project team members and track task status.
- **Progress Tracking**: Monitor the progress of ongoing projects and tasks.
- **Database Integration**: Store project and task data in MySQL with Hibernate ORM for seamless database interaction.
- **RESTful API**: Access the functionality of the application through RESTful endpoints.

## Technologies Used
- **Programming Language**: Java
- **Framework**: Spring Boot
- **Database**: MySQL
- **ORM**: Hibernate
- **Build Tool**: Maven
- **Security**: Spring Security(In Memory Security)

## Getting Started
### Prerequisites
- JDK version 11 or later
- IDE or text editor for Java (e.g., IntelliJ IDEA, STS, Eclipse, or VS Code)
- Maven
- MySQL

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/karimullashaikdev/PMS_MiniProject.git
   ```

## Usage
1. Start the application.
2. Login: Authenticate as an admin or project manager.
3. Create Projects: Add new projects and assign team members.
4. Manage Tasks: Assign tasks to project members and monitor progress.
5. Track Project Status: View and update the status of tasks and projects.
6. API Access: Use RESTful endpoints to interact with the application programmatically.

Example API Endpoints:

1. POST /projects: Create a new project
2. GET /projects: Retrieve all projects
3. GET /projects/{id}: Retrieve details of a specific project
4. POST /tasks: Assign a task to a project
5. GET /tasks: Retrieve all tasks
6. GET /tasks/{id}: Retrieve details of a specific task
7. GET /users: Retrieve user list

## Project Structure
```
src/
├── Main.java               # Main entry point for the application
├── controller/             # REST controller classes for API endpoints
│   ├── ProjectController.java
│   └── TaskController.java
├── model/                  # Entity classes
│   ├── Project.java
│   └── Task.java
├── repository/             # Repository interfaces for data access
│   ├── ProjectRepository.java
│   └── TaskRepository.java
├── service/                # Service layer classes
│   ├── ProjectService.java
│   └── TaskService.java
└── config/                 # Configuration classes (e.g., Spring Security)
    └── SecurityConfig.java
```

## Future Enhancements
- Multi-user Support: Integrating multiple roles with custom permissions (e.g., team members, admin).
- Task Notifications: Send notifications to users when tasks are assigned or updated.
- Reporting: Generate project reports and export data to CSV or PDF formats.
- API Documentation: Add Swagger or OpenAPI integration for easy API documentation

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

## Contact
For any queries or suggestions, feel free to reach out:
- **Name**: Karimulla Shaik
- **Email**: shaikkarimulladev@gmail.com
- **GitHub**: https://github.com/karimullashaikdev
