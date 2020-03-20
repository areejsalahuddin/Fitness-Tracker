package Tracker;

public class Activity {
    private int CalBurnt;
    private double HeartRateInc;
    private int CaloriesTot;
    private double HeartRateTot;
    private String ActivityName;

    public Activity(int CalBurnt,double HeartRateInc, int CaloriesTot, double HeartRateTot,String Activityname)
    {
        this.CalBurnt= CalBurnt;
        this.HeartRateInc=HeartRateInc;
        this.CaloriesTot=CaloriesTot;
        this.HeartRateTot=HeartRateTot;
        this.ActivityName = Activityname;
    }

    public String getActivityName() {
        return ActivityName;
    }

    public int getCalBurnt(int Time){
        return  CalBurnt * Time;
    }
    public int getCaloriesTot() {
        return CaloriesTot;
    }

    public void setCaloriesTot(int Time) {
        CaloriesTot+= getCalBurnt(Time);
    }

    public double getHeartRateTot() {
        return HeartRateTot;
    }


    public void setHeartRateTot(int time) {

        HeartRateTot += User.getHeartRate() * HeartRateInc * time;
    }


    public double getRate(int time) {
        return User.getHeartRate() + (User.getHeartRate() * HeartRateInc * time);
    }

    public void operateActivity(int Time){
        User.setCalories(CalBurnt*Time);
        User.setHeartRate(User.getHeartRate()+(User.getHeartRate()* Time * HeartRateInc));
        setCaloriesTot(Time);
        setHeartRateTot(Time);


    }

         public static void descend(Activity[] activities){
        int n = activities.length;
        for (int i = 0; i < n-1; i++)
           for (int j = 0; j < n-i-1; j++)
                if (activities[j].CaloriesTot < activities[j+1].CaloriesTot)
               {    // swap temp and arr[i]
                    Activity temp = activities[j];
                    activities[j] = activities[j+1];
                    activities[j+1] = temp;
               }
        else if(activities[j].CaloriesTot==activities[j+1].CaloriesTot)
                {
                    if (activities[j].HeartRateTot < activities[j+1].HeartRateTot)
                    {
                        Activity temp = activities[j];
                        activities[j] = activities[j+1];
                        activities[j+1] = temp;
                    }
                }
    }



}

