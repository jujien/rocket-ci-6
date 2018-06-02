import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Player {
    public Vector2D position;
    private Renderer renderer;
    public PlayerMove playerMove;


    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
    }

    public void run() {
        this.playerMove.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }
}
