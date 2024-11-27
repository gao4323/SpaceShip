/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MovingOb;

import GameObject.GameObject;
import Math.Vector2D;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author Hp
 */
public abstract class MovingObject extends GameObject{
    protected Vector2D velocity;
    protected AffineTransform at;
    protected double angle;
    
    public MovingObject(Vector2D position, Vector2D velocity, BufferedImage texture) {
        super(position, texture);
        this.velocity = velocity;
        angle = 0;
    }
    
}
