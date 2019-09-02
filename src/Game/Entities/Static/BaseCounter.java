package Game.Entities.Static;

import Main.Handler;

import java.awt.image.BufferedImage;

public class BaseCounter extends BaseStaticEntity {

    Item items[];

    public BaseCounter(BufferedImage sprite, int xPos, int yPos, Handler handler, Item items[]) {
        super(sprite, xPos, yPos,handler);
        this.items=items;
    }

}
