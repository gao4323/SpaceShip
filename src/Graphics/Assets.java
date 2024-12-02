/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;

/**
 *
 * @author Hp
 */
public class Assets {
    
    public static BufferedImage player;
    
    //effects
    public static BufferedImage spead;
    public static BufferedImage[] expl = new BufferedImage[9];
    
    //Lasers
    public static BufferedImage blueLaser, greenLaser, redLaser;
    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] meds = new BufferedImage[2];
    public static BufferedImage[] smalls = new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];
    
    //ufo
    
    public static BufferedImage ufo;
    
    //Numbers
    
    public static BufferedImage[] numbers = new BufferedImage[11];
    public static BufferedImage life;
    
    //fonts
    
    public static Font fontBig;
    public static Font fontMed;
    
    public static Clip backgroundMusic, explosion, playerLoose, playerShoot, ufoShoot;
    
    public static void init(){
        player = Loader.ImageLoader("/Ships/player.png");
        
        spead = Loader.ImageLoader("/effects/fire08.png");
        
        blueLaser = Loader.ImageLoader("/Lasers/laserBlue01.png");
        
        greenLaser = Loader.ImageLoader("/Lasers/laserGreen11.png");
        
        redLaser = Loader.ImageLoader("/Lasers/laserRed01.png");
        
        for(int i = 0; i < bigs.length; i++)
            bigs[i] = Loader.ImageLoader("/meteors/meteorGrey_big"+(i+1)+".png");
        
	for(int i = 0; i < meds.length; i++)
            meds[i] = Loader.ImageLoader("/meteors/meteorGrey_med"+(i+1)+".png");
        
	for(int i = 0; i < smalls.length; i++)
            smalls[i] = Loader.ImageLoader("/meteors/meteorGrey_small"+(i+1)+".png");
        
        for(int i = 0; i < tinies.length; i++)
            tinies[i] = Loader.ImageLoader("/meteors/meteorGrey_tiny"+(i+1)+".png");
        
        for(int i = 0; i < expl.length; i++)
            expl[i] = Loader.ImageLoader("/explosion/"+ i +".png");
        
        ufo = Loader.ImageLoader("/Ships/ufo.png");
        
        for(int i = 0; i < numbers.length; i++)
            numbers[i] = Loader.ImageLoader("/Numbers/"+"numeral"+ i +".png");
        
        life = Loader.ImageLoader("/Others/playerLife1_blue.png");
        
        fontBig = Loader.loadFont("/fonts/kenvector_future.ttf/", 42);
        
        fontMed = Loader.loadFont("/fonts/kenvector_future.ttf/", 20);
        
        backgroundMusic = Loader.loadSound("/sounds/backgroundMusic.wav");
        explosion = Loader.loadSound("/sounds/explosion.wav");
	playerLoose = Loader.loadSound("/sounds/playerLoose.wav");
	playerShoot = Loader.loadSound("/sounds/playerShoot.wav");
	ufoShoot = Loader.loadSound("/sounds/ufoShoot.wav");
                
    }
    
}
