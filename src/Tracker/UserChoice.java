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
import jdk.nashorn.internal.runtime.regexp.RegExpFactory;

import java.text.DecimalFormat;

public class UserChoice {
    Swimming swim;
    Running run;
    KickBoxing kickbox;
    StrengthTraining strength;
    static Summary results;
    static Stage stage;
    Scene scene;
    public static void UserChoiceWindow(Stage stage){
        UserChoice.stage = stage;
    }
    public static void setSummary(Summary results) {
        UserChoice.results = results;
    }

    public UserChoice(Swimming swim, Running run, KickBoxing kickbox, StrengthTraining strength) {
        this.swim = swim;
        this.run = run;
        this.kickbox = kickbox;
        this.strength = strength;

    }
    public void prepare() {
        DecimalFormat df = new DecimalFormat("0.000");
        Label Choose =  new Label("Choose an Activity:");
        Choose.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
        Label TypeOfActivities = new Label("     Swimming\n     Running\n     Kick Boxing\n     Strength Training");
        Label EnterActivity = new Label("Enter Activity");
        Label Time = new Label("Time in minutes:");
        TextField EnterField= new TextField();
        TextField TimeField = new TextField();
        Button Confirm = new Button("Confirm");
        Label Timevalidation = new Label();
        Label ActValidation = new Label();
        Label heartRateLabel = new Label("Heart Rate=  " + User.getHeartRate() + " bpm");
        Label caloriesLabel = new Label("Calories Burnt=  " + User.getCalories() + " cals");
        Label Recorded = new Label();
        Button FinalResult = new Button("Final Results");
        Button Exit = new Button("Exit");
        GridPane grid = new GridPane();
        //grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10, 15, 10 , 15));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.add(Choose,0,0);
        grid.add(TypeOfActivities, 0, 1);
        grid.add(EnterActivity, 0, 3);
        grid.add(EnterField, 0, 4);
        EnterField.setPrefWidth(200); EnterField.setMaxWidth(200);
        grid.add(Time, 1, 3);
        grid.add(TimeField, 1, 4);
        TimeField.setPrefWidth(200); TimeField.setMaxWidth(200);
        grid.add(Confirm,2,4);
        grid.add(Timevalidation, 1, 6);
        grid.add(ActValidation, 0, 6);
        grid.add(caloriesLabel, 0,8 );
        grid.add(heartRateLabel, 0,7);
        grid.add(FinalResult,2,10);
        grid.add(Exit,3,10);
        grid.add(Recorded,0,9);
        FinalResult.setPrefWidth(200);
        Exit.setPrefWidth(150);
        heartRateLabel.setPrefWidth(250);
        FinalResult.setOnAction(e-> {
            results.SummaryWindow();
            stage.setScene(results.getScene());});
        Exit.setOnAction(e-> Platform.exit());

        Confirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String activity= EnterField.getText();
                int time = 0;
                try {
                    Timevalidation.setText("");
                    time = Integer.parseInt(TimeField.getText());
                    //Some operations
                } catch (NumberFormatException e) {
                    //Here for example prompt some window notifying user
                    Timevalidation.setText("Please Enter time \nwith numbers");
                    Timevalidation.setTextFill(Color.web("#FF0000"));
                    Timevalidation.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 13));
                }
                if(activity.equalsIgnoreCase("Swimming"))
                {    ActValidation.setText("");
                    swim.operateActivity(time);
                    heartRateLabel.setText("Heart Rate= " + df.format(User.getHeartRate())  + " bpm");
                    caloriesLabel.setText("Calories Burnt=  " + User.getCalories() + " cal");
                    Recorded.setText("Activity recorded \n successfully");
                    Recorded.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

                }
                else if(activity.equalsIgnoreCase("Running"))
                {   ActValidation.setText("");
                    run.operateActivity(time);
                    heartRateLabel.setText("Heart Rate= " + df.format(User.getHeartRate()) + " bpm");
                    caloriesLabel.setText("Calories Burnt=  " + User.getCalories() + " cal");
                    Recorded.setText("Activity recorded \n successfully");
                    Recorded.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

                }
                else if(activity.equalsIgnoreCase("Kick Boxing"))
                {   ActValidation.setText("");
                    kickbox.operateActivity(time);
                    heartRateLabel.setText("Heart Rate= " + df.format(User.getHeartRate()) + " bpm");
                    caloriesLabel.setText("Calories Burnt=  " + User.getCalories() + " cal");
                    Recorded.setText("Activity recorded\n successfully");
                    Recorded.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

                }
                else if(activity.equalsIgnoreCase("Strength Training"))
                {   ActValidation.setText("");
                    strength.operateActivity(time);
                    heartRateLabel.setText("Heart Rate= " + df.format(User.getHeartRate()) + " bpm");
                    caloriesLabel.setText("Calories Burnt=  " + User.getCalories() + " cal");
                    Recorded.setText("Activity recorded\n successfully");
                    Recorded.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

                }
                else {
                    ActValidation.setText("Please Enter one of \nthe above Activities");
                    ActValidation.setTextFill(Color.web("#FF0000"));
                    ActValidation.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
                    Recorded.setText("");
                }
            }

        });
        scene = new Scene(grid, 600, 400);
    }
    public Scene getScene(){return this.scene;}

}

















