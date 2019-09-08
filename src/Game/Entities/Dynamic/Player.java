package Game.Entities.Dynamic;

import Game.Entities.Static.BaseCounter;
import Game.Entities.Static.Burger;
import Game.Entities.Static.Item;
import Main.Handler;
import Resources.Images;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends BaseDynamicEntity {
    private Burger burger;
    private String direction = "right";
    private int interactionCounter = 0;
    private int speed = 10;
    public Player(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos,82,112, handler);
        burger = new Burger(handler.getWidth() - 110, 100, 100, 50);
    }
    public void tick(){
        if(xPos + width >= handler.getWidth()){
            direction = "left";
            speed = 10;
        } else if(xPos <= 0){
            direction = "right";
            speed = 10;
        }
        if (direction.equals("right")){
            xPos+=speed;
        } else{
            xPos-=speed;
        }
        if (interactionCounter > 15 && handler.getKeyManager().attbut){
            interact();
            interactionCounter = 0;
        } else {
            interactionCounter++;
        }
    }

    public void render(Graphics g) {
        g.drawImage(Images.player, xPos, yPos, width, height, null);
        g.setColor(Color.green);
        burger.render(g);
    }

    public void interact(){
        for(BaseCounter counter: handler.getWorld().Counters){
            if (counter.isInteractable()){
                counter.interact();
            }
        }
    }
    public Burger getBurger(){
        return this.burger;
    }
}
