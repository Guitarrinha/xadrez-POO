/* Essa classe é responsável pela chacagem da movimentação do cavalo e pela setagem de sua cor e representação;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */

public class Cavalo extends Peca{
    

    public Cavalo(String cor){
        // Cria a peça fazendo com que a situação seja que ela esta em jogo
        setCor(cor);
        // Seta a representação da cavalo
        if (cor.equals("BRANCA")) {
            setRepresentacao("♘");
        } else setRepresentacao("♞");
    }

    // Checa se o movimento do cavalo é válido
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {

        if (Math.abs(linhaOrigem - linhaDestino) == 2 && Math.abs(colunaOrigem - colunaDestino) == 1) {
            return true;
        } else if (Math.abs(linhaOrigem - linhaDestino) == 1 && Math.abs(colunaOrigem - colunaDestino) == 2) {
            return true;
        } else
            return false;
    }
}
