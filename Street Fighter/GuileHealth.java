import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GuileHealth extends Actor
{
    private int health = 10;
    private final String [] images = {"00_.png","r10_.png","r20_.png","r30_.png","r40_.png","r50_.png","r60_.png","r70_.png","r80_.png","r90_.png","100_.png"};
    public GuileHealth()
    {

    }

    public void act() 
    {
        if(health>0){
            setImage(images[0]);
            setImage(images[checkHealth()]);
        }
        else if(health==0){
            getWorld().addObject(new END(), 310, 120);           
            setImage(images[0]);
            getWorld().removeObjects(getWorld().getObjects(healthbar.class));
            getWorld().removeObjects(getWorld().getObjects(RyuHealth.class));
               
        }
    }   

    public void takeDamage(){
        health--;
    }

    public int checkHealth(){
        return health;
    }
}
