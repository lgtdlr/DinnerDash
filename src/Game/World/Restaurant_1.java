package Game.World;

import Game.Entities.Dynamic.Client;
import Game.Entities.Dynamic.Player;
import Game.Entities.Static.*;
import Main.Handler;
import Resources.Images;

import java.awt.*;
import java.util.ArrayList;

public class Restaurant_1 extends BaseWorld {
    private int count=0;
    private int capacity = 5;
    public Restaurant_1(BaseCounter[] Counters, Handler handler) {
        super(Images.floor,Counters, handler, new Player(null,0,650,handler));

    }

    public void tick(){
        count++;
        if(count >= 5*60 && !isFull()){
            count = 0;
            for(Client client: this.clients){
                    client.move();
                }
            this.generateClient();
        }else if(count >= 5*60 && isFull()){
            count=0;
            boolean left=false;
            Client toLeave = null;
            ArrayList<Client> toMove = new ArrayList<>();
            for (Client client : this.clients) {
                if (client.isLeaving && !left) {
                    toLeave = client;
                    left=true;
                }else if (left) {
                    toMove.add(client);
                }
            }
            if(left){
                this.clients.remove(toLeave);
                for (Client client : toMove) {
                    client.move();
                }
                this.generateClient();
            }
        }


        for(Client client: this.clients){
            client.tick();
        }
        for(BaseCounter counter: Counters){
            counter.tick();
        }
        handler.getPlayer().tick();
    }

    public boolean isFull(){
        return this.clients.size() >=capacity;
    }
    public void render(Graphics g){
        g.drawImage(Background,0,0,handler.getWidth(), handler.getHeight(),null);
        g.drawImage(Images.welcome,5,90,43,82,null);
        g.drawImage(Images.table,handler.getWidth()-168,90,96,96,null);
        g.drawImage(Images.chair,handler.getWidth()-216,140,52,52,null);

        g.drawImage(Images.table,handler.getWidth()/3,90+100,96,96,null);
        g.drawImage(Images.chair,handler.getWidth()/3+96,140+100,52,52,null);
        g.drawImage(Images.chair,handler.getWidth()/3-52,140+100,52,52,null);
        

        g.drawImage(Images.table,handler.getWidth()/3+handler.getWidth()/6,190+100,96,96,null);
        g.drawImage(Images.chair,handler.getWidth()/3+handler.getWidth()/6+96,240+100,52,52,null);
        g.drawImage(Images.chair,handler.getWidth()/3+handler.getWidth()/6-52,240+100,52,52,null);

        g.drawImage(Images.table,handler.getWidth()/3+handler.getWidth()/3,90+100,96,96,null);
        g.drawImage(Images.chair,handler.getWidth()/3+handler.getWidth()/3+96,140+100,52,52,null);
        g.drawImage(Images.chair,handler.getWidth()/3+handler.getWidth()/3-52,140+100,52,52,null);

        g.drawImage(Images.table,handler.getWidth()/3+handler.getWidth()/3,292+100,96,96,null);
        g.drawImage(Images.chair,handler.getWidth()/3+handler.getWidth()/3+96,312+100,52,52,null);
        g.drawImage(Images.chair,handler.getWidth()/3+handler.getWidth()/3-52,312+100,52,52,null);

        g.drawImage(Images.table,handler.getWidth()/3,292+100,96,96,null);
        g.drawImage(Images.chair,handler.getWidth()/3+96,312+100,52,52,null);
        g.drawImage(Images.chair,handler.getWidth()/3-52,312+100,52,52,null);

        for(Client client: clients){
            client.render(g);
        }

        for(BaseCounter counter: Counters){
            counter.render(g);
        }
        handler.getPlayer().render(g);
    }
}
