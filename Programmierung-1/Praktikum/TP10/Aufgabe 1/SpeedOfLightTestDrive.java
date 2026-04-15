public class SpeedOfLightTestDrive {
    public static void main(String[] args) {
        System.out.println("Vitesse de la lumière : " + SpeedOfLight.VITESSE + " m/s");
    
        System.out.print("100% de la vitesse : ");
        SpeedOfLight.printFraction(1.0);
        
        System.out.print("50% de la vitesse : ");
        SpeedOfLight.printFraction(0.5);
        
        System.out.print("12,5% de la vitesse : ");
        SpeedOfLight.printFraction(0.125);
    }
}
