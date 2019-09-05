package Game.Entities.Dynamic;

import Game.Entities.Static.BaseCounter;
import Game.Entities.Static.Item;
import Main.Handler;


import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends BaseDynamicEntity {
    Item item;
    public Player(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos,82,112, handler);
    }
    public void tick(){
        if(handler.getKeyManager().right){
            xPos+=2;
        }
        if(handler.getKeyManager().left){
            xPos-=2;
        }
        if(handler.getKeyManager().up){
            yPos-=2;
        }
        if(handler.getKeyManager().down){
            yPos+=2;
        }
        if(handler.getKeyManager().attbut){
            interact();
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.drawRect(xPos,yPos,width,height);
        if(item != null){
            g.drawImage(item.sprite,xPos + width/2 - 25,yPos -30,50,30,null);
        }
    }

    public void interact(){
        for(BaseCounter counter: handler.getWorld().Counters){
            if (counter.isInteractable()){
                counter.interact();
            }
        }
    }

    public void setItem(Item item){
        this.item = item;
    }

    public Item getItem(){
        return item;
    }
}
