import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ryu extends RyuHealth
{
    private GifImage RyuIdle = new GifImage("IdleRyu.gif");
    private GifImage RyuJump = new GifImage("jump2.gif");
    private GifImage RyuShot = new GifImage("blast1.gif");
    private GifImage RyuWalk = new GifImage("walk.gif");
    private int shot = 0;
    private boolean vulnerable = true;
    public Ryu(){
        setImage("idle1.png");        
      
    }

    public void act() 
    {
        try{ //if we're in the 2 player vs mode, or in the bot mode, limit the number of shots you can use
            World worldTwo=(MyWorld)(getWorld());
            if(getWorld()==worldTwo){
                shot = getWorld().getObjects(RyuShot.class).size(); //this returns the number of shots on the screen
            }
        }catch(ClassCastException x) {}
        try{
            World worldThree=(BotMode)(getWorld());
            if(getWorld()==worldThree){
                shot = getWorld().getObjects(RyuShot.class).size();
            }
        }catch(ClassCastException x) {}
        checkKey();
        setBack();
    }    

    public void checkKey(){
        /**
         * This executes a command based off of what key was pressed down/ the controls of the character
         */
        if(Greenfoot.isKeyDown("w")==true)
        {
            jump();
        }
        else if(Greenfoot.isKeyDown("d")==true)
        {
            walkForward();
        }
        else if(Greenfoot.isKeyDown("a")==true)
        {
            walkBack();
        }
        else if(Greenfoot.isKeyDown("s")==true){
            crouch();
        }
        else if(Greenfoot.isKeyDown("f")==true && shot==0){
            shoot();
        }
        else{
            idle();
        }
    }

    public void idle()
    {
        vulnerable=true; // he is able to get hit by enemy blasts
        checkHit(); 
        setImage(RyuIdle.getCurrentImage()); //replays the idle animation when doing nothing
    }

    public void jump()
    {
        vulnerable=false; //cant get hit by enemy blasts
        checkHit();
        setImage(RyuJump.getCurrentImage()); //play the jump animation
    }

    public void walkForward()
    {
        vulnerable=true;
        checkHit();
        move(5); //move forward, can get hit at this time
        setImage(RyuWalk.getCurrentImage()); // play the walk gif
    }
    public void setBack()
    /**
     * if he crosses the middle, set him back to the start
     */
    {
        if (getX()>310)
        {
            move(-310);
        }
    }

    public void walkBack()
    {
        vulnerable=true;
        checkHit();
        move(-5); //walk backwards, can get hit at this time
        setImage(RyuWalk.getCurrentImage());
    }

    public void crouch(){
        vulnerable=false;
        checkHit();
        setImage("crouch1.png"); //crouch to dodge blasts, cant get hit at this time
    }

    public void shoot(){
        vulnerable=true;
        checkHit();
        setImage(RyuShot.getCurrentImage()); //play the animation of the shot
        Greenfoot.playSound("hadouken.mp3"); //play the sound effect
        getWorld().addObject(new RyuShot(), getX()+10, getY()); //create new shot
    }

    public void checkHit(){
        /**
         * this checks if the target is vulnerable, if he is, the shot hits and the health goes down, if he isnt, nothing happens
         */
        if(isTouching(GuileShot.class) && vulnerable==true){
            removeTouching(GuileShot.class); //remove the shot so the size is back to 0
            try{ //if we're in the 2 player vs mode, the characters can take damage
                World worldTwo=(MyWorld)(getWorld());
                if(getWorld()==worldTwo){
                    ((MyWorld)getWorld()).getRyuHealth().takeDamage();
                }
            }catch(ClassCastException x) {}
        
        
            try{
                World world=(Smash)(getWorld());
                if(getWorld()==world){
                    ((Smash)getWorld()).getRyuHealth().takeDamage();
                }
            }catch(ClassCastException x) {}
        }
        if(isTouching(BotShot.class) && vulnerable==true){
            removeTouching(BotShot.class);
            ((BotMode)getWorld()).getRyuHealth().takeDamage();
        }
    }
}
