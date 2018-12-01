import java.awt.*;

public class DrawableRect extends Rectangle {
    public Color outColor;

    public void setOutColor(Color ok) {
        outColor = ok;
    }

    public DrawableRect(int xx1, int yy1, int xx2, int yy2, Color rCol) {
        super(xx1, yy1, xx2, yy2);
        outColor = rCol;
    }

    public DrawableRect(int width, int height, Color rCol) {
        super(width, height);
        outColor = rCol;
    }

    public DrawableRect() {
        super();
        outColor = Color.green;
    }
    @Override
    public void Draw(Graphics g) {
        g.setColor(outColor);
        g.drawRect(x1, y1, x2, y2);
    }
}
