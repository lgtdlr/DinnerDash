package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.image.BufferedImage;

public class EmptyCounter extends BaseCounter {

    public EmptyCounter(int xPos, int yPos, Item[] items, Handler handler) {
        super(Images.kitchenCounter[3], xPos, yPos,handler, items);
    }

}
