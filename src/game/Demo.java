package game;

import base.GameObject;
import renderer.TextRenderer;

import java.awt.*;

public class Demo extends GameObject {

    public Demo() {
        this.position.set(40, 50);
        this.renderer = new TextRenderer(
                "Hello, world!",
                Color.RED,
                "resources/FiraMono-Bold.ttf",
                100
        );

    }
}
