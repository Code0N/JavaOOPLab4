import java.awt.*;

public class Rectangle {
    protected int x1, y1;
    protected int x2, y2;

    public int getx1() {
        return x1;
    }

    public int gety1() {
        return y1;
    }

    public int getx2() {
        return x2;
    }

    public int gety2() {
        return y2;
    }

    public Rectangle(int xx1, int yy1, int xx2, int yy2){ //first constructor
        x1 = xx1;
        y1 = yy1;
        x2 = xx2;
        y2 = yy2;
    }

    public Rectangle(int width, int height) { //second constructor
        x1 = 0;
        x2 = 0;
        x2 = width;
        y2 = height;
    }

    public Rectangle() { //third constructor
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;
    }

    public void rect_print() {
        System.out.println("X1 = " + x1);
        System.out.println("Y1 = " + y1);
        System.out.println("X2 = " + x2);
        System.out.println("Y2 = " + y2);
    }

    public void move(int dx, int dy) {
        x1 += dx;
        x2 += dx;
        y1 += dy;
        y2 += dy;
    }

    public Rectangle union(Rectangle rect) {
        if (x1<rect.getx1() && x2>rect.getx1() && y1>rect.gety1() && y1<rect.gety2()) {
            return new Rectangle(rect.x1, y1, x2, rect.gety2());
        }
        else if (x1>rect.getx1() && x1<rect.getx2() && y1>rect.gety1() && y1<rect.gety2()) {
            return new Rectangle(x1, y1, rect.getx2(), rect.gety2());
        }
        else if (x1<rect.getx1() && x2>rect.getx1() && y2>rect.gety1() && y2<rect.gety2()) {
            return new Rectangle(rect.getx1(), rect.gety1(), x2, y2);
        }
        else if (x1>rect.getx1() && x1<rect.getx2() && y2>rect.gety1() && y2<rect.gety2()) {
            return new Rectangle(x1, rect.gety1(), rect.getx2(), y2);
        }
        else {
            return null;
        }
    }
    public void Draw(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(x1, y1, x2, y2);
    }
}
