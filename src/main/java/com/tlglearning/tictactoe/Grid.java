package com.tlglearning.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 *  This class prints out a 3 x 3 console representation of the Tic-Tac-Toe grid.
 */
public class Grid {
  private List<String> squares = new ArrayList<>();
  private static final int GRID_SIZE = 9;




  public Grid() {
    for(int i =0; i < GRID_SIZE; i++){
      squares.add(" ");

    }

  }

  /**
   * Prints out a representation of the grid in a specific state.
   */
  public void gridLayout() {
    System.out.printf(" %s | %s | %s%n", squares.get(6), squares.get(7), squares.get(8));
    System.out.println("-----------");
    System.out.printf(" %s | %s | %s%n", squares.get(3), squares.get(4), squares.get(5));
    System.out.println("-----------");
    System.out.printf(" %s | %s | %s%n", squares.get(0), squares.get(1),squares.get(2));


  }




}


