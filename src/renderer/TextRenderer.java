package renderer;

import base.Vector2D;

import java.awt.*;

public class TextRenderer implements Renderer {

    private String text;
    private Font font;
    private Color color;

    public TextRenderer(String text, String fontName, int fontSize, Color color) {
        this.text = text;
        this.color = color;

        this.font = new Font(fontName, Font.PLAIN, fontSize);
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color);
        graphics.setFont(this.font);
        graphics.drawString(this.text, (int) position.x, (int) position.y);
    }
}
