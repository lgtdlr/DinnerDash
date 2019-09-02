package Game.Entities.Dynamic;

import Game.Entities.BaseEntity;
import Main.Handler;

import java.awt.image.BufferedImage;

public class BaseDynamicEntity extends BaseEntity {

    public BaseDynamicEntity(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos, handler);
    }
}
