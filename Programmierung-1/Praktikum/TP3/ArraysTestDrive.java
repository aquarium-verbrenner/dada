public class ArraysTestDrive {
    public static void main(String[] args)
    {
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println(numbers[0]);
        
        int[] numbers2 = numbers;
        System.out.println(numbers2[0]);
        
        numbers2[0] = 10;
        System.out.println(numbers2[0]);
        System.out.println(numbers[0]);
    }
}