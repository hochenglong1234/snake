package com.example.domain;

import com.example.common.GameAction;

public class SnakeMover {

    public Snake move(Snake snake, GameAction action, Board board) {
        Direction newDirection = getDirection(action, snake.currentDirection);
        Position newHead = getNextPosition(snake.head(), newDirection);

        // Prevent reversing direction
        if (snake.body.size() > 1 && newHead.equals(snake.body.get(1))) {
            newDirection = snake.currentDirection;
            newHead = getNextPosition(snake.head(), newDirection);
        }

        Snake newSnake = snake.moveTo(newHead, newDirection);
        return newSnake;
    }

    public Snake grow(Snake snake) {
        return snake.grow();
    }

    public boolean hasCollision(Snake snake, Board board) {
        Position head = snake.head();

        // Check wall collision
        if (head.x < 0 || head.x >= board.width || head.y < 0 || head.y >= board.height) {
            return true;
        }

        // Check self collision
        for (int i = 1; i < snake.body.size(); i++) {
            if (head.equals(snake.body.get(i))) {
                return true;
            }
        }

        return false;
    }

    private Direction getDirection(GameAction action, Direction currentDirection) {
        switch (action) {
            case MOVE_UP:
                return currentDirection == Direction.DOWN ? currentDirection : Direction.UP;
            case MOVE_DOWN:
                return currentDirection == Direction.UP ? currentDirection : Direction.DOWN;
            case MOVE_LEFT:
                return currentDirection == Direction.RIGHT ? currentDirection : Direction.LEFT;
            case MOVE_RIGHT:
                return currentDirection == Direction.LEFT ? currentDirection : Direction.RIGHT;
            default:
                return currentDirection;
        }
    }

    private Position getNextPosition(Position head, Direction direction) {
        switch (direction) {
            case UP:
                return new Position(head.x, head.y - 1);
            case DOWN:
                return new Position(head.x, head.y + 1);
            case LEFT:
                return new Position(head.x - 1, head.y);
            case RIGHT:
                return new Position(head.x + 1, head.y);
            default:
                return head;
        }
    }
}
