import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class END here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ENDTWO extends Actor
{
    int i=0, k=0;
    String backgrounds[]=new String[10];
    String backgroundsTwo[]=new String[10];
    public ENDTWO (){
        for(int i = 0; i<=2; i++){
            backgroundsTwo[i] = ("background" + (i+2) + ".jpg");
        }
        for(int i = 3; i<=9; i++){
            backgroundsTwo[i] = ("backgroundTwo" + (i+2) + ".jpg");
        }
    }
    /**
     * Act - do whatever the END wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // endTwo();
    }    

    public void End(){
        i=i++;
        if(i%1==0){
            getWorld().setBackground(backgrounds[k]);
            k++;
            if(k>=10){
                Greenfoot.stop();
            }
        }
    }
    public void endTwo(){
        i=i++;
        if(i%1==0){
            getWorld().setBackground(backgroundsTwo[k]);
            k++;
            if(k>9){ Greenfoot.stop();}
        }
    }
}
