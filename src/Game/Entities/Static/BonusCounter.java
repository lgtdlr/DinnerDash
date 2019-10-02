package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.util.Random;

public class BonusCounter extends BaseCounter {

    int counter = 0;
    int activationThreshold = 0;
    int activationCounter = 0;
    boolean activated = false;
    int doOnce = 0;
    float tint = 1;
    public BonusCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[0], xPos, yPos,BaseCounter.getCOUNTERWIDTH(),102,handler);
    }

    @Override
    public void tick() {
    	counter++;
    	do {
			activationThreshold = new Random().nextInt(9999);
		} while (activationThreshold<1000);
    	
        if(counter >= activationThreshold){
        	
        	if (doOnce == 0) {
        		activationCounter = counter;
        		doOnce++;
        	}
        	activated = true;
        	if (counter-activationCounter >= 120 || !activated) {
        		counter = 0;
        		activationCounter = 0;
        		activated = false;
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

