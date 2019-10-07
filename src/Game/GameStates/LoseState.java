package Game.GameStates;

import Main.Handler;
import Resources.Images;
import Display.UI.UIImageButton;
import Display.UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class LoseState extends State {

    private int count = 0;
    private UIManager uiManager;

    public LoseState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        uiManager.addObjects(new UIImageButton(175, 700, 128, 64, Images.Restart, () -> {
        	handler.getMouseManager().setUimanager(null);
        	handler.getPlayer().setAmountThatLeft(0);
            handler.getGame().reStart();
            State.setState(handler.getGame().gameState);
        }));

        uiManager.addObjects(new UIImageButton(550, 712, 128, 32, Images.Title, () -> {
            handler.getMouseManager().setUimanager(null);
            handler.getPlayer().setAmountThatLeft(0);
            State.setState(handler.getGame().menuState);
        }));


    }

    @Override
    public void tick() {
        handler.getMouseManager().setUimanager(uiManager);
        uiManager.tick();
        count++;
        if( count>=30){
            count=30;
        }
        if(handler.getKeyManager().pbutt && count>=30){
            count=0;

            State.setState(handler.getGame().gameState);
        }


    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Images.Lose,-100,0,970,820,null);
        g.drawImage(Images.Karen,handler.getWidth()/2-20,-60,480,480,null);
        Color KAREN = new Color(165, 216, 63);
        g.setColor(KAREN);
		g.setFont(new Font("ComicSans", Font.BOLD, 32));
		g.drawString("YOU LOSE.", handler.getWidth()/2+140, 110);
		g.drawString("Clients served: " + handler.getPlayer().getAmountServed(), handler.getWidth()/2+80, 150);
		g.drawString("Clients that left: " + handler.getPlayer().getAmountThatLeft(), handler.getWidth()/2+80, 190);
		g.drawString("Money earned: " + handler.getPlayer().getMoney(), handler.getWidth()/2+80, 230);
		g.drawImage(Images.overlayBox,0,620,870,200,null);
        uiManager.Render(g);

    }
}
