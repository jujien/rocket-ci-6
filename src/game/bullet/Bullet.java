package game.bullet;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import physic.PhysicBody;
import renderer.ImageRenderer;

public class Bullet extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;

    public Bullet() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 6, 6);
        this.boxCollider = new BoxCollider(6, 6);
    }

    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
        Enemy enemy = GameObjectManager.instance.checkCollision(this.boxCollider, Enemy.class);
        if (enemy != null) {
            this.getHit();
            enemy.getHit();
        }
    }

    public void getHit() {
        this.isAlive = false;
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
