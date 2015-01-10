import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hound here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class hound extends enemy
{
    private GreenfootImage face;
    private GreenfootImage back;
    private GreenfootImage left;
    private GreenfootImage right;
    private World world;
    private int hp=60;
    
    public hound(World w) {
        this.world = w;    
        GreenfootImage image = getImage();
        image.scale(64, 64);      
        face = new GreenfootImage("hound_face.png");
        face.scale(64, 64);
        back = new GreenfootImage("hound_back.png");
        back.scale(64, 64);
        left = new GreenfootImage("hound_left.png");
        left.scale(64, 64);
        right = new GreenfootImage("hound_right.png");
        right.scale(64, 64);
        //
    }
    
    /**
     * Act - do whatever the hound wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Stage1 w = (Stage1)getWorld();
        Character player = w.getCharacter();
        int diffX = player.getX()-getX();
        int diffY = player.getY()-getY();
        int Xoffset = 0;
        int Yoffset = 0;
        double l = Math.sqrt(diffX*diffX+diffY*diffY);
        
        chase(diffX, diffY, l);
        avoid(diffX, diffY, l);
        takeHit();
    }
    

    private void chase(int diffX, int diffY, double l){
        if(l!=0){
            setLocation(getX()+2*diffX/(int)l,getY()+2*diffY/(int)l);
        }
        if(Math.abs(diffX)>=Math.abs(diffY)){
            if(diffX>=0)
                setImage(right);
            else
                setImage(left);
        }
        else{
            if(diffY>=0)
                setImage(face);
            else
                setImage(back);
        }
    }
    
    private void avoid(int diffX, int diffY, double l){
        Actor s = getOneIntersectingObject(stone.class);
        
        if(s!=null){
            int dX = s.getX()-getX();
            int dY = s.getY()-getY();
            if(l!=0){
                setLocation(getX()-2*diffX/(int)l,getY()-2*diffY/(int)l);
            }
            if(Math.abs(dX)>=Math.abs(dY)){
                if(dX>=0){
                    setLocation(getX(), getY()-2);
                    setImage(back);
                }
                else{
                    setLocation(getX(),getY()+2);
                    setImage(face);
                }
            }
            else{
               if(dY>=0){
                    setLocation(getX()+2, getY());
                    setImage(right);
                }
                else{
                    setLocation(getX()-2,getY());
                    setImage(left);
                }
            }
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
