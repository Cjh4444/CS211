package Week08.Assignment;

public class Test {
    public static void main(String[] args) {
        // ArrayList<Integer> A = new ArrayList<>();
        LinkedList<Integer> B = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            // A.add(i);
            B.add(i);
        }

        // B.stutter();

        System.out.println(B);
        System.out.println(B.backwards());

        B.deleteBack();

        // B.removeAll(2);
        // B.removeAll(7);
        // B.removeAll(11);

        System.out.println(B);
        System.out.println(B.backwards());
        // System.out.println("Array switchpairs: " + timeIt(A::switchPairs));
        // System.out.println("Inefficient linkedlist switchpairs: " + timeIt(B::switchPairs));
    }

    public static double timeIt(Runnable function) {
        long startTime = System.nanoTime();
        for (int i = 0; i < 1; i++) {
            function.run();
        }
        long endTime = System.nanoTime();
        return (double) (endTime - startTime) / 1000000000;
    }
}
