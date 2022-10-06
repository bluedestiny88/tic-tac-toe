package com.tlglearning.tictactoe;

import com.tlglearning.tictactoe.users.OPlayer;
import com.tlglearning.tictactoe.users.XPlayer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  This class prints out a 3 x 3 console representation of the Tic-Tac-Toe grid.
 */
public class Grid {
  private List<String> squares = new ArrayList<>();
  private Set<Integer> availableSpaces = IntStream
      .rangeClosed(1, GRID_SIZE)
      .boxed()
      .collect(Collectors.toCollection(TreeSet::new));
  private Player player1 = new XPlayer();
  private Player player2 = new OPlayer();
  private static final int GRID_SIZE = 9;

  /**
   * Construct a grid object.
   */
  public Grid() {
    for(int i = 0; i < GRID_SIZE; i++){
      Integer stringNum = i + 1;
      squares.add(stringNum.toString());
    }
  }

  /**
   * This method retrieves the grid Array list.
   * @return The grid Array list.
   */
  public List<String> getGrid() {
    return squares;
  }

  /**
   * This method retrieves available spaces in the grid.
   * @return the set of integers of available squares.
   */
  public Set<Integer> getAvailableSpaces()  {
    return availableSpaces;
  }

  /**
   * This method retrieves players information.
   * @return player's class information.
   */
  public Player getXPlayer()  {
    return player1;
  }

  /**
   * This method retrieves players information
   * @return player's class information.
   */
  public Player getOPlayer()  {
    return player2;
  }

  /**
   * This method removes unavailable spaces set of Integers.
    * @param spaceToRemove the space that is to be removed from the set.
   */
  public void setAvailableSpaces(int spaceToRemove)  {
    availableSpaces.remove(spaceToRemove);
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


