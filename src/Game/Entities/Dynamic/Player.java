package Game.Entities.Dynamic;

import Game.Entities.Static.BaseCounter;
import Game.Entities.Static.BreadCounter;
import Game.Entities.Static.EmptyCounter;
import Game.Entities.Static.Item;
import Main.Handler;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends BaseDynamicEntity {
    Item item;
    float money;
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
        if(handler.getKeyManager().fattbut){
            for(BaseCounter counter: handler.getWorld().Counters){
                if (counter instanceof EmptyCounter){
                    ((EmptyCounter)counter).createNewBurger();
                }
            }
        }
        if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_R)){
            ringCustomer();
        }
    }

    private void ringCustomer() {
    }

    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect(xPos,yPos,width,height);
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
