import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;// colour
/**
 * Insert a timer into the game that start from whatever vlaue time is and count to zero, when time is zero game is over.
 * Time goes down one every time the the actor has run throught 1000 times
 */
public class timer3 extends Actor{
    private int time = 10;
    private int count = 50;
    public void act(){
        countdown();
        display();
        checkTimer();
    } 
    //every time the act runs 1000 times the timer goes down by one
    public void countdown(){
        if(count>0){
            count--;//minus from the 1000 to countdown from 1000
            if(count==0){
                time--;//subtract fromt he timer
                count = 50;//reset the count
                // when timer hit 0, game over screen will appear and it will play a time bomb sound before it stops
            }
        }
    }
    public void checkTimer()
    {
        if(time==0)
        {
            Greenfoot.setWorld(new Instructions());
        }
    }
    //show the timer on the screen
    private void display(){
        setImage(new GreenfootImage("" + time, 28, Color.WHITE,Color.BLACK));
    }
}
