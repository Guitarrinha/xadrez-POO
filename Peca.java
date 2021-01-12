/* Essa classe é responssável pela peça, ela é responsável por guardar sua cor, sua representação e se a peça está em jogo,
 * A classe é abstrata pois temos que usar o metodo abstrato checaMovimento que existe em todo tipo de peça;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */

public abstract class Peca {
    private String cor;
    private boolean emJogo;
    private String representacao;

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean getEmJogo() {
        return this.emJogo;
    }

    public void setEmJogo(boolean emJogo) {
        this.emJogo = emJogo;
    }


    public String getRepresentacao() {
        return this.representacao;
    }

    public void setRepresentacao(String representacao) {
        this.representacao = representacao;
    }

   public abstract boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino);

}

    