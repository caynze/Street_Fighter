import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bots here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Bots extends Actor
{
    private GifImage KShot = new GifImage("KBlast.gif");
    private GifImage KWalk = new GifImage("KWalk1.gif");
    private int num;
    public void act() 
    {
        setImage(KWalk.getCurrentImage()); //set walk animation
        move(-1); // slowly move to Ryu
        shoot(); //shoot a bullet
        if(isTouching(RyuShot.class)){ //remove the shot if it touches, increase the chance of Ken spawns
            increaseScore();
            removeTouching(RyuShot.class);
            ((BotMode)getWorld()).increaseChance();
            getWorld().removeObject(this);  //remove the Ken that was shot
            
        }
   
    }    
        public void increaseScore() // Call upon the increase score class
    {
        ((BotMode)getWorld()).getScore().increaseScore();
    }

    public void shoot(){
        num = (int)(Math.random()*100); //RNG for the shot, 1/100 chance of shooting a bullet
        if(num == 1){
            setImage(KShot.getCurrentImage());
            getWorld().addObject(new BotShot(), getX()-10, getY());
        }
    }
}

