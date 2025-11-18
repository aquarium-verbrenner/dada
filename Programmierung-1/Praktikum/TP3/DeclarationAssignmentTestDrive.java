public class DeclarationAssignmentTestDrive {
    public static void main(String[] args) {
        int number = 42;  
        double comma = 3.1415;             
        boolean trueOrFalse = true;       
        String sentence = "Hello, World!"; 
        
        System.out.println("int : " + number);
        System.out.println("double : " + comma);
        System.out.println("boolean : " + trueOrFalse);
        System.out.println("String : " + sentence);
        
        Byte byteValue = -50;
        int intValue = byteValue;
        System.out.println(intValue);
        
        Long longValue = 15000000000l;
        Float floatValue = 15000000000L;
        System.out.println(floatValue);
        System.out.println(longValue);
    }
}