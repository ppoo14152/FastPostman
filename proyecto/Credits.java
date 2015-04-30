import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends Actor
{
     private int band=0;
    /**
     * Act - do whatever the Credits wants to do. This method is called whenever
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
                setImage("creditos2.png");
                i = super.getImage();
                i.scale((i.getWidth())+60, (i.getHeight())+20);
                super.setImage(i);
                mundo.setPaintOrder(Credits.class, Play.class,Ayuda.class);
                
               }
             else
            setImage("creditos1.png");
        }
    }
   
    /**
     *metodo que checa si se dio click en el boton si haci lo hizo se procede a llamar a la accion correspondiente 
     */
    public void clicBoton()
    {
         if( Greenfoot.mouseClicked( null ))
        {
            MouseInfo raton = Greenfoot.getMouseInfo();
            Actor personaje=raton.getActor();
            if(personaje instanceof Credits)
            {
                World mundo=getWorld();
                mundo.removeObjects(mundo.getObjects(null));
                mundo.setBackground("creditos.png");
                mundo.addObject(new Retorno(),100,500);
                GreenfootImage i;
                i = mundo.getBackground();
           
            }
        }
    }
}
