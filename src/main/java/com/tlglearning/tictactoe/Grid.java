package com.tlglearning.tictactoe;

/**
 *  This class prints out a 3 x 3 console representation of the Tic-Tac-Toe grid.
 */
public class Grid {

  String square1 = new String(" ");
  String square2 = new String(" ");
  String square3 = new String(" ");
  String square4 = new String(" ");
  String square5 = new String(" ");
  String square6 = new String(" ");
  String square7 = new String(" ");
  String square8 = new String(" ");
  String square9 = new String(" ");

  public Grid() {

  }

  /**
   * Prints out a representation of the grid in a specific state.
   */
  public void gridLayout() {
    System.out.printf(" %s | %s | %s%n", square7, square8, square9);
    System.out.println("-----------");
    System.out.printf(" %s | %s | %s%n", square4, square5, square6);
    System.out.println("-----------");
    System.out.printf(" %s | %s | %s%n", square1, square2, square3);

  }


}


