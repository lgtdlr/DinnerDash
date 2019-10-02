package Game.Entities.Dynamic;

import Game.Entities.Static.Burger;
import Game.Entities.Static.Item;
import Game.Entities.Static.Order;
import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Client extends BaseDynamicEntity {
    private int patience;
    private int OGpatience;
    Order order;
    public boolean isLeaving = false;
    public Client(int xPos, int yPos, Handler handler) {
        super(Images.people[new Random().nextInt(9)], xPos, yPos,64,72, handler);
        setPatience(new Random().nextInt(120*60)+60*60);
        setOGpatience(getPatience());
        int numOfIngredients = new Random().nextInt(4)+1;
        int chumOrMeat = new Random().nextInt(2);
        order = new Order();
        order.food = new Burger(xPos +72,yPos,52,22);
        ((Burger) order.food).addIngredient(Item.botBread);
        if (chumOrMeat == 1) {
        	((Burger) order.food).addIngredient(Item.burger);
        	chumOrMeat = new Random().nextInt(1);
        }
        else {
        	((Burger) order.food).addIngredient(Item.chum);
        	chumOrMeat = new Random().nextInt(1);
        }
        order.value += 1.0;
        for(int i = 0;i<numOfIngredients;i++){
            int ingredients = new Random().nextInt(4)+1;
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
        setPatience(getPatience() - 1);
        if(getPatience()<=0){
            isLeaving=true;
        }
    }
    public void render(Graphics g){

        if(!isLeaving){
            g.drawImage(Images.tint(sprite,1.0f,((float)getPatience()/(float)getOGpatience()),((float)getPatience()/(float)getOGpatience())),xPos,yPos,width,height,null);

            ((Burger) order.food).render(g);
        }
    }

    public void move(){
        yPos+=102;
        ((Burger) order.food).y+=102;
    }

	public int getPatience() {
		return patience;
	}

	public void setPatience(int patience) {
		this.patience = patience;
	}

	public int getOGpatience() {
		return OGpatience;
	}

	public void setOGpatience(int oGpatience) {
		OGpatience = oGpatience;
	}
}
