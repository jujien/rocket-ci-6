package game.player;

import action.ActionAdapter;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import game.effect.ShieldEffect;
import game.effect.Smoke;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhysicBody;
import physic.RunHitObject;
import renderer.ImageRenderer;
import renderer.PolygonRenderer;
import scene.GameOverScene;
import scene.SceneManager;

import java.awt.*;

public class Player extends GameObject implements PhysicBody {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    private RunHitObject runHitObject;
    private BoxCollider boxCollider;
    private FrameCounter frameCounter = new FrameCounter(10);

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
        this.boxCollider = new BoxCollider(20, 16);
        this.runHitObject = new RunHitObject(
                Enemy.class
        );
        ActionAdapter actionAdapter = new ActionAdapter() {
            @Override
            public boolean run(GameObject owner) {
                return false;
            }
        };
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        this.playerShoot.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
        this.createSmoke();
        this.boxCollider.position.set(this.position);
        this.runHitObject.run(this);
    }

    private void createSmoke() {
        if (this.frameCounter.run()) {
            Smoke smoke = GameObjectManager.instance.recycle(Smoke.class);
            smoke.renderer = new ImageRenderer("resources/images/circle.png", 15, 15, Color.CYAN);
            smoke.position.set(position);

            Vector2D rotate = this.playerMove.velocity.add(
                    (new Vector2D(1.5f, 0)).rotate(this.playerMove.angle)
            );

            smoke.velocity.set(rotate);
            this.frameCounter.reset();
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }

    @Override
    public void getHit(GameObject gameObject) {
        this.isAlive = false;

        SceneManager.instance.changeScene(new GameOverScene());
    }
}
