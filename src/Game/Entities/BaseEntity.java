package Game.Entities;

import Main.Handler;

import java.awt.image.BufferedImage;

public class BaseEntity {

    public BufferedImage sprite;
    public int xPos,yPos;
    private Handler handler;

    public BaseEntity(BufferedImage sprite,int xPos, int yPos,Handler handler){
        this.sprite = sprite;
        this.xPos=xPos;
        this.yPos=yPos;
        this.handler=handler;
    }
}
