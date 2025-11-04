package com.example.domain;

//import com.example.Game;
import com.example.common.GameAction;

public class GameEngine {
    public final GameStateTransitioner gameStateTransitioner;
    public final GameMechanicsManager gameMechanicsManager;

    public GameEngine(GameStateTransitioner gameStateTransitioner, GameMechanicsManager gameMechanicsManager) {
        this.gameStateTransitioner = gameStateTransitioner;
        this.gameMechanicsManager = gameMechanicsManager;
    }

    public GameState processInput(GameState currentState, GameAction action) {
        return gameStateTransitioner.processInput(currentState, action);
    }

    public GameState processAutoMove(GameState currentState) {
        return gameStateTransitioner.processAutoMove(currentState);
    }

    // public boolean shouldAutoMove(long lastMoveTime) {
    // long currentTime = gameMechanicsManager.getCurrentTime();
    // return gameMechanicsManager.shouldAutoMove(lastMoveTime, currentTime);
    // }

    public long getCurrentTime() {
        return gameMechanicsManager.getCurrentTime();
    }
}