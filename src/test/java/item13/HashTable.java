package item13;


public class HashTable implements Cloneable{
    private Entry[] buckets;
    private static final int num = 10;

    HashTable() {
        this.buckets = new Entry[num];
    }

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        Entry(Object key , Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(String key, String value) {
        if(buckets[0]==null) {
            buckets[0] = new Entry(key,value,null);
        }else {
            Entry entry = buckets[0];
            while(entry.next !=null) {
                entry = entry.next;
            }
            entry.next = new Entry(key,value,null);
        }
    }

    public void print() {
        System.out.println("======================================");
        Entry entry = buckets[0];
        while(entry.next!=null) {
            System.out.println(entry.key+ ", "+ entry.value);
            entry = entry.next;
        }
        System.out.println(entry.key+", "+ entry.value);
        System.out.println("======================================");
    }

    @Override
    public HashTable clone() throws CloneNotSupportedException {
        HashTable hashTable = (HashTable) super.clone();
        hashTable.buckets = buckets.clone();
        return hashTable;
    }
}
