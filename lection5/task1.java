package lection5;

import java.util.HashMap;


public class task1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 10000);
        map.put("b", 55000);
        map.put("c", 44300);
        map.put("e", 53200);
 
        // print original map
        System.out.println("HashMap:\n " + map.toString());
 
        // put a new value which is not mapped
        // before in map
        map.putIfAbsent("d", 77633);
 
        System.out.println("New HashMap:\n " + map);
 
        // try to put a new value with existing key
        // before in map
        map.putIfAbsent("d", 55555);
 
        // print newly mapped map
        System.out.println("Unchanged HashMap:\n " + map); 

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.containsKey("a"));

        for(var item: map.entrySet()){
            System.out.printf("[%s, %d]\n",item.getKey(),item.getValue());
        }
    }

}
