package Game.World;

import Game.Entities.Dynamic.Player;
import Game.Entities.Static.*;
import Main.Handler;
import Resources.Images;

import java.awt.*;

public class Restaurant_1 extends BaseWorld {


    public Restaurant_1(BaseCounter[] Counters, Handler handler) {
        super(Images.floor,Counters, handler, new Player(null,0,0,handler));

    }

    public void tick(){
        handler.getPlayer().tick();
    }

    public void render(Graphics g){
        g.drawImage(Background,0,0,handler.getWidth(), handler.getHeight(),null);
        for(BaseCounter counter: Counters){
            g.drawImage(counter.sprite,counter.xPos,counter.yPos,counter.width,counter.height,null);
        }
        handler.getPlayer().render(g);
    }
}
