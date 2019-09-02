package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.image.BufferedImage;

public class StoveCounter extends BaseCounter {
    public StoveCounter(int xPos, int yPos, Item[] items, Handler handler) {
        super(Images.kitchenCounter[0], xPos, yPos,handler, items);
    }
}
