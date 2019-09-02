package Game.Entities.Dynamic;

import Main.Handler;

import java.awt.image.BufferedImage;

public class Player extends BaseDynamicEntity {
    public Player(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos, handler);
    }
}
