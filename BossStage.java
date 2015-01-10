import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BossStage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BossStage extends World
{

    Character ch;
    boss boss1 = new boss(this);
    LifePanel life;
    
    /**
     * Constructor for objects of class BossStage.
     * 
     */
    public BossStage()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public BossStage(Character ch)
    {    
        super(800, 600, 1);
        this.ch = ch;
        life = new LifePanel(ch);
        prepare();
    }
    
    private void prepare(){
        addObject(life, 48,560);
        addObject(ch,400,300);
        addObject(boss1,400,100);
    }
    
    public void act(){
        if(getObjects(boss.class).isEmpty()){
            addObject(new Door(4,4), 400, 300);
        }
    }
    
    public Character getCharacter(){
        return ch;
    }
}
