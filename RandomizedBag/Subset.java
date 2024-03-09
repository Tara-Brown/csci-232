public class Subset {
 

    public static void main(String[] args) {
        
        int k = Integer.parseInt(args[0]);
        RandomizedBag<String> bag = new RandomizedBag<String>();

        //fill the bag with words from StdIn;  example of doing this in e.g. LinkedQueue
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.put(item);
        }

        //pull k things from the bag, if possible.
        for(int i = 0; i < k; i++){
            System.out.println(bag.get());
        }
    }
    
    
}