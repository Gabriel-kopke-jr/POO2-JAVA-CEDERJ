package pooAd2.loja;

public class Produto {
    private String nome;
    private int quantity;

    public String getNome() {
        return nome;
    }

    public int getQuantity() {
        return quantity;
    }

    public Produto(String nomeAndQuantity){
        if(nomeAndQuantity.contains(";")){
           this.nome =  nomeAndQuantity.split(";")[0];
           this.quantity = Integer.parseInt(nomeAndQuantity.split(";")[1]);
        }

    }

}
