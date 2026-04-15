public class StringArrayListTestDrive {

    public static void main(String[] args) {
        StringArrayList list = new StringArrayList(3); 
        

        System.out.println("\nTest 1 : add() und size()");
        
        int idx1 = list.add("Pomme");
        int idx2 = list.add("Banane");
        int idx3 = list.add("Cerise");
        
        System.out.println("add('Pomme') : " + idx1 + " (expected index : 0)");
        System.out.println("add('Banane') : " + idx2 + " (expected index : 1)");
        System.out.println("add('Cerise') : " + idx3 + " (expected index : 2)");
        System.out.println("size (expected: 3) : " + list.size());
        
        int idx4 = list.add("Datte"); 
        System.out.println("add('Datte') : " + idx4 + " (expected : 3)");
        System.out.println("size (expected : 4) : " + list.size());
        
        int idxNull = list.add(null);
        System.out.println("add(null) (expected : -1) : " + idxNull);
        System.out.println("size (expected : 4) : " + list.size());
        

        System.out.println("\nTest 2 : get()");
        System.out.println("get(1) (expected : Banane) : " + list.get(1));
        System.out.println("get(3) (expected : Datte) : " + list.get(3));
        

        System.out.println("\nTest 3 : set()");
        list.set(1, "Orange");
        System.out.println("get(1) after set (expected : Orange) : " + list.get(1));
        

        System.out.println("\nTest 4 : remove()");
        
        list.remove(1);

        System.out.println("size after remove(1) (expected : 3) : " + list.size());
        System.out.println("get(1) (expected : Cerise) : " + list.get(1));
    }
}
