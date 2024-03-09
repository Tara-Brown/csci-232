import java.util.Arrays;
import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query;
    private long weight;
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        this.query = query;
        this.weight = weight;
    }

    public long getWeight() {
        return weight;
    }

    public String getQuery() {
        return query;
    }

    public static Comparator<Term> byReverseWeightOrder() {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                if(v.getWeight() > w.getWeight())
                    return -1;
                if(v.getWeight() < w.getWeight())
                    return 1;
                return 0;
            }
        };
    }

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new Comparator<Term>() {
            public int compare(Term v, Term w) {
                int wlen = Math.min(r, w.getQuery().length());
                int vlen = Math.min(r, v.getQuery().length());
                int difference = v.getQuery().substring(0,vlen).compareTo(w.getQuery().substring(0,wlen));
                if (difference > 0){
                    return 1;
                }
                else if(difference < 0){
                    return -1;
                }
                return 0;
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.getQuery());
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight+"\t"+query;
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
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byReverseWeightOrder());
        for (Term t : terms) {
            StdOut.println(t);
        }
        
        StdOut.println("");
        Arrays.sort(terms, Term.byPrefixOrder(1));
        for (Term t : terms) {
            StdOut.println(t);
        }        
    }
}