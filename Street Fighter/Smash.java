import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Smash here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smash extends World
{           
    private RyuHealth ryuhealth = new RyuHealth();
    private GuileHealth guilehealth = new GuileHealth();
    /**
     * Constructor for objects of class Smash.
     * 
     */
    public Smash()
    {    
        super(620, 240, 1); 

        addObject(new Ryu(), 90, 165);
        addObject(new Guile(), 520, 165);
        addObject(new healthbar(), 310, 33);
        addObject(guilehealth, 434, 28);
        addObject(ryuhealth, 185, 28);
        addObject(new timer2(), 310, 30);
        addObject(new volume(), 130,80);
    }

    public RyuHealth getRyuHealth(){
        return ryuhealth;
    }

    public GuileHealth getGuileHealth(){
        return guilehealth;
    }
}
