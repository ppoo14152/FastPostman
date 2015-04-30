import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ayuda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ayuda extends Actor
{
    /**
     * Act - do whatever the Ayuda wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
               setImage("ayuda2.png");
               i = super.getImage();
               i.scale((i.getWidth())+50, (i.getHeight())+20);
               super.setImage(i);
               mundo.setPaintOrder(Ayuda.class, Play.class,Credits.class);
           }
           else
              setImage("ayuda1.png");
        }
    }
   
    /**
     *metodo que checa si se preciono click en el boton si asi lo hizo se procede a llamar a la accion correspondiente 
     */
    public void clicBoton()
    {  if( Greenfoot.mouseClicked( null ))
        {
          MouseInfo raton = Greenfoot.getMouseInfo();
          Actor personaje=raton.getActor();
          if(personaje instanceof Ayuda)
          {
            
                World mundo=getWorld();
                mundo.removeObjects(mundo.getObjects(null));
                mundo.setBackground("ayuda.png");
                mundo.addObject(new Retorno(),100,500);
          }
        }
    }
}
