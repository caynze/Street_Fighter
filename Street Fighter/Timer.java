import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;// colour
/**
 * Insert a timer into the game that start from whatever vlaue time is and count to zero, when time is zero game is over.
 * Time goes down one every time the the actor has run throught 1000 times
 */
public class Timer extends Actor{
    private int time = 0;
    private int count = 50;
    public void act(){
        countdown();
        display();

    } 
    //every time the act runs 50 times the timer goes down by one
    public void countdown(){
        if(count>0){
            count--;//miuns from the 50 to countdown from 50
            if(count==0){
                time++;//increase the timer
                count = 50;//reset the count
               
            }
        }
    }

    //show the timer on the screen
    private void display(){
        setImage(new GreenfootImage("" + time, 28, Color.WHITE,Color.BLACK));
    }
}
