package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class TomatoCounter extends BaseCounter {
    public TomatoCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[4], xPos, yPos,96,113,handler);
        item = Item.tomato;
    }
}
