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

                new PlateCounter(0,584,handler),
                new CheeseCounter(BaseCounter.DEFAULTCOUNTERWIDTH,593,handler),
                new StoveCounter(BaseCounter.DEFAULTCOUNTERWIDTH*2,600,handler),
                new LettuceCounter(BaseCounter.DEFAULTCOUNTERWIDTH*3,600,handler),
                new ChumCounter(BaseCounter.DEFAULTCOUNTERWIDTH*4,600,handler),
                new TomatoCounter(BaseCounter.DEFAULTCOUNTERWIDTH*5, 590, handler),
                new BreadCounter(BaseCounter.DEFAULTCOUNTERWIDTH*6, 568, handler),
                new TopBreadCounter(BaseCounter.DEFAULTCOUNTERWIDTH*7, 568, handler),
                new BonusCounter(BaseCounter.DEFAULTCOUNTERWIDTH*8, 590, handler)};

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
