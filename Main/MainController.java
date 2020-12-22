/******************
 * Andre Stadler
 * 22.12.2020
 ******************/
package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController
{
    private Stage stage;

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }
    public static void show(Stage stage)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("main.fxml"));
            Parent root = fxmlLoader.load();

            //get controller which is connected to this fxml file
            MainController ctrl = fxmlLoader.getController();
            ctrl.setStage(stage);

            stage.setTitle("RPN-Rechner");
            stage.setScene(new Scene(root, 510, 300));
            stage.show();
        }
        catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Something wrong with welcome.fxml!");
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    }

    Stack<String> stack = new Stack<String>();
    StringBuilder stringBuilder = new StringBuilder();
    StringBuilder num = new StringBuilder();


    @FXML private Button b_plus;
    @FXML private Button button_C;
    @FXML private Button b_clearAll;
    @FXML private Button b_enter;
    @FXML private Button b_minus;
    @FXML private Button b_multiply;
    @FXML private Button b_divide;
    @FXML private Button b_kehrwert;
    @FXML private Button b_vertauschen;
    @FXML private TextArea textArea;
    @FXML private TextField textField;
    @FXML private Button b7;
    @FXML private Button b8;
    @FXML private Button b9;
    @FXML private Button b6;
    @FXML private Button b5;
    @FXML private Button b4;
    @FXML private Button b3;
    @FXML private Button b2;
    @FXML private Button b1;
    @FXML private Button b0;


    public void numbers()
    {
        if(b0.isArmed())
        {
            stringBuilder.append(0);
            textField.setText(stringBuilder.toString());
        }
        else if(b1.isArmed())
        {
            stringBuilder.append(1);
            textField.setText(stringBuilder.toString());
        }
        else if(b2.isArmed())
        {
            stringBuilder.append(2);
            textField.setText(stringBuilder.toString());
        }
        else if(b3.isArmed())
        {
            stringBuilder.append(3);
            textField.setText(stringBuilder.toString());
        }
        else if(b4.isArmed())
        {
            stringBuilder.append(4);
            textField.setText(stringBuilder.toString());
        }
        else if(b5.isArmed())
        {
            stringBuilder.append(5);
            textField.setText(stringBuilder.toString());
        }
        else if(b6.isArmed())
        {
            stringBuilder.append(6);
            textField.setText(stringBuilder.toString());
        }
        else if(b7.isArmed())
        {
            stringBuilder.append(7);
            textField.setText(stringBuilder.toString());
        }
        else if(b8.isArmed())
        {
            stringBuilder.append(8);
            textField.setText(stringBuilder.toString());
        }
        else if(b9.isArmed())
        {
            stringBuilder.append(9);
            textField.setText(stringBuilder.toString());
        }

    }

    public void enter()
    {
        stack.push(String.valueOf(stringBuilder));
        num.append(String.format("%s%n", stringBuilder));
        textArea.setText(String.valueOf(num));
        textField.clear();
        stringBuilder.delete(0,stringBuilder.length());

    }

    public void button_C()
    {
        textField.clear();
        stringBuilder.delete(0,stringBuilder.length());
    }


    public void button_CE ()
    {
        textField.clear();
        textArea.clear();
        stack.clear();
        stringBuilder.delete(0,stringBuilder.length());
        num.delete(0,num.length());
    }


    public void minus()
    {
    try
    {
        double num1 = Double.valueOf(stack.pop());
        double num2 = Double.valueOf(stack.pop());

        double result = num2-num1;
        stack.push(String.valueOf(result));
        textField.setText(String.valueOf(result));
        stack.clear();
    }
    catch (Exception ex)
    {
        System.out.printf("Exeption in *minus*");
    }

    }

    public void plus()
    {
        try
        {
            double num1 = Double.valueOf(stack.pop());
            double num2 = Double.valueOf(stack.pop());

            double result = num2+num1;
            stack.push(String.valueOf(result));
            textField.setText(String.valueOf(result));
            stack.clear();
        }
        catch (Exception ex)
        {
            System.out.printf("Exeption in *plus*%n");
        }

    }

    public void multiply()
    {
        try
        {
            double num1 = Double.valueOf(stack.pop());
            double num2 = Double.valueOf(stack.pop());

            double result = num2*num1;
            stack.push(String.valueOf(result));
            textField.setText(String.valueOf(result));
            stack.clear();
        }

        catch (Exception ex)
        {
            System.out.printf("Exeption in *multiply*%n");
        }

    }

    public void divide()
    {
        try
        {
            double num1 = Double.valueOf(stack.pop());
            double num2 = Double.valueOf(stack.pop());

            double result = num2/num1;
            stack.push(String.valueOf(result));
            textField.setText(String.valueOf(result));
            stack.clear();
        }
        catch (Exception ex)
        {
            System.out.printf("Exeption in *divide*%n");
        }

    }

    public void kehrwert()
    {
        try
        {
            double num1 = Double.valueOf(stack.pop());

            double result = 1/num1;
            stack.push(String.valueOf(result));
            textField.setText(String.valueOf(result));
            stack.clear();
        }
        catch (Exception ex)
        {
            System.out.printf("Exeption in *kehrwert*%n");
        }

    }

    public void vertauschen()
    {
        try
        {
            double num1 = Double.valueOf(stack.pop());
            double num2 = Double.valueOf(stack.pop());

            stack.push(String.valueOf(num2));
            stack.push(String.valueOf(num1));
            textArea.setText(String.valueOf(stack));
        }
        catch (Exception ex)
        {
            System.out.printf("Exeption in *vertauschen*%n");
        }

    }



}
