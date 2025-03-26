import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.GreenfootImage;

/**
 * Write a description of class Jogar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jogar extends Botao {
    public Jogar() {
        GreenfootImage botaoJogar = new GreenfootImage(230, 80);
        Font adjustedFont = new Font(true, false, 40);
        botaoJogar.setFont(adjustedFont);
        botaoJogar.setColor(Color.WHITE);
        botaoJogar.drawString("Jogar", 10, 30);
        setImage(botaoJogar);
    }

    public void act() {
        checarMouse();
        
        // Cria a instância de Pontuacao
        Pontuacao pontuacao = new Pontuacao();

        // Passa a instância de Pontuacao ao mundo Dungeon
        checarClique(new Dungeon(pontuacao));  // Passa pontuacao aqui
    }
}
