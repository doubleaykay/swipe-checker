package mystikos.swipechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //declare time and day variables
    private int time;
    private String day;

    //declare day and time textviews
    private TextView JtextDay;
    private TextView JtextTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JtextDay = (TextView) findViewById(R.id.textDay);
        JtextTime = (TextView) findViewById(R.id.textTime);

        run(); //call run method
    }

    private void run() {//method that calls everything else; can be called by pull to refresh
        day = getDay(); //store day at launch of app as integer variable
        time = getTime(); //store time at launch of app as integer variable

        //TEMP
        JtextDay.setText(day);
        JtextTime.setText(String.valueOf(time));
        //END TEMP

        checkSwipeValue(); //method to return meal swipe value

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
        DateFormat df = new SimpleDateFormat("HHmm");
        String t = df.format(Calendar.getInstance().getTime());
        return Integer.parseInt(t);
    }

    private String getDay() {
        DateFormat df = new SimpleDateFormat("EEE");
        String d = df.format(Calendar.getInstance().getTime());
        return d;
    }

    private void checkSwipeValue() {
        //TODO
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
