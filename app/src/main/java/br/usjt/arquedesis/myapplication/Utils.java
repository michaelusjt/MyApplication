package br.usjt.arquedesis.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class Utils extends AppCompatActivity {

    private static br.usjt.arquedesis.Utils.StatusTracker mStatusTracker = br.usjt.arquedesis.Utils.StatusTracker.getInstance();

    /**
     * Helper method to print out the lifecycle state of each Activity.  Note this has
     * been wrapped in a Handler to delay the output due to overlaps in lifecycle state
     * changes as one Activity launches another.
     * @link http://developer.android.com/guide/topics/fundamentals/activities.html#CoordinatingActivities
     * @param viewMethods TextView to list out the lifecycle methods called
     * @param viewStatus TextView to list out the status of all Activity classes
     */
    public static void printStatus(final TextView viewMethods, final TextView viewStatus) {
        Handler handler = new Handler();
        boolean b = handler.postDelayed(new Runnable() {
            public void run() {
                // Get the stack of Activity lifecycle methods called and print to TextView
                StringBuilder sbMethods = new StringBuilder();
                List<String> listMethods = mStatusTracker.getMethodList();
                for (String method : listMethods) {
                    sbMethods.insert(0, method + "\r\n");
                }
                if (viewMethods != null) {
                    viewMethods.setText(sbMethods.toString());
                }

                // Get the status of all Activity classes and print to TextView
                StringBuilder sbStatus = new StringBuilder();
                for (String key : mStatusTracker.keySet()) {
                    sbStatus.insert(0, key + ": " + mStatusTracker.getStatus(key) + "\n");
                }
                if (viewStatus != null) {
                    viewStatus.setText(sbStatus.toString());
                }
            }
        }, 750);
    }


}
