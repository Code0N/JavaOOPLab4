import java.applet.Applet
import java.awt.*
import java.awt.event.*
import java.util.ArrayList

import ColoredRect
import Rectangle
import DrawableRect

class maap : Applet(), ActionListener, MouseListener, MouseMotionListener {
    internal var rectButton = Button("Прямоугольник 1")
    internal var drawableRectButton = Button("Прямоугольник 2")
    internal var coloredRectButton = Button("Прямоугольник 3")
    internal var rects: MutableList<Rectangle> = ArrayList()
    internal var selectedRect: Rectangle? = null
    internal var lastCursorPoint: Point? = null

    override fun init() {
        rectButton.name = "rect"
        rectButton.addActionListener(this)
        this.add(rectButton)
        this.add(drawableRectButton)
        drawableRectButton.name = "drawableRect"
        drawableRectButton.addActionListener(this)
        this.add(coloredRectButton)
        coloredRectButton.name = "coloredRect"
        coloredRectButton.addActionListener(this)
        this.addMouseListener(this)
        this.addMouseMotionListener(this)
    }

    override fun mousePressed(e: MouseEvent) {
        val x = e.x
        val y = e.y
        selectedRect = getSelRect(x, y)
        lastCursorPoint = Point(x, y)
    }

    fun getSelRect(x: Int, y: Int): Rectangle? {
        for (r in rects) {
            if (r.x1 <= x && r.x2 >= x && r.y1 <= y && r.y2 >= y) {
                return r
            }
        }
        return null
    }

    override fun mouseReleased(e: MouseEvent) {
        if (selectedRect != null) {
            val rectIndex = rects.indexOf(selectedRect!!)
            rects.removeAt(rectIndex)
            rects.add(0, selectedRect!!)
        }
        selectedRect = null
        lastCursorPoint = null
    }

    override fun mouseDragged(e: MouseEvent) {
        if (selectedRect == null) {
            return
        }
        val currentX = e.x
        val currentY = e.y
        val dx = currentX - lastCursorPoint!!.x
        val dy = currentY - lastCursorPoint!!.y
        selectedRect!!.move(dx, dy)
        repaintRects()
        lastCursorPoint = Point(currentX, currentY)
    }

    override fun mouseMoved(e: MouseEvent) {}
    override fun mouseClicked(e: MouseEvent) {}
    override fun mouseEntered(e: MouseEvent) {}
    override fun mouseExited(e: MouseEvent) {}

    override fun actionPerformed(e: ActionEvent) {
        var r = Rectangle(200, 200)
        when ((e.source as Button).name) {
            "drawableRect" -> r = DrawableRect(200, 200, Color.CYAN)
            "coloredRect" -> r = ColoredRect(200, 200, Color.CYAN, Color.BLACK)
            "rect" ->
                r = Rectangle(200, 200)
        }
        r.Draw(this.graphics)
        rects.add(0, r)
    }


    internal fun repaintRects() {
        val g = this.graphics
        val d = this.size
        g.color = Color.white
        g.fillRect(0, 0, d.width, d.height)
        for (r in this.rects) {
            r.Draw(g)
        }
    }
}