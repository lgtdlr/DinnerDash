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
            boolean removed = false;
            int steps=0;
            ArrayList<Client> toDelete = new ArrayList<>();
            for(Client client: this.clients){
                if(client.isLeaving){
                    toDelete.add(client);
                    removed=true;
                    steps++;
                }else {
                    client.move();
                    if(removed){
                        for(int i = 0;i<steps;i++) {
                            client.move();
                        }
                    }
                }
            }
            for(Client client: toDelete){
                this.clients.remove(client);
            }
            this.generateClient();
        }else if(count == 5*60 && isFull()){
            count=0;
            ArrayList<Client> toMove = new ArrayList<>();
            for (Client client : this.clients) {
                if (client.isLeaving) {
                    this.clients.remove(client);
                    for(Client clients : toMove) {
                        clients.move();
                    }
                    this.generateClient();
                    break;
                }else{
                    toMove.add(client);
                }
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
        for(BaseCounter counter: Counters){
            counter.render(g);
        }
        for(Client client: clients){
            client.render(g);
        }
        handler.getPlayer().render(g);
    }
}
