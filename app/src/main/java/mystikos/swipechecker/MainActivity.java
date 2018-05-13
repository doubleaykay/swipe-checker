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
    }

    @Override
    public void onResume() {
        super.onResume();

        // load data
        run();
    }

    private void run() {//method that calls everything else; can be called by pull to refresh
        day = getDay(); //store day at launch of app as integer variable
        time = getTime(); //store time at launch of app as integer variable

        //TEMP
        JtextDay.setText(day);
        JtextTime.setText(String.valueOf(time));
        //END TEMP

        title(); //method to set title of activity to date

        checkSwipeValue(); //method to return meal swipe value

        checkFoco(); //check if Foco is open
        checkNovack(); //check if Novack is open
        checkKAF(); //check if KAF is open
        checkHop(); //check if Hop is open
        checkCollis(); //check if Collis is open
    }

    private int getTime() {
        DateFormat mf = new SimpleDateFormat("mm");
        DateFormat hf = new SimpleDateFormat("HH");
        int h = Integer.parseInt(hf.format(Calendar.getInstance().getTime()));//get 24 hour time with no colon
        int m = Integer.parseInt(mf.format(Calendar.getInstance().getTime()));//get 24 hour time with no colon
        return toTime(h, m); //return time as int
    }

    private int toTime(int h, int m) {
        return (h * 60) + m; //return time as int
    }

    private String getDay() {
        DateFormat df = new SimpleDateFormat("EEEE");
        String d = df.format(Calendar.getInstance().getTime());//get full name of day
        return d;//return day as string
    }

    private void title (){ //gets date in the format of "Monday, January 1"
        DateFormat df = new SimpleDateFormat("EEEE, MMMM d");
        setTitle(df.format(Calendar.getInstance().getTime()));
    }

    public static boolean between(int i, int min, int max) {//check if int provided is within provided range. https://alvinalexander.com/java/java-method-integer-is-between-a-range
        if (i >= min && i <= max)
            return true;
        else
            return false;
    }

    private void checkSwipeValue() {//check if time variable is between certain ranges
        if (between(time, toTime(7, 0), toTime(10,59))) {
            JtextSwipeValue.setText("$5.25");//breakfast
        } else if (between(time, toTime(21, 00), toTime(24,00))) {
            JtextSwipeValue.setText("$5.25");//latenight 1
        } else if (between(time, toTime(0, 0), toTime(7, 0))) {
            JtextSwipeValue.setText("$5.25");//latenight 2
        } else if (between(time, toTime(11,00),toTime(15,59))) {
            JtextSwipeValue.setText("$7.75");//lunch
        } else if (between(time, toTime(16,00), toTime(20,59))) {
            JtextSwipeValue.setText("$10.00");//dinner
        }
    }

    private void checkFoco() {
        if(day.equals("Saturday") || day.equals("Sunday")){
            if (between(time, toTime(8, 00), toTime(14,30))){

            } else if (between(time, toTime(17, 00), toTime(20,30))){

            } else {
                //TODO foco closed
            }
        } else {
            if (between(time, toTime(7, 30), toTime(10,30))){

            } else if (between(time, toTime(11, 00), toTime(15,00))){

            } else if (between(time, toTime(17, 00), toTime(20,30))){

            } else {
                //TODO foco closed
            }
        }
    }

    private void checkNovack() {
        if(day.equals("Saturday")) {
            if (between(time, toTime(13, 00), toTime(14, 00))) {
                // TODO novack open
            } else {
                // TODO novack closed
            }
        } else if (day.equals("Sunday")) {
            if (between(time, toTime(11, 00), toTime(14, 00))) {
                // TODO novack open
            } else {
                // TODO novack closed
            }
        } else {
            if (between(time, toTime(7, 30), toTime(14, 00))) {
                // TODO novack open
            } else {
                // TODO novack closed
            }
        }
    }

    private void checkKAF() {
        if(day.equals("Saturday") || day.equals("Sunday")){
            //TODO closed
        } else {
            if (between(time, toTime(8, 00), toTime(17,00))){

            } else {
                //TODO KAF closed
            }
        }
    }

    private void checkHop() {
        //TODO
    }

    private void checkCollis() {
        if(day.equals("Saturday") || day.equals("Sunday")){
            //TODO collis closed
        } else {
            if (between(time, toTime(7, 00), toTime(20,00))){

            } else {
                //TODO collis closed
            }
        }
    }
}
