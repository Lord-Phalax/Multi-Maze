import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int currentWorld;
    
    private final int NORTH = 270;
    private final int EAST = 0;
    private final int SOUTH = 90;
    private final int WEST = 180;
    
    public Player()
    {
        GreenfootImage Player = new GreenfootImage (40, 40);
        
        Player.setColor(Color.BLUE);
        Player.fillRect(0, 0, 40, 40);

        setImage(Player);
        setRotation(NORTH);
        
        currentWorld = 1;
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkWin();

        if( Greenfoot.isKeyDown("left") )
        {
            setRotation(180);
            
            if( wallInFace() == false )
            {
                move(1);
            }
        }
        else if( Greenfoot.isKeyDown("right") )
        {
            setRotation( 0 );
            
            if( wallInFace() == false )
            {
                move(1);
            }
        }
        else if( Greenfoot.isKeyDown("up") )
        {
            setRotation(270);
            
            if( wallInFace() == false )
            {
                move(1);
            }
        }
        else if( Greenfoot.isKeyDown("down") )
        {
            setRotation(90);
            
            if( wallInFace() == false )
            {
                move(1);
            }
        }
        
    }   
    
    
    
    private boolean wallInFace()
    {
        int xOffset = 0;
        int yOffset = 0;
        
        boolean wallFace = false;
        
        if( getRotation() == NORTH )
        {
            yOffset = -1;
        }
        else if( getRotation() == SOUTH )
        {
            yOffset = 1;
        }
        else if( getRotation() == EAST )
        {
            xOffset = 1;
        }
        else
        {
            xOffset = -1;
        }
        
        if( getOneObjectAtOffset( xOffset, yOffset, Rail.class ) == null )
        {
            wallFace = true;
        }
        
        return wallFace;
    }
     
    private void checkWin()
    {
        MazeWorld world = (MazeWorld)getWorld();
        if( getOneIntersectingObject(WinningSpace.class) != null )
        {
            if( currentWorld == 1)
            {
                world.clear();
                world.prepare2();
                currentWorld++;
            }
            else if( currentWorld == 2)
            {
                world.clear();
                world.prepare3();
                currentWorld++;
            }
            else if( currentWorld == 3)
            {
                getWorld().showText("You have WON!!",getWorld().getWidth() / 2, getWorld().getHeight() / 2 );
                Greenfoot.stop();
            }
            
        }
    }
}
