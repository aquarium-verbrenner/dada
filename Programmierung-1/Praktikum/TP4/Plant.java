public class Plant {
    private double height;
    private String type;
    private int waterLevel;
    private boolean needsWater;
    


    public void main() {
        System.out.println("The plant " + type + " has the height of " + height + " and a water level of " + waterLevel);
    }

    public void grow(int sunlightHours){
        height += 0.5 * sunlightHours;
    }

    public void water(int amount){
        waterLevel += amount;
    }

    public boolean needsWater(){
        //needsWater = (waterLevel <= 5);
        if (waterLevel <= 5){
            needsWater = true;
        } else {
            needsWater = false;
        }
        System.out.println(needsWater);
        return needsWater;
    }

    public double getHeight(){
        System.out.println("The height is : " + height);
        return height;
    }

    public String getType(){
        return type;
    }
    
    public void getWaterLevel(){
        System.out.println("The water level is : " + waterLevel);
    }
    public void getNeedsWater(){
        System.out.println("The plant needs water : ");
        needsWater();
    }

    public void setHeight(int newHeight){
        if (newHeight >= 0){
            height = newHeight;
        } else {
            System.out.println("The height cannot be negative !");
        }
    
    }
    public void setType(String newType){
        if(!newType.trim().isEmpty())
        type = newType;
    }
    public void setWaterLevel( int newWaterLevel){
        if (newWaterLevel <= 10){
            waterLevel = newWaterLevel;
        } else {
            System.out.println("The level of the water cannot exceed a value of 10 !");
        }
    }
}