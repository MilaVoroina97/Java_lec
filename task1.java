import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
public class task1 {
    static public int[] get_rations(int k){
        int[] rations = new int[k+1];
        for(int i = 0; i < k+1; i++){
            rations[i] = ThreadLocalRandom.current().nextInt(0, 10);
        }
        while (rations[0] == 0){
            rations[0] = ThreadLocalRandom.current().nextInt(1, 10);
        }
        return rations;
    }
    static public int[] reverse (int[] arr){
        for(int i = 0; i < arr.length/2;i++){
            int temp = arr[i];
            arr[i] = arr[arr.length- i -1];
            arr[arr.length - i -1] = temp;
        }
        return arr;
    }
    static public String get_pol(int[] arr){

        int[] new_ar = reverse(arr);
        String wr = "";
        if (new_ar.length < 1){

            wr = "x = 0";
        }else{
            for(int j = 0; j < new_ar.length; j++){
                if( j != new_ar.length - 1 && new_ar[j] != 0 && j != new_ar.length - 2){
                    wr += String.format("%d*x^%d",new_ar[j],(new_ar.length - j -1));
                    if (new_ar[j + 1] != 0){
                        wr += "+";
                    }
                } else if(j == new_ar.length - 2 && new_ar[j] != 0){
                    wr += String.format("%d*x", new_ar[j]);
                    if(new_ar[j+1] != 0){
                        wr += "+";
                    }

                }else if( j == new_ar.length - 1 && new_ar[j] != 0){
                    wr += String.format("%d = 0",new_ar[j]);
                }else if(j == new_ar.length - 1 && new_ar[j] == 0){
                    wr += "= 0";
                }

                }
            }
        return wr;
        }


    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите натуральную степень k: ");
        int k = iScanner.nextInt();
        int[] rations = get_rations(k);
        String res = get_pol(rations);
        System.out.println(res);
        iScanner.close();

        
    }
    
}
