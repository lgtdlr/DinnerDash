package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class IngridientCounter extends BaseCounter {
    public IngridientCounter(int xPos, int yPos, Item[] items, Handler handler) {
        super(Images.kitchenCounter[1], xPos, yPos,96,102,handler, items);
    }
}
