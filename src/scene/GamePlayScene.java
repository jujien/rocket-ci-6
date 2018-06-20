package scene;

import base.GameObject;
import base.GameObjectManager;
import game.Demo;
import game.background.Background;
import game.enemy.EnemySpawner;
import game.player.Player;
import game.star.StarSpawner;
import utils.Utils;

import javax.sound.sampled.Clip;

public class GamePlayScene implements Scene {

    private Clip clip;

    @Override
    public void init() {
        this.setupCharacter();
        GameObjectManager.instance.recycle(Demo.class);
        this.clip = Utils.loadAudio("resources/audio/shot.wav");

//        this.clip.loop(-1);
//        this.clip.start();
    }

    @Override
    public void deinit() {
        GameObjectManager.instance.clear();
        this.clip.stop();
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
