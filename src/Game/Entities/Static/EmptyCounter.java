package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.*;

public class EmptyCounter extends BaseCounter {
    public Burger burger;

    public EmptyCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[3], xPos, yPos,96,102,handler);
        createNewBurger();
    }

    public void createNewBurger(){
        burger = new Burger(xPos + width/2 - 20, yPos+height/4, 40, 10);
    }

    @Override
    public void interact(){
        if (handler.getPlayer().getItem()!= null) {
            burger.addIngredient(handler.getPlayer().getItem());
            handler.getPlayer().setItem(null);
        }

    }

    @Override
    public void render(Graphics g){
        g.drawImage(sprite,xPos,yPos,width,height,null);
        burger.render(g);
    }
}
