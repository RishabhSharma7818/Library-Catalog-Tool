# Intern ID: CITS1037
# Library Catalog Tool

A simple console-based Library Management System built in Java. It allows users to manage a collection of books — adding, deleting, issuing, returning, and viewing books — along with a history log of all actions performed.

## Features

- **Add Book** – Add a new book with a unique ID, title, and author.
- **Delete Book** – Remove a book from the library (only if it's not currently issued).
- **Issue Book** – Mark an available book as issued.
- **Return Book** – Mark an issued book as returned/available.
- **Show Available Books** – View all books currently available.
- **Show Issued Books** – View all books currently issued.
- **Show History** – View a log of all actions performed (add, delete, issue, return).
- **Input Validation** – Handles invalid numeric and empty string inputs gracefully.

## Project Structure

```
├── Main.java           # Entry point, handles menu and user interaction
├── LibrarySystem.java   # Core logic for managing books and history
├── Book.java            # Book model class
```

## Classes Overview

### Main
Runs the main menu loop, takes user input, and delegates actions to `LibrarySystem`.

### LibrarySystem
Handles all core operations:
- Stores books in an `ArrayList<Book>`
- Tracks all actions in a `history` list
- Provides input validation methods (`validIntInput`, `validStringInput`)
- Implements add, delete, issue, return, and display operations

### Book
Represents a single book with:
- `id`, `title`, `author`, and `issued` status
- Getters and setters
- Custom `toString()` for clean display

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/RishabhSharma7818/Library-Catalog-Tool.git
   ```
2. Open the project folder in VS Code:
   ```bash
   cd Library-Catalog-Tool
   code .
   ```
3. Compile all files (open a terminal in VS Code):
   ```bash
   javac Main.java LibrarySystem.java Book.java
   ```
4. Run the program:
   ```bash
   java Main
   ```
5. Follow the on-screen menu to manage the library.

## Sample Menu

```
==============Library Catalog Tool==============
1. Add Book
2. Delete Book
3. Issue Book
4. Show Available Books
5. Show Issued Books
6. Return Book
7. Show History
8. Exit
Please enter your choice :
```

## Notes

- Book IDs must be positive integers and unique.
- A book cannot be deleted while it is issued.
- All major actions (add, delete, issue, return) are recorded in the history log.

## Future Improvements

- Search books by title or author
- Persist data to a file or database
- Add unit tests for core logic

## Author
Rishabh Sharma