/* Essa classe é responsável pela chacagem da movimentação dama e pela setagem de sua cor e representação;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */

public class Dama extends Peca{
    

    public Dama(String cor){
        // Cria a peça fazendo com que a situação seja que ela esta em jogo
        setCor(cor);
        // Seta a representação da Dama
        if (cor.equals("BRANCA")) {
            setRepresentacao("♕");
        } else setRepresentacao("♛");
    }

    //checa se o movimento da dama é válido
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        if (linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
            return false;
        } else if ((linhaOrigem == linhaDestino) && (colunaOrigem != colunaDestino)) {
            return true;
        } else if ((linhaOrigem != linhaDestino) && (colunaOrigem == colunaDestino)) {
            return true;
        } else if ((Math.abs(linhaOrigem - colunaOrigem) == Math.abs(linhaDestino - colunaDestino)) || (linhaOrigem + colunaOrigem == linhaDestino + colunaDestino)) {
            return true;
        } else
            return false;
    }

}
