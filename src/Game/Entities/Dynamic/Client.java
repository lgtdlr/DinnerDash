package Game.Entities.Dynamic;

import Game.Entities.Static.Burger;
import Game.Entities.Static.Item;
import Game.Entities.Static.Order;
import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Client extends BaseDynamicEntity {
    int patience = 100;
    Order order;
    public Client(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos,64,72, handler);
        int numOfIngredients = new Random().nextInt(6)+1;
        order = new Order();
        order.food = new Burger(xPos +64,yPos,32,42);
        ((Burger) order.food).addIngredient(Item.botBread);
        ((Burger) order.food).addIngredient(Item.burger);

        for(int i = 0;i<numOfIngredients;i++){
            int ingredients = new Random().nextInt(3)+1;
            switch (ingredients){
                case 1:
                    ((Burger) order.food).addIngredient(Item.lettuce);

                    break;
                case 2:
                    ((Burger) order.food).addIngredient(Item.tomato);

                    break;

                case 3:
                    ((Burger) order.food).addIngredient(Item.cheese);

                    break;
            }

        }
        ((Burger) order.food).addIngredient(Item.topBread);

    }

    public void tick(){

    }
    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(xPos,yPos,width,height);
        ((Burger) order.food).render(g);
    }

    public void move(){
        yPos+=82;
        ((Burger) order.food).y+=82;
    }
}
