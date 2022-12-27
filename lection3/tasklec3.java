import java.util.*;

public class tasklec3 {
    

    // public static void main(String[] args) {
    //     Object o = 1;GetType(o);
    //     o = 1.2;GetType(o);
    //     System.out.println(Sum("kasha ","masha"));
    //     System.out.println(Sum(4,5.7));
    //     LinkedList<String> cars = new LinkedList<String>();
    //     cars.add("Volvo");
    //     cars.add("BMW");
    //     cars.add("Ford");
    //     cars.add("Mazda");
    //     System.out.println(cars);
    // }
    // static void GetType(Object x){
    //     System.out.println(x.getClass().getName());
    // }

    // static Object Sum(Object a , Object b){
    //     if(a instanceof Integer && b instanceof Integer){
    //         return (Object)((Integer) a + (Integer)b);
    //     }else if(a instanceof Double && b instanceof Double){
    //         return (Object)((Double) a + (Double)b);
    //     }else if(a instanceof String && b instanceof String){
    //         return (Object)((String)a + (String)b);
    //     }else return 0;
    // }

    // static int[] AddItem(int[] arr,int item){
    //     int length = arr.length;
    //     int[] temp = new int[length+1];
    //     System.arraycopy(arr, 0, temp, 0, length);
    //     temp[length] = item;
    //     return temp;
    // }

    // public static void main(String[] args) {
    //     StringBuilder day = new StringBuilder("9");
    //     StringBuilder month = new StringBuilder("12");
    //     StringBuilder year = new StringBuilder("2021");
    //     StringBuilder[] date = new StringBuilder[] {day,month,year};
    //     List<StringBuilder> d = Arrays.asList(date);
    //     date[1] = new StringBuilder("11");
    //     System.out.println(d);
    // }

    public static void main(String[] args) {
        List<Character> list1 = List.of('P','u','l','s','o','n');
        System.out.println(list1);
        // list1.remove(1); Unsupported Operation
        // List<Character> list2 = List.copyOf(list1);
        List<Character> arr = new ArrayList<Character>();
        arr.add('P');
        arr.add('u');
        arr.add('l');
        arr.remove(1);
        System.out.println(arr);

        List<Integer> list = List.of(1, 12, 123, 1234, 12345);

        for (int item : list) { System.out.println(item); }
        Iterator<Integer> col = list.iterator();
 
        while (col.hasNext()) {
            System.out.println(col.next());
            // col.next();
            // col.remove();
        }
 
    }
    
}
