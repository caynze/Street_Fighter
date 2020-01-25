import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GuileShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GuileShot extends Guile
{
    private GifImage GuileShot = new GifImage("Gblast.gif");
    public void act() 
    {
        setImage(GuileShot.getCurrentImage());
        move(-10);

              if(isAtEdge()){ //remove the shot if it's at the edge in both 2 player vs and Smash mode

                    getWorld().removeObject(this);
                }

                else{
        try{
            World world=(Smash)(getWorld());

            if(getWorld()==world){
               //getWorld().addObject(this, 0,0);
                smashMode();
                 
            }
        }catch(ClassCastException x) {}
        
    }
    }
    public void smashMode(){
        try{  // if its in Smash world, remove the ryu shots that it touches, and remove itself
            World world=(Smash)(getWorld());

            if(getWorld()==world){
                if(isTouching(RyuShot.class)){
                    removeTouching(RyuShot.class);

                    getWorld().removeObject(this);

                }
   
            }
        }catch(ClassCastException x) {}

    }


}

