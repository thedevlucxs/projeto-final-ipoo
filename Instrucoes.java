import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Jogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Instrucoes extends Botao {
    public Instrucoes() {
        GreenfootImage botaoJogar = new GreenfootImage(230, 80);
        Font adjustedFont = new Font(true, false, 40);
        botaoJogar.setFont(adjustedFont);
        botaoJogar.setColor(Color.WHITE);
        botaoJogar.drawString("Instrucoes", 10, 30);
        setImage(botaoJogar);
    }

    public void act() {
        checarMouse();
        
        
        checarClique(new TelaInstrucoes());  
    }
}