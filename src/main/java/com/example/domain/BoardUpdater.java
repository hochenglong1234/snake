package com.example.domain;

import java.util.List;

public class BoardUpdater {

    public BoardUpdater() {
    }

    public Board_old updateBoard(Board_old board, List<Point> snake, Point food) {
        char[][] newGrid = new char[board.height][board.width];

        // Fill with empty spaces
        for (int y = 0; y < board.height; y++) {
            for (int x = 0; x < board.width; x++) {
                newGrid[y][x] = ' '; // Does this violate the SOLID principle?
            }
        }

        // Draw snake
        for (int i = 0; i < snake.size(); i++) {
            Point p = snake.get(i);
            newGrid[p.y][p.x] = (i == 0) ? 'O' : 'o'; // Head is 'O', body is 'o'
        }

        // Draw food
        newGrid[food.y][food.x] = '*';
        return board;
    }
}