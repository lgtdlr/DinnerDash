package Resources;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by AlexVR on 7/1/2018.
 */
public class Images {


    public static BufferedImage[] butstart;
    public static BufferedImage title;
    public static BufferedImage floor;
    public static BufferedImage welcome;
    public static BufferedImage Pause;
    public static BufferedImage Win;
    public static BufferedImage PlanktonWin;
    public static BufferedImage Lose;
    public static BufferedImage Karen;
    public static BufferedImage overlayBox;
    public static BufferedImage[] Resume;
    public static BufferedImage[] Restart;
    public static BufferedImage[] Title;
    public static BufferedImage[] people;
    public static BufferedImage[] chef;
    public static BufferedImage[] plankton;
    public static BufferedImage[] kitchenChairTable;
    public static BufferedImage chair;
    public static BufferedImage table;
    public static BufferedImage[] kitchenCounter;
    public static BufferedImage[] ingredients;
    public static BufferedImage[] powerUps;
    public static BufferedImage chum;
    public static BufferedImage[] BTitle;
    public static BufferedImage[] Options;
    public static ImageIcon icon;
    public static SpriteSheet kitchenSpriteSheet;
    public static SpriteSheet kitchenCounterSpriteSheet;
    public static SpriteSheet kitchenCounterGlowSpriteSheet;
    public static SpriteSheet burgerSpriteSheet;
    public static SpriteSheet chefSpriteSheet;
    public static SpriteSheet planktonSpriteSheet;

    public Images() {

        butstart = new BufferedImage[3];
        Resume = new BufferedImage[2];
        Restart = new BufferedImage[2];
        Title = new BufferedImage[2];
        BTitle = new BufferedImage[2];
        Options = new BufferedImage[2];
        kitchenChairTable = new BufferedImage[3];
        people = new BufferedImage[11];
        kitchenCounter = new BufferedImage[11];
        ingredients = new BufferedImage[8];
        powerUps = new BufferedImage[2];
        chef = new BufferedImage[4];
        plankton = new BufferedImage[10];
        try {

            kitchenSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/sprite.png")));
            kitchenCounterSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/kitchen_cabinets_by_ayene_chan.png")));
            kitchenCounterGlowSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/kitchen_cabinets_by_ayene_chan_glow.png")));
            burgerSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/burger.png")));
            chum = ImageIO.read(getClass().getResourceAsStream("/Sheets/chum.png"));
            chefSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/chef.png")));
            planktonSpriteSheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/Sheets/plankton.png")));


            title = ImageIO.read(getClass().getResourceAsStream("/Sheets/title.jpg"));
            Pause = ImageIO.read(getClass().getResourceAsStream("/Sheets/Pause.png"));
            Win = ImageIO.read(getClass().getResourceAsStream("/Sheets/Win.png"));
            Lose = ImageIO.read(getClass().getResourceAsStream("/Sheets/Lose2.jpg"));
            Karen = ImageIO.read(getClass().getResourceAsStream("/Sheets/Karen.png"));
            PlanktonWin = ImageIO.read(getClass().getResourceAsStream("/Sheets/PlanktonWin.png"));
            overlayBox = ImageIO.read(getClass().getResourceAsStream("/Sheets/OverlayBox.png"));
            welcome = ImageIO.read(getClass().getResourceAsStream("/Sheets/Welcome.png"));
            floor = ImageIO.read(getClass().getResourceAsStream("/Sheets/floor.jpg"));
            butstart[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/NormBut.png"));
            butstart[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/HoverBut.png"));
            butstart[2]= ImageIO.read(getClass().getResourceAsStream("/Buttons/ClickedBut.png"));
            Resume[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/Resume.png"));
            Resume[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/ResumeP.png"));
            Restart[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/playAgain1.png"));
            Restart[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/playAgain1P.png"));
            Title[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/Title.png"));
            Title[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/TitleP.png"));
            BTitle[0]= ImageIO.read(getClass().getResourceAsStream("/Buttons/NormBut.png"));//hoverbut
            BTitle[1]= ImageIO.read(getClass().getResourceAsStream("/Buttons/HoverBut.png"));//clickbut
            
            kitchenChairTable[0] = kitchenSpriteSheet.crop(21,27,62,54);
            kitchenChairTable[1] = kitchenSpriteSheet.crop(108,14,30,35);
            kitchenChairTable[2] = kitchenSpriteSheet.crop(108,52,30,35);
            chair = ImageIO.read(getClass().getResourceAsStream("/Sheets/chair.png"));
            table = ImageIO.read(getClass().getResourceAsStream("/Sheets/table.png"));

            people[0] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Car_Designer3Female.png"));
            people[1] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Doctor2Female.png"));
            people[2] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Freedom_Fighter2Male.png"));
            people[3] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Hipster.png"));
            people[4] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Lawyer2Male.png"));
            people[5] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Mad_Scientist3Female.png"));
            people[6] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Programmer2Male.png"));
            people[7] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Songwriter3Male.png"));
            people[8] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Weather_Reporter2Female.png"));
            people[9] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Inspector.png"));//Added inspector image
            people[10] = ImageIO.read(getClass().getResourceAsStream("/Sheets/People/Anti-V.png"));//Added Anti-V image

            kitchenCounter[0] = kitchenCounterSpriteSheet.crop(224,12,32,43);//stoveTop
            kitchenCounter[1] = kitchenCounterSpriteSheet.crop(96,76,32,43);//Vegetables
            kitchenCounter[2] = kitchenCounterSpriteSheet.crop(193,70,32,49);//teaPot
            kitchenCounter[3] = kitchenCounterSpriteSheet.crop(0,245,30,43);//Empty
            kitchenCounter[4] = kitchenCounterSpriteSheet.crop(96,200,32,48);//fruit basket
            kitchenCounter[5] = kitchenCounterSpriteSheet.crop(64,73,32,46);//cheese
            kitchenCounter[6] = kitchenCounterSpriteSheet.crop(0,133,32,50);//plates
            kitchenCounter[7] = kitchenCounterSpriteSheet.crop(0,63,34,56);//buns
            kitchenCounter[8] = kitchenCounterSpriteSheet.crop(160, 12, 32, 43);//mortar
            kitchenCounter[9] = kitchenCounterGlowSpriteSheet.crop(96, 133, 32, 50);//balance glow
            kitchenCounter[10] = kitchenCounterSpriteSheet.crop(96, 133, 32, 50);//balance

            ingredients[0] = burgerSpriteSheet.crop(25, 16, 112, 43); // top bun
            ingredients[1] = burgerSpriteSheet.crop(30, 134, 103, 48); // patty
            ingredients[2] = burgerSpriteSheet.crop(169, 213, 102, 39); // cheese
            ingredients[3] = burgerSpriteSheet.crop(169, 158, 110, 41); // tomato
            ingredients[4] = burgerSpriteSheet.crop(161, 62, 117, 34); // lettuce
            ingredients[5] = burgerSpriteSheet.crop(444, 270, 115, 39); // bottom bun
            ingredients[6] = burgerSpriteSheet.crop(575, 263, 131, 51); // plate
            ingredients[7] = chum; //special ingredient

            //powerUps[0] = ImageIO.read(getClass().getResourceAsStream("/Sheets/PowerUps/SecretFormula.png"));
            //powerUps[1] = ImageIO.read(getClass().getResourceAsStream("/Sheets/PowerUps/hydroSpatula.png"));
            //powerUps[2] = ImageIO.read(getClass().getResourceAsStream("/Sheets/PowerUps/leSpatula.png"));
            //powerUps[3] = ImageIO.read(getClass().getResourceAsStream("/Sheets/PowerUps/goldenSpatula.png"));
            
            chef[0] = chefSpriteSheet.crop(30,3,66,120);
            chef[1] = chefSpriteSheet.crop(159,3,66,120);
            chef[2] = chefSpriteSheet.crop(287,3,67,120);
            chef[3] = chefSpriteSheet.crop(31,129,66,120);
            
            plankton[0] = planktonSpriteSheet.crop(0,136,67,134);
            plankton[1] = planktonSpriteSheet.crop(68,136,67,134);
            plankton[2] = planktonSpriteSheet.crop(132,136,67,134);
            plankton[3] = planktonSpriteSheet.crop(190,136,67,134);
            plankton[4] = planktonSpriteSheet.crop(259,136,67,134);
            plankton[5] = planktonSpriteSheet.crop(335,136,67,134);
            plankton[6] = planktonSpriteSheet.crop(404,136,67,134);
            plankton[7] = planktonSpriteSheet.crop(467,136,67,134);
            plankton[8] = planktonSpriteSheet.crop(525,136,67,134);
            plankton[9] = planktonSpriteSheet.crop(594,136,67,134);

            icon =  new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/Sheets/icon.png")));


        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage tint(BufferedImage src, float r, float g, float b) {

        // Copy image ( who made that so complicated :< )
        BufferedImage newImage = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TRANSLUCENT);
        Graphics2D graphics = newImage.createGraphics();
        graphics.drawImage(src, 0, 0, null);
        graphics.dispose();

        // Color image
        for (int i = 0; i < newImage.getWidth(); i++) {
            for (int j = 0; j < newImage.getHeight(); j++) {
                int ax = newImage.getColorModel().getAlpha(newImage.getRaster().getDataElements(i, j, null));
                int rx = newImage.getColorModel().getRed(newImage.getRaster().getDataElements(i, j, null));
                int gx = newImage.getColorModel().getGreen(newImage.getRaster().getDataElements(i, j, null));
                int bx = newImage.getColorModel().getBlue(newImage.getRaster().getDataElements(i, j, null));
                rx *= r;
                gx *= g;
                bx *= b;
                newImage.setRGB(i, j, (ax << 24) | (rx << 16) | (gx << 8) | (bx << 0));
            }
        }
        return newImage;
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
