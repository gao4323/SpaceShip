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
    public static void init(){
        player = Loader.ImageLoader("/Ships/player5.png");
    }
    
}