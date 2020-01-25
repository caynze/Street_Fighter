import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.*;
public class RyuHealth extends Actor
{
    private int health=10;
    private final String [] images = {"00_.png","10_.png","20_.png","30_.png","40_.png","50_.png","60_.png","70_.png","80_.png","90_.png","100_.png"};
    public RyuHealth(){
        
    }
    public void act() 
    /**
     * This reduces the health when hit
     */
    {
       scores();
   
        if(health>0){ //replace the healthbars if the game isnt over yet
        setImage(images[0]);
         setImage(images[checkHealth()]);
        }
       else if(health==0){ //end the game if health=0
            getWorld().addObject(new ENDTWO(), 310, 120); //Set End Screen
           setImage(images[0]);
           getWorld().removeObjects(getWorld().getObjects(healthbar.class)); 
            getWorld().removeObjects(getWorld().getObjects(GuileHealth.class));
            Greenfoot.stop();
     
 
        }

    }    
    public void scores() 
    {
             try{
            World worldThree=(BotMode)(getWorld());
            if(getWorld()==worldThree){
                try{

                    ((BotMode)getWorld()).getScore().readScores(); //reads the top scores from the file
                    
                    ((BotMode)getWorld()).getScore().checkScore();//checks current score achieved

                    ((BotMode)getWorld()).getScore().writeScores();//re writes scores to file accounting for the new score

                    ((BotMode)getWorld()).getScore().printScoreScreen();//prints top scores on screen

                }catch (Exception e){}
            }
        }catch(ClassCastException x) {}
    }
    public void takeDamage(){
        health--;
       
    }
    public int checkHealth(){
        return health;
    }
}
