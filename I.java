import greenfoot.*;


public class I extends Actor {
    
    private int velocidade = 3;
    private boolean podeAtirar = true;
    

    public void act() {
        
        verificarColisaoComMortoVivo();
        verificarColisaoComDiabinho();
        verificarColisaoComDiabinho();
        turn(2); 

        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("left")) {
            
            setLocation(getX() - velocidade, getY());
        }

        if (Greenfoot.isKeyDown("d") || Greenfoot.isKeyDown("right")) {
            
            setLocation(getX() + velocidade, getY());
        }
        
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("up")) {
            
            setLocation(getX(), getY() - velocidade);
        }
        
        if (Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("down")) {
            
            setLocation(getX(), getY() + velocidade);
        }

        if (Greenfoot.isKeyDown("shift") && podeAtirar) {
            
            atirarAviaoDePapel();
            Greenfoot.playSound("jogarAviao.mp3");
            podeAtirar = false;
        }
        
        if (!Greenfoot.isKeyDown("shift")) {
            
            podeAtirar = true;
        }
    }

    private void atirarAviaoDePapel() {
        
        AviaoDePapel aviao = new AviaoDePapel();
        getWorld().addObject(aviao, getX(), getY());
        aviao.setRotation(getRotation());
    }
    
    private void verificarColisaoComMortoVivo() {
        Jogo jogo = (Jogo) getWorld();
        MortoVivo mortovivo = (MortoVivo) getOneIntersectingObject(MortoVivo.class);
        
        if (mortovivo != null) {
            Greenfoot.playSound("deathSound.mp3");
            Jogo.music.stop();
            // Chama o método gameOver() da classe Jogo para passar a pontuação para a classe Perdeu
            jogo = (Jogo) getWorld();
            jogo.gameOver();  // Chama o gameOver para mudar para o mundo Perdeu e passar a pontuação
        }
    }
    
    private void verificarColisaoComDiabinho() {
        Jogo jogo = (Jogo) getWorld();
        Diabinho diabinho = (Diabinho) getOneIntersectingObject(Diabinho.class);
        
        if (diabinho != null) {
            Greenfoot.playSound("deathSound.mp3");
            Jogo.music.stop();
            // Chama o método gameOver() da classe Jogo para passar a pontuação para a classe Perdeu
            jogo = (Jogo) getWorld();
            jogo.gameOver();  // Chama o gameOver para mudar para o mundo Perdeu e passar a pontuação
        }
    }
    
    private void verificarColisaoComVampiro() {
        Jogo jogo = (Jogo) getWorld();
        Vampiro vampiro = (Vampiro) getOneIntersectingObject(Vampiro.class);
        
        if (vampiro != null) {
            Greenfoot.playSound("deathSound.mp3");
            Jogo.music.stop();
            // Chama o método gameOver() da classe Jogo para passar a pontuação para a classe Perdeu
            jogo = (Jogo) getWorld();
            jogo.gameOver();  // Chama o gameOver para mudar para o mundo Perdeu e passar a pontuação
        }
    }
}
