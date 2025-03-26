import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

class Dungeon2 extends Jogo {
    private int contadorTempoDiabinho = 0;
    private int contadorTempoVampiro = 0;

    // Alteração: agora o construtor de Dungeon2 recebe Pontuacao
    public Dungeon2(Pontuacao pontuacao) {
        super(1028, 587, "Dungeon2.png", pontuacao);  // Passa a pontuação para o construtor de Jogo
        Jogar();
    }

    private void Jogar() {
        I personagem = new I();
        addObject(personagem, 650, 325);
    }

    protected void adicionarDiabinho() {
        Diabinho diabinho = new Diabinho(pontuacao);  // Usa a mesma pontuação
        int xAleatorio = Greenfoot.getRandomNumber(getWidth());
        int yAleatorio = Greenfoot.getRandomNumber(getHeight());
        addObject(diabinho, xAleatorio, yAleatorio);
    }

    protected void adicionarVampiro() {
        Vampiro vampiro = new Vampiro(pontuacao);  // Usa a mesma pontuação
        int xAleatorio = Greenfoot.getRandomNumber(getWidth());
        int yAleatorio = Greenfoot.getRandomNumber(getHeight());
        addObject(vampiro, xAleatorio, yAleatorio);
    }
    
    public void act() {
        super.act();  // Chama o método act() da classe Jogo

        contadorTempoDiabinho++;
        contadorTempoVampiro++;

        if (contadorTempoDiabinho >= 12 * 60) {
            adicionarDiabinho();
            contadorTempoDiabinho = 0;
        }

        if (contadorTempoVampiro >= 16 * 60) {
            adicionarVampiro();
            contadorTempoVampiro = 0;
        }
    }
}



