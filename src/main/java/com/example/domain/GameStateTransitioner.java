package com.example.domain;

import com.example.common.GameAction;

public class GameStateTransitioner {
    public final SnakeMover snakeMover;
    public final FoodSpawner foodSpawner;
    public final ScoreCalculator scoreCalculator;

    public GameStateTransitioner(SnakeMover snakeMover, FoodSpawner foodSpawner, ScoreCalculator scoreCalculator) {
        this.snakeMover = snakeMover;
        this.foodSpawner = foodSpawner;
        this.scoreCalculator = scoreCalculator;
    }

    public GameState processInput(GameState currentState, GameAction action) {
        if (currentState.gameOver) {
            return currentState;
        }

        Snake newSnake = snakeMover.move(currentState.snake, action, currentState.board);

        boolean ateFood = newSnake.head().equals(currentState.food.position);
        boolean collided = snakeMover.hasCollision(newSnake, currentState.board);

        int newScore = currentState.score;
        Food newFood = currentState.food;

        if (ateFood) {
            newSnake = snakeMover.grow(newSnake);
            newScore = scoreCalculator.calculateScore(currentState.score, 1);
            newFood = foodSpawner.spawnFood(currentState.board, newSnake);
        }

        boolean gameOver = collided;

        return new GameState(currentState.board, newSnake, newFood, newScore, gameOver);
    }

    public GameState processAutoMove(GameState currentState) {
        return processInput(currentState, currentState.snake.currentDirection);
    }
}