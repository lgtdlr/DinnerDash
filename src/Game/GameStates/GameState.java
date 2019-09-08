package Game.GameStates;

import Game.Entities.Static.*;
import Game.World.Restaurant_1;
import Main.Handler;
import Resources.Images;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class GameState extends State {

    public GameState(Handler handler){
        super(handler);
        BaseCounter Counters[] = {
                new PlateCounter(500,584,handler),
                new CheeseCounter(596,593,handler),
                new StoveCounter(692,600,handler),
                new LettuceCounter(788,600,handler),
                new EmptyCounter(884,600,handler),
                new TomatoCounter(980, 590, handler),
                new BreadCounter(1076, 568, handler),
                new TopBreadCounter(1172, 568, handler)};
        Restaurant_1 World_1 = new Restaurant_1(Counters,handler);

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
