package Game.World;

import Game.Entities.Dynamic.Client;
import Game.Entities.Dynamic.Player;
import Game.Entities.Static.*;
import Main.Handler;
import Resources.Images;

import java.awt.*;

public class Restaurant_1 extends BaseWorld {
    private int count=0;
    private int capacity = 5;
    public Restaurant_1(BaseCounter[] Counters, Handler handler) {
        super(Images.floor,Counters, handler, new Player(null,0,650,handler));

    }

    public void tick(){
        count++;
        if(count == 100 && !isFull()){
            count = 0;
            for(Client client: this.clients){
                client.move();
            }
            this.generateClient();
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
