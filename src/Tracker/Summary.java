package Tracker;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.text.DecimalFormat;

public class Summary {
    Scene scene;
    Swimming swim;
    Running run;
    KickBoxing kickbox;
    StrengthTraining strength;
    UserChoice userchoice;
    static Stage stage;


    public static void SummaryStage(Stage stage){
       Summary.stage = stage;
    }

    //public void Name(ChoosingActivity choosingActivity,String activity) {
       // this.choosingActivity = choosingActivity;
   // }

    public void setUserChoice(UserChoice userChoice) {
        this.userchoice = userChoice;
    }

    public Summary(Swimming swim, Running run, KickBoxing kickbox, StrengthTraining strength) {
        this.swim = swim;
        this.run = run;
        this.kickbox = kickbox;
        this.strength = strength;
    }
        public void SummaryWindow(){
            DecimalFormat df = new DecimalFormat("0.000");
            Activity[] activities = {swim, run, kickbox, strength};
            Activity.descend(activities);
            Label ResultsLabel = new Label("Final Results:");
            ResultsLabel.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 17));
            Label Rank =  new Label("Ranking of Activities:");
            Rank.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            Label Calories = new Label("Total Calories:   " + User.getCalories() + " Calories");
            Label HeartRate= new Label("Heart Rate=  " + df.format(User.getHeartRate()) + "  beats per minute");
            Button Back = new Button("Back");
            Label FirstActivity = new Label( "1. " +activities[0].getActivityName());
            FirstActivity.setTextFill(Color.web("#FF0000"));
            FirstActivity.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
            Label FirstCalRate =  new Label("Calories Burnt= " + activities[0].getCaloriesTot()+ " Calories"+"\nHeart Rate Increase =" + df.format(activities[0].getHeartRateTot())+ " beats per minute");
            Label secondActivity = new Label( "2. " +activities[1].getActivityName());
            secondActivity.setTextFill(Color.web("#FF0000"));
            secondActivity.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
            Label secondCalRate =  new Label("Calories Burnt= " + activities[1].getCaloriesTot()+ " Calories"+"\nHeart Rate Increase =" + df.format(activities[1].getHeartRateTot()) + " beats per minute");
            Label thirdActivity = new Label( "3. " +activities[2].getActivityName());
            thirdActivity.setTextFill(Color.web("#FF0000"));
            thirdActivity.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
            Label thirdCalRate =  new Label("Calories Burnt= " + activities[2].getCaloriesTot()+ " Calories"+"\nHeart Rate Increase =" + df.format(activities[2].getHeartRateTot()) + " beats per minute");
            Label fourthActivity = new Label( "4. " +activities[3].getActivityName());
            fourthActivity.setTextFill(Color.web("#FF0000"));
            fourthActivity.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 14));
            Label fourthCalRate =  new Label("Calories Burnt= " + activities[3].getCaloriesTot()+ " Calories"+"\nHeart Rate Increase =" + df.format(activities[3].getHeartRateTot()) + " beats per minute");
            Button Exit = new Button("Exit");
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10, 15, 10 , 15));
            grid.setVgap(13);
            grid.setHgap(10);
            grid.add(ResultsLabel,0,1);
            grid.add(Calories,0,2);
            grid.add(HeartRate,0,3);
            grid.add(Rank,0,4);
            grid.add(Back,7,14);
            grid.add(Exit,8,14);
            grid.add(FirstActivity,0,5);
            grid.add(FirstCalRate,0,6);
            grid.add(secondActivity,0,7);
            grid.add(secondCalRate,0,8);
            grid.add(thirdActivity,0,9);
            grid.add(thirdCalRate,0,10);
            grid.add(fourthActivity,0,11);
            grid.add(fourthCalRate,0,12);
            Exit.setOnAction(e-> Platform.exit());

            scene = new Scene(grid, 600, 600);
            Back.setOnAction(e->{
                stage.setScene(userchoice.getScene());
            });
        }



    public Scene getScene() {

        return this.scene;

    }
}








