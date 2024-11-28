/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package states;

import GameObject.Constants;
import GameObject.Meteor;
import GameObject.Player;
import Graphics.Assets;
import Math.Vector2D;
import GameObject.MovingObject;
import GameObject.Size;
import static GameObject.Size.BIG;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class GameState {
    
    private Player player;
    private ArrayList<MovingObject> movingObjects = new ArrayList<>();
    
    private int meteors; 
    
    public GameState(){
        player = new Player(new Vector2D(Constants.WIDTH/2 - Assets.player.getWidth()/2,
                Constants.HEIGHT/2 - Assets.player.getHeight()/2), new Vector2D(), Constants.PLAYER_MAX_VEL, Assets.player, this);
        movingObjects.add(player);
        
        meteors = 1;
        
        startWave();
    }
    
    public void divideMeteor(Meteor meteor){
        Size size = meteor.getSize();
        
        BufferedImage[] texture = size.textures;
        
        Size newSize = null;
        
        switch (size) {
            case BIG:
                newSize = size.MED;
                break;
            case MED:
                newSize = size.SMALL;
                break;
            case SMALL:
                newSize = size.TINY;
                break;
            default:
                return; 
        }
        
        for(int i = 0; i < size.quantity; i++){
            movingObjects.add(new Meteor(
                    meteor.getPosition(),
                    new Vector2D(0, 1).setDirection(Math.random()*Math.PI*2),
                    Constants.METEOR_VEL*Math.random() + 1,
                    texture[(int)(Math.random()*texture.length)],
                    this,
                    newSize
                    ));
        }
    }
    
    private void startWave(){
        
        double x, y; 
        
        for(int i = 0; i < meteors; i++){
            
            x = i % 2 == 0 ? Math.random()*Constants.WIDTH : 0;
            y = i % 2 == 0 ? 0 : Math.random()*Constants.HEIGHT;
            
            BufferedImage texture = Assets.bigs[(int)(Math.random()*Assets.bigs.length)];
            
            movingObjects.add(new Meteor(
                    new Vector2D(x, y),
                    new Vector2D(0, 1).setDirection(Math.random()*Math.PI*2),
                    Constants.METEOR_VEL*Math.random() + 1,
                    texture,
                    this,
                    Size.BIG
                    ));
        }
        
        meteors ++; 
        
    }
    
    
    public void update(){
        for (int i = 0; i < movingObjects.size(); i++){
            movingObjects.get(i).update();
        }
        
        for (int i = 0; i < movingObjects.size(); i++)
            if(movingObjects.get(i) instanceof Meteor)
                return;
        startWave();
    }
    
    public void draw(Graphics g){
        for (int i = 0; i < movingObjects.size(); i++){
            movingObjects.get(i).draw(g);
        }
    }

    public ArrayList<MovingObject> getMovingObjects() {
        return movingObjects;
    }
    
}
