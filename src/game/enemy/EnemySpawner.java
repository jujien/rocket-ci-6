package game.enemy;

import action.ActionAdapter;
import action.SequenceAction;
import action.WaitAction;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemySpawner extends GameObject {

    private FrameCounter frameCounter;
    private Random random;

    public EnemySpawner() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(200);
        this.createAction();
    }

    public void createAction() {
        this.addAction(
                new SequenceAction(
                        new WaitAction(30),
                        new ActionAdapter() {

                            private List<Enemy> list = new ArrayList<>();
                            private int count = 0;

                            @Override
                            public boolean run(GameObject owner) {
                                if (list.isEmpty()) {

                                    Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                                    enemy.position.set(random.nextInt(1024), random.nextInt(600));
                                    this.count += 1;
                                    list.add(enemy);
                                }

                                list.removeIf(enemy -> !enemy.isAlive);

                                return this.count == 5;
                            }
                        }
                )
        );
    }

    @Override
    public void run() {
        super.run();
//        if (this.frameCounter.run()) {
//            Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
//            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
//            this.frameCounter.reset();
//        }
    }
}
