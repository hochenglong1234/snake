package com.example.domain;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class FoodSpawner {
    private final Random random = new Random();

    public Food spawnFood(Board board, Snake snake) {
        Set<Position> occupied = new HashSet<>(snake.body);
        int width = board.width;
        int height = board.height;

        Position foodPosition;
        do {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            foodPosition = new Position(x, y);
        } while (occupied.contains(foodPosition));

        return new Food(foodPosition);
    }
}