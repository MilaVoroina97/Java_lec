
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
// import java.util.stream.Collectors;
// import java.lang.Math;




public class task2 {
    static public void wr(String file, String pol){
        try(FileWriter fw = new FileWriter(file,false)){
            fw.write(pol);
            fw.flush();
            System.out.println("Запись успешно добавлена");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
//     static public String[] rd(String file) throws Exception{
//         List<String> listofStrings = new ArrayList<>();
//         BufferedReader fr = new BufferedReader(new FileReader(file));
//             String line = fr.readLine();
//             while(line != null){
//                 listofStrings.add(line);
//                 line = fr.readLine();
//             }
//             fr.close();
//             String[] arr = listofStrings.toArray(new String[0]);
//             return arr;
// }
    static public String rd(String file) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while((str = br.readLine()) != null){
            stringBuilder.append(str);
            stringBuilder.append(ls);
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        br.close();
        return stringBuilder.toString();
        }
    class IntPair {
            // Ideally, name the class after whatever you're actually using 
            // the int pairs *for.*
            final int x;
            final int y;
            IntPair(int x, int y) {this.x=x;this.y=y;}
            // depending on your use case, equals? hashCode?  More methods?
    }

    static public int[][] get_pol(String a){
 
        String res = a;
        List<Integer> integers = new ArrayList<>();
        // res = res.replaceAll("\\-","+-");
        // res = res.replaceAll("\\--","-");
        // res = res.replaceAll("\\*","");
        // Pattern pattern = Pattern.compile("[-]?[0-9]+(.[0-9]+)?");
        Pattern pattern = Pattern.compile("-?\\d+");
        Matcher matcher = pattern.matcher(res);
        while(matcher.find()) {
            String s = matcher.group(0);
            if (s.replaceAll("\\D", "").length() == s.length()) {
                integers.add(Integer.parseInt(s));
            }
        }
        integers.add((integers.size() - 2),1);
        int[] ras = integers.stream().mapToInt(i -> i).toArray();
        int length, limit1,limit2;
        length = ras.length;
        if(length %2 ==0){
            limit1 = ras.length/2;
            limit2 = 2;
        }else{
            limit1 = ras.length/2+1;
            limit2 =2;
        }
        int[] ari[] = new int[limit1][limit2];
        int ctr = 0;
        for(int i = 0; i < limit1; i++){
            for(int j = 0; j < limit2; j++){
                if(ctr<length){
                    ari[i][j] = ras[ctr];
                    ctr++;
                }else{
                    break;
                }

            }
        }
        return ari;

    }

    static public int[][] sum(int[]pol1[],int[]pol2[]){
        // int m = Math.max(pol1[0][1]+1,pol2[0][1]+1);
        // int[] x = new int[m];
        int[] res[] = new int[pol1.length+pol2.length][2];
        int[] resu[] = new int[pol1.length+pol2.length+1][2];
        for(int k = 0; k < pol1.length+pol2.length; k++){
            if(k < pol1.length){
                res[k] = pol1[k];
            }else{
                res[k] = pol2[k - (pol1.length)];
            }
        }
        int sum = 0;
        for(int i = 0; i < pol1.length+pol2.length-1; i++){
            if(res[i][1] == res[i+1][1]){
                sum = res[i][0] + res[i+1][0];
                resu[i][0] = sum;
                resu[i][0] = res[i][1];
            }else if(res[i][1] > res[i+1][1]){
                resu[i] = res[i];
            }else if(res[i+1][1] > res[i][1]){
                resu[i] = res[i+1];
            }
        }
        // int sum = 0;

        // for(int i = 0; i < pol1.length+pol2.length; i++){
        //     if((pol1[i][1] == pol2[i][1]) || (pol2[i][1] == pol1[i][1] )){
        //         sum = pol1[i][0] + pol2[i][0];
        //         res[i][0] = sum;
        //         res[i][1] = pol2[i][1];
        //     }else if(pol1[i][1] > pol2[i][1]){
        //         res[i] = pol1[i];            
        //     }else if(pol2[i][1] > pol1[i][1]){
        //         res[i] = pol2[i];
        //     }else if(pol1[i][1] < pol2[i][1]){
        //         res[i] = pol2[i];
        //     } else if(pol2[i][1] < pol1[i][1]){
        //         res[i] = pol1[i];
        //     }
        // }
        return resu;
    }

    public static void main(String[] args) throws Exception{
        int[] g[] = get_pol("2x^3+ 2x^2 + 1x + 5 = 0");
        // for(int[] a: g){
        //     for(int item :a){
        //         System.out.println(item);
        //     }
        //     System.out.println();
        // }

        int[] t[] = get_pol("8x^4 + 4x^3 + 2x^2 + 3x + 9 = 0");
        // for(int[] a: t){
        //     for(int item :a){
        //         System.out.println(item);
        //     }
        //     System.out.println();
        // }


        int[] l[]=sum(g,t);
        for(int[] a: l){
            for(int item :a){
                System.out.println(item);
            }
            System.out.println();
        }
        System.out.println(l.length);
        System.out.println(l[0].length);




        }
    }



