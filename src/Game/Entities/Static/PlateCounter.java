package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class PlateCounter extends BaseCounter {
    public PlateCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[6], xPos, yPos,96,117,handler);
//        item = new Item(Images.ingredients[6]);
    }
}
