/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package GameObject;

import Graphics.Assets;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hp
 */
public enum Size {
    
    BIG(2, Assets.meds), MED(2, Assets.smalls), SMALL(2, Assets.tinies), TINY(0, null);
    
    public int quantity;
    
    public BufferedImage[] textures;

    private Size(int quantity, BufferedImage[] textures) {
        this.quantity = quantity;
        this.textures = textures;
    }
    
    
}
