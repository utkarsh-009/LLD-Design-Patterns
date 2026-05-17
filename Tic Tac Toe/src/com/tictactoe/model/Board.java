package com.tictactoe.model;

public class Board {
    private final int n;
    private final PlayingPiece[][] board;
    
    public Board(int n) {
        this.n = n;
        this.board = new PlayingPiece[n][n];
    }

    public String getCell(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            throw new IllegalArgumentException("Invalid position");
        }
        return board[x][y] == null ? null : board[x][y].pieceType;
    }

    public boolean placePiece(PlayingPiece piece, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            throw new IllegalArgumentException("Invalid position");
        }
        if (board[x][y] != null) {
            return false; // Cell already occupied
        }
        board[x][y] = piece;
        return true;
    }

    public int[][] getFreeCells() {
        int[][] freeCells = new int[n * n][2];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == null) {
                    freeCells[count++] = new int[]{i, j};
                }
            }
        }
        return freeCells;
    }

    public void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j].pieceType + " ");
                }
            }
            System.out.println();
        }
    }
}
