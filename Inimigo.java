import greenfoot.*;

public class Inimigo extends Actor {
    protected Pontuacao pontuacao;
    protected int pontosDeVida;
    protected int velocidade;
    private static boolean faseMudada = false;

    public Inimigo(Pontuacao pontuacao, int pontosDeVida, int velocidade) {
        this.pontuacao = pontuacao;
        this.pontosDeVida = pontosDeVida;
        this.velocidade = velocidade;
    }

    public void act() {
        moverEmDirecaoAoPersonagem();
        verificarProximaFase();
    }

    protected void moverEmDirecaoAoPersonagem() {
        World mundo = getWorld();

        if (mundo != null && !mundo.getObjects(I.class).isEmpty()) {
            I personagem = (I) mundo.getObjects(I.class).get(0);

            if (personagem != null) {
                turnTowards(personagem.getX(), personagem.getY());
                move(velocidade);
            }
        }
    }

    protected void verificarProximaFase() {
        // Verifica se a pontuação é suficiente para mudar de fase
        if (pontuacao != null && pontuacao.getPontos() >= 10 && !faseMudada) {
            Greenfoot.setWorld(new Dungeon2(pontuacao));  // Passa a pontuação para a próxima fase
            faseMudada = true;
        }
    }

    public static void reiniciarJogo() {
        faseMudada = false;
    }
}
