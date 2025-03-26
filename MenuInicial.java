import greenfoot.*;
import java.util.ArrayList;

public class MenuInicial extends World
{
    private GreenfootImage background;
    private GreenfootImage startButton;
    private GreenfootImage howToPlay;

    public MenuInicial()
    {    
        super(1028, 587, 1); // Largura, altura e resolução do mundo
        background = new GreenfootImage("Menu.png"); // Imagem de fundo
        setBackground(background); // Define o fundo

        // Chama o método para exibir o histórico de pontuação
        mostrarHistoricoPontuacoes();

        // Posição dos botões, etc.
        prepare();
    }

    public void act() {
        // Verifica se o botão de iniciar foi clicado
        Inimigo.reiniciarJogo();
    }

    // Método para exibir o histórico de pontuações no menu
    private void mostrarHistoricoPontuacoes() {
        ArrayList<Integer> historico = Pontuacao.getHistoricoPontuacoes();
        String texto = "Histórico de Pontuação:\n";

        // Adiciona as pontuações do histórico à string
        for (int i = 0; i < historico.size(); i++) {
            texto += "Jogo " + (i + 1) + ": " + historico.get(i) + " pontos\n";
        }

        GreenfootImage imagem = new GreenfootImage(texto, 24, Color.RED, Color.BLACK);
        getBackground().drawImage(imagem, 10, 60);  // Exibe o histórico abaixo da "título" ou acima do botão
    }

    private void prepare()
    {
        Jogar jogar = new Jogar();
        addObject(jogar, 164, 453);  // Posiciona o botão de iniciar
        Instrucoes instrucoes = new Instrucoes();
        addObject(instrucoes,138,532);
    }
}
