import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stage2 extends World
{
    Character ch;
    wing wing1 = new wing(this);
    wing wing2 = new wing(this);
    wing wing3 = new wing(this);
    LifePanel life;
    
    
    /**
     * Constructor for objects of class Stage2.
     * 
     */
    public Stage2()
    {    
        super(800, 600, 1);
        prepare();
    }
    
    public Stage2(Character ch)
    {    
        super(800, 600, 1);
        this.ch = ch;
        life = new LifePanel(ch);
        prepare();
    }
    
    private void prepare(){
        addObject(life, 48,560);
        addObject(ch,400,300);
        

        
        stone s1 = new stone();
        spike s2 = new spike();
        stone s3 = new stone();
        spike s4 = new spike();
        addObject(s1,Greenfoot.getRandomNumber(20)+50,Greenfoot.getRandomNumber(20)+50);
        addObject(s2,Greenfoot.getRandomNumber(20)+200,Greenfoot.getRandomNumber(20)+300);
        addObject(s3,Greenfoot.getRandomNumber(20)+600,Greenfoot.getRandomNumber(20)+400);
        addObject(s4,Greenfoot.getRandomNumber(20)+500,Greenfoot.getRandomNumber(20)+200);
        addObject(wing1,400,500);
        addObject(wing2,100,300);
        addObject(wing3,600,200);
    }
    
    public void act(){
        if(getObjects(wing.class).isEmpty()){
            addObject(new Door(2,0), 400, 300);
        }
    }
    
    public Character getCharacter(){
        return ch;
    }
}
