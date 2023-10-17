package pooAd2.loja;

import java.io.File;

public class FileSearcher {
    private int numberStores;
    File directory = new File("src/pooAd2/loja");

    public FileSearcher(){
        this.numberStores = countStores();
    }

    public int getNumberStores() {
        return numberStores;
    }

    public String[] listFilesTxt(){
        return this.searchFiles();
    }
    private int  countStores(){
        int count = 0;
        File[] files = directory.listFiles();
        for(int i =0; i < files.length;i++){
            if(files[i].getName().contains(".txt")){
                count++;
        }
    }
        return count;

    }

    private String[] searchFiles(){
        File[] files = directory.listFiles();
        int numberStores = this.countStores();
        String[] filesTxt = new String[numberStores];
        for(int i =0; i < files.length;i++){
            if(files[i].getName().contains(".txt")){
                for(int j =0; j < filesTxt.length;j++){
                    if (filesTxt[j] == null){
                        filesTxt[j] = files[i].getName();
                        break;
                    }
                }
            }
            }
        return filesTxt;
    }


}
