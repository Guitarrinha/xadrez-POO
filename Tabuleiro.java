import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* Classe responsável por todo tabuleiro, pela validação de movimento das peças, 
 * por mover as peças, 
 * por colocar as peças no tabuleiro 
 * e imprimir o tabuleiro;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */

public class Tabuleiro {

    private Posicao tab[][];

    // Inicia o tabuleiro criando as posições e setando se a posição é branca ou
    // preta, também carrega ou faz um tabuleiro.
    public Tabuleiro(Peca[] brancas, Peca[] pretas, String Selecao) { 
        // Aloca as posiçoes do tabuleiro
        this.tab = new Posicao[8][8];
        int contador = 1;
        // Cria as posições do tabuleiro determinado se a posição é uma casa preta ou
        // branca do chadrez
        for (int i = 0; i < 8; i++) {
            if (contador == 0) {
                contador = 1;
            } else
                contador = 0;
            for (int j = 0; j < 8; j++) {
                if (contador == 1) {
                    tab[i][j] = new Posicao(i, converter(j), "PRETA");
                    contador--;
                } else {
                    tab[i][j] = new Posicao(i, converter(j), "BRANCA");
                    contador++;
                }
            }
        }
        //Verifica se é para fazer um novo tabuleiro ou Carregar um ja salvo
        if (Selecao.equals("NOVO")) {
            // Assim que cria o tabuleiro e arruma as peças em seu devido lugar para o
            // inicio do jogo;
            arrumarPecas(brancas);
            arrumarPecas(pretas);
        } else {
            // Carrega o tabuleiro de um jogo antigo
            carregarTabuleiro(brancas, pretas);
        }
    }

    // retorna posição do tabuleiro
    public Posicao getTab(int i, int j) {
        try {
            return this.tab[i][j];
        } catch (IndexOutOfBoundsException e3) {
            return null;
        }
    }

    // essa função coloca cada peça em seu lugar;
    private void arrumarPecas(Peca[] pecas) {
        // coloca as peças brancas no seu lugar inicial no tabuleiro;
        if (pecas[0].getCor() == "BRANCA") {
            for (int i = 0; i < 8; i++) {
                colocarPeca(i, 1, pecas[i]);
            }
            colocarPeca(0, 0, pecas[8]);
            colocarPeca(7, 0, pecas[9]);
            colocarPeca(1, 0, pecas[10]);
            colocarPeca(6, 0, pecas[11]);
            colocarPeca(2, 0, pecas[12]);
            colocarPeca(5, 0, pecas[13]);
            colocarPeca(3, 0, pecas[14]);
            colocarPeca(4, 0, pecas[15]);
        } else {
            // Coloca as peças pretas no seu luagar inial no tabuleiro;
            for (int i = 0; i < 8; i++) {
                colocarPeca(i, 6, pecas[i]);
            }
            colocarPeca(0, 7, pecas[8]);
            colocarPeca(7, 7, pecas[9]);
            colocarPeca(1, 7, pecas[10]);
            colocarPeca(6, 7, pecas[11]);
            colocarPeca(2, 7, pecas[12]);
            colocarPeca(5, 7, pecas[13]);
            colocarPeca(3, 7, pecas[14]);
            colocarPeca(4, 7, pecas[15]);

        }
    }

    //Função que carrega o tabuleiro de um jogo antigo
    private void carregarTabuleiro(Peca[] brancas, Peca[] pretas) {

        String[][] tabEmString = new String[8][8];

        //Numeração de casa peça para o acesso do vetor de peças
        int peaob = 0, peaop = 0, torreb = 8, torrep = 8, cavalob = 10, cavalop = 10;
        int bispob = 12, bispop = 12, dama = 14, rei = 15;  
        

        try {
            //Carrega o arquivo
            FileInputStream arquivo = new FileInputStream("Tabuleiro.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);
            String representacao;

            //Faz a leitura do arquivo
            for (int i = 0; i < 8; i++) {
                representacao = br.readLine();
                for (int j = 0; j < 8; j++) {
                    tabEmString[i][j] = Character.toString(representacao.charAt(j));

                }
            }

            //Coloca as peças no tabuleiro a onde estava marcado no arquivo;
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(tabEmString[i][j].equals("♙")){
                        colocarPeca(i, j, brancas[peaob]);
                        peaob++;
                    } else if (tabEmString[i][j].equals("♟")){
                        colocarPeca(i, j, pretas[peaop]);
                        peaop++;
                    } else if(tabEmString[i][j].equals("♖")){
                        colocarPeca(i, j, brancas[torreb]);
                        torreb++;
                    } else if(tabEmString[i][j].equals("♜")){
                        colocarPeca(i, j, pretas[torrep]);
                        torrep++;
                    } else if(tabEmString[i][j].equals("♘")){
                        colocarPeca(i, j, brancas[cavalob]);
                        cavalob++;
                    } else if(tabEmString[i][j].equals("♞")){
                        colocarPeca(i, j, pretas[cavalop]);
                        cavalop++;
                    } else if(tabEmString[i][j].equals("♗")){
                        colocarPeca(i, j, brancas[bispob]);
                        bispob++;
                    } else if(tabEmString[i][j].equals("♝")){
                        colocarPeca(i, j, pretas[bispop]);
                        bispop++;
                    } else if(tabEmString[i][j].equals("♕")){
                        colocarPeca(i, j, brancas[dama]);
                    } else if(tabEmString[i][j].equals("♛")){
                        colocarPeca(i, j, pretas[dama]);
                    } else if(tabEmString[i][j].equals("♔")){
                        colocarPeca(i, j, brancas[rei]);
                    } else if(tabEmString[i][j].equals("♚")){
                        colocarPeca(i, j, pretas[rei]);
                    }
                }
            }


        } catch (Exception e) {
            System.out.println("Erro ao Carregar Tabuleiro");
            System.out.println("Não se preocupe, faremos um novo tabuleiro pra você");
            arrumarPecas(brancas);
            arrumarPecas(pretas);
        }
    }

    // Função para colocar uma peça numa posição do tabuleiro;
    private void colocarPeca(int i, int j, Peca peca) {
        getTab(i, j).setPeca(peca);
        getTab(i, j).setOcupada(true);
        peca.setEmJogo(true);
    }

    // função que limpa uma casa tirando a peça de lá;
    private void limpaCasa(int i, int j) {
        getTab(i, j).setOcupada(false);
        getTab(i, j).setPeca(null);
    }

    // função que capitura uma peça
    private Boolean capiturarPeca(int linhaDestino, int colunaDestino, Peca p) {
        // Se a casa esta ocupada por uma peça de cor igual e quisermos capiturala não
        // conseguimos
        if (getTab(linhaDestino, colunaDestino).getOcupada()
                && getTab(linhaDestino, colunaDestino).getPeca().getCor() != p.getCor()) {
            if (getTab(linhaDestino, colunaDestino).getPeca() instanceof Rei) {
                System.out.println("\n");
                System.out.println("Xeque Mate!!!");
                System.out.println("O Jogo acabou");
                if (p.getCor().equals("BRANCA")) {
                    System.out.println("O Jogador 1 ganhou!!!");
                } else
                    System.out.println("O jogador 2 ganhou!!");
                System.exit(0);
            }
            // tira a peça do jogo
            getTab(linhaDestino, colunaDestino).getPeca().setEmJogo(false);
            // limpa a casa para receber a nova peça
            limpaCasa(linhaDestino, colunaDestino);
            return true;
        } else
            return false;
    }

    // função que move uma peça
    public Boolean moverPeca(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, Jogador jogador) {
        // verifica se o jogador escolheu uma peça que é sua;
        if (getTab(linhaOrigem, colunaOrigem).getOcupada()
                && getTab(linhaOrigem, colunaOrigem).getPeca().getCor() == jogador.getCor()) {
            // Se o movimento for válido realizamos o mesmo;
            if (validarMovimento(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino,
                    getTab(linhaOrigem, colunaOrigem).getPeca())) {
                // Colcoa a peça na sua posição de Destino;
                colocarPeca(linhaDestino, colunaDestino, getTab(linhaOrigem, colunaOrigem).getPeca());
                // Tira a peça da sua posição Original;
                limpaCasa(linhaOrigem, colunaOrigem);
                // Retorna true pois o movimento aconteceu;
                return true;
            } else
                System.out.println("Esse movemento é inválido, tente novamente!!");
        } else
            System.out.println("Essa peça não é sua, tente novamente!!");
        // retorna false se o movimento não aconteceu;
        return false;
    }

    // Função que Valida um movimento;
    private boolean validarMovimento(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, Peca p) {
        // Se o movimento da peça foi válido e se o seu caminho estar livre retorna
        // true;
        if (p.checaMovimento(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino)
                && checaCaminho(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, p))
            return true;
        // Se o movimento não for válido retorna false;
        return false;
    }

    // fumção que checa se um caminho estpá livre para a movimentação;
    private boolean checaCaminho(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, Peca p) {

        // checa o caso do peão;
        if (p instanceof Peao) {
            // se o destino do peão estiver ocupado por uma peça da sua cor retorna false;
            if ((getTab(linhaDestino, colunaDestino).getOcupada()
                    && getTab(linhaDestino, colunaDestino).getPeca().getCor() == p.getCor())) {
                return false;
                // se o peão for andar para frente e seu destino estiver ocupado retorna false;
            } else if ((linhaOrigem == linhaDestino) && getTab(linhaDestino, colunaDestino).getOcupada()) {
                return false;
                // Se o seu destino não estiver ocupado por uma peça da sua mesma cor e se o
                // movimento não foi para frente, capitura a peça da sua diagonal;
                // Se a diagonal estiver desocupado a própria função capiturarPeca retornara
                // false;
            } else if (getTab(linhaDestino, colunaDestino).getOcupada())
                return capiturarPeca(linhaDestino, colunaDestino, p);
            // Checa o Caso do cavalo
        } else if (p instanceof Cavalo) {
            // Se a casa final do Cavalo estiver ocupada por uma peça de cor diferente do
            // mesmo ele capitura a peça;
            if (getTab(linhaDestino, colunaDestino).getOcupada()
                    && getTab(linhaDestino, colunaDestino).getPeca().getCor() != p.getCor()) {
                return capiturarPeca(linhaDestino, colunaDestino, p);
                // Se a casa fional do Cavalo estiver sento ocupada por uma peça de cor igual do
                // mesmo retorna false pois o movimento é inválido;
            } else if (getTab(linhaDestino, colunaDestino).getOcupada()) {
                return false;
            }
            // Casos de movimentação Geral;
        } else {
            int inicio;
            int fim;
            // Caso a peça se movimentar Horizontalmente;
            if (linhaOrigem == linhaDestino) {
                // Verifica se a Origem ou o destino é maior para criar uma constante para andar;
                // pelas casas no for;
                if (colunaOrigem < colunaDestino) {
                    inicio = colunaOrigem;
                    fim = colunaDestino;
                } else {
                    inicio = colunaDestino;
                    fim = colunaOrigem;
                }
                // Checa se alguma casa do caminho horizontal está ocupada;
                for (int j = inicio + 1; j < fim; j++) {
                    try {
                        // Se estiver ocupada retorna false;
                        if (getTab(linhaOrigem, j).getOcupada()) {
                            return false;
                        }
                    } catch (IndexOutOfBoundsException e1) {
                        continue;
                    }
                }
                // Caso a peça se mova Verticalmente
            } else if (colunaOrigem == colunaDestino) {
                // Verifica se a Origem ou o destino é maior para criar uma constante para andar
                // pelas casas no for;
                if (linhaOrigem < linhaDestino) {
                    inicio = linhaOrigem;
                    fim = linhaDestino;
                } else {
                    inicio = linhaDestino;
                    fim = linhaOrigem;
                }
                // Checa se alguma casa do caminho vertical está ocupada;
                for (int i = inicio + 1; i < fim; i++) {
                    try {
                        // Se estiver ocupada retorna false;
                        if (getTab(i, colunaOrigem).getOcupada()) {
                            return false;
                        }
                    } catch (IndexOutOfBoundsException e2) {
                        continue;
                    }
                }
                // Caso seja um movimento em diagonal;
            } else {
                int colunaInicio;
                int linhaInicio;
                int linhaFim;
                // Verifica se a Origem ou o destino é maior para criar uma constante para andar
                // pelas casas no for;
                if (colunaOrigem < colunaDestino) {
                    colunaInicio = colunaOrigem;
                } else
                    colunaInicio = colunaDestino;
                if (linhaOrigem < linhaDestino) {
                    linhaInicio = linhaOrigem;
                } else
                    linhaInicio = linhaDestino;
                if (linhaOrigem > linhaDestino) {
                    linhaFim = linhaOrigem;
                } else
                    linhaFim = linhaDestino;

                // Checa quais das duas diagonais é o movimento;

                if (linhaDestino - linhaOrigem < 0 && colunaDestino - colunaOrigem < 0
                        || linhaDestino - linhaOrigem > 0 && colunaDestino - colunaOrigem > 0) {
                    // anda pela diagonal do movimento;
                    for (int j = colunaInicio + 1, i = linhaInicio + 1; i < linhaFim; i++, j++) {
                        // se alguma casa do caminho estiver ocupada retorna false;
                        if (getTab(i, j).getOcupada()) {
                            return false;
                        }
                    }
                } else if (linhaDestino - linhaOrigem < 0 && colunaDestino - colunaOrigem > 0
                        || linhaDestino - linhaOrigem > 0 && colunaDestino - colunaOrigem < 0) {
                    // anda pela diagonal do movimento;
                    for (int j = colunaInicio + 1, i = linhaFim - 1; i > linhaInicio; i--, j++) {
                        // se alguma casa do caminho estiver ocupada retorna false;
                        if (getTab(i, j).getOcupada()) {
                            return false;
                        }
                    }
                }
            }
            // Se nenhuma das situações a cima tiver acontecido que dizer que o caminho está;
            // livre;
            // Se a posição final estiver ocupada por uma cor diferente a mesma capitura ela;
            if (getTab(linhaDestino, colunaDestino).getOcupada()
                    && getTab(linhaDestino, colunaDestino).getPeca().getCor() != p.getCor()) {
                // Capitua a peça da posição final
                return capiturarPeca(linhaDestino, colunaDestino, p);
                // Se a posição final estiver ocupada por uma peça da mesma cor da mesma retorna;
                // false;
            } else if (getTab(linhaDestino, colunaDestino).getOcupada()
                    && getTab(linhaDestino, colunaDestino).getPeca().getCor() == p.getCor())
                return false;
        }
        // Se chegamos até aqui não tem nenhuma peça no caminho do movimento e retorna;
        // true;
        return true;
    }

    //Salva o Tabuleiro num Arquivo
    public Boolean salvarTabuleiro() {

        //Carrega o arquivo onde salvamos o Tabuleiro;
        File arquivo = new File("Tabuleiro.txt");

        try {
            //Se o arquivo não existir criamos ele;
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }

            FileWriter fw = new FileWriter(arquivo, false);

            //Escreve no arquivo a representação da peça a onde ela está no tabuleiro e escreve x a onde não existe peça;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    if (this.tab[i][j].getOcupada()) {
                        Posicao casa = this.tab[i][j];
                        fw.write(casa.getPeca().getRepresentacao());
                    } else
                        fw.write("x");
                }
                fw.write("\n");
            }
            fw.close();

            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    // Imprime o tabuleiro mostrando se a casa é branca ou preta e mostrando as
    // peças;
    public void imprimeTabuleiro() {
        System.out.printf("  ");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%d ", i + 1);
        }
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            System.out.print(converter(i));
            System.out.print(" ");
            for (int j = 0; j < 8; j++) {
                Posicao casa = this.tab[i][j];
                if (casa.getOcupada()) {
                    System.out.printf(casa.getPeca().getRepresentacao() + " ");
                } else if (casa.getCor().equals("BRANCA")) {
                    System.out.printf("x ");
                } else
                    System.out.printf("o ");
            }
            System.out.println("");
        }
    }

    // comverte int para char
    public char converter(int i) {
        return (char) (i + 'A');
    }
}
