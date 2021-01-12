/* Essa classe é responsável pela chacagem da movimentação do Peao e pela setagem de sua cor e representação;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */

public class Peao extends Peca{

    public Peao(String cor){
        // Cria a peça fazendo com que a situação seja que ela esta em jogo
        setCor(cor);
        // Seta a representação do peao
        if (cor.equals("BRANCA")) {
            setRepresentacao("♙");
        } else setRepresentacao("♟");
    }

    //chega se o movimento do peao é valido
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        if(this.getCor().equals("BRANCA")){
                
            if ((colunaDestino == colunaOrigem + 1) && (linhaDestino == linhaOrigem)) {
                return true;
            } else if (linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
                return false;
            } else if (colunaDestino == colunaOrigem + 1 && ((linhaDestino == linhaOrigem + 1) || (linhaDestino == linhaOrigem -1))){
                return true;
            } else if(colunaOrigem == 1){
                if ((colunaDestino == colunaOrigem + 2) && (linhaDestino == linhaOrigem)){
                    return true; 
                }
            } else return false;
        } else {
                
            if ((colunaDestino == colunaOrigem - 1) && (linhaDestino == linhaOrigem)) {
                return true;
            } else if (linhaOrigem == linhaDestino && colunaOrigem == colunaDestino) {
                return false;
            } else if (colunaDestino == colunaOrigem - 1 && ((linhaDestino == linhaOrigem + 1) || (linhaDestino == linhaOrigem -1))){
                return true;
            } else if (colunaOrigem == 6){
                if ((colunaDestino == colunaOrigem - 2) && (linhaDestino == linhaOrigem)){
                    return true;
                }
            } else return false;
        } 
        return false;
    }
    
}
