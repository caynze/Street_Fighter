import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;// colour
/**
 * Insert a timer into the game that start from whatever vlaue time is and count to zero, when time is zero game is over.
 * Time goes down one every time the the actor has run throught 1000 times
 */
public class timer2 extends Actor{
    private int time = 120;
    private int count = 50;
    public void act(){
        countdown();
        display();
        checkTimer();
    } 
    //every time the act runs 1000 times the timer goes down by one
    public void countdown(){
        if(count>0){
            count--;// subtract it from the 50 and count down from the 50
            if(count==0){
                time--;//subtract fromt the timer
                count = 50;//reset the count
               
            }
        }
    }
        public void checkTimer()
    {
        if(time==0)
        {
            Greenfoot.stop(); //stop when it hits 0
        }
    }
    //show the timer on the screen
    private void display(){
        setImage(new GreenfootImage("" + time, 28, Color.WHITE,Color.BLACK));
    }
}