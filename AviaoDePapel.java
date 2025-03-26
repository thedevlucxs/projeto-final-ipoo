import greenfoot.*;


public class AviaoDePapel extends Actor {
    
    private int velocidade = 5;
    private int tempoDeVida = 0;
    private int tempoMaximo = 270;

    public void act() {
        
        move(velocidade); 
        tempoDeVida++;

        if (tempoDeVida >= tempoMaximo || isAtWorldEdge()) {
            
            removeThis();
        }
    }

    private boolean isAtWorldEdge() {
        
        return getX() <= 0 || getX() >= getWorld().getWidth() || 
               getY() <= 0 || getY() >= getWorld().getHeight();
    }

    private void removeThis() {
        
        if (getWorld() != null) {
            
            getWorld().removeObject(this);
        }
    }
}





