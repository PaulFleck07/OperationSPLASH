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

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
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
        OverlayFragment.AnimationServiceUpdate {

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
    private Polygon poly6;
    private Polygon poly7;
    private Polygon poly8;
    private Polygon poly9;
    private Polygon poly10;
    private Polygon poly11;
    private Polygon poly12;
    private Polygon poly13;
    private Polygon poly14;
    private Polygon poly15;
    private Polygon poly16;
    private Polygon poly17;
    private Polygon poly18;
    private Polygon poly19;
    private Polygon poly20;
    private Polygon poly21;
    private Polygon poly22;
    private Polygon poly23;
    private Polygon poly24;
    private Polygon poly25;
    private Polygon poly26;
    private Polygon poly27;
    private Polygon poly28;
    private Polygon poly29;
    private Polygon poly30;
    private Polygon poly31;
    private Polygon poly32;
    private Polygon poly33;
    private Polygon poly34;
    private Polygon poly35;
    private Polygon poly36;
    private Polygon poly37;
    private Polygon poly38;
    private Polygon poly39;
    private Polygon poly40;


    //private Map<String, Polygon> polygonMap = new HashMap<>();

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    //private Map<String, List<LatLng>> polygonCoordinates = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //Set Polygons to the polygonMap
        /*for (int i = 1; i <= 20; i++) {
            try {
                // Get the field representing each polygon (poly1, poly2, etc.)
                Field field = this.getClass().getDeclaredField("poly" + i);
                field.setAccessible(true);
                Polygon polygon = (Polygon) field.get(this);
                polygonMap.put("poly" + i, polygon);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }*/
        //this.initializePolygonCoordinates();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    // Making app less redundent and more dynamic
    /*private void initializePolygonCoordinates() {
        polygonCoordinates.put("poly1", Arrays.asList(
                new LatLng(40.604422, -73.570834),
                new LatLng(40.603973, -73.574583),
                new LatLng(40.606350, -73.575530),
                new LatLng(40.606514, -73.573365)
        ));
        polygonCoordinates.put("poly2", Arrays.asList(
                new LatLng(40.605052, -73.568133),
                new LatLng(40.607145, -73.568184),
                new LatLng(40.608404, -73.565173),
                new LatLng(40.608008, -73.563310),
                new LatLng(40.609068, -73.559183),
                new LatLng(40.609966, -73.557575),
                new LatLng(40.608768, -73.554176),
                new LatLng(40.606787, -73.560700)
        ));
        polygonCoordinates.put("poly3", Arrays.asList(
                new LatLng(40.630186, -73.562643),
                new LatLng(40.631263, -73.563873),
                new LatLng(40.632336, -73.564047),
                new LatLng(40.637467, -73.564109),
                new LatLng(40.639927, -73.564914),
                new LatLng(40.640512, -73.564603),
                new LatLng(40.640527, -73.563409),
                new LatLng(40.635764, -73.562082),
                new LatLng(40.632336, -73.562227)
        ));
        polygonCoordinates.put("poly4", Arrays.asList(
                new LatLng(40.638047, -73.565238),
                new LatLng(40.640002, -73.566577),
                new LatLng(40.641745, -73.568415),
                new LatLng(40.642587, -73.568198),
                new LatLng(40.641183, -73.566501),
                new LatLng(40.639054, -73.565455)
        ));
        polygonCoordinates.put("poly5", Arrays.asList(
                new LatLng(40.629917, -73.562873),
                new LatLng(40.628183, -73.568104),
                new LatLng(40.625341, -73.570640),
                new LatLng(40.622019, -73.571542),
                new LatLng(40.620950, -73.569378),
                new LatLng(40.622586, -73.562217),
                new LatLng(40.625995, -73.563340)
        ));
        polygonCoordinates.put("poly6", Arrays.asList(
                new LatLng(40.641133, -73.563820),
                new LatLng(40.642077, -73.566159),
                new LatLng(40.643836, -73.566867),
                new LatLng(40.645675, -73.566352),
                new LatLng(40.647059, -73.567039),
                new LatLng(40.651634, -73.566481),
                new LatLng(40.645001, -73.565577),
                new LatLng(40.642318, -73.564242)
        ));
        polygonCoordinates.put("poly7", Arrays.asList(
                new LatLng(40.628008, -73.571305),
                new LatLng(40.634089, -73.570616),
                new LatLng(40.636355, -73.568422),
                new LatLng(40.638601, -73.567962),
                new LatLng(40.638601, -73.567478),
                new LatLng(40.635968, -73.567656),
                new LatLng(40.634031, -73.567835),
                new LatLng(40.632966, -73.566789),
                new LatLng(40.635348, -73.565385),
                new LatLng(40.632540, -73.565513),
                new LatLng(40.630733, -73.566909)
        ));
        polygonCoordinates.put("poly8", Arrays.asList(
                new LatLng(40.620757, -73.568731),
                new LatLng(40.622125, -73.562037),
                new LatLng(40.615968, -73.555256),
                new LatLng(40.616490, -73.559719),
                new LatLng(40.619454, -73.566414)
        ));
        polygonCoordinates.put("poly9", Arrays.asList(
                new LatLng(40.629849, -73.562353),
                new LatLng(40.629042, -73.560775),
                new LatLng(40.624344, -73.559986),
                new LatLng(40.623204, -73.559096),
                new LatLng(40.622510, -73.561286),
                new LatLng(40.626694, -73.562690),
                new LatLng(40.628882, -73.562613)
        ));
        polygonCoordinates.put("poly10", Arrays.asList(
                new LatLng(40.623033, -73.559015),
                new LatLng(40.622297, -73.561210),
                new LatLng(40.620263, -73.559704),
                new LatLng(40.616235, -73.554984),
                new LatLng(40.618210, -73.554907),
                new LatLng(40.620593, -73.556132)
        ));
        polygonCoordinates.put("poly11", Arrays.asList(
                new LatLng(40.628123, -73.571653),
                new LatLng(40.634474, -73.572361),
                new LatLng(40.635484, -73.574893),
                new LatLng(40.634816, -73.575430),
                new LatLng(40.624329, -73.572619),
                new LatLng(40.624925, -73.571690)
        ));
        polygonCoordinates.put("poly12", Arrays.asList(
                new LatLng(40.625995, -73.580078),
                new LatLng(40.621889, -73.579491),
                new LatLng(40.621507, -73.582145),
                new LatLng(40.625529, -73.582874)
        ));
        polygonCoordinates.put("poly13", Arrays.asList(
                new LatLng(40.621432, -73.579437),
                new LatLng(40.621041, -73.584909),
                new LatLng(40.618337, -73.583106),
                new LatLng(40.615470, -73.580832),
                new LatLng(40.616057, -73.579930),
                new LatLng(40.618728, -73.580209)
        ));
        polygonCoordinates.put("poly14", Arrays.asList(
                new LatLng(40.621156, -73.586876),
                new LatLng(40.621629, -73.583207),
                new LatLng(40.625326, -73.584001),
                new LatLng(40.625342, -73.587241),
                new LatLng(40.622964, -73.587026)
        ));
        polygonCoordinates.put("poly15", Arrays.asList(
                new LatLng(40.629080, -73.586651),
                new LatLng(40.626018, -73.586780),
                new LatLng(40.625350, -73.588389),
                new LatLng(40.626002, -73.591178)
        ));
        polygonCoordinates.put("poly16", Arrays.asList(
                new LatLng(40.607364, -73.572834),
                new LatLng(40.606680, -73.577855),
                new LatLng(40.609971, -73.578885),
                new LatLng(40.609808, -73.574121),
                new LatLng(40.608635, -73.572576)
        ));
        polygonCoordinates.put("poly17", Arrays.asList(
                new LatLng(40.606210, -73.576219),
                new LatLng(40.605444, -73.580896),
                new LatLng(40.603831, -73.584759),
                new LatLng(40.602528, -73.585896),
                new LatLng(40.600785, -73.585724),
                new LatLng(40.602773, -73.581840),
                new LatLng(40.603440, -73.579480),
                new LatLng(40.603897, -73.575017)
        ));
        polygonCoordinates.put("poly18", Arrays.asList(
                new LatLng(40.604108, -73.570725),
                new LatLng(40.602740, -73.571240),
                new LatLng(40.598667, -73.573858),
                new LatLng(40.597917, -73.575618),
                new LatLng(40.603098, -73.577763)
        ));
        polygonCoordinates.put("poly19", Arrays.asList(
                new LatLng(40.597522, -73.576721),
                new LatLng(40.603012, -73.578394),
                new LatLng(40.601904, -73.582386),
                new LatLng(40.599998, -73.585089),
                new LatLng(40.597424, -73.586548),
                new LatLng(40.595387, -73.586956),
                new LatLng(40.595811, -73.581377)
        ));
        polygonCoordinates.put("poly20", Arrays.asList(
                new LatLng(40.622657, -73.575798),
                new LatLng(40.619170, -73.577891),
                new LatLng(40.616381, -73.577227),
                new LatLng(40.614560, -73.574880),
                new LatLng(40.615994, -73.570490),
                new LatLng(40.618085, -73.569215),
                new LatLng(40.619209, -73.573604),
                new LatLng(40.621727, -73.573706)
        ));
    }

    private void createPolygonWithDefaultColors(String polygonId) {
        List<LatLng> coordinates = polygonCoordinates.get(polygonId);
        if (coordinates != null) {
            Polygon polygon = mMap.addPolygon(new PolygonOptions()
                    .addAll(coordinates)
                    .strokeColor(Color.argb(100, 255, 0, 0))
                    .fillColor(Color.argb(100, 255, 0, 0)));
            polygon.setStrokeJointType(JointType.ROUND);
            polygon.setClickable(true);
            polygon.setTag(polygonId);
            polygonMap.put(polygonId, polygon); // Store polygon reference
            savePolygonToFirestore(polygon, polygonId);
        }
    }*/


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

        /*for (String polygonId : polygonCoordinates.keySet()) {
            db.collection("polygons").document(polygonId).get()
                    .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()) {
                            loadPolygonFromFirestore(polygonId);
                            Log.d(TAG, polygonId + ": Loaded from Firestore");
                        } else {
                            createPolygonWithDefaultColors(polygonId);
                            Log.d(TAG, polygonId + ": Created with default colors");
                        }
                    })
                    .addOnFailureListener(e -> Log.w(TAG, "Error checking document for " + polygonId, e));
        }*/


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
                                .strokeColor(Color.argb(100, 255, 0, 0))
                                .fillColor(Color.argb(100, 255, 0, 0)));
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
                                .strokeColor(Color.argb(100, 55, 200, 0))
                                .fillColor(Color.argb(100, 55, 200, 0)));
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
                                .strokeColor(Color.argb(100, 75, 180, 0))
                                .fillColor(Color.argb(100, 75, 180, 0)));
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
                                .strokeColor(Color.argb(100, 75, 180, 0))
                                .fillColor(Color.argb(100, 75, 180, 0)));
                        poly5.setStrokeJointType(JointType.ROUND);
                        poly5.setClickable(true);
                        poly5.setTag("poly5");
                        savePolygonToFirestore(poly5, "poly5");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly6").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly6");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly6 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.641133, -73.563820),
                                        new LatLng(40.642077, -73.566159),
                                        new LatLng(40.643836, -73.566867),
                                        new LatLng(40.645675, -73.566352),
                                        new LatLng(40.647059, -73.567039),
                                        new LatLng(40.651634, -73.566481),
                                        new LatLng(40.645001, -73.565577),
                                        new LatLng(40.642318, -73.564242))
                                .strokeColor(Color.argb(100, 155, 100, 0))
                                .fillColor(Color.argb(100, 155, 100, 0)));
                        poly6.setStrokeJointType(JointType.ROUND);
                        poly6.setClickable(true);
                        poly6.setTag("poly6");
                        savePolygonToFirestore(poly6, "poly6");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly7").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly7");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly7 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.628008, -73.571305),
                                        new LatLng(40.634089, -73.570616),
                                        new LatLng(40.636355, -73.568422),
                                        new LatLng(40.638601, -73.567962),
                                        new LatLng(40.638601, -73.567478),
                                        new LatLng(40.635968, -73.567656),
                                        new LatLng(40.634031, -73.567835),
                                        new LatLng(40.632966, -73.566789),
                                        new LatLng(40.635348, -73.565385),
                                        new LatLng(40.632540, -73.565513),
                                        new LatLng(40.630733, -73.566909))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly7.setStrokeJointType(JointType.ROUND);
                        poly7.setClickable(true);
                        poly7.setTag("poly7");
                        savePolygonToFirestore(poly7, "poly7");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly8").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly8");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly8 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.620757, -73.568731),
                                        new LatLng(40.622125, -73.562037),
                                        new LatLng(40.615968, -73.555256),
                                        new LatLng(40.616490, -73.559719),
                                        new LatLng(40.619454, -73.566414))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly8.setStrokeJointType(JointType.ROUND);
                        poly8.setClickable(true);
                        poly8.setTag("poly8");
                        savePolygonToFirestore(poly8, "poly8");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly9").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly9");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly9 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.629849, -73.562353),
                                        new LatLng(40.629042, -73.560775),
                                        new LatLng(40.624344, -73.559986),
                                        new LatLng(40.623204, -73.559096),
                                        new LatLng(40.622510, -73.561286),
                                        new LatLng(40.626694, -73.562690),
                                        new LatLng(40.628882, -73.562613))
                                .strokeColor(Color.argb(100, 155, 100, 0))
                                .fillColor(Color.argb(100, 155, 100, 0)));
                        poly9.setStrokeJointType(JointType.ROUND);
                        poly9.setClickable(true);
                        poly9.setTag("poly9");
                        savePolygonToFirestore(poly9, "poly9");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly10").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly10");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly10 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.623033, -73.559015),
                                        new LatLng(40.622297, -73.561210),
                                        new LatLng(40.620263, -73.559704),
                                        new LatLng(40.616235, -73.554984),
                                        new LatLng(40.618210, -73.554907),
                                        new LatLng(40.620593, -73.556132))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly10.setStrokeJointType(JointType.ROUND);
                        poly10.setClickable(true);
                        poly10.setTag("poly10");
                        savePolygonToFirestore(poly10, "poly10");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly11").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly11");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly11 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.628123, -73.571653),
                                        new LatLng(40.634474, -73.572361),
                                        new LatLng(40.635484, -73.574893),
                                        new LatLng(40.634816, -73.575430),
                                        new LatLng(40.624329, -73.572619),
                                        new LatLng(40.624925, -73.571690))
                                .strokeColor(Color.argb(100, 155, 100, 0))
                                .fillColor(Color.argb(100, 155, 100, 0)));
                        poly11.setStrokeJointType(JointType.ROUND);
                        poly11.setClickable(true);
                        poly11.setTag("poly11");
                        savePolygonToFirestore(poly11, "poly11");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly12").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly12");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly12 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.625995, -73.580078),
                                        new LatLng(40.621889, -73.579491),
                                        new LatLng(40.621507, -73.582145),
                                        new LatLng(40.625529, -73.582874))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly12.setStrokeJointType(JointType.ROUND);
                        poly12.setClickable(true);
                        poly12.setTag("poly12");
                        savePolygonToFirestore(poly12, "poly12");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly13").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly13");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly13 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.621432, -73.579437),
                                        new LatLng(40.621041, -73.584909),
                                        new LatLng(40.618337, -73.583106),
                                        new LatLng(40.615470, -73.580832),
                                        new LatLng(40.616057, -73.579930),
                                        new LatLng(40.618728, -73.580209))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly13.setStrokeJointType(JointType.ROUND);
                        poly13.setClickable(true);
                        poly13.setTag("poly13");
                        savePolygonToFirestore(poly13, "poly13");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly14").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly14");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly14 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.621156, -73.586876),
                                        new LatLng(40.621629, -73.583207),
                                        new LatLng(40.625326, -73.584001),
                                        new LatLng(40.625342, -73.587241),
                                        new LatLng(40.622964, -73.587026))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly14.setStrokeJointType(JointType.ROUND);
                        poly14.setClickable(true);
                        poly14.setTag("poly14");
                        savePolygonToFirestore(poly14, "poly14");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly15").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly15");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly15 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.629080, -73.586651),
                                        new LatLng(40.626018, -73.586780),
                                        new LatLng(40.625350, -73.588389),
                                        new LatLng(40.626002, -73.591178))
                                .strokeColor(Color.argb(100, 75, 180, 0))
                                .fillColor(Color.argb(100, 75, 180, 0)));
                        poly15.setStrokeJointType(JointType.ROUND);
                        poly15.setClickable(true);
                        poly15.setTag("poly15");
                        savePolygonToFirestore(poly15, "poly15");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly16").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly16");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly16 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.607364, -73.572834),
                                        new LatLng(40.606680, -73.577855),
                                        new LatLng(40.609971, -73.578885),
                                        new LatLng(40.609808, -73.574121),
                                        new LatLng(40.608635, -73.572576))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly16.setStrokeJointType(JointType.ROUND);
                        poly16.setClickable(true);
                        poly16.setTag("poly16");
                        savePolygonToFirestore(poly16, "poly16");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly17").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly17");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly17 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.606210, -73.576219),
                                        new LatLng(40.605444, -73.580896),
                                        new LatLng(40.603831, -73.584759),
                                        new LatLng(40.602528, -73.585896),
                                        new LatLng(40.600785, -73.585724),
                                        new LatLng(40.602773, -73.581840),
                                        new LatLng(40.603440, -73.579480),
                                        new LatLng(40.603897, -73.575017))
                                .strokeColor(Color.argb(100, 255, 0, 0))
                                .fillColor(Color.argb(100, 255, 0, 0)));
                        poly17.setStrokeJointType(JointType.ROUND);
                        poly17.setClickable(true);
                        poly17.setTag("poly17");
                        savePolygonToFirestore(poly17, "poly17");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly18").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly18");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly18 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.604108, -73.570725),
                                        new LatLng(40.602740, -73.571240),
                                        new LatLng(40.602740, -73.571240),
                                        new LatLng(40.598667, -73.573858),
                                        new LatLng(40.597917, -73.575618),
                                        new LatLng(40.603098, -73.577763))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly18.setStrokeJointType(JointType.ROUND);
                        poly18.setClickable(true);
                        poly18.setTag("poly18");
                        savePolygonToFirestore(poly18, "poly18");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly19").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly19");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly19 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.597522, -73.576721),
                                        new LatLng(40.603012, -73.578394),
                                        new LatLng(40.601904, -73.582386),
                                        new LatLng(40.599998, -73.585089),
                                        new LatLng(40.597424, -73.586548),
                                        new LatLng(40.595387, -73.586956),
                                        new LatLng(40.595811, -73.581377))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly19.setStrokeJointType(JointType.ROUND);
                        poly19.setClickable(true);
                        poly19.setTag("poly19");
                        savePolygonToFirestore(poly19, "poly19");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly20").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly20");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly20 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.622657, -73.575798),
                                        new LatLng(40.619170, -73.577891),
                                        new LatLng(40.616381, -73.577227),
                                        new LatLng(40.614560, -73.574880),
                                        new LatLng(40.615994, -73.570490),
                                        new LatLng(40.618085, -73.569215),
                                        new LatLng(40.619209, -73.573604),
                                        new LatLng(40.621727, -73.573706))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly20.setStrokeJointType(JointType.ROUND);
                        poly20.setClickable(true);
                        poly20.setTag("poly20");
                        savePolygonToFirestore(poly20, "poly20");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly21").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly21");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly21 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.609019, -73.568631),
                                        new LatLng(40.610616, -73.567859),
                                        new LatLng(40.611430, -73.565069),
                                        new LatLng(40.610160, -73.565155))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly21.setStrokeJointType(JointType.ROUND);
                        poly21.setClickable(true);
                        poly21.setTag("poly21");
                        savePolygonToFirestore(poly21, "poly21");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly22").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly22");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly22 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.614474, -73.573970),
                                        new LatLng(40.615681, -73.570553),
                                        new LatLng(40.616784, -73.569406),
                                        new LatLng(40.615350, -73.565438),
                                        new LatLng(40.613994, -73.565438),
                                        new LatLng(40.612144, -73.569931))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly22.setStrokeJointType(JointType.ROUND);
                        poly22.setClickable(true);
                        poly22.setTag("poly22");
                        savePolygonToFirestore(poly22, "poly22");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly23").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly23");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly23 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.621472, -73.573215),
                                        new LatLng(40.619746, -73.573449),
                                        new LatLng(40.618436, -73.571635),
                                        new LatLng(40.618532, -73.569237),
                                        new LatLng(40.617583, -73.568777),
                                        new LatLng(40.616886, -73.569288),
                                        new LatLng(40.614174, -73.564490),
                                        new LatLng(40.614368, -73.559004),
                                        new LatLng(40.615782, -73.561301),
                                        new LatLng(40.619540, -73.569032))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly23.setStrokeJointType(JointType.ROUND);
                        poly23.setClickable(true);
                        poly23.setTag("poly23");
                        savePolygonToFirestore(poly23, "poly23");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly24").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly24");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly24 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.615742, -73.579799),
                                        new LatLng(40.615074, -73.581013),
                                        new LatLng(40.611480, -73.580558),
                                        new LatLng(40.611434, -73.574701))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly24.setStrokeJointType(JointType.ROUND);
                        poly24.setClickable(true);
                        poly24.setTag("poly24");
                        savePolygonToFirestore(poly24, "poly24");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly25").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly25");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly25 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.611457, -73.580679),
                                        new LatLng(40.615627, -73.581984),
                                        new LatLng(40.621017, -73.585322),
                                        new LatLng(40.620464, -73.587112),
                                        new LatLng(40.615627, -73.584351),
                                        new LatLng(40.611204, -73.583683))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly25.setStrokeJointType(JointType.ROUND);
                        poly25.setClickable(true);
                        poly25.setTag("poly25");
                        savePolygonToFirestore(poly25, "poly25");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly26").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly26");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly26 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.620141, -73.587841),
                                        new LatLng(40.616318, -73.585201),
                                        new LatLng(40.617032, -73.590845),
                                        new LatLng(40.618990, -73.590056))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly26.setStrokeJointType(JointType.ROUND);
                        poly26.setClickable(true);
                        poly26.setTag("poly26");
                        savePolygonToFirestore(poly26, "poly26");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly27").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly27");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly27 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.609660, -73.579374),
                                        new LatLng(40.608255, -73.578858),
                                        new LatLng(40.607748, -73.584412),
                                        new LatLng(40.610052, -73.584624))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly27.setStrokeJointType(JointType.ROUND);
                        poly27.setClickable(true);
                        poly27.setTag("poly27");
                        savePolygonToFirestore(poly27, "poly27");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly28").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly28");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly28 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.609407, -73.585413),
                                        new LatLng(40.610144, -73.584685),
                                        new LatLng(40.611872, -73.585747),
                                        new LatLng(40.614728, -73.586293),
                                        new LatLng(40.615604, -73.591118),
                                        new LatLng(40.616387, -73.592392),
                                        new LatLng(40.618345, -73.594274),
                                        new LatLng(40.617677, -73.595002),
                                        new LatLng(40.615650, -73.593849),
                                        new LatLng(40.613876, -73.589054),
                                        new LatLng(40.613208, -73.587841))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly28.setStrokeJointType(JointType.ROUND);
                        poly28.setClickable(true);
                        poly28.setTag("poly28");
                        savePolygonToFirestore(poly28, "poly28");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly29").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly29");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly29 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.595119, -73.587454),
                                        new LatLng(40.598298, -73.586877),
                                        new LatLng(40.600572, -73.585758),
                                        new LatLng(40.599805, -73.586949),
                                        new LatLng(40.600331, -73.588163),
                                        new LatLng(40.598879, -73.589225),
                                        new LatLng(40.598165, -73.588102),
                                        new LatLng(40.597358, -73.588284),
                                        new LatLng(40.597450, -73.589771),
                                        new LatLng(40.596321, -73.589893))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly29.setStrokeJointType(JointType.ROUND);
                        poly29.setClickable(true);
                        poly29.setTag("poly29");
                        savePolygonToFirestore(poly29, "poly29");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly30").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly30");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly30 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.627493, -73.602513),
                                        new LatLng(40.624239, -73.602232),
                                        new LatLng(40.622941, -73.602692),
                                        new LatLng(40.623580, -73.606315),
                                        new LatLng(40.623212, -73.609632),
                                        new LatLng(40.625169, -73.612210),
                                        new LatLng(40.629410, -73.615195),
                                        new LatLng(40.629487, -73.614812),
                                        new LatLng(40.625285, -73.611291),
                                        new LatLng(40.625537, -73.608178))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly30.setStrokeJointType(JointType.ROUND);
                        poly30.setClickable(true);
                        poly30.setTag("poly30");
                        savePolygonToFirestore(poly30, "poly30");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly31").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly31");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly31 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.615582, -73.593894),
                                        new LatLng(40.613770, -73.588969),
                                        new LatLng(40.613325, -73.588102),
                                        new LatLng(40.608521, -73.584657),
                                        new LatLng(40.606855, -73.586570),
                                        new LatLng(40.607630, -73.587413),
                                        new LatLng(40.610012, -73.586928),
                                        new LatLng(40.611309, -73.587902),
                                        new LatLng(40.612277, -73.591882))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly31.setStrokeJointType(JointType.ROUND);
                        poly31.setClickable(true);
                        poly31.setTag("poly31");
                        savePolygonToFirestore(poly31, "poly31");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly32").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly32");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly32 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.606737, -73.586447),
                                        new LatLng(40.604412, -73.585784),
                                        new LatLng(40.606698, -73.578001),
                                        new LatLng(40.608151, -73.578613))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly32.setStrokeJointType(JointType.ROUND);
                        poly32.setClickable(true);
                        poly32.setTag("poly32");
                        savePolygonToFirestore(poly32, "poly32");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly33").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly33");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly33 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.602897, -73.587551),
                                        new LatLng(40.608322, -73.592014),
                                        new LatLng(40.610293, -73.588044),
                                        new LatLng(40.609967, -73.587701),
                                        new LatLng(40.607884, -73.588360),
                                        new LatLng(40.603941, -73.586536))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly33.setStrokeJointType(JointType.ROUND);
                        poly33.setClickable(true);
                        poly33.setTag("poly33");
                        savePolygonToFirestore(poly33, "poly33");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly34").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly34");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly34 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.608698, -73.592244),
                                        new LatLng(40.610392, -73.588167),
                                        new LatLng(40.610685, -73.589261),
                                        new LatLng(40.610865, -73.591450),
                                        new LatLng(40.613634, -73.594518),
                                        new LatLng(40.613178, -73.595076),
                                        new LatLng(40.611419, -73.594626))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly34.setStrokeJointType(JointType.ROUND);
                        poly34.setClickable(true);
                        poly34.setTag("poly34");
                        savePolygonToFirestore(poly34, "poly34");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly35").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly35");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly35 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.602752, -73.587781),
                                        new LatLng(40.602084, -73.588596),
                                        new LatLng(40.603892, -73.594433),
                                        new LatLng(40.605391, -73.592802),
                                        new LatLng(40.608633, -73.597050),
                                        new LatLng(40.612477, -73.595634),
                                        new LatLng(40.607704, -73.591557))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly35.setStrokeJointType(JointType.ROUND);
                        poly35.setClickable(true);
                        poly35.setTag("poly35");
                        savePolygonToFirestore(poly35, "poly35");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly36").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly36");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly36 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.604618, -73.568206),
                                        new LatLng(40.606323, -73.561105),
                                        new LatLng(40.599641, -73.557615),
                                        new LatLng(40.599964, -73.563714),
                                        new LatLng(40.600793, -73.566355))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly36.setStrokeJointType(JointType.ROUND);
                        poly36.setClickable(true);
                        poly36.setTag("poly36");
                        savePolygonToFirestore(poly36, "poly36");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly37").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly37");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly37 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.606507, -73.560255),
                                        new LatLng(40.599595, -73.556492),
                                        new LatLng(40.599065, -73.552851),
                                        new LatLng(40.600010, -73.551303),
                                        new LatLng(40.605585, -73.553852),
                                        new LatLng(40.608442, -73.554004))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly37.setStrokeJointType(JointType.ROUND);
                        poly37.setClickable(true);
                        poly37.setTag("poly37");
                        savePolygonToFirestore(poly37, "poly37");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly38").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly38");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly38 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.609502, -73.552083),
                                        new LatLng(40.611776, -73.554357),
                                        new LatLng(40.615009, -73.553906),
                                        new LatLng(40.612365, -73.550983),
                                        new LatLng(40.610845, -73.550207),
                                        new LatLng(40.609968, -73.550874))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly38.setStrokeJointType(JointType.ROUND);
                        poly38.setClickable(true);
                        poly38.setTag("poly38");
                        savePolygonToFirestore(poly38, "poly38");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly39").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly39");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly39 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.630223, -73.562242),
                                        new LatLng(40.630340, -73.559155),
                                        new LatLng(40.633922, -73.557266),
                                        new LatLng(40.637911, -73.558874),
                                        new LatLng(40.639092, -73.560864),
                                        new LatLng(40.638744, -73.562166),
                                        new LatLng(40.635161, -73.561502),
                                        new LatLng(40.632683, -73.561604))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly39.setStrokeJointType(JointType.ROUND);
                        poly39.setClickable(true);
                        poly39.setTag("poly39");
                        savePolygonToFirestore(poly39, "poly39");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        db.collection("polygons").document("poly40").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly40");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly40 = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.639273, -73.560673),
                                        new LatLng(40.638841, -73.559755),
                                        new LatLng(40.640413, -73.558989),
                                        new LatLng(40.641339, -73.557290),
                                        new LatLng(40.643093, -73.556408),
                                        new LatLng(40.643703, -73.557008),
                                        new LatLng(40.642803, -73.557646),
                                        new LatLng(40.641380, -73.557965),
                                        new LatLng(40.639724, -73.560402))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly40.setStrokeJointType(JointType.ROUND);
                        poly40.setClickable(true);
                        poly40.setTag("poly40");
                        savePolygonToFirestore(poly40, "poly40");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));
        /*db.collection("polygons").document("poly").get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        try {
                            // Attempt to load polygon colors from Firestore
                            loadPolygonFromFirestore("poly");
                            Log.d(TAG, "onMapReady: Can load Polygon colors");
                        } catch (Exception e) {
                            Log.e(TAG, "Error while loading polygon colors: " + e.getMessage());
                        }
                    } else {
                        // Create and save a new polygon with default colors
                        Log.d(TAG, "Document does not exist, creating a new polygon.");
                        poly = mMap.addPolygon(new PolygonOptions().add(
                                        new LatLng(40.641133, -73.563820),
                                        new LatLng(40.642077, -73.566159),
                                        new LatLng(40.643836, -73.566867),
                                        new LatLng(40.645675, -73.566352),
                                        new LatLng(40.647059, -73.567039),
                                        new LatLng(40.651634, -73.566481),
                                        new LatLng(40.645001, -73.565577),
                                        new LatLng(40.642318, -73.564242))
                                .strokeColor(Color.argb(100, 0, 255, 0))
                                .fillColor(Color.argb(100, 0, 255, 0)));
                        poly.setStrokeJointType(JointType.ROUND);
                        poly.setClickable(true);
                        poly.setTag("poly");
                        savePolygonToFirestore(poly, "poly");
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error checking document", e));*/
    }



    private void checkAndUpdatePolygon() {
        Executors.newSingleThreadExecutor().execute(() -> {
            while (isMapsActivityRunning) {
                // Query Firestore for polygon data

               /* for (Map.Entry<String, Polygon> entry : polygonMap.entrySet()) {
                    String polygonId = entry.getKey();
                    Polygon polygon = entry.getValue();

                    db.collection("polygons").document(polygonId)
                            .get()
                            .addOnSuccessListener(documentSnapshot -> {
                                if (documentSnapshot.exists()) {
                                    int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                    int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                    Log.d(TAG, "checkAndUpdatePolygon: " + isMapsActivityRunning);
                                    // Check if colors have changed
                                    if (polygon.getFillColor() != newFillColor || polygon.getStrokeColor() != newStrokeColor) {
                                        // Update the polygon on the map
                                        runOnUiThread(() -> {
                                            polygon.setFillColor(newFillColor);
                                            polygon.setStrokeColor(newStrokeColor);
                                        });
                                    }
                                }
                            })
                            .addOnFailureListener(e -> Log.w(TAG, "Error checking document for " + polygonId, e));

                }*/
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
                db.collection("polygons").document("poly6")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly6.getFillColor() != newFillColor || poly6.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly6.setFillColor(newFillColor);
                                        poly6.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly7")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly7.getFillColor() != newFillColor || poly7.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly7.setFillColor(newFillColor);
                                        poly7.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly8")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly8.getFillColor() != newFillColor || poly8.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly8.setFillColor(newFillColor);
                                        poly8.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly9")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly9.getFillColor() != newFillColor || poly9.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly9.setFillColor(newFillColor);
                                        poly9.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly10")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly10.getFillColor() != newFillColor || poly10.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly10.setFillColor(newFillColor);
                                        poly10.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly11")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly11.getFillColor() != newFillColor || poly11.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly11.setFillColor(newFillColor);
                                        poly11.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly12")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly12.getFillColor() != newFillColor || poly12.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly12.setFillColor(newFillColor);
                                        poly12.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly13")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly13.getFillColor() != newFillColor || poly13.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly13.setFillColor(newFillColor);
                                        poly13.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly14")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly14.getFillColor() != newFillColor || poly14.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly14.setFillColor(newFillColor);
                                        poly14.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly15")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly15.getFillColor() != newFillColor || poly15.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly15.setFillColor(newFillColor);
                                        poly15.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly16")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly16.getFillColor() != newFillColor || poly16.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly16.setFillColor(newFillColor);
                                        poly16.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly17")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly17.getFillColor() != newFillColor || poly17.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly17.setFillColor(newFillColor);
                                        poly17.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly18")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly18.getFillColor() != newFillColor || poly18.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly18.setFillColor(newFillColor);
                                        poly18.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly19")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly19.getFillColor() != newFillColor || poly19.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly19.setFillColor(newFillColor);
                                        poly19.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly20")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly20.getFillColor() != newFillColor || poly20.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly20.setFillColor(newFillColor);
                                        poly20.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly21")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly21.getFillColor() != newFillColor || poly21.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly21.setFillColor(newFillColor);
                                        poly21.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly22")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly22.getFillColor() != newFillColor || poly22.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly22.setFillColor(newFillColor);
                                        poly22.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly23")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly23.getFillColor() != newFillColor || poly23.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly23.setFillColor(newFillColor);
                                        poly23.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly24")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly24.getFillColor() != newFillColor || poly24.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly24.setFillColor(newFillColor);
                                        poly24.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly25")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly25.getFillColor() != newFillColor || poly25.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly25.setFillColor(newFillColor);
                                        poly25.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly26")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly26.getFillColor() != newFillColor || poly26.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly26.setFillColor(newFillColor);
                                        poly26.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly27")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly27.getFillColor() != newFillColor || poly27.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly27.setFillColor(newFillColor);
                                        poly27.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly28")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly28.getFillColor() != newFillColor || poly28.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly28.setFillColor(newFillColor);
                                        poly28.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly29")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly29.getFillColor() != newFillColor || poly29.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly29.setFillColor(newFillColor);
                                        poly29.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly30")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly30.getFillColor() != newFillColor || poly30.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly30.setFillColor(newFillColor);
                                        poly30.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("31")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly31.getFillColor() != newFillColor || poly31.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly31.setFillColor(newFillColor);
                                        poly31.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly31")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly31.getFillColor() != newFillColor || poly31.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly31.setFillColor(newFillColor);
                                        poly31.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly32")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly32.getFillColor() != newFillColor || poly32.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly32.setFillColor(newFillColor);
                                        poly32.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly33")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly33.getFillColor() != newFillColor || poly33.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly33.setFillColor(newFillColor);
                                        poly33.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly34")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly34.getFillColor() != newFillColor || poly34.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly34.setFillColor(newFillColor);
                                        poly34.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly35")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly35.getFillColor() != newFillColor || poly35.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly35.setFillColor(newFillColor);
                                        poly35.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly36")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly36.getFillColor() != newFillColor || poly36.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly37.setFillColor(newFillColor);
                                        poly37.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly38")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly38.getFillColor() != newFillColor || poly38.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly38.setFillColor(newFillColor);
                                        poly38.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly39")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly39.getFillColor() != newFillColor || poly39.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly39.setFillColor(newFillColor);
                                        poly39.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                db.collection("polygons").document("poly40")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly40.getFillColor() != newFillColor || poly40.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly40.setFillColor(newFillColor);
                                        poly40.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });
                /*db.collection("polygons").document("poly")
                        .get()
                        .addOnSuccessListener(documentSnapshot -> {
                            if (documentSnapshot.exists()) {
                                int newFillColor = documentSnapshot.getLong("fillColor").intValue();
                                int newStrokeColor = documentSnapshot.getLong("strokeColor").intValue();
                                Log.d(TAG, "checkAndUpdatePolygon: " +isMapsActivityRunning);
                                // Check if colors have changed
                                if (poly.getFillColor() != newFillColor || poly.getStrokeColor() != newStrokeColor) {
                                    // Update the polygon on the map
                                    runOnUiThread(() -> {
                                        poly.setFillColor(newFillColor);
                                        poly.setStrokeColor(newStrokeColor);
                                    });
                                }
                            }
                        });

                */

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

        /*db.collection("polygons").document(polygonId).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        int fillColor = documentSnapshot.getLong("fillColor").intValue();
                        int strokeColor = documentSnapshot.getLong("strokeColor").intValue();

                        List<LatLng> coordinates = polygonCoordinates.get(polygonId);
                        if (coordinates != null) {
                            Polygon polygon = mMap.addPolygon(new PolygonOptions()
                                    .addAll(coordinates)
                                    .fillColor(fillColor)
                                    .strokeColor(strokeColor));
                            polygon.setStrokeJointType(JointType.ROUND);
                            polygon.setClickable(true);
                            polygon.setTag(polygonId);
                            polygonMap.put(polygonId, polygon); // Store polygon reference
                        }
                    }
                })
                .addOnFailureListener(e -> Log.w(TAG, "Error loading polygon colors for " + polygonId, e));*/

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
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
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
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
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
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly5.setStrokeJointType(JointType.ROUND);
                                poly5.setClickable(true);
                                poly5.setTag("poly5");
                            } else if (polygonId.equals("poly6")){
                                poly6 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.641133, -73.563820),
                                                new LatLng(40.642077, -73.566159),
                                                new LatLng(40.643836, -73.566867),
                                                new LatLng(40.645675, -73.566352),
                                                new LatLng(40.647059, -73.567039),
                                                new LatLng(40.651634, -73.566481),
                                                new LatLng(40.645001, -73.565577),
                                                new LatLng(40.642318, -73.564242))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly6.setStrokeJointType(JointType.ROUND);
                                poly6.setClickable(true);
                                poly6.setTag("poly6");
                            } else if (polygonId.equals("poly7")){
                                poly7 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.628008, -73.571305),
                                                new LatLng(40.634089, -73.570616),
                                                new LatLng(40.636355, -73.568422),
                                                new LatLng(40.638601, -73.567962),
                                                new LatLng(40.638601, -73.567478),
                                                new LatLng(40.635968, -73.567656),
                                                new LatLng(40.634031, -73.567835),
                                                new LatLng(40.632966, -73.566789),
                                                new LatLng(40.635348, -73.565385),
                                                new LatLng(40.632540, -73.565513),
                                                new LatLng(40.630733, -73.566909))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly7.setStrokeJointType(JointType.ROUND);
                                poly7.setClickable(true);
                                poly7.setTag("poly7");
                            } else if (polygonId.equals("poly8")){
                            poly8 = mMap.addPolygon(new PolygonOptions().add(
                                            new LatLng(40.620757, -73.568731),
                                            new LatLng(40.622125, -73.562037),
                                            new LatLng(40.615968, -73.555256),
                                            new LatLng(40.616490, -73.559719),
                                            new LatLng(40.619454, -73.566414))
                                    .fillColor(fillColor)
                                    .strokeColor(strokeColor));
                            poly8.setStrokeJointType(JointType.ROUND);
                            poly8.setClickable(true);
                            poly8.setTag("poly8");
                        } else if (polygonId.equals("poly9")){
                            poly9 = mMap.addPolygon(new PolygonOptions().add(
                                            new LatLng(40.629849, -73.562353),
                                            new LatLng(40.629042, -73.560775),
                                            new LatLng(40.624344, -73.559986),
                                            new LatLng(40.623204, -73.559096),
                                            new LatLng(40.622510, -73.561286),
                                            new LatLng(40.626694, -73.562690),
                                            new LatLng(40.628882, -73.562613))
                                .fillColor(fillColor)
                                .strokeColor(strokeColor));
                            poly9.setStrokeJointType(JointType.ROUND);
                            poly9.setClickable(true);
                            poly9.setTag("poly9");
                        }else if (polygonId.equals("poly10")){
                            poly10 = mMap.addPolygon(new PolygonOptions().add(
                                            new LatLng(40.623033, -73.559015),
                                            new LatLng(40.622297, -73.561210),
                                            new LatLng(40.620263, -73.559704),
                                            new LatLng(40.616235, -73.554984),
                                            new LatLng(40.618210, -73.554907),
                                            new LatLng(40.620593, -73.556132))
                                    .fillColor(fillColor)
                                    .strokeColor(strokeColor));
                            poly10.setStrokeJointType(JointType.ROUND);
                            poly10.setClickable(true);
                            poly10.setTag("poly10");
                        }else if (polygonId.equals("poly11")){
                                poly11 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.628123, -73.571653),
                                                new LatLng(40.634474, -73.572361),
                                                new LatLng(40.635484, -73.574893),
                                                new LatLng(40.634816, -73.575430),
                                                new LatLng(40.624329, -73.572619),
                                                new LatLng(40.624925, -73.571690))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly11.setStrokeJointType(JointType.ROUND);
                                poly11.setClickable(true);
                                poly11.setTag("poly11");
                            }else if (polygonId.equals("poly12")){
                                poly12 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.625995, -73.580078),
                                            new LatLng(40.621889, -73.579491),
                                            new LatLng(40.621507, -73.582145),
                                            new LatLng(40.625529, -73.582874))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly12.setStrokeJointType(JointType.ROUND);
                                poly12.setClickable(true);
                                poly12.setTag("poly12");
                            }else if (polygonId.equals("poly13")){
                                poly13 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.621432, -73.579437),
                                                new LatLng(40.621041, -73.584909),
                                                new LatLng(40.618337, -73.583106),
                                                new LatLng(40.615470, -73.580832),
                                                new LatLng(40.616057, -73.579930),
                                                new LatLng(40.618728, -73.580209))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly13.setStrokeJointType(JointType.ROUND);
                                poly13.setClickable(true);
                                poly13.setTag("poly13");
                            }else if (polygonId.equals("poly14")){
                                poly14 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.621156, -73.586876),
                                                new LatLng(40.621629, -73.583207),
                                                new LatLng(40.625326, -73.584001),
                                                new LatLng(40.625342, -73.587241),
                                                new LatLng(40.622964, -73.587026))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly14.setStrokeJointType(JointType.ROUND);
                                poly14.setClickable(true);
                                poly14.setTag("poly14");
                            }else if (polygonId.equals("poly15")){
                                poly15 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.629080, -73.586651),
                                                new LatLng(40.626018, -73.586780),
                                                new LatLng(40.625350, -73.588389),
                                                new LatLng(40.626002, -73.591178))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly15.setStrokeJointType(JointType.ROUND);
                                poly15.setClickable(true);
                                poly15.setTag("poly15");
                            }else if (polygonId.equals("poly16")){
                                poly16 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.607364, -73.572834),
                                                new LatLng(40.606680, -73.577855),
                                                new LatLng(40.609971, -73.578885),
                                                new LatLng(40.609808, -73.574121),
                                                new LatLng(40.608635, -73.572576))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly16.setStrokeJointType(JointType.ROUND);
                                poly16.setClickable(true);
                                poly16.setTag("poly16");
                            }else if (polygonId.equals("poly17")){
                                poly17 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.606210, -73.576219),
                                                new LatLng(40.605444, -73.580896),
                                                new LatLng(40.603831, -73.584759),
                                                new LatLng(40.602528, -73.585896),
                                                new LatLng(40.600785, -73.585724),
                                                new LatLng(40.602773, -73.581840),
                                                new LatLng(40.603440, -73.579480),
                                                new LatLng(40.603897, -73.575017))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly17.setStrokeJointType(JointType.ROUND);
                                poly17.setClickable(true);
                                poly17.setTag("poly17");
                            }else if (polygonId.equals("poly18")){
                                poly18 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.604108, -73.570725),
                                                new LatLng(40.602740, -73.571240),
                                                new LatLng(40.602740, -73.571240),
                                                new LatLng(40.598667, -73.573858),
                                                new LatLng(40.597917, -73.575618),
                                                new LatLng(40.603098, -73.577763))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly18.setStrokeJointType(JointType.ROUND);
                                poly18.setClickable(true);
                                poly18.setTag("poly18");
                            }else if (polygonId.equals("poly19")){
                                poly19 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.597522, -73.576721),
                                                new LatLng(40.603012, -73.578394),
                                                new LatLng(40.601904, -73.582386),
                                                new LatLng(40.599998, -73.585089),
                                                new LatLng(40.597424, -73.586548),
                                                new LatLng(40.595387, -73.586956),
                                                new LatLng(40.595811, -73.581377))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly19.setStrokeJointType(JointType.ROUND);
                                poly19.setClickable(true);
                                poly19.setTag("poly19");
                            }else if (polygonId.equals("poly20")){
                                poly20 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.622657, -73.575798),
                                                new LatLng(40.619170, -73.577891),
                                                new LatLng(40.616381, -73.577227),
                                                new LatLng(40.614560, -73.574880),
                                                new LatLng(40.615994, -73.570490),
                                                new LatLng(40.618085, -73.569215),
                                                new LatLng(40.619209, -73.573604),
                                                new LatLng(40.621727, -73.573706))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly20.setStrokeJointType(JointType.ROUND);
                                poly20.setClickable(true);
                                poly20.setTag("poly20");
                            }else if (polygonId.equals("poly21")){
                                poly21 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.609019, -73.568631),
                                                new LatLng(40.610616, -73.567859),
                                                new LatLng(40.611430, -73.565069),
                                                new LatLng(40.610160, -73.565155))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly21.setStrokeJointType(JointType.ROUND);
                                poly21.setClickable(true);
                                poly21.setTag("poly21");
                            }else if (polygonId.equals("poly22")){
                                poly22 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.614474, -73.573970),
                                                new LatLng(40.615681, -73.570553),
                                                new LatLng(40.616784, -73.569406),
                                                new LatLng(40.615350, -73.565438),
                                                new LatLng(40.613994, -73.565438),
                                                new LatLng(40.612144, -73.569931))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly22.setStrokeJointType(JointType.ROUND);
                                poly22.setClickable(true);
                                poly22.setTag("poly22");
                            }else if (polygonId.equals("poly23")){
                                poly23 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.621472, -73.573215),
                                                new LatLng(40.619746, -73.573449),
                                                new LatLng(40.618436, -73.571635),
                                                new LatLng(40.618532, -73.569237),
                                                new LatLng(40.617583, -73.568777),
                                                new LatLng(40.616886, -73.569288),
                                                new LatLng(40.614174, -73.564490),
                                                new LatLng(40.614368, -73.559004),
                                                new LatLng(40.615782, -73.561301),
                                                new LatLng(40.619540, -73.569032))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly23.setStrokeJointType(JointType.ROUND);
                                poly23.setClickable(true);
                                poly23.setTag("poly23");
                            }else if (polygonId.equals("poly24")){
                                poly24 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.615742, -73.579799),
                                                new LatLng(40.615074, -73.581013),
                                                new LatLng(40.611480, -73.580558),
                                                new LatLng(40.611434, -73.574701))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly24.setStrokeJointType(JointType.ROUND);
                                poly24.setClickable(true);
                                poly24.setTag("poly24");
                            }else if (polygonId.equals("poly25")){
                                poly25 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.611457, -73.580679),
                                                new LatLng(40.615627, -73.581984),
                                                new LatLng(40.621017, -73.585322),
                                                new LatLng(40.620464, -73.587112),
                                                new LatLng(40.615627, -73.584351),
                                                new LatLng(40.611204, -73.583683))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly25.setStrokeJointType(JointType.ROUND);
                                poly25.setClickable(true);
                                poly25.setTag("poly25");
                            }
                            else if (polygonId.equals("poly26")){
                                poly26 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.620141, -73.587841),
                                                new LatLng(40.616318, -73.585201),
                                                new LatLng(40.617032, -73.590845),
                                                new LatLng(40.618990, -73.590056))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly26.setStrokeJointType(JointType.ROUND);
                                poly26.setClickable(true);
                                poly26.setTag("poly26");
                            }
                            else if (polygonId.equals("poly27")){
                                poly27 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.609660, -73.579374),
                                                new LatLng(40.608255, -73.578858),
                                                new LatLng(40.607748, -73.584412),
                                                new LatLng(40.610052, -73.584624))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly27.setStrokeJointType(JointType.ROUND);
                                poly27.setClickable(true);
                                poly27.setTag("poly27");
                            }
                            else if (polygonId.equals("poly28")){
                                poly28 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.609407, -73.585413),
                                                new LatLng(40.610144, -73.584685),
                                                new LatLng(40.611872, -73.585747),
                                                new LatLng(40.614728, -73.586293),
                                                new LatLng(40.615604, -73.591118),
                                                new LatLng(40.616387, -73.592392),
                                                new LatLng(40.618345, -73.594274),
                                                new LatLng(40.617677, -73.595002),
                                                new LatLng(40.615650, -73.593849),
                                                new LatLng(40.613876, -73.589054),
                                                new LatLng(40.613208, -73.587841))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly28.setStrokeJointType(JointType.ROUND);
                                poly28.setClickable(true);
                                poly28.setTag("poly28");
                            }
                            else if (polygonId.equals("poly29")){
                                poly29 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.595119, -73.587454),
                                                new LatLng(40.598298, -73.586877),
                                                new LatLng(40.600572, -73.585758),
                                                new LatLng(40.599805, -73.586949),
                                                new LatLng(40.600331, -73.588163),
                                                new LatLng(40.598879, -73.589225),
                                                new LatLng(40.598165, -73.588102),
                                                new LatLng(40.597358, -73.588284),
                                                new LatLng(40.597450, -73.589771),
                                                new LatLng(40.596321, -73.589893))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly29.setStrokeJointType(JointType.ROUND);
                                poly29.setClickable(true);
                                poly29.setTag("poly29");
                            }
                            else if (polygonId.equals("poly30")){
                                poly30 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.627493, -73.602513),
                                                new LatLng(40.624239, -73.602232),
                                                new LatLng(40.622941, -73.602692),
                                                new LatLng(40.623580, -73.606315),
                                                new LatLng(40.623212, -73.609632),
                                                new LatLng(40.625169, -73.612210),
                                                new LatLng(40.629410, -73.615195),
                                                new LatLng(40.629487, -73.614812),
                                                new LatLng(40.625285, -73.611291),
                                                new LatLng(40.625537, -73.608178))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly30.setStrokeJointType(JointType.ROUND);
                                poly30.setClickable(true);
                                poly30.setTag("poly30");
                            } else if (polygonId.equals("poly31")){
                                poly31 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.615582, -73.593894),
                                                new LatLng(40.613770, -73.588969),
                                                new LatLng(40.613325, -73.588102),
                                                new LatLng(40.608521, -73.584657),
                                                new LatLng(40.606855, -73.586570),
                                                new LatLng(40.607630, -73.587413),
                                                new LatLng(40.610012, -73.586928),
                                                new LatLng(40.611309, -73.587902),
                                                new LatLng(40.612277, -73.591882))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly31.setStrokeJointType(JointType.ROUND);
                                poly31.setClickable(true);
                                poly31.setTag("poly31");
                            } else if (polygonId.equals("poly32")){
                                poly32 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.606737, -73.586447),
                                                new LatLng(40.604412, -73.585784),
                                                new LatLng(40.606698, -73.578001),
                                                new LatLng(40.608151, -73.578613))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly32.setStrokeJointType(JointType.ROUND);
                                poly32.setClickable(true);
                                poly32.setTag("poly32");
                            } else if (polygonId.equals("poly33")){
                                poly33 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.602897, -73.587551),
                                                new LatLng(40.608322, -73.592014),
                                                new LatLng(40.610293, -73.588044),
                                                new LatLng(40.609967, -73.587701),
                                                new LatLng(40.607884, -73.588360),
                                                new LatLng(40.603941, -73.586536))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly33.setStrokeJointType(JointType.ROUND);
                                poly33.setClickable(true);
                                poly33.setTag("poly33");
                            }else if (polygonId.equals("poly34")){
                                poly34 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.608698, -73.592244),
                                                new LatLng(40.610392, -73.588167),
                                                new LatLng(40.610685, -73.589261),
                                                new LatLng(40.610865, -73.591450),
                                                new LatLng(40.613634, -73.594518),
                                                new LatLng(40.613178, -73.595076),
                                                new LatLng(40.611419, -73.594626))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly34.setStrokeJointType(JointType.ROUND);
                                poly34.setClickable(true);
                                poly34.setTag("poly34");
                            } else if (polygonId.equals("poly35")){
                                poly35 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.602752, -73.587781),
                                                new LatLng(40.602084, -73.588596),
                                                new LatLng(40.603892, -73.594433),
                                                new LatLng(40.605391, -73.592802),
                                                new LatLng(40.608633, -73.597050),
                                                new LatLng(40.612477, -73.595634),
                                                new LatLng(40.607704, -73.591557))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly35.setStrokeJointType(JointType.ROUND);
                                poly35.setClickable(true);
                                poly35.setTag("poly35");
                            }else if (polygonId.equals("poly36")){
                                poly36 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.604618, -73.568206),
                                                new LatLng(40.606323, -73.561105),
                                                new LatLng(40.599641, -73.557615),
                                                new LatLng(40.599964, -73.563714),
                                                new LatLng(40.600793, -73.566355))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly36.setStrokeJointType(JointType.ROUND);
                                poly36.setClickable(true);
                                poly36.setTag("poly36");
                            }else if (polygonId.equals("poly37")){
                                poly37 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.606507, -73.560255),
                                                new LatLng(40.599595, -73.556492),
                                                new LatLng(40.599065, -73.552851),
                                                new LatLng(40.600010, -73.551303),
                                                new LatLng(40.605585, -73.553852),
                                                new LatLng(40.608442, -73.554004))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly37.setStrokeJointType(JointType.ROUND);
                                poly37.setClickable(true);
                                poly37.setTag("poly37");
                            }else if (polygonId.equals("poly38")){
                                poly38 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.609502, -73.552083),
                                                new LatLng(40.611776, -73.554357),
                                                new LatLng(40.615009, -73.553906),
                                                new LatLng(40.612365, -73.550983),
                                                new LatLng(40.610845, -73.550207),
                                                new LatLng(40.609968, -73.550874))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly38.setStrokeJointType(JointType.ROUND);
                                poly38.setClickable(true);
                                poly38.setTag("poly38");
                            }else if (polygonId.equals("poly39")){
                                poly39 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.630223, -73.562242),
                                                new LatLng(40.630340, -73.559155),
                                                new LatLng(40.633922, -73.557266),
                                                new LatLng(40.637911, -73.558874),
                                                new LatLng(40.639092, -73.560864),
                                                new LatLng(40.638744, -73.562166),
                                                new LatLng(40.635161, -73.561502),
                                                new LatLng(40.632683, -73.561604))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly39.setStrokeJointType(JointType.ROUND);
                                poly39.setClickable(true);
                                poly39.setTag("poly39");
                            }else if (polygonId.equals("poly40")){
                                poly40 = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.639273, -73.560673),
                                                new LatLng(40.638841, -73.559755),
                                                new LatLng(40.640413, -73.558989),
                                                new LatLng(40.641339, -73.557290),
                                                new LatLng(40.643093, -73.556408),
                                                new LatLng(40.643703, -73.557008),
                                                new LatLng(40.642803, -73.557646),
                                                new LatLng(40.641380, -73.557965),
                                                new LatLng(40.639724, -73.560402))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly40.setStrokeJointType(JointType.ROUND);
                                poly40.setClickable(true);
                                poly40.setTag("poly40");
                            }/*else if (polygonId.equals("poly")){
                                poly = mMap.addPolygon(new PolygonOptions().add(
                                                new LatLng(40.641133, -73.563820),
                                                new LatLng(40.642077, -73.566159),
                                                new LatLng(40.643836, -73.566867),
                                                new LatLng(40.645675, -73.566352),
                                                new LatLng(40.647059, -73.567039),
                                                new LatLng(40.651634, -73.566481),
                                                new LatLng(40.645001, -73.565577),
                                                new LatLng(40.642318, -73.564242))
                                        .fillColor(fillColor)
                                        .strokeColor(strokeColor));
                                poly.setStrokeJointType(JointType.ROUND);
                                poly.setClickable(true);
                                poly.setTag("poly");
                            }*/


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
    polygonMap.put("jointType", jointType);
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
        fragmentTransaction.addToBackStack(null); // for back navigation
        fragmentTransaction.commit();

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

        for (int i = 1; i <= 40; i++) {
            String currentPolygonId = "poly" + i;
            if (polygonId.equals(currentPolygonId)) {
                try {
                    // Dynamically find the service class for each polygon
                    Class<?> serviceClass = Class.forName("com.example.operationsplash.Poly" + i + "Service");
                    Intent intent = new Intent(this, serviceClass);
                    intent.putExtra("polygonId", currentPolygonId);
                    intent.putExtra("greenFraction", greenFraction);
                    startService(intent);
                    Log.d(TAG, currentPolygonId + " service called");
                } catch (ClassNotFoundException e) {
                    Log.e(TAG, "Service class not found for " + currentPolygonId, e);
                }
                break; // Exit the loop once the matching polygon service is started
            }
        }


        /*if (polygonId.equals("poly1")) {
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
        } else if (polygonId.equals("poly6")) {
            Intent intent5 = new Intent(this, Poly6Service.class);
            intent5.putExtra("polygonId", "poly6");
            intent5.putExtra("greenFraction", greenFraction);
            startService(intent5);
        } else if (polygonId.equals("poly7")) {
            Intent intent6 = new Intent(this, Poly7Service.class);
            intent6.putExtra("polygonId", "poly7");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly8")) {
            Intent intent6 = new Intent(this, Poly8Service.class);
            intent6.putExtra("polygonId", "poly8");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly9")) {
            Intent intent6 = new Intent(this, Poly9Service.class);
            intent6.putExtra("polygonId", "poly9");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly10")) {
            Intent intent6 = new Intent(this, Poly10Service.class);
            intent6.putExtra("polygonId", "poly10");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly11")) {
            Intent intent6 = new Intent(this, Poly11Service.class);
            intent6.putExtra("polygonId", "poly11");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly12")) {
            Intent intent6 = new Intent(this, Poly12Service.class);
            intent6.putExtra("polygonId", "poly12");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly13")) {
            Intent intent6 = new Intent(this, Poly13Service.class);
            intent6.putExtra("polygonId", "poly13");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly14")) {
            Intent intent6 = new Intent(this, Poly14Service.class);
            intent6.putExtra("polygonId", "poly14");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly15")) {
            Intent intent6 = new Intent(this, Poly15Service.class);
            intent6.putExtra("polygonId", "poly15");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly16")) {
            Intent intent6 = new Intent(this, Poly16Service.class);
            intent6.putExtra("polygonId", "poly16");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly17")) {
            Intent intent6 = new Intent(this, Poly17Service.class);
            intent6.putExtra("polygonId", "poly17");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly18")) {
            Intent intent6 = new Intent(this, Poly18Service.class);
            intent6.putExtra("polygonId", "poly18");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly19")) {
            Intent intent6 = new Intent(this, Poly19Service.class);
            intent6.putExtra("polygonId", "poly19");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly20")) {
            Intent intent6 = new Intent(this, Poly20Service.class);
            intent6.putExtra("polygonId", "poly20");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        /*else if (polygonId.equals("poly")) {
            Intent intent6 = new Intent(this, PolyService.class);
            intent6.putExtra("polygonId", "poly");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly")) {
            Intent intent6 = new Intent(this, PolyService.class);
            intent6.putExtra("polygonId", "poly");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly")) {
            Intent intent6 = new Intent(this, PolyService.class);
            intent6.putExtra("polygonId", "poly");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly")) {
            Intent intent6 = new Intent(this, PolyService.class);
            intent6.putExtra("polygonId", "poly");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        else if (polygonId.equals("poly")) {
            Intent intent6 = new Intent(this, PolyService.class);
            intent6.putExtra("polygonId", "poly");
            intent6.putExtra("greenFraction", greenFraction);
            startService(intent6);
        }
        */
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




}







