package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class EmptyCounter extends BaseCounter {

    public EmptyCounter(int xPos, int yPos, Item[] items, Handler handler) {
        super(Images.kitchenCounter[3], xPos, yPos,96,102,handler, items);
    }

}