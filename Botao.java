import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botao here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Botao extends Actor
{   
    private boolean mouseEmCima = false;
    private static int transparenciaMaxima = 255;
    /*
     Essa função identifica se o mouse está em cima do botão
     e altera sua transparencia para sabermos que podemos clicar
     */
    public void checarMouse()
    {
        if (Greenfoot.mouseMoved(null)){
            mouseEmCima = Greenfoot.mouseMoved(this);
        }
        
        if (mouseEmCima){
            ajustarTransparencia(transparenciaMaxima/2);
        }
        else {
            ajustarTransparencia(transparenciaMaxima);
        }
    }
    
    /* essa função cria um novo mundo ao clicar nos botões, seja ele
       as instrucoes ou o proprio jogo*/
    public void checarClique(World world){
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(world);
        }
    }
    
    /* essa função altera a transparência do botão, com as implementações
       anteriores, deixa ele escuro quando o mouse está em cima*/
    public void ajustarTransparencia(int transparencia){
        GreenfootImage tempImage = getImage();
        tempImage.setTransparency(transparencia);
        setImage(tempImage);
    }
}
