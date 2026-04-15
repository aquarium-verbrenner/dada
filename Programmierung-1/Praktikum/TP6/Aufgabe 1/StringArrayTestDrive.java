public class StringArrayTestDrive {

    public static void main(String[] args) {

        System.out.println("Test 1");
        StringArray sa = new StringArray(3);
        System.out.println("Array = 3");
        
        System.out.println("Test 2 : null value");
        int idxNull = sa.add(null);
        System.out.println("expected : -1 : " + idxNull);
        System.out.println("expected : 0 : " + sa.size());
        
        System.out.println("Test 3 : Insertions");
        
        int idx1 = sa.add("Un");
        int idx2 = sa.add("Deux");
        int idx3 = sa.add("Trois");
        
        System.out.println("expected : 0 : " + idx1);
        System.out.println("expected : 1 : " + idx2);
        System.out.println("expected : 2 : " + idx3);
        System.out.println("expected : 3 : " + sa.size());
        System.out.println("expected : Trois : " + sa.get(2));
        
        System.out.println("Test 4 : Resize");
        
        int idx4 = sa.add("Quatre");
        
        System.out.println("expected : 3 : " + idx4);
        System.out.println("expected : 4 : " + sa.size());

        System.out.println("expected : Un : " + sa.get(0));
        System.out.println("expected : Quatre : " + sa.get(3));
        
        System.out.println("Test 5 : Add after resize");
        sa.remove(0);
        System.out.println("expected : 3 : " + sa.size());
        
        int idx5 = sa.add("Zéro");
        System.out.println("Insertion 'Zéro' à l'index : " + idx5 + " (attendue: 0)");
        System.out.println("Taille logique (attendue: 4) : " + sa.size());
        System.out.println("get(0) (attendue: Zéro) : " + sa.get(0));
    }
}
