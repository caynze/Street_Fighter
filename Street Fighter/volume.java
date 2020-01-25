import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class volume here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class volume extends Actor
{
    /**
     * Act - do whatever the volume wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int y=100;
    private int x=0;
    private GreenfootImage [] volume= new GreenfootImage[3];
    private GreenfootSound backgroundMusic = new GreenfootSound("theme.mp3");      
    public volume()
    {
        backgroundMusic.setVolume(y);
        backgroundMusic.playLoop();
        for (int i=0; i<3;i++)
        {
            volume[i]=new GreenfootImage("sound"+i+".png");
        }
    }

    public void act() 
    {
        checkKeys();
    }

    public void checkKeys()
    {
        if (x>=0 && x<=2) 
        {
            if (Greenfoot.isKeyDown("down")) // lower the volume if you press down
            {        
                Greenfoot.delay(10);
                x++;//this controls the image that's placed
                y=y-50;
                setImage(volume[x]); //set the image for the volume
                backgroundMusic.setVolume(y); //lower the volume
            }
            if (Greenfoot.isKeyDown("up")) //increase the volume if you press up
            {
                Greenfoot.delay(10);
                x--;
                y=y+50; //increase the variable thats used for volume
                setImage(volume[x]);
                backgroundMusic.setVolume(y); //increase the volume
            }
        }}
}

