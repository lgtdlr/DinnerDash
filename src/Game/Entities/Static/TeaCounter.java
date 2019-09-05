package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class TeaCounter extends BaseCounter {

    public TeaCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[2], xPos, yPos,96,116,handler);
    }

}
