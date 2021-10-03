package item13;


public class HashTable2 implements Cloneable{
    private Entry[] buckets;
    private static final int num = 1;

    HashTable2() {
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

        Entry deepCopy() {
            return new Entry(key,value, next == null ? null : next.deepCopy());
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
    public HashTable2 clone() throws CloneNotSupportedException {
        HashTable2 hashTable = (HashTable2) super.clone();
        hashTable.buckets = new Entry[buckets.length];

        hashTable.buckets[0] = buckets[0].deepCopy();
        return hashTable;
    }
}
