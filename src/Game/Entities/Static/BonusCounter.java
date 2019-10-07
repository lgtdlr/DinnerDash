package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.util.Random;

public class BonusCounter extends BaseCounter {

    int timer = 0;
    int activationThreshold = 0;
    int activationTimer = 0;
    boolean activated = false;
    int doOnce = 0;
    float tint = 1;
    public BonusCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[0], xPos, yPos,BaseCounter.getCOUNTERWIDTH(),102,handler);
    }

    @Override
    public void tick() {
    	timer++;
    	do {
			activationThreshold = new Random().nextInt(9999);
		} while (activationThreshold<1000);
    	
        if(timer >= activationThreshold){
        	
        	if (doOnce == 0) {
        		activationTimer = timer;
        		doOnce++;
        	}
        	activated = true;
        	if (timer-activationTimer >= 120 || !activated) {
        		timer = 0;
        		activationTimer = 0;
        		activated = false;
        		doOnce = 0;
        	}
        }
    }

    public void render(Graphics g){
        g.drawImage(sprite,xPos,yPos,width,height,null);
        if(activated){
            g.drawImage(Images.kitchenCounter[1],xPos,yPos,width,height,null);
        } else {
        	g.drawImage(Images.kitchenCounter[0],xPos,yPos,width,height,null);
        }
        if(isInteractable() && item != null){
            g.drawImage(item.sprite,xPos + width/2 - 25,yPos -30,50,30,null);
        }
    }
}

