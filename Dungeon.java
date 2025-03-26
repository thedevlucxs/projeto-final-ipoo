import greenfoot.*;
class Dungeon extends Jogo {
    public Dungeon(Pontuacao pontuacao) {
        super(1028, 587, "Dungeon.png", pontuacao);  // Passa a pontuação para o construtor de Jogo
        Jogar();
    }

    private void Jogar() {
        I personagem = new I();
        addObject(personagem, 650, 325);
    }

    protected void verificarProximaFase() {
        if (pontuacao != null && pontuacao.getPontos() >= 100) {
            Dungeon2 proximoMundo = new Dungeon2(pontuacao);  // Passa a pontuação para Dungeon2
            Greenfoot.setWorld(proximoMundo);
        }
    }
}
