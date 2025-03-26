import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VoltarAoMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VoltarAoMenu extends Botao
{
    /*basicamente essa função cria e estiliza o texto do botão como se fosse
       uma imagem*/
    public VoltarAoMenu(){
        GreenfootImage botaoMenu = new GreenfootImage(160,60);
        botaoMenu.fillRect(0,0,160,60);
        Font adjustedFont = new Font(true,false,27);
        botaoMenu.setFont(adjustedFont);
        botaoMenu.setColor(Color.WHITE);
        botaoMenu.drawString("Menu Inicial",0,30);
        setImage(botaoMenu);
    }
    
    public void act()
    {
        checarMouse();
        checarClique(new MenuInicial());
    }
}
