import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* Essa classe é responsavel  por tudo que acontece no jogo, faz a movimentação, troca de turno e etc...;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
*/

public class Jogo {

    private Tabuleiro tab;
    private Scanner scan = new Scanner(System.in);
    private Jogador Jogador1;
    private Jogador Jogador2;
    private int turno;

    // cria o jogo setando os nomes do jogador e cria o tabuleiro
    public Jogo(String nomeJogador1, String nomeJogador2) {

        novoJogo(nomeJogador1, nomeJogador2);
    }

    public Jogo() {
        carregarJogo();
    }

    public Jogador getJogador1() {
        return this.Jogador1;
    }

    private void setJogador1(Jogador jogador1) {
        this.Jogador1 = jogador1;
    }

    public Jogador getJogador2() {
        return this.Jogador2;
    }

    private void setJogador2(Jogador jogador2) {
        this.Jogador2 = jogador2;
    }

    public Tabuleiro getTab() {
        return this.tab;
    }

    private void setTab(Tabuleiro tab) {
        this.tab = tab;
    }

    private int getTurno() {
        return this.turno;
    }

    private void setTurno(int turno) {
        this.turno = turno;
    }

    // inicia um novo jogo;
    public void novoJogo(String jogador1, String jogador2) {

        // Cria o jogador1 com suas peças;
        Jogador player1 = new Jogador(jogador1, "BRANCA", fazerPecas("BRANCA"));
        setJogador1(player1);

        // Cria o Jogador2 com suas peças
        Jogador player2 = new Jogador(jogador2, "PRETA", fazerPecas("PRETA"));
        setJogador2(player2);

        // Cria um novo tabuleiro colocando as peças dos jogadores em sua devida
        // posição;
        Tabuleiro novoTabuleiro = new Tabuleiro(getJogador1().getPecas(), getJogador2().getPecas(), "NOVO");
        setTab(novoTabuleiro);

        // Seta o turno antes de começar o jogo
        setTurno(1);

        // inicia o jogo;
        jogar();

    }


    // Caarrega o ultimo jogo salvo
    public void carregarJogo() {
        try {
            // Carrega o arquivo a onde o Jogo foi salvo;
            FileInputStream arquivo = new FileInputStream("jogo.txt");
            InputStreamReader input = new InputStreamReader(arquivo);
            BufferedReader br = new BufferedReader(input);

            String nome1, nome2;

            // Copia o Nome do Jogador 1
            nome1 = br.readLine();

            Jogador player1 = new Jogador(nome1, "BRANCA", fazerPecas("BRANCA"));
            setJogador1(player1);

            // Copia o nome do Jogador 2
            nome2 = br.readLine();

            // Cria o Jogador2 com suas peças
            Jogador player2 = new Jogador(nome2, "PRETA", fazerPecas("PRETA"));
            setJogador2(player2);

            // Carrega o tabuleiro
            Tabuleiro novoTabuleiro = new Tabuleiro(getJogador1().getPecas(), getJogador2().getPecas(), "CARREGAR");
            setTab(novoTabuleiro);

            // Copia o turno e o transforma em int
            int turno = Integer.parseInt(br.readLine());

            // Seta o turno antes de começar o jogo
            setTurno(turno);

            br.close();

            // inicia o jogo;
            jogar();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao Carregar Jogo");
        }
    }

    private void jogar() {
        String linhaOrigem;
        int colunaOrigem;
        String linhaDestino;
        int colunaDestino;
        System.out.println("");
        System.out.println("Dica: Todas as jogadas são feitas com letra maiúscula, deixe seu capslock ligado!!");
        System.out.println("Dica: Digite X nas capituras de linha quando quiser sair do jogo");
        System.out.println("");
        System.out.println("Digite C para continuar ou X para sair");
        linhaOrigem = scan.next();
        // imprime o Tabuleiro inicial
        tab.imprimeTabuleiro();
        while (!linhaOrigem.equals("X")) {
            // Checa de quem é a vez
            switch (getTurno()) {
                case 1:
                    do {

                        // Capitura a jogada do jogador 1
                        System.out.println("É a vez do jogardor(a): " + getJogador1().getNome());
                        System.out.print("Digite a Linha da peça que voce quer mover: ");
                        linhaOrigem = scan.next();
                        if (linhaOrigem.equals("X"))
                            sair();
                        System.out.println("");
                        System.out.print("Digite a coluna da peça que voce quer mover: ");
                        colunaOrigem = scan.nextInt();
                        System.out.println("");
                        System.out.print("Digite a Linha da Casa da sua jogada: ");
                        linhaDestino = scan.next();
                        if (linhaDestino.equals("X"))
                            sair();
                        System.out.println("");
                        System.out.print("Digite a Coluna Da Casa da sua jogada: ");
                        colunaDestino = scan.nextInt();
                        // Faz a jogada do Jogador1
                        fazerJogada(converteParaInt(linhaOrigem), colunaOrigem - 1, converteParaInt(linhaDestino),
                                colunaDestino - 1, getJogador1());
                        // Se não mudou o turno, a jogada foi inválida, e o vez continua com o mesmo
                        // jogador;
                    } while (getTurno() == 1);
                    break;
                case 2:
                    do {

                        // Capitura a jogada do Jogador2
                        System.out.println("É a vez do jogardor(a): " + getJogador2().getNome());
                        System.out.print("Digite a Linha da peça que voce quer mover: ");
                        linhaOrigem = scan.next();
                        if (linhaOrigem.equals("X"))
                            sair();
                        System.out.println("");
                        System.out.print("Digite a coluna da peça que voce quer mover: ");
                        colunaOrigem = scan.nextInt();
                        System.out.println("");
                        System.out.print("Digite a Linha da Casa da sua jogada: ");
                        linhaDestino = scan.next();
                        if (linhaDestino.equals("X"))
                            sair();
                        System.out.println("");
                        System.out.print("Digite a Coluna Da Casa da sua jogada: ");
                        colunaDestino = scan.nextInt();

                        // Faz a jogada do jogador2
                        fazerJogada(converteParaInt(linhaOrigem), colunaOrigem - 1, converteParaInt(linhaDestino),
                                colunaDestino - 1, getJogador2());
                        // Se não mudou o turno, a jogada foi inválida, e o vez continua com o mesmo
                        // jogador;
                    } while (getTurno() == 2);
                    break;
            }
        }
    }

    // Faz a Jogada;
    private void fazerJogada(int linhaOrigem, int colunaOrigem, int linhaDestino, int colunaDestino, Jogador jogador) {
        // Checa se o movimento está dentro do tabuleiro;
        try {
            // Move a peça;
            if (tab.moverPeca(linhaOrigem, colunaOrigem, linhaDestino, colunaDestino, jogador)) {
                // Se ocorreu o movimento troca de turno;
                if (getTurno() == 1) {
                    setTurno(2);
                } else
                    setTurno(1);
                tab.imprimeTabuleiro();
            }
        } catch (NullPointerException e5) {
            System.out.println("A casa selecionada para a jogada não está no tabuleiro");
        }
    }

    // Faz a peça dos jogadores
    private Peca[] fazerPecas(String cor) {

        Peca[] peca = new Peca[16];

        for (int i = 0; i < 16; i++) {
            if (i < 8) {
                peca[i] = new Peao(cor);
            } else if (i < 10) {
                peca[i] = new Torre(cor);
            } else if (i < 12) {
                peca[i] = new Cavalo(cor);
            } else if (i < 14) {
                peca[i] = new Bispo(cor);
            } else if (i == 14) {
                peca[i] = new Dama(cor);
            } else if (i == 15) {
                peca[i] = new Rei(cor);
            }
        }
        return peca;
    }

    private Boolean salvarJogo() {

        // Abre o arquivo Jogo;
        File arquivo = new File("jogo.txt");
        tab.salvarTabuleiro();

        try {
            if (!arquivo.exists()) {
                arquivo.createNewFile();
            }
            FileWriter fw = new FileWriter(arquivo, false);
            fw.write(getJogador1().getNome() + "\n" + getJogador2().getNome() + "\n" + getTurno());
            fw.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    // função para sair do jogo;
    private void sair() {

        String escolha;

        System.out.println("");
        System.out.println("");
        System.out.println("Voce deseja Salvar o jogo para continuar depois?");
        System.out.println("Digite SIM ou NAO");

        escolha = scan.next();

        // Salva o jogo se o Jogador quiser continuar depois
        if (escolha.equals("SIM")) {
            if (salvarJogo()) {
                System.out.println("O Jogo foi Salvo");
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    // Conversor de char para int;
    private int converteParaInt(String charconv) {
        char a = charconv.charAt(0);
        int b = (int) (a - 'A');
        return b;
    }
}