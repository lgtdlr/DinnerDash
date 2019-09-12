package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class CheeseCounter extends BaseCounter {
    public CheeseCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[5], xPos, yPos,96,108,handler);
        item = Item.cheese;
    }

}
