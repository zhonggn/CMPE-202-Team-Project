import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bossmagic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bossmagic extends bullet
{
    private int life = 30;
    
    public bossmagic(){
        GreenfootImage image = getImage();
        image.scale(64,64);
    }
    
    
    public void act() 
    {
        life--;
        if(life<=0){
            getWorld().removeObject(this);
        }    
    }    
}
