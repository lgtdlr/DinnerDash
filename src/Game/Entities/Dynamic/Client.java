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
    private int patienceCounter=0;//Used for counting every 8% patience loss for Anti-V
    Order order;
    public boolean isLeaving = false;
    private int runOnce;//To make condition run once in tick()
    public int inspectorNotOnTime=0;//Indicates how many inspectors did not get food on time
    private int posModifier;//Used for Anti-V affecting nearby clients
    private int runSlow=0;//Used in tick() so the command runs once every second and avoids bugs
    
    public Client(int xPos, int yPos, Handler handler) {
        super(Images.people[new Random().nextInt(11)], xPos, yPos,64,72, handler);
        runOnce = 0;
        setPatience(new Random().nextInt(120*60)+60*60);
        setOGpatience(getPatience());
        
        //Subtracting 6% patience to all future customers for each inspector not served
        if(inspectorNotOnTime!=0) {
        	setPatience(getOGpatience()-getOGpatience()*(0.06*inspectorNotOnTime));
        	setOGpatience(getPatience());
        }
        
        //Adding 10% patience to all future customers for each inspector served
        if(handler.getPlayer().inspectorOnTime!=0) {
        	setPatience(getOGpatience()+getOGpatience()*(0.10*handler.getPlayer().inspectorOnTime));
        	setOGpatience(getPatience());
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
    	runSlow++;
        setPatience(getPatience() - 1);
        if(getPatience()<=0){
            isLeaving=true;
        }
        //Checks if inspector is served on time and if not, half the money
		if(sprite.equals(Images.people[9])) {
			if(isLeaving && runSlow >=1*60) {
				handler.getPlayer().money-=handler.getPlayer().money/2;
				inspectorNotOnTime++;
				runSlow=0;
			}
		}
		
		
		//As Anti-V's patience goes down every 8% they will lower another client that is in front or being(randomly) patience by 4%
        if(sprite.equals(Images.people[10])) {
        	if(getPatience()<=getOGpatience()-getOGpatience()*(0.08+0.08*patienceCounter)) {
        		patienceCounter++;
        		//Randomly front or behind Anti-V
        		if(new Random().nextBoolean())
        			posModifier=1;
        		else posModifier=-1;
        		//To avoid out of bounds exception
        		if(handler.getWorld().clients.indexOf(this)+posModifier>= handler.getWorld().clients.size())
        			posModifier=-1;
        		else if (handler.getWorld().clients.indexOf(this)+posModifier<0)
        			posModifier=1;
        		
        		//Actual lowering of 4% patience of randomly selected client
        		handler.getWorld().clients.get(handler.getWorld().clients.indexOf(this) + posModifier).setPatience(getPatience()-getPatience()*0.04);
        	}	
        }
			
    }
    public void render(Graphics g){

        if(!isLeaving){
            g.drawImage(Images.tint(sprite,1.0f,((float)getPatience()/(float)getOGpatience()),((float)getPatience()/(float)getOGpatience())),xPos,yPos,width,height,null);

            ((Burger) order.food).render(g);
        } else if (runOnce==0){
        	handler.getPlayer().setAmountThatLeft(handler.getPlayer().getAmountThatLeft()+1);
        	runOnce=1;
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
