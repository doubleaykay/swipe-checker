package mystikos.swipechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    //declare time and day variables
    private int time;
    private String day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        run(); //call run method
    }

    private void run() {//method that calls everything else; can be called by pull to refresh
        time = getTime(); //store time at launch of app as integer variable
        day = getDay(); //store day at launch of app as integer variable

        checkSwipeValue(time); //method to return meal swipe value; gets passed the time int

        checkFoco(); //check if Foco is open
        checkNovack(); //check if Novack is open
        checkKAF(); //check if KAF is open
        checkHop(); //check if Hop is open

        if(day.equals("Saturday") || day.equals("Sunday")){
            //code to print that Collis is closed
        } else {
            checkCollis();
        }
    }

    private int getTime() {
        return 5; //TODO add code to get 24hr time as an int
    }

    private String getDay() {
        return "Test"; //TODO add code to get current day as string
    }

    private void checkSwipeValue(int time) {
        //TODO add code to check swipe value based on
    }

    private void checkFoco() {
        //TODO
    }

    private void checkNovack() {
        //TODO
    }

    private void checkKAF() {
        //TODO
    }

    private void checkHop() {
        //TODO
    }

    private void checkCollis() {
        //TODO
    }
}
