# apcsasudoku

Sudoku Puzzle Generator

Beckham Zhou

The aim of this project was to print a randomly generated but solved Sudoku puzzle. 

To run the program, paste the code into an IDE and run the code. You should see the result in the console. 

The Sudoku puzzle is generated through a 2-step process. First, the program adds numbers to the 9x9 2D array using a formula on row and column indices. This creates a seed board that satisfies the rules of Sudoku. For randomness, the program also creates an ArrayList containing the numbers 1 through 9 and uses Collection.shuffle() to randomize their order. Lastly, the program swaps every number in the seed board with its corresponding randomized number from the list. 

List of files:

SudokuGenerator.java
README.md
DesignDocument.pdf
