# Bank Management System

A simple console-based Bank Management System built entirely in Java. This project allows users to perform basic banking operations like creating accounts, depositing money, withdrawing money, and checking balances.

## Features
- Create a new bank account (Name, Account Number, Initial Deposit)
- Deposit funds into an existing account
- Withdraw funds with balance validation
- Check current account balance
- Display account holder details
- Exit menu safely

## Technologies Used
- **Language:** Java (JDK 8 or higher)
- **Concept:** Object-Oriented Programming (OOP)

## Project Structure
Bank-Management-System/
│
├── src/
│   ├── Main.java          # Entry point and user menu interface
│   ├── BankAccount.java   # Class handling account data and operations
│   └── Bank.java          # Class managing multiple accounts (if applicable)
│
└── README.md              # Project documentation

## Getting Started

### Prerequisites
Make sure you have **Java Development Kit (JDK)** installed on your computer. 
Check your Java version in the terminal or command prompt:
bash
java -version

### Installation & Running
1. Clone the repository or download the source files:
   bash
   git clone https://github.com
2. Navigate to the project directory containing the `.java` files:
   bash
   cd your-repo-name/src

3. Compile the Java files:
   bash
   javac Main.java BankAccount.java
  
4. Run the program:
   bash
   java Main
   
## Usage Example
Once you run the program, follow the on-screen terminal prompts:
1. Choose `1` to Create Account.
2. Choose `2` to Deposit Money.
3. Choose `3` to Withdraw Money.
4. Choose `4` to Check Balance.
5. Choose `5` to Exit.

## Contributing
Pull requests are welcome! For major changes, please open an issue first to discuss what you would like to change.

## License
This project is open-source and available under the [MIT License](LICENSE).
