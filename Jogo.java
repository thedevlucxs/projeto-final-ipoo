import greenfoot.*;

public class Jogo extends World {
    protected int contadorTempo = 0;
    protected GreenfootImage background;
    protected static GreenfootSound music = new GreenfootSound("backgroundsound.mp3");
    protected Pontuacao pontuacao;

    public Jogo(int largura, int altura, String imagemFundo, Pontuacao pontuacao) {
        super(largura, altura, 1);
        background = new GreenfootImage(imagemFundo);
        setBackground(background);
        this.pontuacao = pontuacao;  // Atribui a instância passada
        addObject(pontuacao, 100, 30); // Exibe a pontuação no mundo
    }

    public void act() {
        contadorTempo++;
        music.playLoop();
        verificarVitoria();

        if (contadorTempo >= 8 * 60) {
            adicionarMortoVivo();
            contadorTempo = 0;
        }
    }

    protected void adicionarMortoVivo() {
        MortoVivo mortoVivo = new MortoVivo(pontuacao);
        int xAleatorio = Greenfoot.getRandomNumber(getWidth());
        int yAleatorio = Greenfoot.getRandomNumber(getHeight());
        addObject(mortoVivo, xAleatorio, yAleatorio);
    }
    
    protected void verificarVitoria(){
        if ((Diabinho.getContadorDiabinhos() == 5) && (Vampiro.getContadorVampiros() == 5)){
            music.stop();
            Greenfoot.playSound("Venceu.mp3");
            Pontuacao.salvarPontuacaoFinal(pontuacao);
            Greenfoot.setWorld(new Venceu(pontuacao.getPontos()));
        }
    }

    public void gameOver() {
        music.stop();
        Pontuacao.salvarPontuacaoFinal(pontuacao);  // Passa a instância de Pontuacao para salvar a pontuação
        Greenfoot.setWorld(new Perdeu(pontuacao.getPontos()));  // Passa a pontuação final para a tela de "Perdeu"
    }
}
