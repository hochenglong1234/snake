package com.example.domain;

import java.util.List;
import java.util.Random;

public class Board_old {
    public int width, height;

    public Board_old(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(List<Point> snake, Point food) {
        char[][] board = new char[height][width];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                board[y][x] = ' ';

        for (int i = 0; i < snake.size(); i++) {
            Point p = snake.get(i);
            board[p.y][p.x] = (i == 0) ? 'O' : 'o';
        }
        board[food.y][food.x] = '*';

        System.out.print("\033[H\033[2J"); // Clear console
        System.out.flush();
        System.out.println("-".repeat(width + 2));
        for (int y = 0; y < height; y++) {
            System.out.print("|");
            for (int x = 0; x < width; x++)
                System.out.print(board[y][x]);
            System.out.println("|");
        }
        System.out.println("-".repeat(width + 2));
    }

    public Point placeFood(List<Point> snake) {
        Random rand = new Random();
        Point p;
        do {
            p = new Point(rand.nextInt(width), rand.nextInt(height));
        } while (snake.contains(p));
        return p;
    }
}