package Game.Entities.Static;

import Main.Handler;
import Resources.Images;

import java.awt.*;

public class PlateCounter extends BaseCounter {
    public PlateCounter(int xPos, int yPos, Handler handler) {
        super(Images.kitchenCounter[6], xPos, yPos,96,117,handler);
    }

    @Override
    public void render(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g.drawImage(sprite,xPos,yPos,width,height,null);
        if(isInteractable()){
            g2.setColor(Color.RED);
            g.setFont(new Font("ComicSans", Font.ITALIC, 32));
            g2.drawString("SERVE (R)",xPos + width/2 - 32,yPos -70);
            g.drawImage(sprite,xPos,yPos,width,height,null);
            g2.drawString("Clear (C)",xPos + width/2 - 32,yPos -30);
//                g.drawImage(item.sprite,50,30,null);
//            g.drawImage(item.sprite,50,30,null);
            
        }
    }
}
