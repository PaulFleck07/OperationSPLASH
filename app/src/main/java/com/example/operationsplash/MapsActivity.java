package com.example.operationsplash;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.example.operationsplash.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.annotation.SuppressLint;

import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import android.widget.Toast;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnMyLocationButtonClickListener,
        OnMyLocationClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback,
        GoogleMap.OnPolygonClickListener,
        OverlayFragment.OnFragmentInteractionListener,
        OverlayFragment.AnimationServiceUpdate
{

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;
    private boolean permissionDenied = false;
    private boolean isMapsActivityRunning = false;

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private Polygon poly1;
    private Polygon poly2;
    private Polygon poly3;
    private Polygon poly4;
    private Polygon poly5;

    ExecutorService executorService = Executors.newSingleThreadExecutor();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        enableMyLocation();
        mMap.setOnPolygonClickListener(this);



        // Check if the polygon exists in Firestore before creating a new one
        db.collection("polygons").document("poly1").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly1");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly1 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.604422, -73.570834),
                                        new LatLng(40.603973, -73.574583),
                                        new LatLng(40.606350, -73.575530),
                                        new LatLng(40.606514, -73.573365))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly1.setStrokeJointType(JointType.ROUND);
                        poly1.setClickable(true);
                        poly1.setTag("poly1");
                        savePolygonToFirestore(poly1, "poly1");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));

        db.collection("polygons").document("poly2").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly2");
                            Log.d(TAG, "onMapReady: Can load Polygon22 colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon22 colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly2 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.605052, -73.568133),
                                        new LatLng(40.607145, -73.568184),
                                        new LatLng(40.608404, -73.565173),
                                        new LatLng(40.608008, -73.563310),
                                        new LatLng(40.609068, -73.559183),
                                        new LatLng(40.609966, -73.557575),
                                        new LatLng(40.608768, -73.554176),
                                        new LatLng(40.606787, -73.560700))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly2.setStrokeJointType(JointType.ROUND);
                        poly2.setClickable(true);
                        poly2.setTag("poly2");
                        savePolygonToFirestore(poly2, "poly2");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));

        db.collection("polygons").document("poly3").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly3");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly3 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.630186, -73.562643),
                                        new LatLng(40.631263, -73.563873),
                                        new LatLng(40.632336, -73.564047),
                                        new LatLng(40.637467, -73.564109),
                                        new LatLng(40.639927, -73.564914),
                                        new LatLng(40.640512, -73.564603),
                                        new LatLng(40.640527, -73.563409),
                                        new LatLng(40.635764, -73.562082),
                                        new LatLng(40.632336, -73.562227))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly3.setStrokeJointType(JointType.ROUND);
                        poly3.setClickable(true);
                        poly3.setTag("poly3");
                        savePolygonToFirestore(poly3, "poly3");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly4").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly4");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly4 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.638047, -73.565238),
                                        new LatLng(40.640002, -73.566577),
                                        new LatLng(40.641745, -73.568415),
                                        new LatLng(40.642587, -73.568198),
                                        new LatLng(40.641183, -73.566501),
                                        new LatLng(40.639054, -73.565455))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly4.setStrokeJointType(JointType.ROUND);
                        poly4.setClickable(true);
                        poly4.setTag("poly4");
                        savePolygonToFirestore(poly4, "poly4");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly5").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly5");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly5 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.629917, -73.562873),
                                        new LatLng(40.628183, -73.568104),
                                        new LatLng(40.625341, -73.570640),
                                        new LatLng(40.622019, -73.571542),
                                        new LatLng(40.620950, -73.569378),
                                        new LatLng(40.622586, -73.562217),
                                        new LatLng(40.625995, -73.563340))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly5.setStrokeJointType(JointType.ROUND);
                        poly5.setClickable(true);
                        poly5.setTag("poly5");
                        savePolygonToFirestore(poly5, "poly5");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));




    }
    private void checkAndUpdatePolygon() {
        Executors.newSingleThreadExecutor().execute(() -> {
            while (isMapsActivityRunning) {
                // Query Firestore for polygon data
                db.collection("polygons").document("poly1")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly1.getFillColor() != newFillColor || poly1.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly1.setFillColor(newFillColor);
                                        poly1.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly2")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly2.getFillColor() != newFillColor || poly2.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly2.setFillColor(newFillColor);
                                        poly2.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly3")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly3.getFillColor() != newFillColor || poly3.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly3.setFillColor(newFillColor);
                                        poly3.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly4")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly4.getFillColor() != newFillColor || poly4.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly4.setFillColor(newFillColor);
                                        poly4.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly5")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly5.getFillColor() != newFillColor || poly5.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly5.setFillColor(newFillColor);
                                        poly5.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });

                // Sleep for a while before checking again
                try {
                    Thread.sleep(2000); // 2 seconds or whatever interval you choose
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
    }

    public void loadPolygonFromFirestore(String polygonId) {

        //******Try ExecuteSertvice********
        executorService.execute(() -> {
            //******Try ExecuteSertvice********

        db.collection("polygons").document(polygonId).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        // Retrieve and set the polygon colors
                        int fillColor = documentSnapshot.getLong("fillColor").intValue();
                        int strokeColor = documentSnapshot.getLong("strokeColor").intValue();

                        //******Try ExecuteSertvice********
                        runOnUiThread(() -> {
                            //******Try ExecuteSertvice********


                        // Create a new polygon with the saved colors
                            if ( polygonId.equals("poly1")) {
                                poly1 = mMap.addPolygon(new PolygonOptions()
                                        .add(
                                                new LatLng(40.604422, -73.570834),
                                                new LatLng(40.603973, -73.574583),
                                                new LatLng(40.606350, -73.575530),
                                                new LatLng(40.606514, -73.573365))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly1.setStrokeJointType(JointType.ROUND);
                                poly1.setClickable(true);

                                poly1.setTag("poly1");
                            }
                            else if (polygonId.equals("poly2")) {
                                poly2 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.605052, -73.568133),
                                                new LatLng(40.607145, -73.568184),
                                                new LatLng(40.608404, -73.565173),
                                                new LatLng(40.608008, -73.563310),
                                                new LatLng(40.609068, -73.559183),
                                                new LatLng(40.609966, -73.557575),
                                                new LatLng(40.608768, -73.554176),
                                                new LatLng(40.606787, -73.560700))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly2.setStrokeJointType(JointType.ROUND);
                                poly2.setClickable(true);
                                poly2.setTag("poly2");

                            }
                            else if (polygonId.equals("poly3")) {
                                poly3 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.630186, -73.562643),
                                                new LatLng(40.631263, -73.563873),
                                                new LatLng(40.632336, -73.564047),
                                                new LatLng(40.637467, -73.564109),
                                                new LatLng(40.639927, -73.564914),
                                                new LatLng(40.640512, -73.564603),
                                                new LatLng(40.640527, -73.563409),
                                                new LatLng(40.635764, -73.562082),
                                                new LatLng(40.632336, -73.562227))
                                        .strokeColor(Color.argb(100, 0, 255, 0))
                                        .fillColor(Color.argb(100, 0, 255, 0)));
                                poly3.setStrokeJointType(JointType.ROUND);
                                poly3.setClickable(true);
                                poly3.setTag("poly3");
                            } else if (polygonId.equals("poly4")){
                                poly4 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.638047, -73.565238),
                                                new LatLng(40.640002, -73.566577),
                                                new LatLng(40.641745, -73.568415),
                                                new LatLng(40.642587, -73.568198),
                                                new LatLng(40.641183, -73.566501),
                                                new LatLng(40.639054, -73.565455))
                                        .strokeColor(Color.argb(100, 0, 255, 0))
                                        .fillColor(Color.argb(100, 0, 255, 0)));
                                poly4.setStrokeJointType(JointType.ROUND);
                                poly4.setClickable(true);
                                poly4.setTag("poly4");
                            } else if (polygonId.equals("poly5")){
                                poly5 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.629917, -73.562873),
                                                new LatLng(40.628183, -73.568104),
                                                new LatLng(40.625341, -73.570640),
                                                new LatLng(40.622019, -73.571542),
                                                new LatLng(40.620950, -73.569378),
                                                new LatLng(40.622586, -73.562217),
                                                new LatLng(40.625995, -73.563340))
                                        .strokeColor(Color.argb(100, 0, 255, 0))
                                        .fillColor(Color.argb(100, 0, 255, 0)));
                                poly5.setStrokeJointType(JointType.ROUND);
                                poly5.setClickable(true);
                                poly5.setTag("poly5");
                            }

                        // Now it's safe to call checkAndUpdatePolygon
                        if (isMapsActivityRunning) {
                            checkAndUpdatePolygon();
                        }
                        //******Try ExecuteSertvice********
                        });
                        //******Try ExecuteSertvice********

                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error loading polygon colors", e));

            //******Try ExecuteSertvice********
        });
        //******Try ExecuteSertvice********

    }

   /* public void savePolygonToFirestore(Polygon polygon, String polygonId) {
        // Extract the polygon's colors
        //******Try ExecuteSertvice********
            executorService.execute(() -> {
        //******Try ExecuteSertvice********



        int fillColor = polygon.getFillColor();
        int strokeColor = polygon.getStrokeColor();

        // Create a map of the color data
        Map<String, Object> polygonMap = new HashMap<>();
        polygonMap.put("fillColor", fillColor);
        polygonMap.put("strokeColor", strokeColor);

        // Save the colors to Firestore
        db.collection("polygons").document(polygonId)
                .set(polygonMap)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully written!"))
                .addOnFailureListener(e -> Log.w(TAG, "Error writing document", e));

                //******Try ExecuteSertvice********
            });
                    //******Try ExecuteSertvice********

    }*/
    public void savePolygonToFirestore(Polygon polygon, String polygonId) {
    if (polygon == null) {
        Log.e(TAG, "Polygon is null, cannot save");
        return;
    }

    // Extract polygon attributes
    List<LatLng> points = polygon.getPoints();
    int fillColor = polygon.getFillColor();
    int strokeColor = polygon.getStrokeColor();
    float strokeWidth = polygon.getStrokeWidth();
    int jointType = polygon.getStrokeJointType();  // Extract joint type
    boolean isClickable = polygon.isClickable();
    boolean isVisible = polygon.isVisible();

    // Create a map for polygon attributes
    Map<String, Object> polygonMap = new HashMap<>();
    polygonMap.put("points", pointsToMap(points));
    polygonMap.put("fillColor", fillColor);
    polygonMap.put("strokeColor", strokeColor);
    polygonMap.put("strokeWidth", strokeWidth);
    polygonMap.put("jointType", jointType);  // Include joint type
    polygonMap.put("isClickable", isClickable);
    polygonMap.put("isVisible", isVisible);

    // Save to Firestore asynchronously
    executorService.execute(() -> {
        db.collection("polygons").document(polygonId)
                .set(polygonMap)
                .addOnSuccessListener(aVoid -> Log.d(TAG, "Polygon successfully written to Firestore"))
                .addOnFailureListener(e -> Log.w(TAG, "Error writing polygon to Firestore", e));
    });
}
    private List<Map<String, Object>> pointsToMap(List<LatLng> points) {
        List<Map<String, Object>> pointsList = new ArrayList<>();
        for (LatLng point : points) {
            Map<String, Object> pointMap = new HashMap<>();
            pointMap.put("latitude", point.latitude);
            pointMap.put("longitude", point.longitude);
            pointsList.add(pointMap);
        }
        return pointsList;
    }

    public void updatePolygonToFirestore(Polygon polygon, String polygonId) {

            int fillColor = polygon.getFillColor();
            int strokeColor = polygon.getStrokeColor();

            // Create a map of the color data to update
            Map<String, Object> polygonMap = new HashMap<>();
            polygonMap.put("fillColor", fillColor);
            polygonMap.put("strokeColor", strokeColor);

            // Update the colors in Firestore
            db.collection("polygons").document(polygonId)
                    .update(polygonMap)
                    .addOnSuccessListener(aVoid -> Log.d(TAG, "DocumentSnapshot successfully updated!"))
                    .addOnFailureListener(e -> Log.w(TAG, "Error updating document", e));


    }


    public void onPolygonClick(@NonNull Polygon polygon) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Polygon Clicked");
        builder.setMessage("Do you want to continue or exit?");
        builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User chose to continue
                dialog.dismiss();
                addOverlayFragment(getPolygonId(polygon), polygon);
                Log.d(TAG, "Polygon clicked"+ getPolygonId(polygon));



            }
        });
        builder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User chose to exit
                dialog.dismiss(); // Close the activity

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();


    }



   private void addOverlayFragment(String polygonId, Polygon polygon) {
        OverlayFragment overlayFragment = new OverlayFragment();

        overlayFragment.setPolygonId(polygonId);
       

        overlayFragment.setPolygon(polygon);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.fragment_container, overlayFragment); // R.id.fragment_container is the FrameLayout in your layout
        fragmentTransaction.addToBackStack(null); // Optional, for back navigation
        fragmentTransaction.commit();

        // Optionally, update the progress bar after adding the fragment
        fragmentManager.executePendingTransactions(); // Ensure the fragment is added before accessing it

        double greenFraction = Color.green(polygon.getFillColor()) / 255.0;
        int progress = (int) ((greenFraction * 100)+.5);//rounded to nearest integer
        overlayFragment.setProgress(progress);
    }
    @Override
    public void onCloseFragment() {
        // Logic to close the fragment
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment != null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.remove(fragment);
            transaction.commit();
        }
    }


    @Override
    public void beginPolyService(Polygon polygon, String polygonId, float progress) {

        double greenFraction = (((int) (progress + .5)) / 100.0);
        int updatedColor = Color.argb(100, (int) (255 * (1 - greenFraction)), (int) (255 * greenFraction), 0);
        Log.d(TAG, polygonId + " is good");
        polygon.setFillColor(updatedColor);
        polygon.setStrokeColor(updatedColor);

        if (polygonId != null && !polygonId.isEmpty()) {
            updatePolygonToFirestore(polygon, polygonId);
            Log.d(TAG, polygonId + " is goood");
        } else {
            Log.e(TAG, polygonId + " is null or empty in beginPolyService");
            return;
        }

        if (polygonId.equals("poly1")) {
            Intent intent = new Intent(this, Poly1Service.class);

            intent.putExtra("polygonId", "poly1");
            intent.putExtra("greenFraction", greenFraction);
            startService(intent);
        } else if (polygonId.equals("poly2")) {
            Intent intent1 = new Intent(this, Poly2Service.class);
            intent1.putExtra("polygonId", "poly2");
            intent1.putExtra("greenFraction", greenFraction);
            startService(intent1);
            Log.d(TAG, polygonId + " is service called");
        } else if (polygonId.equals("poly3")) {
            Intent intent2 = new Intent(this, Poly3Service.class);
            intent2.putExtra("polygonId", "poly3");
            intent2.putExtra("greenFraction", greenFraction);
            startService(intent2);
        } else if (polygonId.equals("poly4")) {
            Intent intent3 = new Intent(this, Poly4Service.class);
            intent3.putExtra("polygonId", "poly4");
            intent3.putExtra("greenFraction", greenFraction);
            startService(intent3);
        } else if (polygonId.equals("poly5")) {
            Intent intent4 = new Intent(this, Poly5Service.class);
            intent4.putExtra("polygonId", "poly5");
            intent4.putExtra("greenFraction", greenFraction);
            startService(intent4);
        }
    }



    private String getPolygonId(Polygon polygon) {

            return polygon.getTag() != null ? polygon.getTag().toString() : null;

    }



    @SuppressLint("MissingPermission")
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED
                || ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
            return;
        }

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                LOCATION_PERMISSION_REQUEST_CODE);
    }

    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            return;
        }

        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            enableMyLocation();
        } else {
            permissionDenied = true;
            showMissingPermissionError();
        }
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        if (permissionDenied) {
            showMissingPermissionError();
            permissionDenied = false;
        }
        isMapsActivityRunning = true;
    }

    private void showMissingPermissionError() {
        Toast.makeText(this, "Location permission is required to show your location on the map.", Toast.LENGTH_LONG).show();
    }
    /*
    @Override
    protected void onResume() {
        super.onResume();
        // The activity is visible and ready to interact with
        isMapsActivityRunning = true;

        // Start your method to check and update the polygon if needed
        //checkAndUpdatePolygon();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // The activity is no longer in the foreground
        isMapsActivityRunning = false;
    }

*/


}







