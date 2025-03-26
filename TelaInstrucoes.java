import greenfoot.*;
import java.util.ArrayList;

public class TelaInstrucoes extends World
{
    private GreenfootImage background;

    public TelaInstrucoes()
    {    
        super(1028, 587, 1); // Largura, altura e resolução do mundo
        background = new GreenfootImage("Instrucoes.png"); // Imagem de fundo
        setBackground(background); // Define o fundo

        // Posição dos botões, etc.
        prepare();
    }
    
    private void prepare()
    {
        VoltarAoMenu voltarAoMenu = new VoltarAoMenu();
        addObject(voltarAoMenu, 537, 440);
    }
}