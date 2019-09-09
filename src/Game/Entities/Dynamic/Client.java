package Game.Entities.Dynamic;

import Game.Entities.Static.Burger;
import Game.Entities.Static.Item;
import Game.Entities.Static.Order;
import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Client extends BaseDynamicEntity {
    int patience;
    int OGpatience;
    Order order;
    public boolean isLeaving = false;
    public Client(BufferedImage sprite, int xPos, int yPos, Handler handler) {
        super(sprite, xPos, yPos,64,72, handler);
        patience = new Random().nextInt(120*60)+60*60;
        OGpatience = patience;
        int numOfIngredients = new Random().nextInt(6)+1;
        order = new Order();
        order.food = new Burger(xPos +64,yPos,32,42);
        ((Burger) order.food).addIngredient(Item.botBread);
        ((Burger) order.food).addIngredient(Item.burger);
        order.value += 1.0;
        for(int i = 0;i<numOfIngredients;i++){
            int ingredients = new Random().nextInt(3)+1;
            order.value += 0.5;
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
        patience--;
        if(patience<=0){
            isLeaving=true;
        }
    }
    public void render(Graphics g){
        if(patience<=OGpatience/4) {
            g.setColor(Color.red);
        }
        else if(patience<= (OGpatience/4)*3) {
            g.setColor(Color.YELLOW);
        }else{
            g.setColor(Color.GREEN);
        }
        if(!isLeaving){
            g.fillRect(xPos,yPos,width,height);
            ((Burger) order.food).render(g);
        }
    }

    public void move(){
        yPos+=92;
        ((Burger) order.food).y+=92;
    }
}
