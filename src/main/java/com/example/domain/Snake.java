
// Snake.java
import java.util.Deque;
import java.util.LinkedList;

public class Snake {
    private Deque<Point> body; // head is first element
    private Direction direction;

    public Snake(int startX, int startY, int initialLength, Direction startDir) {
        body = new LinkedList<>();
        direction = startDir;
        // build initial snake horizontally/vertically depending on startDir
        for (int i = 0; i < initialLength; i++) {
            if (startDir == Direction.RIGHT) {
                body.addLast(new Point(startX - (initialLength - 1) + i, startY));
            } else if (startDir == Direction.LEFT) {
                body.addLast(new Point(startX + (initialLength - 1) - i, startY));
            } else if (startDir == Direction.DOWN) {
                body.addLast(new Point(startX, startY - (initialLength - 1) + i));
            } else { // UP
                body.addLast(new Point(startX, startY + (initialLength - 1) - i));
            }
        }
    }

    public Deque<Point> getBody() {
        return body;
    }

    public Point getHead() {
        return body.peekLast(); // we added with addLast; last is head
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDir) {
        if (newDir == null)
            return;
        // avoid reversing directly
        if (!newDir.isOpposite(direction)) {
            direction = newDir;
        }
    }

    // move the snake by adding new head and removing tail unless grow==true
    public void move(boolean grow) {
        Point head = getHead();
        Point newHead = null;
        switch (direction) {
            case UP:
                newHead = new Point(head.x, head.y - 1);
                break;
            case DOWN:
                newHead = new Point(head.x, head.y + 1);
                break;
            case LEFT:
                newHead = new Point(head.x - 1, head.y);
                break;
            case RIGHT:
                newHead = new Point(head.x + 1, head.y);
                break;
        }
        body.addLast(newHead);
        if (!grow) {
            body.removeFirst();
        }
    }

    // check if position collides with any part of the snake
    public boolean occupies(Point p) {
        for (Point b : body) {
            if (b.equals(p))
                return true;
        }
        return false;
    }

    // check self-collision (head with other body parts)
    public boolean hasSelfCollision() {
        Point head = getHead();
        int count = 0;
        for (Point b : body) {
            if (b.equals(head)) {
                count++;
                if (count >= 2)
                    return true;
            }
        }
        return false;
    }
}
