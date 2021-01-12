/* Classe responsável pela posição do tabuleiro, guarda se ela está ocupada, a cor da posição, a peça que está ocupando ela, e sua localização;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */

public class Posicao {
    
    private boolean ocupada;
    private String cor;
    private Peca peca;
    private int linha;
    private char coluna;

    //Cria as posições com sua cor
    public Posicao(int lin, char colun, String cor){
        setLinha(lin);
        setColuna(colun);
        setCor(cor);
        setOcupada(false);
    }

    public boolean getOcupada() {
        return this.ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public String getCor() {
        return this.cor;
    }

    private void setCor(String cor) {
        this.cor = cor;
    }

    public Peca getPeca() {
        //Se a posiçao estiver ocupada retorna a peça que está nela;
        if(getOcupada()){
            return this.peca;
            //Se não tiver peça naquela posicao retorna null;
        } else return null;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    private void setLinha(int linha) {
        this.linha = linha;
    }

    private void setColuna(char coluna) {
        this.coluna = coluna;
    }
    
}
