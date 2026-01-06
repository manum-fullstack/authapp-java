# AuthApp 🔐

AuthApp is a Java-based web authentication application built using **Servlets, JSP, JDBC, and MySQL**.  
It provides basic user authentication features such as signup, login, session handling, and logout.

---

## 🚀 Features

- User Registration (Signup)
- User Login with credential validation
- Session-based Authentication
- Logout functionality
- Authentication Filter to protect secured pages
- Simple and clean UI using HTML, CSS, and JavaScript

---

## 🛠️ Tech Stack

- **Backend:** Java, Servlets, JDBC  
- **Frontend:** JSP, HTML, CSS, JavaScript  
- **Database:** MySQL  
- **Server:** Apache Tomcat  
- **Version Control:** Git & GitHub

---

## ⚙️ Database Setup

Create a MySQL database and table:

```sql
CREATE DATABASE authapp;

USE authapp;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

## Project Structure

AuthApp
│
├── .classpath
├── .gitignore
├── .project
├── README.md
│
├── .settings
│   ├── org.eclipse.core.resources.prefs
│   ├── org.eclipse.jdt.core.prefs
│   ├── org.eclipse.wst.common.component
│   ├── org.eclipse.wst.common.project.facet.core.xml
│   ├── org.eclipse.wst.jsdt.ui.superType.container
│   └── org.eclipse.wst.jsdt.ui.superType.name
│
├── src
│   └── main
│       ├── java
│       │   ├── controller
│       │   │   ├── LoginServlet.java
│       │   │   ├── SignupServlet.java
│       │   │   └── LogoutServlet.java
│       │   │
│       │   ├── dao
│       │   │   └── UserDAO.java
│       │   │
│       │   ├── model
│       │   │   └── User.java
│       │   │
│       │   ├── filter
│       │   │   └── AuthFilter.java
│       │   │
│       │   └── util
│       │       └── DBUtil.java
│       │
│       └── webapp
│           ├── META-INF
│           │   └── MANIFEST.MF
│           │
│           ├── WEB-INF
│           │   └── lib
│           │       └── mysql-connector-j-9.5.0.jar
│           │
│           ├── login.html
│           ├── signup.html
│           ├── dashboard.jsp
│           ├── style.css
│           └── toast.js
│
└── build