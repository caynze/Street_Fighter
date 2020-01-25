import greenfoot.*;
import java.io.*;
import java.awt.Color;
public class score extends Actor

{
    private int currentScore;
    private int [] bestScores = new int[5];
    private int key;
   private int i;
    public score(){
        currentScore = 0;
    }
    public void act() 
    {
        printScore(); //prints current score in the bottom left
    }    
    public void readScores() throws java.io.IOException
    {
        FileReader fr = new FileReader("TopFive.txt"); //opens new file reader file
        BufferedReader bfr = new BufferedReader(fr);
        for (int i = 0; i<5; i++){

            bestScores[i] = Integer.parseInt(bfr.readLine()); //reads current top scores from the file

        }
        bfr.close(); 
    }
    public void writeScores() throws java.io.IOException 
    {
        FileWriter fw = new FileWriter ("TopFive.txt"); //opens new file writer
        BufferedWriter bfw = new BufferedWriter(fw);
        for (int i = 0; i<5; i++){
            bfw.write(bestScores[i]+ "\r\n"); //writes new top scores to the file
        }
        bfw.close();
    }
    public void increaseScore(){ 
        currentScore += 10; //increases score by 10
    }
    public void printScore(){ //prints current score in bottom left
        GreenfootImage textImage = new GreenfootImage("Score: " + currentScore, 24, new Color(0, 0, 0), new Color(255, 255, 255)); //prints current score on the game screen
        GreenfootImage background = getWorld().getBackground();
        background.drawImage (textImage, 0, 375);
        textImage.clear();
    }
    public void printScoreScreen(){ //prints the top scores
        GreenfootImage textScores = new GreenfootImage(bestScores[0] + "\r\n" + bestScores[1] + "\r\n" + bestScores[2] + "\r\n" + bestScores[3] + "\r\n" + bestScores[4], 40, new Color(255, 255, 255), new Color(0, 0, 0));
        GreenfootImage background = getWorld().getBackground();
        background.drawImage (textScores, 247, 130);
        textScores.clear();
    }    
    public void checkScore(){                           
        if(currentScore > bestScores[4]){ //sets new score if successful
            bestScores[4] = currentScore;
        }
        for (int j=1; j<5; j++) //sorts scores from least to greatest
        {
            key = bestScores[j];
            for(i = j-1; (i>=0) && (bestScores[i] < key); i--)   
            {
                bestScores[i+1] = bestScores[i];
            }
            bestScores[i+1] = key;   
        }
    }}