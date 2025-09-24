package com.example.domain;

public class GameState {
    public final Board board;
    public final Point point;
    public final boolean gameOver;

    public GameState(Board board, Point point, boolean gameOver) {
        this.board = board;
        this.point = point;
        this.gameOver = gameOver;
    }
}