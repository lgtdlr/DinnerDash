package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.*;

public class BreadCounter extends BaseCounter {
    public BreadCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[7], xPos, yPos,96,133,handler);
        item = new Item(Images.ingredients[5]);
    }



}
