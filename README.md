University Management System

A Java-based desktop application for managing university operations including students, faculty, exams, and fee management. Built using Java Swing and MySQL.

Project Structure
University Management System/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── UniversityManagementSystem/
│   │   │       ├── About.java
│   │   │       ├── AddFaculty.java
│   │   │       ├── AddStudent.java
│   │   │       ├── Conn.java
│   │   │       ├── EnterMarks.java
│   │   │       ├── ExamDetails.java
│   │   │       ├── FeeStructure.java
│   │   │       ├── Login.java
│   │   │       ├── Main.java
│   │   │       ├── Marks.java
│   │   │       ├── Splash.java
│   │   │       ├── StudentDetails.java
│   │   │       ├── StudentFeeForm.java
│   │   │       ├── StudentLeave.java
│   │   │       ├── StudentLeaveDetails.java
│   │   │       ├── TeacherDetails.java
│   │   │       ├── TeacherLeave.java
│   │   │       ├── TeacherLeaveDetails.java
│   │   │       ├── UpdateStudent.java
│   │   │       └── UpdateTeacher.java
│   │   │
│   │   └── resources/
│   │       └── icons/
│   │           ├── about.png
│   │           ├── exam.png
│   │           ├── fee.png
│   │           ├── first.png
│   │           ├── loginback.png
│   │           ├── second.png
│   │           └── third.jpg
│   │
│   └── test/
│       └── java/
│
├── lib/                     # External libraries (JARs)
│   ├── jcalendar-tz-1.3.3-4.jar
│   └── ResultSet2xml.jar
│
├── target/                  # Compiled and packaged JARs
│   ├── ums-1.0-SNAPSHOT-jar-with-dependencies.jar
│   └── ums-1.0-SNAPSHOT.jar
│
├── .gitignore               # Git ignore file
├── pom.xml                  # Maven configuration
├── README.md                # Project documentation
├── ums.iml                  # IntelliJ project file
└── University Management System.iml

Features

Student Management: Add, update, and view student details.

Faculty Management: Add, update, and view faculty details.

Exam Management: Enter and view exam marks.

Fee Management: Maintain student fee records.

Leaves Management: Track student and faculty leaves.

Login System: Secure login for admins and faculty.

User Interface: Built with Java Swing for desktop.

Properties

Language: Java (JDK 11+ recommended)

Database: MySQL

Build Tool: Maven

IDE Support: IntelliJ IDEA

Dependencies:

jcalendar-tz-1.3.3-4.jar (Calendar UI)

ResultSet2xml.jar (Export ResultSet to XML)

Setup Instructions

Clone the repository:

git clone <https://github.com/kamranNabil/UniversityManagementSystem>


Import the project in IntelliJ IDEA or any Java IDE.

Add the JAR files in lib/ to the project dependencies.

Configure the MySQL database (subject and marks tables).

Run Splash.java to start the application.