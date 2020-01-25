import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Instructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instructions extends World
{

    /**
     * Constructor for objects of class Instructions.
     * 
     */
    public Instructions() //adds buttons to beginning screen
    {    
         super(620, 240, 1); 
         addObject(new Button1(), 110, 190);
         addObject(new Button2(), 310, 190);
         addObject(new Button3(), 510, 190);
         addObject(new Button4(), 510, 60);
    }
    
    public void act (){
        
    }
}
