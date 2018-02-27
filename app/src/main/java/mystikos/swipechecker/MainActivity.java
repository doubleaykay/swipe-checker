package mystikos.swipechecker;

import android.support.annotation.IntRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Range;
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
    private TextView JtextSwipeValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find textviews
        JtextDay = (TextView) findViewById(R.id.textDay);
        JtextTime = (TextView) findViewById(R.id.textTime);
        JtextSwipeValue = (TextView) findViewById(R.id.textSwipeValue);

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
        String t = df.format(Calendar.getInstance().getTime());//get 24 hour time with no colon
        return Integer.parseInt(t);//return time as int
    }

    private String getDay() {
        DateFormat df = new SimpleDateFormat("EEEE");
        String d = df.format(Calendar.getInstance().getTime());//get full name of day
        return d;//return day as string
    }

    public static boolean between(int i, int min, int max) {//check if int provided is within provided range. https://alvinalexander.com/java/java-method-integer-is-between-a-range
        if (i >= min && i <= max)
            return true;
        else
            return false;
    }

    private void checkSwipeValue() {//check if time variable is between certain ranges
        if (between(time, 700, 1059)){
            JtextSwipeValue.setText("$5.25");//breakfast
        } else if (between(time, 2100, 2400)){
            JtextSwipeValue.setText("$5.25");//latenight 1
        } else if (between(time, 0, 700)){
            JtextSwipeValue.setText("$5.25");//latenight 2
        } else if (between(time, 1100, 1559)){
            JtextSwipeValue.setText("$7.75");//lunch
        } else if (between(time, 1600, 2059)){
            JtextSwipeValue.setText("$10.00");//dinner
        }
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
