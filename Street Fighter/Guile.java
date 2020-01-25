import greenfoot.*;  
public class Guile extends GuileHealth
{
    private int delay=5;
    private GifImage GIdle = new GifImage("Gidle.gif");
    private GifImage GJump = new GifImage("Gjump3.gif");
    private GifImage GShot = new GifImage("Gshot.gif");
    private GifImage GWalk = new GifImage("Gwalk.gif");
    int shot = 0;
    private boolean vulnerable = true;
    public Guile(){
        getImage().mirrorHorizontally();
    }
        public void setBack()
    {
        if (getX()<310)
        {
            move(310);
        }
    }
    public void act() 
    {
     try{
            World worldTwo=(MyWorld)(getWorld());
            if(getWorld()==worldTwo){
                 shot = getWorld().getObjects(GuileShot.class).size();
                 
            }
        }catch(ClassCastException x) {}       
        if(Greenfoot.isKeyDown("i")==true)
        {
            jump();
        }
        else if(Greenfoot.isKeyDown("j")==true)
        {
            walkForward();
        }
        else if(Greenfoot.isKeyDown("l")==true)
        {
            walkBack();
        }
        else if(Greenfoot.isKeyDown("k")==true){
            crouch();
        }
        else if(Greenfoot.isKeyDown(";")==true && shot ==0){
            shoot();
        }
        else{
             idle();
        }
        setBack();
    }    

    public void idle()
    {
            vulnerable=true;
        checkHit();
        setImage(GIdle.getCurrentImage());
    }

    public void jump()
    {
        vulnerable = false;
        checkHit();
        setImage(GJump.getCurrentImage());
    }

    public void walkBack()
    {
        vulnerable = true;
        checkHit();
        move(5);
        setImage(GWalk.getCurrentImage());
    }

    public void walkForward()
    {
        vulnerable = true;
        checkHit();
        move(-5);
        setImage(GWalk.getCurrentImage());
    }

    public void crouch(){
        vulnerable = false;
        checkHit();
        setImage("Gcrouch.png");
    }

    public void shoot(){
        vulnerable = true;
        checkHit();
        setImage(GShot.getCurrentImage());
        Greenfoot.playSound("pew.mp3");
        getWorld().addObject(new GuileShot(), getX()-10, getY());
    }

    public void checkHit(){
        if(isTouching(RyuShot.class) && vulnerable == true){
            removeTouching(RyuShot.class);
               try{
            World worldTwo=(MyWorld)(getWorld());

            if(getWorld()==worldTwo){
                ((MyWorld)getWorld()).getGuileHealth().takeDamage();
                 
            }
        }catch(ClassCastException x) {}
            
             try{
            World world=(Smash)(getWorld());

            if(getWorld()==world){
                ((Smash)getWorld()).getGuileHealth().takeDamage();
                 
            }
        }catch(ClassCastException x) {}
        }
    }
}
