import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class fireball_bullet extends bullet
{
    private GreenfootImage up;
    private GreenfootImage down;
    private GreenfootImage left;
    private GreenfootImage right;
    private int bulletLife = 50+Greenfoot.getRandomNumber(5);
    private int speed = 10;
    private String direction = "";
    public int dmg = 30;
    
    public fireball_bullet(String dir) {
        GreenfootImage image = getImage();
        image.scale(25, 50);
        this.direction = dir;
        right = new GreenfootImage("fireball_right.png");
        right.scale(50, 25);
        left = new GreenfootImage("fireball_left.png");
        left.scale(50, 25);
        up = new GreenfootImage("fireball_up.png");
        up.scale(25, 50);
        down = new GreenfootImage("fireball_down.png");
        down.scale(25, 50);
    }
    
    public void act() 
    {
        shoot(direction);
        bulletLife--;
        if(bulletLife == 0 || atWorldEdge()){
            getWorld().removeObject(this);
        }
    } 
    
    public void shoot(String direction) {
        if("up".equals(direction)){
            shootUp(speed);
            setImage(up);
        }else if("down".equals(direction)){
            shootDown(speed);
            setImage(down);
        }else if("left".equals(direction)){
            shootLeft(speed);
            setImage(left);
        }else if("right".equals(direction)){
            move(speed);
            setImage(right);
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
