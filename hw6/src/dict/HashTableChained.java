/* HashTableChained.java */

package dict;

import list.*;

/**
 * HashTableChained implements a Dictionary as a hash table with chaining.
 * All objects used as keys must have a valid hashCode() method, which is
 * used to determine which bucket of the hash table an entry is stored in.
 * Each object's hashCode() is presumed to return an int between
 * Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 * implements only the compression function, which maps the hash code to
 * a bucket in the table's range.
 * <p/>
 * DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

    /**
     * Place any data fields here.
     **/
    private int size = 0;
    private int bucketSize = 113;
    private SList[] table;

    /**
     * Construct a new empty hash table intended to hold roughly sizeEstimate
     * entries.  (The precise number of buckets is up to you, but we recommend
     * you use a prime number, and shoot for a load factor between 0.5 and 1.)
     **/

    public HashTableChained(int sizeEstimate) {
        // Your solution here.
        bucketSize = sizeEstimate;
        table = new SList[bucketSize];
    }

    /**
     * Construct a new empty hash table with a default size.  Say, a prime in
     * the neighborhood of 100.
     **/

    public HashTableChained() {
        // Your solution here.
        table = new SList[bucketSize];
        for (int i = 0; i < bucketSize; i++) {
            table[i] = new SList();
        }
    }

    /**
     * Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
     * to a value in the range 0...(size of hash table) - 1.
     * <p/>
     * This function should have package protection (so we can test it), and
     * should be used by insert, find, and remove.
     **/

    int compFunction(int code) {
        // Replace the following line with your solution.
        int a = 3;
        int b = 5;
        int p = 1097;
        int hashValue = (((a * code + b) % p) + p) % bucketSize;
        return hashValue;
    }

    /**
     * Returns the number of entries stored in the dictionary.  Entries with
     * the same key (or even the same key and value) each still count as
     * a separate entry.
     *
     * @return number of entries in the dictionary.
     **/

    public int size() {
        // Replace the following line with your solution.
        return size;
    }

    /**
     * Tests if the dictionary is empty.
     *
     * @return true if the dictionary has no entries; false otherwise.
     **/

    public boolean isEmpty() {
        // Replace the following line with your solution.
        return size == 0;
    }

    /**
     * Create a new Entry object referencing the input key and associated value,
     * and insert the entry into the dictionary.  Return a reference to the new
     * entry.  Multiple entries with the same key (or even the same key and
     * value) can coexist in the dictionary.
     * <p/>
     * This method should run in O(1) time if the number of collisions is small.
     *
     * @param key   the key by which the entry can be retrieved.
     * @param value an arbitrary object.
     * @return an entry containing the key and value.
     **/

    public Entry insert(Object key, Object value) {
        // Replace the following line with your solution.
        int hashValue = compFunction(key.hashCode());
        SList list = table[hashValue];
        ListNode current = list.front();
        Entry entry = createEntry(key, value);
        list.insertBack(entry);
        return entry;
    }

    /**
     * Create a new Entry with a pair of specify key and value.
     *
     * @param key
     * @param value
     * @return an entry contains (key, value).
     */
    private Entry createEntry(Object key, Object value) {
        Entry entry = new Entry();
        entry.key = key;
        entry.value = value;
        return entry;
    }

    /**
     * Search for an entry with the specified key.  If such an entry is found,
     * return it; otherwise return null.  If several entries have the specified
     * key, choose one arbitrarily and return it.
     * <p/>
     * This method should run in O(1) time if the number of collisions is small.
     *
     * @param key the search key.
     * @return an entry containing the key and an associated value, or null if
     * no entry contains the specified key.
     **/

    public Entry find(Object key) {
        // Replace the following line with your solution.
        int hashValue = compFunction(key.hashCode());
        SList list = table[hashValue];
        ListNode current = list.front();
        try {
            while (current.isValidNode()) {
                Entry entry = (Entry) current.item();
                Object entryKey = entry.key();
                if (entryKey.equals(key)) {
                    return entry;
                }
                current = current.next();
            }
        } catch (InvalidNodeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Remove an entry with the specified key.  If such an entry is found,
     * remove it from the table and return it; otherwise return null.
     * If several entries have the specified key, choose one arbitrarily, then
     * remove and return it.
     * <p/>
     * This method should run in O(1) time if the number of collisions is small.
     *
     * @param key the search key.
     * @return an entry containing the key and an associated value, or null if
     * no entry contains the specified key.
     */

    public Entry remove(Object key) {
        // Replace the following line with your solution.
        int hashValue = compFunction(key.hashCode());
        SList list = table[hashValue];
        ListNode current = list.front();
        try {
            while (current.isValidNode()) {
                Entry entry = (Entry) current.item();
                Object entryKey = entry.key();
                if (entryKey.equals(key)) {
                    current.remove();
                    size--;
                    return entry;
                }
                current = current.next();
            }
        } catch (InvalidNodeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Remove all entries from the dictionary.
     */
    public void makeEmpty() {
        // Your solution here.
        for (int i = 0; i < bucketSize; i++) {
            table[i] = new SList();
        }
        size = 0;
    }

    public String toString() {
        String string="[  ";
        try{
            for (int i=0; i < table.length; i++) {
                int count=0;
                if (table[i]!=null) {
                    ListNode node=table[i].front();
                    while(node.isValidNode()) {
                        node=node.next();
                        count++;
                    }
                    string+=count+"  ";
                }
                if (i % 10 == 0) {
                    string += "\n";
                }
            }
        } catch (InvalidNodeException e) {
            System.out.println(e);
        }
        return string+"]";
    }
}
