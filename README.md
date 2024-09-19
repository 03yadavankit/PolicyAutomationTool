# Policy Automation Tool

## Overview

The Policy Automation Tool is a Java-based application designed to manage insurance policies. It provides a simple command-line interface (CLI) for viewing and adding policies. The application interacts with a MySQL database to store and retrieve policy information.

## Features

- **View All Policies**: List all policies stored in the database.
- **Add New Policy**: Add a new policy to the database with a name and description.

## Technologies Used

- **Java**: Programming language used to develop the application.
- **MySQL**: Relational database management system used to store policy data.
- **Maven**: Build automation tool used to manage project dependencies and build processes.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- MySQL Server
- Maven
- Git

### Setup

1. **Clone the Repository**

   ```bash
   git clone https://github.com/03yadavankit/PolicyAutomationTool.git
   cd PolicyAutomationTool
   ```

2. **Create the Database**

   Log in to your MySQL server and create a database named `policy_db`:

   ```sql
   CREATE DATABASE policy_db;
   ```

3. **Configure the Database Connection**

   Edit the `PolicyDAO.java` file to include your MySQL database connection details:

   ```java
   private static final String DB_URL = "jdbc:mysql://localhost:3306/policy_db";
   private static final String DB_USER = "root";
   private static final String DB_PASSWORD = "1408620Anki@";
   ```

4. **Build the Project**

   Run Maven to build the project:

   ```bash
   mvn clean package
   ```

5. **Run the Application**

   Execute the `Main` class to start the application:

   ```bash
   mvn exec:java -Dexec.mainClass="com.policyautomation.Main"
   ```

## Usage

Upon running the application, you will see a menu with options to:

1. **View All Policies**: Select this option to display all policies.
2. **Add New Policy**: Select this option to add a new policy. You will be prompted to enter the policy name and description.
3. **Exit**: Select this option to exit the application.

## Contributing

If you would like to contribute to this project, please fork the repository and submit a pull request with your changes. Ensure that your code follows the project's coding standards and includes appropriate tests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

For any questions or issues, please contact the repository owner at `03yadavankit@gmail.com`.
