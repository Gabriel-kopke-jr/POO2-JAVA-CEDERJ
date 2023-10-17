package pooAd2.loja;

import java.io.*;
import java.util.Scanner;

public class Loja {
    private String nomeLoja;
    private Produto[] produtos = new Produto[3];

    public String getNomeLoja() {
        return nomeLoja;
    }

    public Loja(String nomeLoja) throws IOException {
        this.loadInfo(nomeLoja);
    }

    private void loadInfo(String nomeLoja) throws IOException {

        FileSearcher fileSearcher = new FileSearcher();
        String[] filesTxt =  fileSearcher.listFilesTxt();
        if (this.checkIsNameLoja(nomeLoja,filesTxt)){
           this.loadInfoLoja(nomeLoja);
        }
        };

    private void fillProdutos(Produto produto){
       for(int i =0; i < produtos.length; i++ ){
           if (this.produtos[i] == null){
               this.produtos[i] = produto;
               break;
           }
        }
    }
    private Produto findByName(String nomeProduto){
        for (int i=0; i < produtos.length;i++){
           Produto comparable = this.produtos[i];
           if (comparable.getNome().toLowerCase().strip().equalsIgnoreCase(nomeProduto)){
               return comparable;
           }
        }
        return null;
    }

    public int getQuantityStock(String nomeProduto){
        Produto produto = findByName(nomeProduto);
        if (produto != null){
            return produto.getQuantity();
        }
        else return 0;
    }

    private boolean checkIsNameLoja(String nomeLoja, String[] lojas){
        for(int i=0; i< lojas.length;i++){
            if(lojas[i].equalsIgnoreCase(nomeLoja)){
                return true;
            }
        }
        return false;
    }

    private void loadInfoLoja(String nomeLoja) throws IOException {
        final String nameFile = "src/pooAd2/loja/" + nomeLoja;
        File file = new File(nameFile);
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while((line = bufferedReader.readLine()) != null){
            if (!line.contains(";")){
                this.nomeLoja = line;
            }
            else{
                Produto produto = new Produto(line);
                fillProdutos(produto);

            }
        }
        bufferedReader.close();
    }


}
