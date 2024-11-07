package com.example.operationsplash;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Poly25Service extends Service {
    private double greenFraction;
    private Handler handler;
    private Runnable runnable;
    private long totalDuration = 30000; // in milliseconds
    private long startTime;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private String polygonId;


    public Poly25Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        polygonId = intent.getStringExtra("polygonId");
        greenFraction = intent.getDoubleExtra("greenFraction", 0.0);
        if (greenFraction < 0.0 || greenFraction > 1.0) {
            stopSelf();
            return START_NOT_STICKY;
        }

        startTime = System.currentTimeMillis();

        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                updatePolygonColor();
            }
        };
        handler.postDelayed(runnable, 0); // Start immediately

        return START_STICKY;
    }

    private void updatePolygonColor() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        if (elapsedTime >= totalDuration) {
            stopSelf();

            // Update the final polygon color in Firestore directly
            int finalColor = Color.argb(100, 255, 0, 0);
            updatePolygonColorInFirestore(finalColor);

            return;
        }

        float currentFraction = ((float) elapsedTime / totalDuration);

        int ogColor = Color.argb(100, (int) (255 * (1 - greenFraction)), (int) (255 * greenFraction), 0);
        int updatedColor = blendColors(ogColor, Color.argb(100, 255, 0, 0), currentFraction);

        // Update the polygon color in Firestore directly
        updatePolygonColorInFirestore(updatedColor);

        handler.postDelayed(runnable, 2000); // Update every 2 seconds
    }

    private void updatePolygonColorInFirestore(int updatedColor) {
        Map<String, Object> polygonMap = new HashMap<>();
        polygonMap.put("fillColor", updatedColor);
        polygonMap.put("strokeColor", updatedColor);

        // Update Firestore with the new polygon color
        db.collection("polygons").document(polygonId)
                .update(polygonMap)
                .addOnSuccessListener(aVoid -> Log.d("Poly1Service", "Polygon color successfully updated in Firestore!"))
                .addOnFailureListener(e -> Log.w("Poly1Service", "Error updating polygon color in Firestore", e));
    }

    private int blendColors(int startColor, int endColor, float fraction) {
        int startA = Color.alpha(startColor);
        int startR = Color.red(startColor);
        int startG = Color.green(startColor);
        int startB = Color.blue(startColor);

        int endA = Color.alpha(endColor);
        int endR = Color.red(endColor);
        int endG = Color.green(endColor);
        int endB = Color.blue(endColor);

        int newA = (int) (startA + (endA - startA) * fraction);
        int newR = (int) (startR + (endR - startR) * fraction);
        int newG = (int) (startG + (endG - startG) * fraction);
        int newB = (int) (startB + (endB - startB) * fraction);

        return Color.argb(newA, newR, newG, newB);
    }
}