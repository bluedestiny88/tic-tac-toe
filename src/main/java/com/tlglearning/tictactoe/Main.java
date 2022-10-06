package com.tlglearning.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;


/**
 * The focal point of where the game will run from and check to see if the game is finished using
 * various logics.
 */
public class Main {

  private static final int LINE_TOTAL_WINS = 8;
  private static final int GRID_SIZE = 9;

  /**
   * Execution of tic-tac-toe program.
   * @param args         String command line arguments.
   * @throws IOException If user doesn't provide valid input.
   */
  public static void main(String[] args) throws IOException {
    Grid grid1 = new Grid();
    System.out.println("Welcome to Tic-Tac-Toe.");
    gameRunning(grid1);
    grid1.gridLayout();
  }

  /**
   * This method reflects the actions of the players playing the game.
   * @param grid1         reflects the grid layout.
   * @throws IOException  if the user provided number is invalid.
   */
  private static void gameRunning(Grid grid1)
      throws IOException {
    boolean gameIsRunning = true;
    boolean isPlayerXsTurn = true;

    do {
      grid1.gridLayout();
      if (isPlayerXsTurn) {
        System.out.println(grid1.getXPlayer().getPlayerStart());  //  Print out "Player X, it is your turn: "
        int chosenNum = enterKey(grid1.getAvailableSpaces()); //  Player to choose a square
        grid1.getGrid().set(chosenNum - 1, grid1.getXPlayer().getPlayer());
        grid1.setAvailableSpaces(chosenNum);
      } else  {
        System.out.println(grid1.getOPlayer().getPlayerStart());  //  Print out "Player X, it is your turn: "
        int chosenNum = enterKey(grid1.getAvailableSpaces()); //  Player to choose a square
        grid1.getGrid().set(chosenNum - 1, grid1.getOPlayer().getPlayer());
        grid1.setAvailableSpaces(chosenNum);
      }
      if (!checkWinner(grid1))  {
        gameIsRunning = false;
      }
      if (checkDraw(grid1.getAvailableSpaces()))  {
        gameIsRunning = false;
        System.out.println("GAME IS A DRAW");
      }
      isPlayerXsTurn = !isPlayerXsTurn;
    } while(gameIsRunning);
  }

  /**
   * implement sthe space being utilized by the player.
   * @param validSpaces   spaces left over for users to use.
   * @return             represents numbers utilized by a player.
   * @throws IOException  if the user provided number is invalid.
   */
  public static int enterKey(Set<Integer> validSpaces) throws IOException {
    int userNumber = 0;
    Reader input = new InputStreamReader(System.in);
    BufferedReader buffer = new BufferedReader(input);
    do {
      System.out.printf("Please enter a space number %s: ",
          validSpaces); //  consider passing in a treeSet
      try {
        userNumber = Integer.parseInt(buffer.readLine().trim());
        if (!validSpaces.contains(userNumber)) {
          throw new IllegalArgumentException();
        }
        break;
      } catch (IllegalArgumentException e) {
        System.out.println("Sorry, that is not an available space!");
      }
    } while (true); //  doing 0 ends the
    return userNumber;
  }

  /**
   * This method checks to see if tic-tac-toe has a winner.
   * @param table    a representation of the Grid layout.
   * @return          returns if there is a winner or not.
   */
  public static boolean checkWinner(Grid table) {
    boolean thereIsNoWinner = true;
    for (int i = 0; i < LINE_TOTAL_WINS; i++) {
      String line = null;
      switch (i + 1) {
        case 1:
          line = table.getGrid().get(6).toString() + table.getGrid().get(7).toString()
              + table.getGrid().get(8).toString();
          break;
        case 2:
          line = table.getGrid().get(3).toString() + table.getGrid().get(4).toString()
              + table.getGrid().get(5).toString();
          break;
        case 3:
          line = table.getGrid().get(0).toString() + table.getGrid().get(1).toString()
              + table.getGrid().get(2).toString();
          break;
        case 4:
          line = table.getGrid().get(0).toString() + table.getGrid().get(3).toString()
              + table.getGrid().get(6).toString();
          break;
        case 5:
          line = table.getGrid().get(1).toString() + table.getGrid().get(4).toString()
              + table.getGrid().get(7).toString();
          break;
        case 6:
          line = table.getGrid().get(2).toString() + table.getGrid().get(5).toString()
              + table.getGrid().get(8).toString();
          break;
        case 7:
          line = table.getGrid().get(0).toString() + table.getGrid().get(4).toString()
              + table.getGrid().get(8).toString();
          break;
        case 8:
          line = table.getGrid().get(2).toString() + table.getGrid().get(4).toString()
              + table.getGrid().get(6).toString();
          break;
      }
      if(line.equals("XXX")) {
        System.out.println("X, YOU ARE THE WINNER!");
        thereIsNoWinner = false;
        break;
      }
       if(line.equals("OOO")) {
        System.out.println("O, YOU ARE THE WINNER!");
        thereIsNoWinner = false;
        break;
      }
    }
    return thereIsNoWinner;
  }

  /**
   * This method checks to see if there's no winners, this is done by seeing if there are any numbers left in a set of integers.
   * @param availableSpaces   check availability of spaces for the players.
   * @return                   Returns true, if all spaces are being utilized.
   */
  public static boolean checkDraw(Set<Integer> availableSpaces){
    boolean noMoreAvailableSpaces = false;
    if (availableSpaces.isEmpty())  {
      noMoreAvailableSpaces = true;
    }
    return noMoreAvailableSpaces;
  }
}



