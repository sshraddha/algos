package algorithms.datastructures.hashmap;

/**
 * @author vkavuluri
 */
public class TMHashMap {

    // for simplicity array size is taken as 2^4
    private static final int SIZE = 16;
    private Entry table[] = new Entry[SIZE];

    private int size;

    private int size() {
        return this.size;
    }


    /**
     * User defined key-value data structure.
     * This is also used as linked list for collision resolution.
     */
    class Entry {
        final String key;
        String value;
        Entry next;

        Entry(String k, String v) {
            key = k;
            value = v;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Returns the entry associated with the specified key in the
     * HashMap.  Returns null if the HashMap contains no mapping
     * for the key.
     */
    public Entry get(String key) {
        int hash = key.hashCode() % SIZE;
        Entry e = table[hash];

        while (e != null) {
            if (e.key.equals(key) ) {
                return e;
            }
            e = e.next;
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map.
     * If the map previously contained a mapping for the key, the old
     * value is replaced.
     */
    public void put(String key, String value) {
        int hash = key.hashCode() % SIZE;
        Entry e = table[hash];

        if (e != null) {
            // replacing value
            if (e.key.equals(key)) {
                e.value = value;
            } else {
                size++;
                // traverse to the end of the list and insert new element in the same bucket
                while (e.next != null) {
                    e = e.next;
                }
                Entry entryInOldBucket = new Entry(key, value);
                e.next = entryInOldBucket;
            }
        } else {
            size++;
            // new element in the map, hence create new bucket
            Entry entryInNewBucket = new Entry(key, value);
            table[hash] = entryInNewBucket;
        }
    }

    public static void main(String[] args) {
        TMHashMap tmHashMap = new TMHashMap();

        tmHashMap.put("foo", "bar");
        tmHashMap.put("alpha", "beta");
        tmHashMap.put("foo", "baz");
        tmHashMap.put("foo1", "baz1");

        System.out.println(tmHashMap.get("alpha").getValue());
        System.out.println(tmHashMap.get("foo").getValue());

        System.out.println(tmHashMap.size());


    }

}
