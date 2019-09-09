package Game.Entities.Static;

import Resources.Images;

import java.awt.image.BufferedImage;

public class Item {

    public BufferedImage sprite;

    public Item(BufferedImage sprite){
        this.sprite = sprite;
    }

    public static Item cheese = new Item(Images.ingredients[2]);
    public static Item lettuce = new Item(Images.ingredients[4]);
    public static Item tomato = new Item(Images.ingredients[3]);
    public static Item burger = new Item(Images.tint(Images.ingredients[1],0.5f,0.5f,0.5f));
    public static Item botBread = new Item(Images.ingredients[5]);
    public static Item topBread = new Item(Images.ingredients[0]);
}



