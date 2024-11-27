/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package states;

import GameObject.Player;
import Graphics.Assets;
import Math.Vector2D;
import java.awt.Graphics;

/**
 *
 * @author Hp
 */
public class GameState {
    
    private Player player;
    
    public GameState(){
        player = new Player(new Vector2D(100,500), new Vector2D(), Assets.player);
    }
    
    public void update(){
        player.update();
    }
    
    public void draw(Graphics g){
        player.draw(g);
    }
}
