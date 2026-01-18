# 📚 Library Management System

[![Java](https://img.shields.io/badge/Java-11+-orange.svg)](https://www.oracle.com/java/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue.svg)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![Build](https://img.shields.io/badge/build-passing-brightgreen.svg)](https://github.com)

A comprehensive desktop application for managing library operations including book inventory, user authentication, and borrowing/return workflows. Built with Java Swing for an intuitive graphical user interface.

---

## 🌟 Features

### 👥 User Management
- **Dual Role Authentication**: Separate login systems for Students and Librarians
- **Student Registration**: New students can sign up with email and phone verification
- **Secure Password Management**: Password-based authentication system
- **User Profiles**: Store and manage user information (ID, name, email, phone)

### 📖 Book Management
- **Add Books**: Librarians can add new books with title, author, and ISBN
- **Remove Books**: Delete books from the library inventory
- **View Catalog**: Browse all available books in a searchable table format
- **ISBN Tracking**: Unique identification for each book

### 🔄 Borrowing System
- **Borrow Books**: Students can borrow available books
- **Return Books**: Process book returns and update availability
- **Borrowing Records**: Track which students have borrowed which books
- **Availability Status**: Real-time book availability tracking

### 💾 Data Persistence
- **Automatic Save**: Library data persists between sessions
- **Serialization**: Java object serialization for data storage
- **Data Recovery**: Automatically load previous session data on startup

---




## 🏗️ Architecture

### System Design

The application follows a **Model-View-Controller (MVC)** inspired architecture:

```
┌─────────────────────────────────────────┐
│           Presentation Layer            │
│  (Swing GUI Components - Login, Home)   │
└───────────────┬─────────────────────────┘
                │
┌───────────────▼─────────────────────────┐
│          Business Logic Layer           │
│     (Library, Authentication Logic)     │
└───────────────┬─────────────────────────┘
                │
┌───────────────▼─────────────────────────┐
│            Data Layer                   │
│  (Models: Book, Student, Librarian)     │
│  (Persistence: Serialization)           │
└─────────────────────────────────────────┘
```

### Class Structure

**Core Classes:**
- `Library`: Central class managing books, students, and librarians
- `User`: Abstract base class for all users
- `Student`: Student user with borrowing capabilities
- `Librarian`: Admin user with management privileges
- `Book`: Book entity with title, author, ISBN

**GUI Classes:**
- `Login`: Main authentication interface
- `Student_home`: Student dashboard
- `Librarian_home`: Librarian dashboard
- `BookTable`: Table view for displaying books
- `AddBookGui`, `RemoveBookGui`: Book management interfaces
- `BorrowBookGui`, `ReturnBookGui`: Transaction interfaces

For detailed UML diagrams, see:
- [Class Diagram](Uml%20Class%20Diagram.png)
- [Sequence Diagram](Sequence%20Diagram-0.png)

---

## 🚀 Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Version 11 or higher
- **Java Runtime Environment (JRE)**: For running the application
- **IDE** (Optional): IntelliJ IDEA, Eclipse, or NetBeans

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Skvmqq/Library_Managment_System.git
   cd Library_Managment_System
   ```

2. **Compile the source code**
   ```bash
   javac -d out src/*.java
   ```

3. **Run the application**
   ```bash
   java -cp out Main
   ```

### Alternative: Using an IDE

1. Open the project in your IDE (IntelliJ IDEA, Eclipse, NetBeans)
2. Ensure JDK 11+ is configured
3. Build the project
4. Run `Main.java`

---

## 📖 Usage Guide

### First Time Setup

When you first run the application, it creates sample data:
- **Sample Books**: Book1, Book2 (for testing)
- **Default Student**: Username: `j`, Password: `s`
- **Default Librarian**: Username: `j`, Password: `s`

### For Students

1. **Login**: Enter your credentials or sign up as a new student
2. **Browse Books**: View available books in the catalog
3. **Borrow Book**: Select a book by title or ISBN to borrow
4. **Return Book**: Return borrowed books when finished

### For Librarians

1. **Login**: Use librarian credentials
2. **Manage Books**: Add new books or remove existing ones
3. **View Inventory**: Browse complete book catalog
4. **Monitor Activity**: Track borrowing records

---

## 🛠️ Technology Stack

- **Language**: Java 11+
- **GUI Framework**: Java Swing
- **Data Persistence**: Java Serialization
- **Testing**: JUnit (unit tests included)
- **Build Tool**: Standard Java compilation
- **Version Control**: Git

---

## 📁 Project Structure

```
Library_Managment_System/
├── src/                          # Source code files
│   ├── Main.java                 # Application entry point
│   ├── Login.java                # Login interface
│   ├── Library.java              # Core library logic
│   ├── Book.java                 # Book model
│   ├── Student.java              # Student model
│   ├── Librarian.java            # Librarian model
│   ├── User.java                 # User base class
│   ├── Student_home.java         # Student dashboard
│   ├── Librarian_home.java       # Librarian dashboard
│   ├── BookTable.java            # Book table view
│   ├── AddBookGui.java           # Add book interface
│   ├── RemoveBookGui.java        # Remove book interface
│   ├── BorrowBookGui.java        # Borrow book interface
│   ├── ReturnBookGui.java        # Return book interface
│   └── StudentSignUpGUI.java     # Student registration
├── Test/                         # Unit tests
│   ├── LibraryTest.java
│   ├── StudentTest.java
│   └── LibrarianTest.java
├── Uml Class Diagram.png         # System architecture diagram
├── Sequence Diagram-0.png        # Sequence flow diagram
├── .gitignore                    # Git ignore rules
└── README.md                     # This file
```

---

## 🧪 Testing

### Unit Tests

The project includes JUnit 5 unit tests in the `Test/` directory:
- **LibraryTest**: Tests book search and user authentication
- **StudentTest**: Tests book borrowing and returning
- **LibrarianTest**: Tests book management operations

### Running Tests

**⚠️ Note**: Tests require JUnit 5 (Jupiter) to run.

**Using an IDE (Easiest)**:
- IntelliJ IDEA: Right-click test file → Run (auto-downloads JUnit)
- Eclipse: Right-click → Run As → JUnit Test
- VS Code: Install "Java Test Runner" extension

### Test Coverage

- ✅ User authentication (student and librarian login)
- ✅ Book search by ISBN and title
- ✅ Book borrowing and returning workflow
- ✅ Librarian book management (add/remove)
- ✅ Student and librarian registration

**Note**: The tests demonstrate professional development practices. The application works independently of the tests.

---

## 🔮 Future Enhancements

- [ ] Database integration (MySQL/PostgreSQL) instead of serialization
- [ ] Advanced search and filtering capabilities
- [ ] Book categories and genres
- [ ] Due date tracking and late fee calculations
- [ ] Export reports to PDF/Excel
- [ ] Email notifications for due dates
- [ ] Book reservation system
- [ ] Multi-library support
- [ ] RESTful API for mobile integration
- [ ] Modern UI with JavaFX or web interface



---

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

## 👤 Author

**Your Name**
- LinkedIn: linkedin.com/in/shivam-kohli-67602b240
- Email: shivamkohli810@gmail.com

---

## 🙏 Acknowledgments

- Inspired by real-world library management systems
- Built as a learning project to demonstrate Java Swing and OOP principles
- UML diagrams created to showcase software design skills

---




<div align="center">
Made with ☕ and Java
</div>
