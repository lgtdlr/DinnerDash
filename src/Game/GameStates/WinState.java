package Game.GameStates;

import Main.Handler;
import Resources.Images;
import Display.UI.UIImageButton;
import Display.UI.UIManager;

import java.awt.*;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class WinState extends State {

    private int count = 0;
    private UIManager uiManager;

    public WinState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUimanager(uiManager);

        uiManager.addObjects(new UIImageButton(175, 700, 128, 64, Images.Restart, () -> {
        	handler.getMouseManager().setUimanager(null);
        	handler.getPlayer().setAmountThatLeft(0);
            handler.getGame().reStart();
            handler.getGame().getMusicHandler().playGame();
            State.setState(handler.getGame().gameState);
        }));

        uiManager.addObjects(new UIImageButton(550, 712, 128, 32, Images.Title, () -> {
            handler.getMouseManager().setUimanager(null);
            handler.getPlayer().setAmountThatLeft(0);
            handler.getGame().getMusicHandler().playMenu();
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
        g.drawImage(Images.Win,0,0,870,820,null);
        g.drawImage(Images.Karen,handler.getWidth()/2-100,-60,480,480,null);
        Color KAREN = new Color(165, 216, 63);
        g.setColor(KAREN);
		g.setFont(new Font("ComicSans", Font.BOLD, 32));
		g.drawString("YOU WIN!", handler.getWidth()/2+60, 110);
		g.drawString("Clients served: " + handler.getPlayer().getAmountServed(), handler.getWidth()/2, 150);
		g.drawString("Clients that left: " + handler.getPlayer().getAmountThatLeft(), handler.getWidth()/2, 190);
        g.drawImage(Images.PlanktonWin,0,0,870,820,null);
        g.drawImage(Images.overlayBox,0,620,870,200,null);
        uiManager.Render(g);

    }
}
