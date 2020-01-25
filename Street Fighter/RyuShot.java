import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RyuShot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RyuShot extends Ryu
{
    private GifImage RyuShot = new GifImage("RyuShot.gif");
    public void act() 
    {
        setImage(RyuShot.getCurrentImage());
        move(10);

        if(isAtEdge()){ //remove if its at the edge

            getWorld().removeObject(this);
        }

        else{
            try{ //if its in smash mode then theres no limits
                World world=(Smash)(getWorld());

                if(getWorld()==world){
                    //getWorld().addObject(this, 0,0);
                    smashMode();

                }
            }catch(ClassCastException x) {}

        }

    }    

    public void smashMode(){
        try{ 
            World world=(Smash)(getWorld());

            if(getWorld()==world){
                if(isTouching(GuileShot.class)){
                    removeTouching(GuileShot.class); //remove guiles shot in the blast mode

                    getWorld().removeObject(this); //remove itself

                }

            }

        }catch(ClassCastException x) {}

    }
}

