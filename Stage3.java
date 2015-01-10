import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage3 extends World
{

    Character ch;
    mage mage1 = new mage(this);
    mage mage2 = new mage(this);
    mage mage3 = new mage(this);
    LifePanel life;
    
    /**
     * Constructor for objects of class Stage3.
     * 
     */
    public Stage3()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        prepare();
    }
    
    public Stage3(Character ch)
    {    
        super(800, 600, 1);
        this.ch = ch;
        life = new LifePanel(ch);
        prepare();
    }
    
    private void prepare(){
        addObject(life, 48,560);
        addObject(ch,400,300);
        addObject(mage1,400,500);
        addObject(mage2,100,300);
        addObject(mage3,600,200);

        
        spike s1 = new spike();
        spike s2 = new spike();
        spike s3 = new spike();
        spike s4 = new spike();
        addObject(s1,Greenfoot.getRandomNumber(20)+50,Greenfoot.getRandomNumber(20)+50);
        addObject(s2,Greenfoot.getRandomNumber(20)+200,Greenfoot.getRandomNumber(20)+300);
        addObject(s3,Greenfoot.getRandomNumber(20)+600,Greenfoot.getRandomNumber(20)+400);
        addObject(s4,Greenfoot.getRandomNumber(20)+500,Greenfoot.getRandomNumber(20)+200);

    }
    
    public void act(){
        if(getObjects(mage.class).isEmpty()){
            addObject(new Door(3,0), 400, 300);
        }
    }
    
    public Character getCharacter(){
        return ch;
    }
    
}
