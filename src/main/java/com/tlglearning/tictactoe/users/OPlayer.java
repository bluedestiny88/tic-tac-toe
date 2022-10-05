package com.tlglearning.tictactoe.users;

import com.tlglearning.tictactoe.Player;

public class OPlayer implements Player {

  @Override
  public String getPlayer() {
    return "O";
  }

  @Override
  public String getPlayerStart() {
    return "Player O, it is your turn: ";
  }
}
