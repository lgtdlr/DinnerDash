package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class Images {


    public static BufferedImage[] butstart;
    public static BufferedImage title;
    public static BufferedImage floor;
    public static BufferedImage Pause;
    public static BufferedImage[] Resume;
    public static BufferedImage[] kitchenChairTable;
    public static BufferedImage[] kitchenCounter;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] Options;
    public static ImageIcon icon;
    public static SpriteSheet kitchenSpriteSheet;
    public static SpriteSheet kitchenCounterSpriteSheet;

    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        BTitle = new BufferedImage[2];
        Options = new BufferedImage[2];
        kitchenChairTable = new BufferedImage[3];
        kitchenCounter = new BufferedImage[4];

        try {

            kitchenSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/sprite.png")));
            kitchenCounterSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/kitchen_cabinets_by_ayene_chan.png")));


            title = ImageIO.read(getClass().getResourceAsStream("/Sheets/title.jpg"));
            Pause = ImageIO.read(getClass().getResourceAsStream("/Sheets/Pause.png"));
            floor = ImageIO.read(getClass().getResourceAsStream("/Sheets/floor.jpg"));
            butstart[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/NormBut.png"));//normbut
            butstart[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/HoverBut.png"));//hoverbut
            butstart[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/ClickedBut.png"));//clickbut

            kitchenChairTable[0] = kitchenSpriteSheet.crop(21,27,62,54);
            kitchenChairTable[1] = kitchenSpriteSheet.crop(108,14,30,35);
            kitchenChairTable[2] = kitchenSpriteSheet.crop(108,52,30,35);

            kitchenCounter[0] = kitchenCounterSpriteSheet.crop(224,12,32,43);//stoveTop
            kitchenCounter[1] = kitchenCounterSpriteSheet.crop(96,76,32,43);//Vegetablea
            kitchenCounter[2] = kitchenCounterSpriteSheet.crop(193,70,32,49);//teaPot
            kitchenCounter[3] = kitchenCounterSpriteSheet.crop(0,245,32,43);//Empty

            icon =  new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Sheets/icon.png")));


        }catch (IOException e) {
        e.printStackTrace();
    }


    }

    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(Images.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
