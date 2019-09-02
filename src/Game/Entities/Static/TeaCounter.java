package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.image.BufferedImage;

public class TeaCounter extends BaseCounter {

    public TeaCounter(int xPos, int yPos, Item[] items, Handler handler) {
        super(Images.kitchenCounter[2], xPos, yPos,handler, items);
    }

}
