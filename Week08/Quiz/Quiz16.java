package Week08.Quiz;

public class Quiz16 {
    public static void main(String[] arg474) {
        LinkedIntList list1 = new LinkedIntList();
        LinkedIntList list2 = new LinkedIntList();
        for (int i = 1; i <= 6; i++) {
            list1.add(i);
            list2.add(i);
        }

        System.out.println("BEFORE");
        System.out.println("list 1: " + list1);
        System.out.println("list 2: " + list2);

        list1.removeEvenNumbers();

        list2.removeEvenNumbers();
        list2.removeEvenNumbers();

        System.out.println();

        System.out.println("AFTER");
        System.out.println("list 1: " + list1);
        System.out.println("list 2: " + list2);
    }
}
