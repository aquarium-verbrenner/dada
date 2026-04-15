public class PlantTestDrive {
    public static void main(String[] args) {

        Plant plant = new Plant();
        //plant.height = 10.0;
        //plant.type = "Orchid";
        //plant.waterLevel = 2;

        plant.main();
        plant.grow(2);
        //System.out.println("The plant " + plant.type + " has the height of " + plant.height + " and a water level of " + plant.waterLevel);
        plant.water(2);
        plant.needsWater();

        if (plant.needsWater()){
            plant.water(3);
        }


        plant.setHeight(-2);
        plant.setType("Ficus");
        plant.setWaterLevel(11);

        plant.getHeight();
        plant.getType();
        plant.getWaterLevel();
        plant.getNeedsWater();

        


         double height1 = 2;
         double height2 = 3;
        System.out.println(height1 == height2);
            height2 = 2;
        System.out.println(height1 == height2);
    

        Plant plant1 = new Plant();
        plant1.setHeight(1);
        plant1.setType("Cactus");
        plant1.setWaterLevel(3);

        Plant plant2 = new Plant();
        plant2.setHeight(1);
        plant2.setType("Cactus");
        plant2.setWaterLevel(3);

        System.out.println(plant1 == plant2);
        System.out.println(plant1.getType().equals(plant2.getType()));

    }
}
