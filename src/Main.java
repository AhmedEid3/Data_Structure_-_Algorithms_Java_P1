import ds.HashTable;
import ds.HashTableV2;

public class Main {
    public static void main(String[] args) {
        var list = new HashTableV2();
        list.put(6, "A");
        list.put(8, "B");
        list.put(11, "C");
        list.put(11, "D");
        list.put(13, "E");


        System.out.println(list);

        System.out.println(list.get(13));

        list.remove(13);
        System.out.println(list);
    }


}