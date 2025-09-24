package com.example.domain;

import java.util.List;

public class CollisionDetector {

    public CollisionDetector() {
    }

    public boolean wouldCollide(List<Point> snake, int boardWidth, int boardHeight) {
        Point head = snake.get(0);

        // Check wall collision
        if (head.x < 0 || head.x >= boardWidth || head.y < 0 || head.y >= boardHeight) {
            return true;
        }

        // Check self collision
        for (int i = 1; i < snake.size(); i++) {
            if (head.equals(snake.get(i))) {
                return true;
            }
        }

        return false;
    }
}