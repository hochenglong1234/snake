package com.example.domain;

public class GameMechanicsManager {
    public final long moveIntervalMillis;

    public GameMechanicsManager(long moveIntervalMillis) {
        this.moveIntervalMillis = moveIntervalMillis;
    }

    public boolean shouldAutoDrop(long lastMoveTime, long currentTime) {
        return currentTime - lastMoveTime >= moveIntervalMillis;
    }

    public long getCurrentTime() {
        return System.currentTimeMillis();
    }
}
