package Game.Entities.Static;

import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

import Game.Entities.Dynamic.Client;

public class BaseCounter extends BaseStaticEntity {

    public Item item;
    public static int DEFAULTCOUNTERWIDTH = 96;

	public static int getCOUNTERWIDTH() {
		return DEFAULTCOUNTERWIDTH;
	}

	BaseCounter(BufferedImage sprite, int xPos, int yPos,int width,int height, Handler handler) {
        super(sprite, xPos, yPos,width, height, handler);
    }

    public boolean isInteractable(){
        return handler.getPlayer().xPos + width/2 >= xPos && handler.getPlayer().xPos + width/2 < xPos + width;
    }

    public void interact(){
        if (item != null) {
            handler.getPlayer().getBurger().addIngredient(item);
        } else if (handler.getBonusCounter().activated) {
        	for (Client clients: handler.getWorld().clients) {
				clients.setPatience(clients.getOGpatience());
			}
        	handler.getBonusCounter().activated=false;
        	handler.getBonusCounter().timer=0;
        	handler.getBonusCounter().activationTimer=0;
        }
    }
    public void tick(){

    }

    public void render(Graphics g){
        g.drawImage(sprite,xPos,yPos,width,height,null);
        if(isInteractable() && item != null){
            g.drawImage(item.sprite,xPos + width/2 - 25,yPos -30,50,30,null);
        }
    }
}
