/* Essa classe é responsável pela chacagem da movimentação da torre e pela setagem de sua cor e representação;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */

public class Torre extends Peca{


    public Torre(String cor){
        //Cria a peça fazendo com que a situação seja que ela esta em jogo
        setCor(cor);

        //Seta a representação da torre
        if(cor.equals("BRANCA")){
            setRepresentacao("♖");
        } else setRepresentacao("♜");

    }

    //Checa se o movimento da torre é valido
    public boolean checaMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino){
        if((linhaOrigem == linhaDestino) && (colunaOrigem != colunaDestino)){
            return true;
        } else if((linhaOrigem != linhaDestino) && (colunaOrigem == colunaDestino)){
            return true;
        } else return false;
    } 


}
