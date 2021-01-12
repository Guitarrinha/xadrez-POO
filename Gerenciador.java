import java.util.Scanner;

/* Classe principal, ela deve disparar o jogo coletando se o jogador quer carregar o ultimo jogo 
 * ou começar um novo jogo coletando o nome dos jogadores e iniciando o jogo com os mesmos;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */
 
public class Gerenciador {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        
        System.out.println("Bem Vindo a este LINDO jogo De Xadrez!!\n");
        System.out.println("Se voce quizer começar um novo jogo digite Novo");
        System.out.println("Se voce quiser carregar seu ultimo jogo digite Carregar");

      
        String selecao;
        selecao = scan.nextLine();

        if (selecao.equals("Novo")) {
            
            String jogador1, jogador2;
                System.out.println("");
                System.out.println("Digite o nome do jogador 1:");
                jogador1 = scan.nextLine();
                System.out.println("");
                System.out.println("Digite o nome do jogador 2:");
                jogador2 = scan.nextLine();

            Jogo xadrez = new Jogo(jogador1, jogador2);

        } else if (selecao.equals("Carregar")) {
            Jogo xadrez = new Jogo();
        }

        
    }
}
