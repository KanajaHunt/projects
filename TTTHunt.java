import java.util.Scanner;

/*
* Author: Kanaja Hunt
* Date: March 12, 2025
*
* Programming Assigment: Tic Tac Toe
* File(s) Name: TTTHunt.java
*
* Program Description: Tic Tac Toe game is traditionally played on a 3x3 board between two players x and o. 
A player can mark a single cell by placing a symbol in it (either an 'x' or an 'o' character). 
A player who manages to mark a row, column, or a diagonal completely with his symbol first wins the game. 
The game ends in a tie if no player manages to win after all the cells have been marked.  
You will design a textual version of this game, in which a human player gets to play against a computer opponent.
*
* Honor Code: I pledge that I will not cheat, help others to cheat, plagiarize, or otherwise
engage in any misrepresentation of my work.
*
*/

public class TTTHunt{
    //initBoard ( ) – This function initializes the game board. There are 9 cells represented by 1 or 2 dimensional array.
    public static void initBoard(String[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = " ";
        }
    }
}
    // gameBoard ( ) – This method prints the game board
    public static void gameBoard(String[][] board){
        System.out.println("Let's play!");

        for(int i = 0; i < board.length; i++){
            System.out.print("|");

            for(int j = 0; j < board[i].length; j++){
                // outputs each element followd by | - also prints on the same line
                System.out.print(board[i][j] + " | ");
        }
        System.out.println();
    }
    //opitonal but prints out a newline - used for aestheic purposes
    System.out.println();
}
    /* void yourTurn ( ) - This method handles moves made by the user. It displays the game board and asks the user to enter a move.  
    If the move is invalid, it prompts user to enter a valid move again. A valid move refers to one of the empty cells in the board*/
    public static void yourTurn(Scanner input, String[][] board){
        //instead of userInput var we use row and col bc it's 3x3 and would take two inputs to get it's actual location
        int row;
        int column;

        //getting user input for location of X
        System.out.println("Enter a number [0-2] for row location(x). Note: 0 is leftmost and 2 is rightmost. ");
        row = input.nextInt();

        System.out.println("Enter a number [0-2] for column location(x). Note: 0 is leftmost and 2 is rightmost. ");
        column = input.nextInt();

        // equals method used bc we cant compare strings using == 
        if(row >= 0 && row <= 2 && column >= 0 && column <= 2 && board[row][column].equals(" ")){
            board[row][column] = "x";
        }
        else{
            System.out.println("Invalid move. Try again");
            yourTurn(input, board);
        }
    }

    /* void machineTurn ( ) - This method handles moves by the computer.  
    You can implement a simple logic where you just search for an empty position in the array and mark it for computer player.  
    You can get really creative and design the method so that it makes a well thought out move. 
    The logic is entirely up to you. Finally, you should display the computer's move */
    public static void machineTurn(String[][]board){
        int row = -1; // -1 shows no empty spot has been found [default values]
        int column = -1; // -1 shows no empy spot has been found [default values]

        //loop to find an empty spot for row and column
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j].equals(" ")){
                    row = i;
                    column = j;
                    break; // breaks out the INNER loop
                }
            }
            if(row != -1 && column != -1){
                break; // breaks out of the OUTER loop so the program doesnt keep looking bc the != -1 shows that the empty spot HAS BEEN FOUND
            }
        }
        // places the computer's spot
        if(row != -1 && column != -1){
            board[row][column] = "o";
        }
    }

    /*checkWinner ( ) -This method examines the array to see if either player has won. 
    A player has won if he has marked a row, column or diagonal with his symbol. 
    The function returns different values based on results of winner, loser and no winner. */
    public static int checkWinner(String[][]board, int winner, int loser, int tie){
        //This loop iterates over the columns of the board, which has 3 columns (0 to 2).
        // rows
        for (int i = 0; i < board.length; i++) {
            /* board[0][i] refer to the values in the same column at rows 0, 1, and 2, respectively.
               board.equals checks that all 3 rows have the same symbol
            */
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals(" ")) {
                return board[i][0].equals("x") ? winner : loser;
            }
        }
        // columns
        //This loop iterates over the columns of the board, which has 3 columns (0 to 2).
        for (int i = 0; i < board.length; i++) {

            /* board[0][i] refer to the values in the same column at rows 0, 1, and 2, respectively.
               board.equals checks that all 3 columns have the same symbol
            */
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals(" ")) {
                return board[0][i].equals("x") ? winner : loser;
            }
        }
        // diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals(" ")) {
            return board[0][0].equals("x") ? winner : loser;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals(" ")) {
            return board[0][2].equals("x") ? winner : loser;
        }

        // If the board is full and no winner
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(" ")) {
                    // No winner yet, game continues bc you must have 3 in a row to win
                    return -1; 
                }
            }
        }
        // If the board is full and no winner, it's a tie
        return tie; 
    }

    /* main ( ) - The main method controls the game. You will declare an array for the game and make use of the methods that you have written
     to produce behavior of the Tic-Tac-Toe game. The human player always makes the first move in the game.  
     You should alternate between the human player and the computer. After each move you should check for a winner using the 
     checkWinner method. While there is no winner, you should display the gameboard, ask the user for next valid move, update computer 
     move until one of player wins or the game is tie.*/

    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        // declaring the array
        String[][] board = new String[3][3];

        // declaring checkWinner var in main so they arent local vars
        int checkWinner = 1;
        int checkLoser = 2;
        int checkTie = 0;

        //intializing TTT board
        initBoard(board);

        // Game start 

        int gameStatus = -1; //return -1 meaning the game is still in session

        while (gameStatus == -1) {
            // player turn
            gameBoard(board); //outputting blank TTT board
            yourTurn(input, board);
            //reinitalize var to check status
            gameStatus = checkWinner(board, checkWinner, checkLoser, checkTie);
            if (gameStatus != -1){
                break; // Check for winner or tie after human move
            }

            // Computer's turn
            gameBoard(board);
            machineTurn(board);
            gameStatus = checkWinner(board, checkWinner, checkLoser, checkTie);
        }

        // End of game
        gameBoard(board);
        if (gameStatus == checkWinner) {
            System.out.println("You win!");
        } else if (gameStatus == checkLoser) {
            System.out.println("You lost!");
        } else if (gameStatus == checkTie) {
            System.out.println("Tie!");
        }

        input.close();
    }

 }