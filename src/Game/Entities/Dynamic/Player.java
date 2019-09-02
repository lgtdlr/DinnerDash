package Game.Entities.Dynamic;

import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends BaseDynamicEntity {
    public Player(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos,82,112, handler);
    }
    public void tick(){
        if(handler.getKeyManager().right){
            xPos++;
        }
        if(handler.getKeyManager().left){
            xPos--;
        }
        if(handler.getKeyManager().up){
            yPos--;
        }
        if(handler.getKeyManager().down){
            yPos++;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(xPos,yPos,width,height);
    }
}
