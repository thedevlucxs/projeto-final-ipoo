import greenfoot.*;
import java.util.ArrayList;

public class Perdeu extends World
{
    private GreenfootImage background;
    private int pontuacao;
    
    public Perdeu(int pontuacao)
    {    
        // largura, altura e resolução
        super(1028, 587, 1); 
        this.pontuacao = pontuacao;
        background = new GreenfootImage("Perdeu.png"); // Imagem de fundo
        setBackground(background); // Define o fundo
        mostrarPontuacao();
        mostrarHistoricoPontuacoes();  // Chama o método para mostrar o histórico
        prepare();
    }
    
    private void prepare()
    {
        VoltarAoMenu voltarAoMenu = new VoltarAoMenu();
        addObject(voltarAoMenu, 293, 201);
        voltarAoMenu.setLocation(516, 347);
        voltarAoMenu.setLocation(530, 335);
    }
    
    // Método para exibir a pontuação final na tela
    private void mostrarPontuacao() {
        GreenfootImage imagem = new GreenfootImage("Pontuação Final: " + pontuacao, 24, Color.RED, Color.BLACK);
        getBackground().drawImage(imagem, 10, 10);
    }

    // Método para exibir o histórico de pontuações
    private void mostrarHistoricoPontuacoes() {
        ArrayList<Integer> historico = Pontuacao.getHistoricoPontuacoes();
        String texto = "Histórico de Pontuação:\n";
        
        // Adiciona as pontuações do histórico à string
        for (int i = 0; i < historico.size(); i++) {
            texto += "Jogo " + (i + 1) + ": " + historico.get(i) + " pontos\n";
        }
        
        GreenfootImage imagem = new GreenfootImage(texto, 24, Color.RED, Color.BLACK);
        getBackground().drawImage(imagem, 10, 40);  // Exibe o histórico abaixo da pontuação final
    }
}
