/* Essa classe é responsável pela chacagem da movimentação do bispo e pela setagem de sua cor e representação;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */



public class Bispo extends Peca{
    

    public Bispo(String cor){
        // Cria a peça fazendo com que a situação seja que ela esta em jogo
        setCor(cor);
        // Seta a representação da torre
        if (cor.equals("BRANCA")) {
            setRepresentacao("♗");
        } else setRepresentacao("♝");
    }

    //Checa se o movimento do Bispo é valido
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {

        if(linhaOrigem == linhaDestino && colunaOrigem == colunaDestino){
            return false;
        }else if ((Math.abs(linhaOrigem - colunaOrigem) == Math.abs(linhaDestino - colunaDestino)) ||  (linhaOrigem + colunaOrigem == linhaDestino + colunaDestino)) {
            return true;
        } else
            return false;
    }

}
