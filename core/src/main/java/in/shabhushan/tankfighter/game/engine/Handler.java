package in.shabhushan.tankfighter.game.engine;

import in.shabhushan.tankfighter.game.model.GameObject;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shashi Bhushan
 * @date 16/9/18
 */
public class Handler<T extends GameObject> {
    List<T> gameObjects = new LinkedList<>();

    public void update() {
        // TODO: Check why it's Giving Error
        // gameObjects.forEach(GameObject::update);
        for(T gameObject: gameObjects) {
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

    public void addObject(T gameObject) {
        gameObjects.add(gameObject);
    }

    public boolean removeObject(T gameObject) {
        return gameObjects.remove(gameObject);
    }

    public List<T> getGameObjects() {
        return gameObjects;
    }
}
