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
    private double patience;
    private double OGpatience;
    Order order;
    public boolean isLeaving = false;
    private int runOnce=0;//To make condition run once in tick()
    public int inspectorNotOnTime=0;//How many times inspector does not get food on time
    
    public Client(int xPos, int yPos, Handler handler) {
        super(Images.people[new Random().nextInt(10)], xPos, yPos,64,72, handler);
        setPatience(new Random().nextInt(120*60)+60*60);
        //Subtracting 6% patience to all future customers for each inspector not served
        if(inspectorNotOnTime!=0)
        	setOGpatience(getPatience()-getPatience()*0.06*inspectorNotOnTime);
        else setOGpatience(getPatience());
        //Adding 6% patience to all future customers for each inspector served
        if(handler.getPlayer().inspectorOnTime!=0)
        	setOGpatience(getPatience()*1.10*handler.getPlayer().inspectorOnTime);
        
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
        //Checks if inspector is served on time and if not, set money to 0
		if(sprite.equals(Images.people[9])) {
			if(isLeaving) {
				handler.getPlayer().money=0;
				inspectorNotOnTime++;
			}
		}
		//Adding 12% patience to customers if inspector is served
		if(handler.getPlayer().inspectorOnTime!=0 && runOnce==0) {
			setPatience(getPatience()*1.12);
			runOnce=1;
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
    
    public void moveBackwards() {
    	yPos-=102;
    	((Burger) order.food).y-=102;
    }

	public double getPatience() {
		return patience;
	}

	public void setPatience(double patience) {
		this.patience = patience;
	}

	public double getOGpatience() {
		return OGpatience;
	}

	public void setOGpatience(double oGpatience) {
		OGpatience = oGpatience;
	}
}
