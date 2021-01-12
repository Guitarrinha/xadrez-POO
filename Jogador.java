/* Essa classe é responsavel pelo jogador guardando suas peças seu nome e sua cor;
 * @autor: Gustavo de Jesus Rodrigues Silva;
 * @RA: 771021;
 */


public class Jogador {
    
    private String nome;
    private String cor;
    private Peca[] pecas = new Peca[16];
    
    public Jogador(String nome, String cor, Peca[] pecas){
        setNome(nome);
        setCor(cor);
        setPecas(pecas);
    }
    

    public String getNome() {
        return this.nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return this.cor;
    }

    private void setCor(String cor) {
        this.cor = cor;
    }

    public Peca[] getPecas() {
        return this.pecas;
    }

    private void setPecas(Peca[] pecas) {
        this.pecas = pecas;
    }


}
