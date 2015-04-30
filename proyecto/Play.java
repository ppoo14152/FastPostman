import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Actor
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   private GreenfootImage play2;
   

    public void act() 
    {
        interseccionBoton();
        clicBoton();   
    }
    
     /**
     * metodo en el que se checa si hay una inteseccion entre el boton y el puntero del mouse, si esto ocurre
     * manda llamar a otra imagen y la hace mas grande para que de un buen efecto visual
     */
    public void interseccionBoton()
    {
             if(Greenfoot.mouseMoved(null))
         {
             MouseInfo raton = Greenfoot.getMouseInfo();
             if(raton.getActor()==this)
               { 
                 World mundo=(World)getWorld();  
                GreenfootImage i;
                setImage("jugar2.png");
                i = super.getImage();
                i.scale((i.getWidth()), (i.getHeight()));
                super.setImage(i);
                mundo.setPaintOrder(Play.class, Credits.class,Ayuda.class);
              
               }
             else
            setImage("jugar1.png");
        }
          
    }
   
    /**
     *metodo que checa si se preciono click en el boton si asi lo hizo se procede a llamar a la accion correspondiente 
     */
    public void clicBoton()
    {
       
       if( Greenfoot.mouseClicked( null ))
        {
          MouseInfo raton = Greenfoot.getMouseInfo();
          Actor personaje=raton.getActor();
          if(personaje instanceof Play)
          {
               World mundo=(World)getWorld();  
               mundo.removeObjects(mundo.getObjects(null));
              ((Mundo)mundo).ecenario();
         
           }
        }        
    }
  
}