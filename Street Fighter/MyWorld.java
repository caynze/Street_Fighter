import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 99 Bugs of code on the wall
 * 99 Bugs of code
 * Take 1 down, pass it around
 * 147 bugs of code on the wall
 */
public class MyWorld extends World
{
    private RyuHealth ryuhealth = new RyuHealth();
    private GuileHealth guilehealth = new GuileHealth();

    public MyWorld()
    {    
        super(620, 240, 1); 
        // GreenfootSound backgroundMusic = new GreenfootSound("theme.mp3");
        // backgroundMusic.setVolume(x);
        // backgroundMusic.playLoop();
        addObject(new Ryu(), 90, 165);
        addObject(new Guile(), 520, 165);
        addObject(new healthbar(), 310, 33);
        addObject(guilehealth, 434, 28);
        addObject(ryuhealth, 185, 28);
        addObject(new timer2(), 310, 30);
        addObject(new volume(), 130, 80);
    }
    public void act()
    {
      
    }
    public RyuHealth getRyuHealth(){
        return ryuhealth;
    }
    public GuileHealth getGuileHealth(){
        return guilehealth;
    }
}
