package lection2;

import java.io.File;

public class task1 {

    public static void main(String[] args) {

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < 1_000_000; i++){
            str.append("+");

        }


        String[] name = {"C","e","r","g","e","y"};
        String sk = "SERGEY KA";
        System.out.println(String.join("",name));
        System.out.println(sk.toLowerCase());
        System.out.println(String.join("","S","e","r","a"));
        System.out.println(String.join(",","S","e","r","a"));


        //Работа с файлами

        String pathProject = System.getProperty("user.dir");
        String pathDir = pathProject.concat("/files");//catalog
        File dir = new File(pathDir);
        System.out.println(dir.getAbsolutePath());
        if(dir.mkdir()){ 
            //проверяем нет ли такого уже каталога
            System.out.println("+");
        }else{
            System.out.println("-");
        }for(String fname: dir.list()){
            System.out.println(fname);
        }



    }
    
}
