package com.example;

import java.util.Scanner;
import com.example.domain.*;

public class Game {
    public static void main(String[] args) throws InterruptedException {
        Board_old board = new Board_old(20, 20);
        Snake snake = new Snake();
        Point food = board.placeFood(snake.body);
        int score = 0;
        Scanner sc = new Scanner(System.in);

        Thread inputThread = new Thread(() -> {
            while (true) {
                String dir = sc.nextLine().trim().toUpperCase();
                switch (dir) {
                    case "W":
                        snake.setDirection("UP");
                        break;
                    case "S":
                        snake.setDirection("DOWN");
                        break;
                    case "A":
                        snake.setDirection("LEFT");
                        break;
                    case "D":
                        snake.setDirection("RIGHT");
                        break;
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();

        while (true) {
            boolean grow = snake.body.get(0).equals(food);
            snake.move(grow);
            if (grow) {
                score++;
                food = board.placeFood(snake.body);
            }
            if (snake.isCollision(board.width, board.height)) {
                board.draw(snake.body, food);
                System.out.println("Game Over! Score: " + score);
                break;
            }
            board.draw(snake.body, food);
            System.out.println("Score: " + score);
            Thread.sleep(150);
        }
    }
}