package com.tlglearning.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The focal point of where the game will run from and check to see if the game is finished using
 * various logics.
 */
public class Main {

  private static final int LINE_TOTAL_WINS = 8;
  private static final int GRID_SIZE = 9;

  public static void main(String[] args) throws IOException {
    Grid grid1 = new Grid();
    boolean gameIsRunning = true;
    boolean isPlayerXsTurn = true;
    //  Lines 22 - 26 are for demonstration purposes only, will be replaced in further
    //  implementations
    System.out.println("Welcome to Tic-Tac-Toe.");
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
    grid1.gridLayout();
  }


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
   * @param table - a representation of the Grid layout.
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

  public static boolean checkDraw(Set<Integer> availableSpaces){
    boolean noMoreAvailableSpaces = false;
    if (availableSpaces.isEmpty())  {
      noMoreAvailableSpaces = true;
    }
    return noMoreAvailableSpaces;
  }
}



