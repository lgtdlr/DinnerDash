package Game.Entities.Dynamic;

import Game.Entities.Static.Burger;
import Game.Entities.Static.Item;
import Game.Entities.Static.Order;
import Game.GameStates.State;
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
    private int runOnce;//To make condition run once in tick()
    private int runOnce1;//To make condition run once in tick()
    private int runOnce2;//To make condition run once in tick()
    public int inspectorNotOnTime=0;//Indicates inspector did not get food on time
    private int countNotOnTime=0;//Counts how many times did inspectors NOT get food on time
    private int countOnTime=0;//Counts how many times did inspector get food on time
    
    public Client(int xPos, int yPos, Handler handler) {
        super(Images.people[new Random().nextInt(11)], xPos, yPos,64,72, handler);
        runOnce = 0;
        runOnce1 = 0;
        runOnce2 = 0;
        setPatience(new Random().nextInt(120*60)+60*60);
        setOGpatience(getPatience());
        
        //Subtracting 6% patience to all future customers for each inspector not served
        if(inspectorNotOnTime!=0) {
        	countNotOnTime++;
        	setPatience(getOGpatience()-getOGpatience()*(0.06*countNotOnTime));
        	setOGpatience(getPatience());
        	inspectorNotOnTime=0;
        }
        
        //Adding 10% patience to all future customers for each inspector served
        if(handler.getPlayer().inspectorOnTime!=0) {
        	countOnTime++;
        	setPatience(getOGpatience()+getOGpatience()*(0.10*countOnTime));
        	setOGpatience(getPatience());
        	handler.getPlayer().inspectorOnTime=0;
        }
        
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
			if(isLeaving && runOnce == 0) {
				handler.getPlayer().money-=handler.getPlayer().money/2;
				inspectorNotOnTime++;
				runOnce = 1;
			}
		}
		
		//Adding 12% patience to customers if inspector is served
		if(handler.getPlayer().inspectorOnTime!=0 && runOnce1==0) {
			for(Client client: handler.getWorld().clients) {
				client.setPatience(getPatience()*1.12);
			}
			runOnce1=1;
		}
			
    }
    public void render(Graphics g){

        if(!isLeaving){
            g.drawImage(Images.tint(sprite,1.0f,((float)getPatience()/(float)getOGpatience()),((float)getPatience()/(float)getOGpatience())),xPos,yPos,width,height,null);

            ((Burger) order.food).render(g);
        } else if (runOnce2==0){
        	handler.getPlayer().setAmountThatLeft(handler.getPlayer().getAmountThatLeft()+1);
        	runOnce2=1;
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
