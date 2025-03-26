import greenfoot.*;
class MortoVivo extends Inimigo {

    public MortoVivo(Pontuacao pontuacao) {
        super(pontuacao, 20, 2);
    }
    
    public void act(){
        super.act();
        verificarColisao();
    }
    
    protected void verificarColisao() {
        AviaoDePapel aviao = (AviaoDePapel) getOneIntersectingObject(AviaoDePapel.class);

        if (aviao != null) {
            pontosDeVida -= 10;
            getWorld().removeObject(aviao);

            if (pontosDeVida <= 0) {
                getWorld().removeObject(this);
                pontuacao.adicionarPontos(10);  // Atualiza a pontuação ao derrotar o inimigo
                Greenfoot.playSound("somMorteZumbi.mp3");
            }
        }
    }
}
