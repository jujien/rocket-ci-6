package game.player;

import base.FrameCounter;
import base.GameObjectManager;
import base.Vector2D;
import game.bullet.Bullet;
import input.KeyboardInput;

public class PlayerShoot {
    private FrameCounter frameCounter;
    public Shoot shoot;
    public SingleShoot singleShoot;
    public TripleShoot tripleShoot;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(20);
        this.tripleShoot = new TripleShoot();
        this.shoot = this.singleShoot;
    }

    public void run(Player player) {
        if (KeyboardInput.instance.spacePressed) {
            System.out.println("shoot");
            this.shoot.shoot(player);
//            if (this.frameCounter.run()) {
//
//                this.frameCounter.reset();
//            }
        }

    }
}
