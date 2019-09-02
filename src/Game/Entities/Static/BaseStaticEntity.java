package Game.Entities.Static;

import Game.Entities.BaseEntity;
import Main.Handler;

import java.awt.image.BufferedImage;

class BaseStaticEntity extends BaseEntity {

    BaseStaticEntity(BufferedImage sprite, int xPos, int yPos,int width,int height, Handler handler) {
        super(sprite, xPos, yPos,width,height,handler);
    }
}
