import java.util.ArrayList;
import greenfoot.*;

public class Pontuacao extends Actor {
    private int pontos;  // Variável para armazenar a pontuação
    private static ArrayList<Integer> historicoPontuacoes = new ArrayList<>();

    // Construtor da classe
    public Pontuacao() {
        pontos = 0;  // Inicializa a pontuação com 0
    }

    // Método que será chamado a cada atualização do jogo
    public void act() {
        mostrarPontuacao();
    }

    // Método para atualizar a pontuação
    public void adicionarPontos(int pontosAdicionais) {
        pontos += pontosAdicionais;
    }

    // Método para exibir a pontuação na tela
    private void mostrarPontuacao() {
        GreenfootImage imagem = new GreenfootImage("Pontos: " + pontos, 24, Color.RED, Color.BLACK);
        setImage(imagem);  // Atualiza a imagem do actor com o texto da pontuação
    }

    public int getPontos() {
        return pontos;
    }

    // Método para adicionar a pontuação ao histórico no fim do jogo
    public static void salvarPontuacaoFinal(Pontuacao pontuacao) {
        historicoPontuacoes.add(pontuacao.getPontos());  // Adiciona a pontuação final ao histórico
    }

    // Método para obter o histórico de pontuações
    public static ArrayList<Integer> getHistoricoPontuacoes() {
        return historicoPontuacoes;
    }
}


