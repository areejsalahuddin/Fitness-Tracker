package Tracker;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FitnessTrackerApp extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Fitness Tracker Application");
        User user = new User(0,80);
        Swimming swim = new Swimming(4, 0.002, 0, 0,"Swimming");
        Running run = new Running(5, 0.003, 0, 0,"Running");
        KickBoxing kick = new KickBoxing(3, 0.005, 0, 0,"Kick Boxing");
        StrengthTraining train = new StrengthTraining(5, 0.006, 0, 0,"Strength Training");
        UserChoice userchoice = new UserChoice(swim,run,kick,train);
        userchoice.prepare();
        primaryStage.setScene(userchoice.getScene());
        Summary results = new Summary(swim,run,kick,train);
        UserChoice.UserChoiceWindow(primaryStage);
        Summary.SummaryStage(primaryStage);
        UserChoice.setSummary(results);
        results.setUserChoice(userchoice);
        primaryStage.show();
    }
}
