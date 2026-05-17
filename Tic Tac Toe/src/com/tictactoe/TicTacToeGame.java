package com.tictactoe;

import com.tictactoe.model.Board;
import com.tictactoe.model.Player;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeGame {
    Deque<Player> players;
    Board gameBoard;

    public void initializeGame() {
        players = new LinkedList<>();
        
        PlayingPiece crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player 1", crossPiece);
        players.add(player1);
        
        PlayingPiece noughtPiece = new PlayingPieceO();
        Player player2 = new Player("Player 2", noughtPiece);
        players.add(player2);

        gameBoard = new Board(3,3);        
    }

    public String startGame() {
        boolean isGameOver = false;
        while (!isGameOver) {
            Player currentPlayer = players.poll();
        
            gameBoard.printBoard();

            List<Pair<Integer, Integer>> freeCells = gameBoard.getFreeCells();
            if (freeCells.isEmpty()) {
                System.out.println("Game is a draw!");
                return "Draw";
            }

            System.out.println(currentPlayer.getName() + "'s turn. Please enter your move (x y): ");
            Scanner scanner = new Scanner(System.in);
            String st = scanner.nextLine();
            String[] parts = st.split(",");
            int x = Integer.parseInt(parts[0].trim());
            int y = Integer.parseInt(parts[1].trim());

            boolean moveSuccessful = gameBoard.placePiece(currentPlayer.getPlayingPiece(), x, y);
            if (!moveSuccessful) {
                System.out.println("Invalid move. Try again.");
                players.addFirst(currentPlayer); // Re-add the current player to the front of the queue
                continue;
            }

            players.addLast(currentPlayer); // Move the current player to the end of the queue

            boolean isWinner = checkForWinner(currentPlayer);
            if (isWinner) {
                System.out.println(currentPlayer.getName() + " wins!");
                return currentPlayer.getName();
            }
        }

        return "Game Over";
    }

    private boolean checkForWinner(Player player) {
        boolean checkRows = true;
        boolean checkCols = true;
        boolean checkDiag1 = true;
        boolean checkDiag2 = true;

        for (int i = 0; i < gameBoard.getSize(); i++) {
            if (gameBoard.getCell(i, 0) != player.getPlayingPiece()) {
                checkRows = false;
            }
            if (gameBoard.getCell(0, i) != player.getPlayingPiece()) {
                checkCols = false;
            }
            if (gameBoard.getCell(i, i) != player.getPlayingPiece()) {
                checkDiag1 = false;
            }
            if (gameBoard.getCell(i, gameBoard.getSize() - 1 - i) != player.getPlayingPiece()) {
                checkDiag2 = false;
            }
        }
        return checkRows || checkCols || checkDiag1 || checkDiag2;
    }
}
