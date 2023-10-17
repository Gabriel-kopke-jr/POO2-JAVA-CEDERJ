import pooAd2.loja.Loja;
import pooAd2.loja.FileSearcher;
import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
    Scanner reader = new Scanner(System.in);
    FileSearcher fileSearcher = new FileSearcher();
    int numberStores = fileSearcher.getNumberStores();
    Loja[] lojas = new Loja[numberStores];
    int counter = 0;
    System.out.println("Seja bem-vindo(a)!");
    for(int i =0; i< fileSearcher.getNumberStores();i++) {
        System.out.print("Informe um arquivo de inventário, ou “fim” para encerrar:");
        final String option = reader.nextLine();
        if(option.equalsIgnoreCase("fim")){
            break;

        }
        Loja loja = new Loja(option);
        lojas[i] = loja;
        counter++;

    }
    String conditional = "1";
    while(!conditional.equalsIgnoreCase("0")){
        System.out.print("Informe um produto, ou 0 para encerrar:");
        String produto = reader.nextLine();
        if (produto.equalsIgnoreCase("0")){
            conditional = "0";
            reader.close();

        }
        else {
            int productInStock = 0;
            for(int i =0; i < counter;i++){

                String productMinusculo = produto.toLowerCase(Locale.ROOT).strip();
                int quantityProduct = lojas[i].getQuantityStock(productMinusculo);
                System.out.println(quantityProduct + " unidades em " + lojas[i].getNomeLoja());
                productInStock = productInStock + quantityProduct;
            }
            System.out.println(productInStock + " unidades no total");
        }
    }





    }
}