package com.example.android.sunshine.app;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Pranav on 31/07/16.
 */
public class Utils {

    public static final String HIGH_TEMP = "high";
    public static final String LOW_TEMP = "low";
    public static final String WEATHER_ID = "weather_id";


    public static SharedPreferences getPreferencesInstance(SharedPreferences preferences, Context context) {

        if (preferences == null) {

            return PreferenceManager.getDefaultSharedPreferences(context);
        }

        return preferences;
    }

    public static String getData(String id, String value, Context context) {
        if (id != null && id.trim().length() > 0) {
            SharedPreferences preferences = Utils.getPreferencesInstance(null, context);
            value = preferences.getString(id, value);
        }
        return value;
    }

    public static void saveData(String id, String value, Context context) {
        // TODO Auto-generated method stub
        SharedPreferences preferences = Utils.getPreferencesInstance(null, context);
        preferences.edit().putString(id, value).commit();
    }

    public static int getData(String id, int value, Context context) {
        if (id != null && id.trim().length() > 0) {
            SharedPreferences preferences = Utils.getPreferencesInstance(null, context);
            value = preferences.getInt(id, value);
        }
        return value;
    }

    public static void saveData(String id, int value, Context context) {
        // TODO Auto-generated method stub
        SharedPreferences preferences = Utils.getPreferencesInstance(null, context);
        preferences.edit().putInt(id, value).commit();
    }

    public static Float getData(String id, Float value, Context context) {
        if (id != null && id.trim().length() > 0) {
            SharedPreferences preferences = Utils.getPreferencesInstance(null, context);
            value = preferences.getFloat(id, value);
        }
        return value;
    }

    public static void saveData(String id, Float value, Context context) {
        // TODO Auto-generated method stub
        SharedPreferences preferences = Utils.getPreferencesInstance(null, context);
        preferences.edit().putFloat(id, value).commit();
    }

    public static int getIconResourceForWeatherCondition(int weatherId) {
        // Based on weather code data found at:
        // http://bugs.openweathermap.org/projects/api/wiki/Weather_Condition_Codes
        if (weatherId >= 200 && weatherId <= 232) {
            return R.drawable.ic_storm;
        } else if (weatherId >= 300 && weatherId <= 321) {
            return R.drawable.ic_light_rain;
        } else if (weatherId >= 500 && weatherId <= 504) {
            return R.drawable.ic_rain;
        } else if (weatherId == 511) {
            return R.drawable.ic_snow;
        } else if (weatherId >= 520 && weatherId <= 531) {
            return R.drawable.ic_rain;
        } else if (weatherId >= 600 && weatherId <= 622) {
            return R.drawable.ic_snow;
        } else if (weatherId >= 701 && weatherId <= 761) {
            return R.drawable.ic_fog;
        } else if (weatherId == 761 || weatherId == 781) {
            return R.drawable.ic_storm;
        } else if (weatherId == 800) {
            return R.drawable.ic_clear;
        } else if (weatherId == 801) {
            return R.drawable.ic_light_clouds;
        } else if (weatherId >= 802 && weatherId <= 804) {
            return R.drawable.ic_cloudy;
        }
        return -1;
    }

}
