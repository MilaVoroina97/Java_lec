package lection5;
import java.util.ArrayList;
public class linear {

    class HashNode<K,V>{// узел цепей
        K key;
        V value;
        HashNode<K,V> next; //ссылка на след. узел

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    class Map<K,V>{//реализация хеш-таблицы 
        private ArrayList<HashNode<K,V>> bucketArray; //для хранения массива цепочек с узлами
        private int numBucket; //текущее кол-во корзин
        private int size; //размер списка массивов цепочек
        public Map(){
            bucketArray = new ArrayList<>();
            numBucket = 10;
            size = 0;
            for(int i = 0 ; i < numBucket; i++){
                bucketArray.add(null);
            }
        }

        public int size(){return size;}
        public boolean isEmpty(){return size == 0;}
        private int getBucketIndex(K key){ //хеш-функция для поиска индекса корзины
            int hashcode = key.hashCode();
            int index = hashcode % numBucket;
            return index;
        }

        public V remove(K key){ 
            int bucketIndex = getBucketIndex(key);//поиск индекса удаляемого объекта по ключу
            HashNode<K,V> head = bucketArray.get(bucketIndex);
            HashNode<K,V> prev= null;
            while(head != null){
                if (head.key.equals(key)) break;
                prev = head;
                head = head.next;//ключ найден, двигаемся дальше по цепочке
            }

            if(head == null) return null;
            size--;
            if(prev != null){
                prev.next = head.next;
            }else{
                bucketArray.set(bucketIndex,head.next);
            }

            return head.value;
        }

        public V get(K key){
            int bucketIndex = getBucketIndex(key);
            HashNode<K,V> head = bucketArray.get(bucketIndex);
            while(head != null){
                if(head.key.equals(key)) return head.value;
                head = head.next;
            }
            return null;
        }

        public void add(K key, V value){
            int bucketIndex = getBucketIndex(key);
            HashNode<K,V> head = bucketArray.get(bucketIndex);
            while(head != null){
                if(head.key.equals(key)){
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            size++;
            head = bucketArray.get(bucketIndex);
            HashNode<K,V> newNode = new HashNode<K,V>(key, value);
            newNode.next = head;
            bucketArray.set(bucketIndex, newNode);
            if((1.0 * size)/ numBucket < 0.7){
                ArrayList<HashNode<K,V>> temp = bucketArray;
                bucketArray = new ArrayList<>();
                numBucket = 2 * numBucket;
                size = 0;
                for(int j = 0 ; j < numBucket; j++){
                    bucketArray.add(null);
                }

                for(HashNode<K,V> headNode : temp){
                    while(headNode != null){
                        add(headNode.key, headNode.value);
                        headNode = headNode.next;
                    }
                }

            }

        }

        

    }

}
