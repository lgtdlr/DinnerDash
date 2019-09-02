package Game.GameStates;

import Game.Entities.Static.*;
import Game.World.Restaurant_1;
import Main.Handler;
import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class GameState extends State {

    public GameState(Handler handler){
        super(handler);
        BaseCounter Counterss[] = {new TeaCounter(596,587,null,handler),
                new StoveCounter(692,600,null,handler),
                new IngridientCounter(788,600,null,handler),
                new EmptyCounter(884,600,null,handler)} ;
        Restaurant_1 World_1 = new Restaurant_1(Counterss,handler);

    }


    @Override
    public void tick() {
        handler.getWorld().tick();

    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);

    }

}
