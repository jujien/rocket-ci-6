package scene;

import base.GameObject;
import base.GameObjectManager;
import game.background.Background;
import game.enemy.EnemySpawner;
import game.player.Player;
import game.star.StarSpawner;

public class GamePlayScene implements Scene {
    @Override
    public void init() {
        this.setupCharacter();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
    }

    private void setupCharacter() {
        GameObjectManager.instance.add(new Background());
        this.setupPlayer();
        GameObjectManager.instance.add(new StarSpawner());
        GameObjectManager.instance.add(new EnemySpawner());
    }

    private void setupPlayer() {
        Player player = GameObjectManager.instance.recycle(Player.class);
        player.position.set(500, 300);
        player.playerMove.velocity.set(4, 0);
    }
}
