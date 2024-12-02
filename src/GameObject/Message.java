/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

import Graphics.Text;
import Math.Vector2D;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import states.GameState;

/**
 *
 * @author Hp
 */
public class Message {
    private GameState gameState;
    private float alfha;
    private String text;
    private Vector2D position;
    private Color color;
    private boolean center;
    private boolean fade;
    private Font font;
    private final float deltaAlpha = 0.01f;

    public Message(Vector2D position, boolean fade, String text, Color color, boolean center, Font font, GameState gameState) {
        this.gameState = gameState;
        this.alfha = alfha;
        this.text = text;
        this.position = position;
        this.color = color;
        this.center = center;
        this.fade = fade;
        this.font = font;
        
        if(fade)
            alfha = 1;
        else
            alfha = 0;
    }
    
    public void draw(Graphics2D g2d){
        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alfha));
        
        Text.drawText(g2d, text, position, center, color, font);
        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        
        position.setY(position.getY() - 1);
        
        if(fade)
            alfha -= deltaAlpha;
        else
            alfha += deltaAlpha;
        
        if(fade && alfha < 0 || !fade && alfha > 1){
            gameState.getMessage().remove(this);
        }
    }
}
