/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.image.BufferedImage;

/**
 *
 * @author Hp
 */
public class Assets {
    
    public static BufferedImage player;
    
    //effects
    public static BufferedImage spead;
    
    //Lasers
    public static BufferedImage blueLaser, greenLaser, redLaser;
    public static BufferedImage[] bigs = new BufferedImage[4];
    public static BufferedImage[] meds = new BufferedImage[2];
    public static BufferedImage[] smalls = new BufferedImage[2];
    public static BufferedImage[] tinies = new BufferedImage[2];
    
    
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
        
    }
    
}
