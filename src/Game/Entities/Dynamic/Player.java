package Game.Entities.Dynamic;

import Game.Entities.Static.*;
import Main.Handler;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Player extends BaseDynamicEntity {
    Item item;
    float money;
    int speed = 5;
    public Player(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos,82,112, handler);
    }
    public void tick(){
        if(handler.getKeyManager().right){
            xPos+=speed;
        }
        if(handler.getKeyManager().left){
            xPos-=speed;
        }
        if(handler.getKeyManager().up){
            yPos-=speed;
        }
        if(handler.getKeyManager().down){
            yPos+=speed;
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
        if(handler.getCurrentBurger().ingredients.size()<=1){
            return;
        }
        for(Client client: handler.getWorld().clients){
            boolean matched =true;
            for(int i =0 ;i<((Burger)client.order.food).ingredients.size();i++){
                if(!((Burger)client.order.food).ingredients.get(i).sprite.equals(handler.getCurrentBurger().ingredients.get(i+1).sprite) ){
                    matched=false;
                    System.out.println("Didnt Match");
                    break;
                }

            }
            if(matched){
                money+=client.order.value;
                handler.getWorld().clients.remove(client);
                handler.getEmptyCounter().createNewBurger();
                return;
            }

        }
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
