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
public enum PowerUpTypes {
    
    SHIELD("SHIELD", Assets.shield),
	LIFE("+1 LIFE", Assets.life),
	SCORE_X2("SCORE x2", Assets.doubleScore),
	FASTER_FIRE("FAST FIRE", Assets.fastFire),
	SCORE_STACK("+1000 SCORE", Assets.star),
	DOUBLE_GUN("DOUBLE GUN", Assets.doubleGun);
	
	public String text;
	public BufferedImage texture;
	
	private PowerUpTypes(String text, BufferedImage texture){
		this.text = text;
		this.texture = texture;
	}
    
}
