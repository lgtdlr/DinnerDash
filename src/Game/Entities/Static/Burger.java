package Game.Entities.Static;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Burger{

    int x;
    int y;
    int width;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    int height;
    public Burger(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    ArrayList<Item> ingredients = new ArrayList<>();
    ArrayList<BufferedImage> sprite = new ArrayList<>();

    public void addIngredient(Item ingredient){
        this.ingredients.add(ingredient);
        this.sprite.add(ingredient.sprite);
    }
    public void finishBurger(){
        this.sprite.add(null);
    }

    public void render(Graphics g){
        int counter = 1;
        for (BufferedImage ingredient:this.sprite){
            g.drawImage(ingredient,x,y-(counter * 10),width,height,null);
            counter++;
        }
    }

}
