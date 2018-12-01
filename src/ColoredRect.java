import java.awt.*;

public class ColoredRect extends DrawableRect {
    protected Color inColor;

    public ColoredRect(int xx1, int yy1, int xx2, int yy2, Color rCol, Color inCol) {
        super(xx1, yy1, xx2, yy2, rCol);
        inColor = inCol;
    }

    public ColoredRect(int width, int height, Color rCol, Color inCol) {
        super(width, height, rCol);
        inColor = inCol;
    }

    public ColoredRect() {
        super();
        inColor = Color.blue;
    }

    @Override
    public void Draw(Graphics g) {
        g.setColor(super.outColor);
        g.fillRect(x1, y1, x2, y2);
        g.setColor(inColor);
        g.drawRect(x1, y1, x2, y2);
    }
}
