package game.player;

import base.GameObject;
import base.Vector2D;
import game.effect.ShieldEffect;
import physic.RunHitObject;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    private RunHitObject runHitObject;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.runHitObject = new RunHitObject(
                ShieldEffect.class
        );
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
    }
}
