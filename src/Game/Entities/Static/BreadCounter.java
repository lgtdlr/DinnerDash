package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class BreadCounter extends BaseCounter {
    public BreadCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[7], xPos, yPos,96,133,handler);
        item = Item.botBread;
    }


}
