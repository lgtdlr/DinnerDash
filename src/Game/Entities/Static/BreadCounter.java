package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

public class BreadCounter extends BaseCounter {
    private Item topBun = new Item(Images.ingredients[0]);
    private Item bottomBun = new Item(Images.ingredients[5]);
    public BreadCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[7], xPos, yPos,96,133,handler);
        item = bottomBun;
    }

    @Override
    public void interact(){
       super.interact();
       if (item.equals(bottomBun)){
           item = topBun;
       }else{
           item = bottomBun;
       }
    }

}
