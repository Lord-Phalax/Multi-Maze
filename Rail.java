import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Rail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rail extends Actor
{
    private final int NORTH = 270;
    private final int EAST = 0;
    private final int SOUTH = 90;
    private final int WEST = 180;
    
    public Rail()
    {
        GreenfootImage wall = new GreenfootImage(40, 40);
        wall.setColor(Color.BLACK);
        wall.fillRect(0, 0, 40, 40);
        
        setImage(wall);
    }
    
    /**
     * Act - do whatever the Rail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
}
