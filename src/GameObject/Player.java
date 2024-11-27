/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

import Graphics.Assets;
import Math.Vector2D;
import MovingOb.MovingObject;
import input.KeyBoard;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hp
 */
public class Player extends MovingObject{
    
    private Vector2D heading;
    private Vector2D acceleration;
    private final double ACC = 0.08;
    
    public Player(Vector2D position, Vector2D velocity, BufferedImage texture) {
        super(position, velocity, texture);
        heading = new Vector2D(0, 1);
        acceleration = new Vector2D();
    }
    
    @Override
    public void update() {
        if(KeyBoard.RIGHT)
            angle += Math.PI/20;
        if(KeyBoard.LEFT)
            angle -= Math.PI/20;
        
        if(KeyBoard.UP){
            acceleration = heading.scale(ACC);
        }
        
        velocity = velocity.add(acceleration);
        
        heading = heading.setDirection(angle - Math.PI/2);
        
        position = position.add(velocity);
    }

    @Override
    public void draw(Graphics g) {
       Graphics2D g2d = (Graphics2D)g;
       at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
       at.rotate(angle, Assets.player.getWidth()/2, Assets.player.getHeight()/2);
       g2d.drawImage(Assets.player, at, null);
    }
    
    
    
}
