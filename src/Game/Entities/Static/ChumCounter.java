package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.*;

public class ChumCounter extends BaseCounter {
    public ChumCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[8], xPos, yPos,BaseCounter.getCOUNTERWIDTH(),102,handler);
        item = Item.chum;
    }

}
