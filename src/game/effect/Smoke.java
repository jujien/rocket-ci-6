package game.effect;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

import java.awt.*;

public class Smoke extends GameObject {

    public Vector2D velocity;

    public Smoke() {
        this.renderer = new ImageRenderer("resources/images/circle.png", 15, 15, Color.CYAN);
        this.velocity = new Vector2D();
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
    }
}
