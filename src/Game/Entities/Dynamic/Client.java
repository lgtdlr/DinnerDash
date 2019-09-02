package Game.Entities.Dynamic;

import Main.Handler;

import java.awt.image.BufferedImage;

public class Client extends BaseDynamicEntity {

    public Client(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos,32,32, handler);
    }

}
