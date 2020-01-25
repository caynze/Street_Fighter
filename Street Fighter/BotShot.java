import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BotShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BotShot extends Bots
{
    private GifImage KShot = new GifImage("RyuShot.gif");
    public BotShot(){
        getImage().mirrorHorizontally();
    }
    public void act() 
    {
        setImage(KShot.getCurrentImage());
        move(-10);
        if(isAtEdge() == true){
            getWorld().removeObject(this); 
        }
    }    
}
