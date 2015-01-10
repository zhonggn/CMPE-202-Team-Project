import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class laser_bullet extends bullet
{
    private GreenfootImage up;
    private GreenfootImage down;
    private GreenfootImage left;
    private GreenfootImage right;
    private int bulletLife = 3;
    //private int speed = 20;
    private String direction = "";
    public int dmg = 15;
    
    public laser_bullet(String dir) {
        GreenfootImage image = getImage();
        image.scale(25, 500);
        this.direction = dir;
        right = new GreenfootImage("laser_right.png");
        right.scale(500, 25);
        left = new GreenfootImage("laser_left.png");
        left.scale(500, 25);
        up = new GreenfootImage("laser_up.png");
        up.scale(25, 500);
        down = new GreenfootImage("laser_down.png");
        down.scale(25, 500);
        
    }
    
    public void act() 
    {
        shoot(direction);
        bulletLife--;
        if(bulletLife <= 0){
            getWorld().removeObject(this);
        }
    } 
   
    public void shoot(String direction) {
        if("up".equals(direction)){
            //shootUp(speed);
            setImage(up);            
        }else if("down".equals(direction)){
            //shootDown(speed);
            setImage(down);
        }else if("left".equals(direction)){
            //shootLeft(speed);
            setImage(left);           
        }else if("right".equals(direction)){
            //move(speed);
            setImage(right);
        }
    }
    
    /*public void shootLeft(int speed){
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
        
    }*/
}
