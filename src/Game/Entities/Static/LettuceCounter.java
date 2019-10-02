package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class LettuceCounter extends BaseCounter {
    public LettuceCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[1], xPos, yPos,BaseCounter.getCOUNTERWIDTH(),102,handler);
        item = Item.lettuce;
    }
}
