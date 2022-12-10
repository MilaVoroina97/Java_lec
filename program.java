// public class program {
//     public static void main(String[] args) {
//         boolean flag1 = 123 <=234;
//         System.out.println(flag1);
//         boolean flag2 = 123 <= 234 || flag1;
//         System.out.println(flag2);
//         boolean flag3 = flag1 ^ flag2;
//         System.out.println(flag3);
//         boolean x = 6 - 2 > 3 && 12*12 <= 119;// false && false
//         System.out.println(x);

//     }
    
// }

// public class program {
//     public static void main(String[] args) {
//         var a = 123;
//         System.out.println(a);
//         var d = 123.456;
//         System.out.println(d);
//         System.out.println(getType(a));
//         System.out.println(getType(d));
//         d = 1022;
//         System.out.println(d);

//     }

//     static String getType(Object o){

//         return o.getClass().getSimpleName();
//     }
    
// }

// public class program {
//     public static void main(String[] args) {
//         String s = "qwer";
//         s.charAt(1);
//         System.out.println(s.charAt(1));

//     }
    
// }

// public class program {
//     public static void main(String[] args) {

//         int a = 123;
//         System.out.println(++a);//префиксный инкремент , а++ - постфиксный инкремент
//         System.out.println(a);

//     }
    

// }

// public class program {
//     public static void main(String[] args) {

//         String s = "qwert";
//         boolean a = s.length() >= 5 && s.charAt(3) == '1';
//         System.out.println(a);

//     }
    

// }

// public class program {
//     public static void main(String[] args) {

//         int[] arr = new int[10];
//         // arr[3] = 13;
//         int[] a = new int[] {1,2,3,45};//одномерный массив
//         int[] arr1[] = new int[3][5];
//         for (int[] line: arr1){
//             for(int item : line){
//                 System.out.printf("%d ",item);
//             }
//         }

//     }
    

// }


// public class program {
//     public static void main(String[] args) {

//         int[][] arr = new int[3][5];
//         for(int i = 0; i < arr.length; i++){
//             for(int j = 0; j < arr[i].length; j++){
//                 System.out.printf("%d", arr[i][j]);
//             }
//         }
//     }
    

// }



// import java.util.Scanner;
// public class program {
//     public static void main(String[] args) {

//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("name: ");
//         String name = iScanner.nextLine();
//         System.out.printf("Hi, %s!\n",name);
//         System.out.printf("int a: ");
//         int x = iScanner.nextInt();
//         System.out.printf("double y: ");
//         double y = iScanner.nextDouble();
//         System.out.printf("%d + %f = %f",x,y,x+y);
//         iScanner.close();
//     }
// }


// import java.util.Scanner;
// public class program {
//     public static void main(String[] args) {

//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("int a: ");
//         boolean flag = iScanner.hasNextInt();
//         System.out.println(flag);
//         int i = iScanner.nextInt();
//         System.out.println(i);
//         iScanner.close();
//     }
// }


// public class program {
//     public static void main(String[] args) {
//         String s = "qwer";
//         int a = 123;
//         String b = s+a;//неявное преобразование
//         System.out.println(b);
//     }
// }

// public class program {
//     // static public void sayHi(){
//     //     System.out.println("Hi!");
//     // }

//     static public int sum(int a,int b){
//         return a + b;
//     }

//     static public double factor(int n){
//         if (n ==1) return 1;
//         return n * factor(n-1);
//     }

//     public static void main(String[] args) {
//         lib.sayHi();
//         System.out.println(sum(3,5));
//         System.out.println(factor(5));

//     }
// }

// public class program {
//         public static void main(String[] args) {

//             int a =10;
//             switch(a){
//                 case 1:
//                 case 2:
//                 case 3:
//                 case 4:
//                 case 5:
//                 case 6:
//                     System.out.println('a');
//                     break;
//                 case 10:
//                     System.out.println('b');
//                     break;
//                 default:
//                     System.out.println("mistake");
//                     break;

//             }
//         }
//     }

// public class program {
//     public static void main(String[] args) {
//         int value = 321;
//         int count = 0;
//         while(value !=0){
//             value /= 10;
//             System.out.println(value);
//             count++;
//         }
//         System.out.println(count);

//     }
    
// }

// public class program {
//     public static void main(String[] args) {

//         for(int i = 0; i < 10; i++){
//             if (i%2 == 0)
//                 continue;
//             System.out.println(i);//выводит нечетные числа
//         }
//     }  
// }


// import java.io.FileWriter;
// import java.io.IOException;
// public class program {
//     public static void main(String[] args) {
//         try (FileWriter fw = new FileWriter("file.txt",false)){
//             fw.write("line 1");
//             fw.append('\n');
//             fw.append('2');
//             fw.append('\n');
//             fw.write("line 3");
//             fw.flush();
//         }catch (IOException ex){
//             System.out.println(ex.getMessage());
//         }
//     }  
// }

// import java.io.*;
// public class program {
//     public static void main(String[] args) throws Exception {
//         FileReader fr = new FileReader("file.txt");//чтение посимвольно
//         int c;
//         while((c = fr.read())!= -1){
//             char ch = (char) c;
//             if(ch == '\n'){
//                 System.out.println(ch);
//             }else{
//                 System.out.println(ch);
//             }

//         }

//     }  
// }

import java.io.*;
public class program{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("file.txt"));
        String str;
        while((str = br.readLine())!= null){
            System.out.printf("== %s ==\n",str);
        }
        br.close();
        
    }
}
