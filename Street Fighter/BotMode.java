import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class BotMode extends World
{
    private RyuHealth ryuhealth = new RyuHealth();
    private int num;
    private int chance =200;
    private score theScore;
    public BotMode() //Constructor, adds objects to world
    {    
        super(620, 240, 1); 
        GreenfootSound backgroundMusic = new GreenfootSound("theme.mp3");
         theScore= new score(); 
        backgroundMusic.setVolume(20);
        backgroundMusic.playLoop();
        addObject(new healthbar(), 310, 33);
        addObject(ryuhealth, 185, 28);
        addObject(new Ryu(), 90, 165);
        addObject(new Bots(), 520, 165);
        addObject(new Timer(), 310, 30);
        addObject(new score(),0,0);
    }
    public void act(){
        num = (int)(Math.random()*chance); //the chance of adding bots in survival mode
        if(num == 1){
            addObject(new Bots(), 520, 165);
        }
    }
    
    public void increaseChance(){
        chance=chance-10;
    }
    public RyuHealth getRyuHealth(){
        return ryuhealth;
    }
        public score getScore(){
        return theScore;
    }
}

