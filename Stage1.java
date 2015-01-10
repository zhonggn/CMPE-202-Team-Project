import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage1 extends World
{
    
    Character ch = new Character(this);
    hound hound1 = new hound(this);
    hound hound2 = new hound(this);
    hound hound3 = new hound(this);
    LifePanel life = new LifePanel(ch);
    
    
    /**
     * Constructor for objects of class Stage1.
     * 
     */
    public Stage1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }
    
    private void prepare(){
        addObject(life, 48,560);
        addObject(ch,400,300);
        addObject(hound1,400,500);
        addObject(hound2,100,300);
        addObject(hound3,600,200);

        
        stone s1 = new stone();
        stone s2 = new stone();
        stone s3 = new stone();
        stone s4 = new stone();
        addObject(s1,Greenfoot.getRandomNumber(20)+50,Greenfoot.getRandomNumber(20)+50);
        addObject(s2,Greenfoot.getRandomNumber(20)+200,Greenfoot.getRandomNumber(20)+300);
        addObject(s3,Greenfoot.getRandomNumber(20)+600,Greenfoot.getRandomNumber(20)+400);
        addObject(s4,Greenfoot.getRandomNumber(20)+500,Greenfoot.getRandomNumber(20)+200);

    }
    
    public void act(){
        if(getObjects(enemy.class).isEmpty()){
            addObject(new Door(1,0), 400, 300);
        }
    }
    
    public Character getCharacter(){
        return ch;
    }

}
