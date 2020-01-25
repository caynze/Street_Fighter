import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VersusButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button1 extends Actor
{
    /**
     * If this is clicked, set the world to the 2 player vs mode
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MyWorld()); 
        }
    }
}    

