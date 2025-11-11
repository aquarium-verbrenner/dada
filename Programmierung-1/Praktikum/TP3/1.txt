public class Main {
    public static void main(String[] args) {
        int a = 42;  
        double b = 3.1415;             
        boolean c = true;       
        String d = "Hello, World!"; 
        
        System.out.println("int : " + a);
        System.out.println("double : " + b);
        System.out.println("boolean : " + c);
        System.out.println("String : " + d);
        
        Byte byteValue = -50;
        int intValue = byteValue;
        System.out.println(intValue);
        
        Long longValue = 15000000000L;
        Float floatValue = 15000000000L;
        System.out.println(floatValue);
    }
}