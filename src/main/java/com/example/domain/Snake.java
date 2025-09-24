package com.example.domain;

import java.util.Scanner;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    public List<Point> body = new LinkedList<>();
    public String direction = "RIGHT";

    public Snake() {
        body.add(new Point(10, 10));
    }

    public void setDirection(String dir) {
        if ((direction.equals("UP") && dir.equals("DOWN")) ||
                (direction.equals("DOWN") && dir.equals("UP")) ||
                (direction.equals("LEFT") && dir.equals("RIGHT")) ||
                (direction.equals("RIGHT") && dir.equals("LEFT"))) {
            return;
        }
        direction = dir;
    }

    public void move(boolean grow) {
        Point head = body.get(0);
        int x = head.x, y = head.y;
        switch (direction) {
            case "UP":
                y--;
                break;
            case "DOWN":
                y++;
                break;
            case "LEFT":
                x--;
                break;
            case "RIGHT":
                x++;
                break;
        }
        body.add(0, new Point(x, y));
        if (!grow)
            body.remove(body.size() - 1);
    }

    public boolean isCollision(int width, int height) {
        Point head = body.get(0);
        if (head.x < 0 || head.x >= width || head.y < 0 || head.y >= height)
            return true;
        for (int i = 1; i < body.size(); i++)
            if (head.equals(body.get(i)))
                return true;
        return false;
    }
}