package Game.Entities.Static;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Burger{

    int x =0,y =0, width = 16, height = 6;

    public Item ingridients[];
    ArrayList<BufferedImage> sprite = new ArrayList<>();

    public void addIngridient(BufferedImage sprite){
        this.sprite.add(sprite);
    }
    public void finishBurger(){
        this.sprite.add(null);
    }

    public void render(Graphics g){
        int counter = 1;
        for (BufferedImage ingridient:this.sprite){
            g.drawImage(ingridient,x,y-(counter * 15),width,height,null);
        }
    }
}
