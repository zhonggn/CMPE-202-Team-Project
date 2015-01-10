import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    private int lvl;
    private int type;
    
    public Door(int lvl, int type){
        this.lvl = lvl;
        this.type = type;
    }
    
    
    public void act() 
    {
        Character ch = (Character)getOneIntersectingObject(Character.class);
        if(ch!=null){
            switch(type){
                case 0: Greenfoot.setWorld(new Shop(lvl, ch)); break;
                case 1: Greenfoot.setWorld(new Stage2(ch)); break;
                case 2: Greenfoot.setWorld(new Stage3(ch)); break;
                case 3: Greenfoot.setWorld(new BossStage(ch)); break;
                case 4: Greenfoot.setWorld(new Win()); break;
            }
        }
    }    
}
