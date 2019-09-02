package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.image.BufferedImage;

public class IngridientCounter extends BaseCounter {
    public IngridientCounter(int xPos, int yPos, Item[] items, Handler handler) {
        super(Images.kitchenCounter[1], xPos, yPos,handler, items);
    }
}
