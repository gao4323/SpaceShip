/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GameObject;

import Graphics.Assets;
import Graphics.Sound;
import Math.Vector2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import states.GameState;

/**
 *
 * @author Hp
 */
public class Ufo extends MovingObject{

    private ArrayList<Vector2D> path;
    
    private Vector2D currentNode;
    
    private int index;
            
    private boolean following;
    
    private Chronometer fireRate;
    
    private Sound shoot;
    
    public Ufo(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, ArrayList<Vector2D> path , GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
        this.path = path;
        index = 0;
        following = true;
        fireRate = new Chronometer();
        fireRate.run(Constants.UFO_FIRE_RATE);
        shoot = new Sound(Assets.ufoShoot);
    }
    
    private Vector2D pathFollowing(){
        currentNode = path.get(index);
        
        double distanceToNode = currentNode.subtract(getCenter()).getMagnitude();
        
        if(distanceToNode < Constants.NODE_RADIUS){
            index ++;
            if(index >= path.size()){
                following =  false;
            }
        }
        
        return seekForce(currentNode);
        
    }
            
    private Vector2D seekForce(Vector2D target){
        
        Vector2D desiredVelocity = target.subtract(getCenter());
        desiredVelocity = desiredVelocity.normalize().scale(maxVel);
        return desiredVelocity.subtract(velocity);
    }
    
    @Override
    public void update() {
        Vector2D pathFollowing;
        if(following)
            pathFollowing = pathFollowing();
        else
            pathFollowing = new Vector2D();
        
        pathFollowing = pathFollowing().scale(1/Constants.UFO_MASS);
        
        velocity = velocity.add(pathFollowing);
        
        velocity = velocity.limit(maxVel);
        
        position = position.add(velocity);
        
        if(position.getX()  < -width || position.getX() > Constants.WIDTH || position.getY() < -height || position.getY() > Constants.HEIGHT)
            Destroy();
        //Shot
        if(!fireRate.isRunning()){
            
            Vector2D toPLayer = gameState.getPlayer().getCenter().subtract(getCenter());
            
            toPLayer = toPLayer.normalize();
            
            double currentAngle = toPLayer.getAngle();
            
            currentAngle += Math.random() + Constants.UFO_ANGLE_RANGE - Constants.UFO_ANGLE_RANGE / 2;
            
            if(toPLayer.getX() < 0)
                currentAngle = -currentAngle + Math.PI;
            
            toPLayer = toPLayer.setDirection(currentAngle);
            
            Laser laser = new Laser(
                    getCenter().add(toPLayer.scale(width)),
                    toPLayer,
                    Constants.LASER_VEL,
                    currentAngle + Math.PI/2,
                    Assets.redLaser,
                    gameState);
            
            gameState.getMovingObjects().add(0, laser);
            
            fireRate.run(Constants.UFO_FIRE_RATE);
            
            shoot.play();
        }
        
        if(shoot.getFramesPosition() > 8500){
            shoot.stop();
        }
        
       angle += 0.05;
       
       collidesWhidt();
       fireRate.update();
    }

    @Override
    public void Destroy(){
        gameState.addScore(Constants.UFO_SCORE, position);
        super.Destroy(); 
    }
    
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
		
	at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
		
	at.rotate(angle, width/2, height/2);
		
	g2d.drawImage(texture, at, null);
    }
    
    
}
