import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cherry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cherry extends Item
{
    public cherry(){
        GreenfootImage image = getImage();
        image.scale(48, 48); 
    }
    
    public void act() 
    {
        Character ch = (Character)getOneIntersectingObject(Character.class);
        if(ch!=null){
            ch.setHP(100);
            getWorld().removeObject(this);
        }
    }    
}
