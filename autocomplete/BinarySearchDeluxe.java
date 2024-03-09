import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {

    
    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int index = -1;
        int low = 0;
        int high = a.length;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (comparator.compare(a[mid], key) < 0) {
                low = mid + 1;
            } else if (comparator.compare(a[mid],key) > 0) {
                high = mid - 1;
            } else if (comparator.compare(a[mid],key) == 0) {
                if(mid == 0 || comparator.compare(a[mid-1], key) != 0){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
        }
        return index;
    }


    
    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int index = -1;
        int low = 0;
        int high = a.length;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (comparator.compare(a[mid], key) < 0) {
                low = mid + 1;
            } else if (comparator.compare(a[mid],key) > 0) {
                high = mid - 1;
            } else if (comparator.compare(a[mid],key) == 0) {
                if(mid == a.length-1 || comparator.compare(a[mid+1], key) != 0){
                    return mid;
                }
                else{
                    low = mid+1;
                }
            }
        }
        return index;
    }

    // unit testing (you should have some Unit Testing here to confirm that your methods work); for example...
    public static void main(String[] args) {
    
        Term[] terms = new Term[5];
        terms[0] = new Term("Trevor", 45);
        terms[1] = new Term("Kathy", 43);
        terms[2] = new Term("Ellie", 11);
        terms[3] = new Term("Allen", 9);
        terms[4] = new Term("Eva", 1);
        Arrays.sort(terms);
        
        Term searchme = new Term("J",0);
        int first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        int last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("J: " + first + " to " + last);

        searchme = new Term("A",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("A: " + first + " to " + last);
       
        searchme = new Term("E",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("E: " + first + " to " + last);
        
        searchme = new Term("T",0);
        first = BinarySearchDeluxe.firstIndexOf(terms, searchme, Term.byPrefixOrder(1));
        last = BinarySearchDeluxe.lastIndexOf(terms, searchme, Term.byPrefixOrder(1));
        StdOut.println("T: " + first + " to " + last);        
    }
}