package in.shabhushan.tankfighter.game.engine;

import in.shabhushan.tankfighter.game.model.GameObject;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public class Handler {
    List<GameObject> gameObjects = new LinkedList<>();

    public void update() {
        // TODO: Check why it's Giving Error
        // gameObjects.forEach(GameObject::update);
        for(GameObject gameObject: gameObjects) {
            gameObject.update();
        }
    }

    /**
     * Loops through all the game model and render them on the Frame
     * @param graphics
     */
    public void draw(Graphics2D graphics) {
        /* TODO: Check why it's not working
        gameObjects.forEach((GameObject gameObject) -> {
            gameObject.draw(graphics);
        });*/

        for(GameObject gameObject : gameObjects) {
           gameObject.draw(graphics);
        }
    }

    public void addObject(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public boolean removeObject(GameObject gameObject) {
        return gameObjects.remove(gameObject);
    }
}
