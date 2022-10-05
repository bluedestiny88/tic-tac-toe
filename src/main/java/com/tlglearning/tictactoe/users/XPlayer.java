package com.tlglearning.tictactoe.users;

import com.tlglearning.tictactoe.Player;

public class XPlayer implements Player {

  /**
   * This method is retrieving player X.
    * @return String representation of player x.
   */
  @Override
  public String getPlayer() {
    return "X";
  }

  @Override
  public String getPlayerStart() {
    return "Player X, it is your turn: ";
  }
}
