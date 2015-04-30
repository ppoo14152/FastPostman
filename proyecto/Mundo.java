import greenfoot.*; 
import java.util.Timer;
import java.util.TimerTask;

/**
 * Write a description of class Mundo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mundo extends World
{
   
    private static final GreenfootImage bgImage = new GreenfootImage("calle.jpg");
    private int scrollSpeed;
    private GreenfootImage imagenG;
    private GreenfootImage scrollingImage;
    private int scrollPosition = 0;
    private boolean pause;
    private int cont;
     private int num;
    
   
     
    /**
     * Constructor for objects of class Mundo.
     * 
     */
    public Mundo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(900, 600, 1);
        
        menu();
        
        scrollSpeed=1;
        pause=false;
         imagenG=new GreenfootImage("ayuda.png");
         
    }
    
    
    
    
     /**
     * metodo de actua
     */
    public void act()
    { 
      cont++;
       scroll();
      
              
           
    }
    
    /**
     * metodo en el cual se realiza el scroll del mundo por medio de dos variables 
     * velocidad de scroll y la posicion de la imagen
     */
    public void scroll()
    {
      if(pause)
        {
        if (scrollSpeed!=0)
        {
            
            if(scrollSpeed > 0 && scrollPosition <= 0) {
               scrollPosition = getWidth();
            }
            if(scrollSpeed < 0 && scrollPosition >= getWidth()) {
               scrollPosition = 0;
            }
            scrollPosition -= scrollSpeed;
            paint(scrollPosition);
            
        }
    
       }
    }
    
    /**
     * metodo en el cual se insertan los objetos que lleva el menu del juego
     */
    public void menu()
    {
        
        addObject(new Play(),250,400);
        addObject(new Ayuda(),450,520);
        addObject(new Credits(),750,400);
    }
  
    /**
     * Pintura de la imagen de desplazamiento en la posición dada y asegúrese de que el resto de
     * el fondo también está pintado con la misma imagen.
     */
    private void paint(int position)
    {
        GreenfootImage bg = getBackground();
        bg.drawImage(scrollingImage, position, 0);
        bg.drawImage(scrollingImage, position - scrollingImage.getWidth(), 0);
    }
 
    /**
     * Devuelve una imagen con las dimensiones dadas.
     */
    private GreenfootImage getScrollingImage(int width, int height)
    {
        GreenfootImage image = new GreenfootImage(width, height);
        for(int x = 0; x < width; x += bgImage.getWidth()) {
            for(int y = 0; y < height; y += bgImage.getHeight()) {
                image.drawImage(bgImage, x, y);
            }
        }
        return image;
    } 
    
    /**
     * metodo en el cual se sabe si esta en pause el juego
     */
      public boolean getPause()
    {
       return pause;
    }
   
    /**
     *cambia la velocidad del scroll
     */
    public void cambiaSpeedScroll(int vs)
    {
       scrollSpeed=vs;
    }
    
    /**
     *regresa la velocidad del scroll
     */
    public int dameSpeedScroll()
    {
        return scrollSpeed;
    }
    
 
   /**
     *cambia numero que se toma como aleatorio
     */
   public void cambianum(int d)
   {
    num=d;
   }
    
   /**
     *regresa el numero que se toma como aleatorio
     */
  public int damenum()
  {
   return num; 
   }
 /**
     * metodo en el cual se inicia el juego con los objetos iniciales
     */
    public void ecenario()
    {
        pause=true;
        GreenfootImage background = new GreenfootImage(1000, 600);
        scrollingImage = getScrollingImage(1000, 600);
        background.drawImage(scrollingImage, 0, 0);
        setBackground(background);
        addObject(new Clock(), getWidth()-395,getHeight()-getHeight()+35);
        addObject(new jackCartero(), 65, 545);
        
    } 
  
   
}