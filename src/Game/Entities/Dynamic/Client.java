package Game.Entities.Dynamic;

import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Client extends BaseDynamicEntity {
    int patience = 100;
    public Client(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos,32,32, handler);
    }

    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.drawRect(xPos,yPos,width,height);
    }

    public void move(){
        yPos+=64;
    }
}
