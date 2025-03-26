# Digital Library Book Management System

A Java application for managing books in a digital library system.

## Features
- Add new books with validation
- View all books
- Search books by ID or title
- Update book details
- Delete books
- Input validation and error handling

## Prerequisites
- Java JDK 11 or higher
- Maven (for building and testing)

## Setup and Running
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Digital-Library.git
   cd Digital-Library

## Development Process

1. **Initial Setup**  
   - Created project structure following Maven/Gradle conventions.  
   - Implemented core classes (`Book`, `LibraryService`).  

2. **Feature Implementation**  
   - Added CRUD operations with validation.  
   - Designed the console-based user interface.  

3. **Testing**  
   - Wrote unit tests for all service methods.  
   - Verified edge cases (empty inputs, duplicate IDs).  

## Challenges Faced

1. **Input Validation**  
   - Ensuring all fields (ID, title, author) followed constraints required careful error handling.  

2. **Git Integration**  
   - Initial issues with Git setup were resolved by configuring the correct PATH.  

3. **Modular Design**  
   - Separating concerns (model, service, validation) needed multiple iterations.  

## Future Improvements

1. **Database Integration**  
   - Replace in-memory storage with SQLite/MySQL.  

2. **Enhanced UI**  
   - Add a graphical interface using JavaFX.  

3. **Advanced Features**  
   - Book lending history, user accounts, overdue fines.  

