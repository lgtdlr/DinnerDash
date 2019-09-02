package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class StoveCounter extends BaseCounter {
    public StoveCounter(int xPos, int yPos, Item[] items, Handler handler) {
        super(Images.kitchenCounter[0], xPos, yPos,96,102,handler, items);
    }
}
