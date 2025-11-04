// Point.java
public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Point))
            return false;
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }

    public int hashCode() {
        return 31 * x + y;
    }

    public Point copy() {
        return new Point(x, y);
    }
}