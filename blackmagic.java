import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class blackmagic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class blackmagic extends bullet
{
    private int bulletLife = 40+Greenfoot.getRandomNumber(5);
    private int speed = 5;
    private String direction = "";
    public int dmg = 20;
    
    public blackmagic(String dir){
        GreenfootImage image = getImage();
        image.scale(20,20);
        this.direction = dir;
    }
    
    public void act() 
    {
        shoot(direction);
        bulletLife--;
        if(bulletLife == 0 || atWorldEdge()||getOneIntersectingObject(stone.class) != null){
            getWorld().removeObject(this);
        }
    }
    
    public void shoot(String direction){
        
        if("up".equals(direction)){
            shootUp(speed);
        }else if("down".equals(direction)){
            shootDown(speed);
        }else if("left".equals(direction)){
           shootLeft(speed);
        }else if("right".equals(direction)){
            move(speed);
        }
    }
    
    public void shootLeft(int speed){
        int x = getX();
        if (x > 0) {
            x = x-speed;
            setLocation(x, getY());
        }
    }
    
    public void shootUp(int speed){
        int y = getY();
        if (y > 0) {
            y = y - speed;
            setLocation(getX(), y);
        }
    }
    
    public void shootDown(int speed){
        int y = getY();
        
        y = y + speed;
        setLocation(getX(), y);
        
    }
}
