import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.MouseInfo;
/**
 * Write a description of class Initiate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Title t = new Title();
    obj_play play;
    /**
     * Constructor for objects of class Initiate.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
        //Greenfoot.start();
    }
    
    private void prepare(){
        addObject(t, 370,200);
        play = new obj_play();
        addObject(play, 400,400);
    }
    
    public void act() {
       
        if(Greenfoot.mouseClicked(this.play)){
          
         Greenfoot.setWorld(new Stage1());
      }
  }
    
  
}
