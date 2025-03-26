import greenfoot.*;
class Vampiro extends Inimigo {
    private static int contadorVampiros = 0;

    public Vampiro(Pontuacao pontuacao) {
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
                contadorVampiros += 1;
                pontuacao.adicionarPontos(10);  // Atualiza a pontuação ao derrotar o inimigo
                Greenfoot.playSound("somMorteZumbi.mp3");
            }
        }
    }
    
    public static int getContadorVampiros(){
        return contadorVampiros;
    }
    
    public static void resetContadorVampiros(){
        contadorVampiros = 0;
    }
}