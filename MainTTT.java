import java.util.Scanner;

public class MainTTT{
     Board game = new Board();
     Scanner input = new Scanner(System.in);
     public static void main(String[] args){
          System.out.println("Hello World!");
          System.out.println("Welcome to tic tac toe!");
          //Board game = new Board();
          while(!game.isDone()){
               printBoard(game);
          }
     }

     public static void printBoard(Board game){
          int[][] board = game.getBoard();
          for(int r = 0; r < 3; r++){
               for(int c = 0; c <3; c++){
                    char toBePrinted = ' ';
                    switch(board[r][c]){
                         case 1:
                              toBePrinted = 'X';
                              break;
                         case 2:
                              toBePrinted = 'O';
                              break;
                         default:
                              toBePrinted = ' ';
                              break;
                    }
                    if(c < 2){
                         System.out.print(toBePrinted+"|");
                    }
                    else{
                         System.out.println(toBePrinted);
                    }
               }
               if(r < 2){
                    System.out.println("-----");
               }
               else{
                    System.out.println();
               }
          }
     } 

     public static void playerMove(){
          System.out.println("Please type the row and column you'd like to place your piece \'X\'.");
          System.out.print("Type row first then column, with a space separating the two: \n>");
          String userInput = input.nextLine();
          String[] splitInput = userInput.split(" ", 0);
          int row = Integer.parseInt(splitInput[0]);
          int col = Integer.parseInt(splitInput[1]);
          game.setBoard(row, col, 1);
     }
}