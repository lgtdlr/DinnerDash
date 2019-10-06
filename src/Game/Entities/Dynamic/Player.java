package Game.Entities.Dynamic;

import Game.Entities.Static.*;
import Game.World.BaseWorld;
import Main.Handler;
import Resources.Animation;
import Resources.Images;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import org.w3c.dom.css.Counter;

public class Player extends BaseDynamicEntity {
	Item item;
	float money;
	int speed = 7;
	int BaseSpeed=speed;//Used to get base move speed back
	boolean matched = false;
	private Burger burger;
	private String direction = "right";
	private int interactionCounter = 0;
	private int selectClient = 0;//Indicates selected client; value must be 0-4
	public int inspectorOnTime=0;//How many times inspector was served on time
	private Animation playerAnim;
	
	
	public Player(BufferedImage sprite, int xPos, int yPos, Handler handler) {
		super(sprite, xPos, yPos,82,112, handler);
		createBurger();
		playerAnim = new Animation(120,Images.chef);
	}

	public void createBurger(){
		burger = new Burger(handler.getWidth() - 110, 100, 100, 50);

	}

	public void tick(){
		playerAnim.tick();
		if(xPos + width >= handler.getWidth()){
			direction = "left";

		} else if(xPos <= 0){
			direction = "right";
		}
		if (direction.equals("right")){
			xPos+=speed;
		} else{
			xPos-=speed;
		}
		if (interactionCounter > 15 && handler.getKeyManager().attbut){
			interact();
			interactionCounter = 0;
		} else {
			interactionCounter++;
		}

		//Pressing shift to make the player move slower
		if (handler.getKeyManager().shiftButt) {
			speed=2;
		} else {
			speed=BaseSpeed;
		}

		if(handler.getKeyManager().fattbut){
			for(BaseCounter counter: handler.getWorld().Counters){
				if (counter instanceof PlateCounter && counter.isInteractable()){
					createBurger();
				}
			}
		}

		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_1)&&handler.getWorld().clients.size()>0) {
			selectClient = 0;
			matched = ((Burger)handler.getWorld().clients.get(selectClient).order.food).equals(handler.getCurrentBurger());
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_2)&&handler.getWorld().clients.size()>1) {
			selectClient = 1;
			matched = ((Burger)handler.getWorld().clients.get(selectClient).order.food).equals(handler.getCurrentBurger());
			}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_3)&&handler.getWorld().clients.size()>2) {
			selectClient = 2;
			matched = ((Burger)handler.getWorld().clients.get(selectClient).order.food).equals(handler.getCurrentBurger());
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_4)&&handler.getWorld().clients.size()>3) {
			selectClient = 3;
			matched = ((Burger)handler.getWorld().clients.get(selectClient).order.food).equals(handler.getCurrentBurger());
		}
		if (handler.getKeyManager().keyJustPressed(KeyEvent.VK_5)&&handler.getWorld().clients.size()>4) {
			selectClient = 4;
			matched = ((Burger)handler.getWorld().clients.get(selectClient).order.food).equals(handler.getCurrentBurger());
		}
			
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_R)){
			for(BaseCounter counter: handler.getWorld().Counters) {
				if (counter instanceof PlateCounter && counter.isInteractable()) {
					ringCustomer();
				}
			}
		}


	}

	private void ringCustomer() {
		matched = ((Burger)handler.getWorld().clients.get(selectClient).order.food).equals(handler.getCurrentBurger());
		if(matched){
			//Tip of 15% if client is served before patience reaches half
			if (handler.getWorld().clients.get(selectClient).getOGpatience()/2 > handler.getWorld().clients.get(selectClient).getPatience())
				money+=handler.getWorld().clients.get(selectClient).order.value*(1+0.15);
			else money+=handler.getWorld().clients.get(selectClient).order.value;
			//Increase every client's patience when order is given exactly right
			for (Client clients: handler.getWorld().clients) {
				clients.setPatience(clients.getPatience() + clients.getOGpatience()/4);
			
				//Counting how many times the inspector was served on time
				for(Client client: handler.getWorld().clients) {
					if(client.sprite.equals(Images.people[9]))
						inspectorOnTime++;
				}
			}
			
			//Moves all clients after the served client backwards
			if (selectClient>0) {
				for (int i = selectClient; i >= 0; i--) {
				handler.getWorld().clients.get(i).moveBackwards();
				}
			}
			
			handler.getWorld().clients.remove(selectClient);
			handler.getPlayer().createBurger();
			matched = false;
			System.out.println("Total money earned is: " + String.valueOf(money));
			selectClient = 0;
			return;
		}
	}

	public void render(Graphics g) {
		if(direction=="right") {
			g.drawImage(playerAnim.getCurrentFrame(), xPos, yPos, width, height, null);
		}else{
			g.drawImage(playerAnim.getCurrentFrame(), xPos+width, yPos, -width, height, null);

		}
		g.setColor(Color.green);
		burger.render(g);
		g.setColor(Color.green);
		g.fillRect(handler.getWidth()/2 -210, 3, 320, 32);;
		g.setColor(Color.yellow);
		g.setFont(new Font("ComicSans", Font.BOLD, 32));
		g.drawString("Money Earned: " + money, handler.getWidth()/2 -200, 30);
		
		//Visual indication of which client is selected
		switch (selectClient) {
		case 4:
			g.drawRect(1, 96, 64-4, 64+8);
			break;
		case 3:
			g.drawRect(1, 96*(handler.getWorld().clients.size()-3)+4, 60, 72);
			break;
		case 2:
			g.drawRect(1, 96*(handler.getWorld().clients.size()-2)+8, 60, 72);
			break;
		case 1:
			g.drawRect(1, 96*(handler.getWorld().clients.size()-1)+12, 60, 72);
			break;
		case 0:
			g.drawRect(1, 96*(handler.getWorld().clients.size())+16, 60, 72);
			break;
		default:
			break;
		}
	}

	public void interact(){
		for(BaseCounter counter: handler.getWorld().Counters){
			if (counter.isInteractable()){
				counter.interact();
			}
		}
	}
	public Burger getBurger(){
		return this.burger;
	}
}
