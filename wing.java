import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class wing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class wing extends enemy
{
    /**
     * Act - do whatever the wing wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootImage face;
    private GreenfootImage back;
    private GreenfootImage left;
    private GreenfootImage right;
    private GreenfootImage dface;
    private GreenfootImage dback;
    private GreenfootImage dleft;
    private GreenfootImage dright;
    private World world;
    private int hp=30;
    private int d;
    private int dd = -1;
    private int cd=20;
    private int cd_num=0;
    private int dash = 0;
    
    public wing(World w) {
        this.world = w;    
        GreenfootImage image = getImage();
        image.scale(48, 48);      
        face = new GreenfootImage("wing-face.jpeg");
        face.scale(48, 48);
        back = new GreenfootImage("wing-back.jpeg");
        back.scale(48, 48);
        left = new GreenfootImage("wing-left.jpeg");
        left.scale(48, 48);
        right = new GreenfootImage("wing-right.jpeg");
        right.scale(48, 48);
        dface = new GreenfootImage("wing-dash-front.jpeg");
        dface.scale(48, 48);
        dback = new GreenfootImage("wing-dash-back.jpeg");
        dback.scale(48, 48);
        dleft = new GreenfootImage("wing-dash-left.jpeg");
        dleft.scale(48, 48);
        dright = new GreenfootImage("wing-dash-right.jpeg");
        dright.scale(48, 48);
        this.d = 0;
    }
    
    public void act() 
    {
        // Add your action code here.
        this.d = wander(this.d);
        Stage2 w = (Stage2)getWorld();
        Character player = w.getCharacter();
        int diffX = player.getX()-getX();
        int diffY = player.getY()-getY();
        double l = Math.sqrt(diffX*diffX+diffY*diffY);
        this.cd_num++;
        if(l < 80.0 && cd_num >= cd && dash <= 0){
            this.dd = dashStandby(diffX, diffY);
            this.dash = 15;
            
        }
        if(this.dash > 0){
            dash(dd);
            this.dash--;
            if(this.dash <= 0){cd_num = 0;}
        }
        takeHit();
    }
    
    private int wander(int d){
        if (Greenfoot.getRandomNumber(500)<5||getX()<=5||getX()>=getWorld().getWidth()-5||getY()<=5||getY()>=getWorld().getHeight()-5){
            d = Greenfoot.getRandomNumber(4);
        }
        if (d == 0){
            setLocation(getX(), getY() + 1);
            setImage(face);
        }
        if (d == 1){
            setLocation(getX(), getY() - 1);
            setImage(back);
        }
        if (d == 2){
            setLocation(getX() - 1, getY());
            setImage(left);
        }
        if (d == 3){
            setLocation(getX() + 1, getY());
            setImage(right);
        }
        return d;
    }
    
    private int dashStandby(int dx, int dy){
        if(Math.abs(dx)>=Math.abs(dy)){
            if(dx>=0){
                setImage(dright);
                return 3;
            }
            else{
                setImage(dleft);
                return 2;
            }
        }
        else{
            if(dy>=0){
                setImage(dface);
                return 0;
            }
            else{
                setImage(dback);
                return 1;
            }
        }
    }
    
    private void dash(int d){
        if (d == 0){
            setLocation(getX(), getY() + 4);
        }
        if (d == 1){
            setLocation(getX(), getY() - 4);
        }
        if (d == 2){
            setLocation(getX() - 4, getY());
        }
        if (d == 3){
            setLocation(getX() + 4, getY());
        }
    }
    
    private void takeHit(){
        normal_bullet bullet1 = (normal_bullet)getOneIntersectingObject(normal_bullet.class);
        crystal_bullet bullet2 = (crystal_bullet)getOneIntersectingObject(crystal_bullet.class);
        fireball_bullet bullet3 = (fireball_bullet)getOneIntersectingObject(fireball_bullet.class);
        laser_bullet bullet4 = (laser_bullet)getOneIntersectingObject(laser_bullet.class);
        if(bullet1!=null){
            getWorld().removeObject(bullet1);
            if(hp>0){
                hp-=bullet1.dmg;
            }
            else{
                getWorld().removeObject(this);
            }
        }
        
        else if(bullet2!=null){
            getWorld().removeObject(bullet2);
            if(hp>0){
                hp-=bullet2.dmg;
            }
            else{
                getWorld().removeObject(this);
            }
        }
        
        else if(bullet3!=null){
            getWorld().removeObject(bullet3);
            if(hp>0){
                hp-=bullet3.dmg;
            }
            else{
                getWorld().removeObject(this);
            }
        }
        
        else if(bullet4!=null){
            if(hp>0){
                hp-=bullet4.dmg;
            }
            else{
                getWorld().removeObject(this);
            }
        }
    }
}
