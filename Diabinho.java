import greenfoot.*;
class Diabinho extends Inimigo {
    private static int contadorDiabinhos = 0;
    
    public Diabinho(Pontuacao pontuacao) {
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
                contadorDiabinhos += 1;
                pontuacao.adicionarPontos(10);  // Atualiza a pontuação ao derrotar o inimigo
                Greenfoot.playSound("somMorteZumbi.mp3");
            }
        }
    }
    
    public static int getContadorDiabinhos(){
        return contadorDiabinhos;
    }
    
    public static void resetContadorDiabinhos(){
        contadorDiabinhos = 0;
    }
}