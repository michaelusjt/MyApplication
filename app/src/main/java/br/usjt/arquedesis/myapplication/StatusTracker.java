package br.usjt.arquedesis.myapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StatusTracker extends AppCompatActivity {

    private Map<String, String> mStatusMap;
    private List<String> mMethodList;
    private static StatusTracker ourInstance = new StatusTracker();
    private static final String STATUS_SUFFIX = "ed";

    public static StatusTracker getInstance() {
        return ourInstance;
    }

    private StatusTracker() {
        mStatusMap = new LinkedHashMap<String, String>();
        mMethodList = new ArrayList<String>();
    }

    public List<String> getMethodList() {
        return mMethodList;
    }

    public void clear() {
        mMethodList.clear();
        mStatusMap.clear();
    }

    /**
     * Adds the status value for the given activityName into the Map.
     *
     * @param activityName
     * @param status
     */
    public void setStatus(String activityName, String status) {
        mMethodList.add(activityName + "." + status + "()");
        if (mStatusMap.containsKey(activityName)) mStatusMap.remove(activityName);
        mStatusMap.put(activityName, status);
    }

    /**
     * Gets the status value for the given activityName.
     *
     * @param activityName
     * @return
     */
    public String getStatus(String activityName) {
        String status = mStatusMap.get(activityName);
        status = status.substring(2, status.length());

        // String manipulation to ensure the status value is spelled correctly.
        if (status.endsWith("e")) {
            status = status.substring(0, status.length() - 1);
        }
        if (status.endsWith("p")) {
            status = status + "p";
        }
        status = status + STATUS_SUFFIX;
        return status;
    }

    public Set<String> keySet() {
        return mStatusMap.keySet();
    }


}
