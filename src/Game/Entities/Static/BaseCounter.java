package Game.Entities.Static;

import Main.Handler;

import java.awt.image.BufferedImage;

public class BaseCounter extends BaseStaticEntity {

    Item items[];

    BaseCounter(BufferedImage sprite, int xPos, int yPos,int width,int height, Handler handler, Item items[]) {
        super(sprite, xPos, yPos,width, height, handler);
        this.items=items;
    }

}
