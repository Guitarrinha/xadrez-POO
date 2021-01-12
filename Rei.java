/* Essa classe é responsável pela chacagem da movimentação do rei e pela setagem de sua cor e representação;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */

public class Rei extends Peca{

    public Rei(String cor) {
        // Cria a peça fazendo com que a situação seja que ela esta em jogo
        setCor(cor);
        // Seta a representação dao Rei
        if(cor.equals("BRANCA")){
            setRepresentacao("♔");
        } else setRepresentacao("♚");

    }

    //Checa se o movimento do rei é válido
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino) {
        if ((Math.abs(linhaOrigem - linhaDestino) == 1) && (Math.abs(colunaOrigem - colunaDestino) == 0)){
            return true;
        } else if ((Math.abs(linhaOrigem - linhaDestino) == 0) && (Math.abs(colunaOrigem - colunaDestino) == 1)){
            return true;
        } else if((Math.abs(linhaOrigem - linhaDestino) == 1) && (Math.abs(colunaOrigem - colunaDestino) == 1)){
            return true;
        } else return false;
    }

}
