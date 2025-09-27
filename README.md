# University Management System (UMS)

A Java-based **University Management System** built with **Swing GUI** and **MySQL database integration**, designed to manage students, faculty, subjects, exams, and results.  
The project follows a **Maven structure** for better dependency management and modular development.

## 📂 Project Structure

University-Management-System/
│── pom.xml # Maven build file (dependencies & project info)
│── README.md # Project documentation
│── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── UniversityManagementSystem/ # All Java source code
│ │ │ ├── Login.java
│ │ │ ├── Splash.java
│ │ │ ├── Conn.java
│ │ │ ├── StudentDetails.java
│ │ │ ├── TeacherDetails.java
│ │ │ ├── Marks.java
│ │ │ └── ... (other modules)
│ │ └── resources/ # Images, icons, configuration files
│ └── test/ # (Optional) Unit tests
│
└── target/ # Compiled classes & packaged artifacts (ignored in Git)


## 🚀 Features

- **Authentication System** – Login for admin/staff.  
- **Student Management** – Add, update, view student details.  
- **Faculty Management** – Add, update, view faculty records.  
- **Subject & Marks Management** – Define subjects per semester and assign marks.  
- **Examination Module** – View and generate student results.  
- **Fee Management** – Manage fee structures and payment records.  
- **Leave Management** – Handle student/teacher leave applications.  
- **Swing GUI** – User-friendly desktop interface.  
- **MySQL Integration** – Persistent storage of all university data.  


## ⚙️ Technologies Used

- **Java (JDK 21+ )**
- **Swing (GUI Framework)**
- **MySQL (Database)**
- **Maven (Build & Dependency Management)**
- **JCalendar** (for date picking)
- **MySQL Connector/J** (for DB connectivity)


## 🗄️ Database Schema

Main tables include:  

- `student` – stores student info  
- `faculty` – stores faculty info  
- `subject` – subjects per rollno & semester  
- `marks` – marks linked to `subject`  
- `fee` – fee details  
- `leave_student` & `leave_teacher` – leave records  

 `marks` table references `subject` via `(rollno, semester)`.


## ▶️ How to Run

1. **Clone the repository**  
   git clone https://github.com/your-username/university-management-system.git
   cd university-management-system
Configure Database

Install MySQL and create a database, e.g., ums.

Import SQL schema (/src/resources/ums.sql if available).

Update Conn.java with your DB username & password.

Build the project with Maven

mvn clean install
Run the application

mvn exec:java -Dexec.mainClass="UniversityManagementSystem.Main"

📝 Future Improvements
Export results as PDF.

Role-based authentication (Admin/Faculty/Student).

Web-based version (Spring Boot + React).

👨‍💻 Contributors
Nabil Md (Developer)

📜 License
This project is for educational purposes only. Free to use and modify.

pgsql
👉 This README is **structured for GitHub**: clean sections, proper code blocks, expandable.  
Do you want me to also create a **database schema .sql file** (`ums.sql`) that matches your current `subject`, `marks`, and other tables, so contributors can quickly set up the DB?






