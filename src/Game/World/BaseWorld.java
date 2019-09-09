package Game.World;

import Game.Entities.Dynamic.Client;
import Game.Entities.Dynamic.Player;
import Game.Entities.Static.BaseCounter;
import Main.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BaseWorld {

    public BufferedImage Background;

    public BaseCounter Counters[];

    public Handler handler;

    public ArrayList<Client> clients = new ArrayList<>();

    public BaseWorld(BufferedImage Background, BaseCounter Counters[], Handler handler, Player player){
        this.Background = Background;
        this.Counters = Counters;
        this.handler=handler;
        handler.setWorld(this);
        handler.setPlayer(player);
    }

    public Client generateClient(){
        Client client =  new Client(0,96,handler);
        this.clients.add(client);
        return client;
    }

    public void tick(){

    }

    public void render(Graphics g){

    }
}
