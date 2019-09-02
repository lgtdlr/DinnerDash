package Game.Entities.Dynamic;

import Game.Entities.BaseEntity;
import Main.Handler;

import java.awt.image.BufferedImage;

public class BaseDynamicEntity extends BaseEntity {

    BaseDynamicEntity(BufferedImage sprite, int xPos, int yPos, int width, int height, Handler handler) {
        super(sprite, xPos, yPos,width,height, handler);
    }
}
