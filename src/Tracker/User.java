package Tracker;

public class User{

    static int Calories=0;
    static double HeartRate=80;

    public User (int Calories, double HeartRate){
        User.Calories=Calories;
        User.HeartRate=HeartRate;
    }

    public static double getHeartRate() {
        return HeartRate;
    }

    public static void setHeartRate(double heartRate) {
        User.HeartRate = heartRate;
    }

    public static int getCalories() {
        return Calories;
    }

    public static void setCalories(int calories) {
        User.Calories+= calories;
    }

    //@Override
   // public int compareTo(User user) {
      //  return Calories.compareTo(user.getCalories());

}
