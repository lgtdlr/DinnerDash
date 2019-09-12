package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class TopBreadCounter extends BaseCounter {
    public TopBreadCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[7], xPos, yPos,96,133,handler);
        item = Item.topBread;
    }



}
