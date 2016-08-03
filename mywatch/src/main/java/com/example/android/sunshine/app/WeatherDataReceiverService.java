package com.example.android.sunshine.app;

import android.util.Log;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.DataMap;
import com.google.android.gms.wearable.DataMapItem;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;


/**
 * Created by Pranav on 31/07/16.
 */
public class WeatherDataReceiverService extends WearableListenerService {

    private String TAG = "WeatherDataReceiverService";



    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        super.onMessageReceived(messageEvent);
        Log.d(TAG, "onMessageReceived");
    }

    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {
        super.onDataChanged(dataEventBuffer);

        for (DataEvent dataEvent : dataEventBuffer) {

            Log.d(TAG, "onDataChanged" + " : " + dataEvent.getType() );

            if (dataEvent.getType() == DataEvent.TYPE_CHANGED) {
                DataMap dataMap = DataMapItem.fromDataItem(dataEvent.getDataItem()).getDataMap();
                String path = dataEvent.getDataItem().getUri().getPath();
                Log.d(TAG, "onDataChanged" + " : " + dataEvent.getType() +" : " + path);
                if (path.equals("/sunshine")) {
                    float low = (float) dataMap.getDouble("low");
                    int weatherId = dataMap.getInt("weatherId");
                    float high = (float)dataMap.getDouble("high");
                    Log.d(TAG, "low =" + low + " high = " + high);

                    Utils.saveData(Utils.HIGH_TEMP, high, getBaseContext());
                    Utils.saveData(Utils.LOW_TEMP, low, getBaseContext());
                    Utils.saveData(Utils.WEATHER_ID, weatherId, getBaseContext());

                }
            }
        }

    }
}
