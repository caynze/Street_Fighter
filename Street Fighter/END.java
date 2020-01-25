import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class END here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class END extends Actor
{
    int i=0, k=0;
    String backgrounds[]=new String[10];
    String backgroundsTwo[]=new String[10];

    public END (){
        for(int i =0; i<=9; i++){
            backgrounds[i] = ("background" + (i+2) + ".jpg");
        }
    }

    public void act() 
    {
        End();
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
