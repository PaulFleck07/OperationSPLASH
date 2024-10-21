package com.example.operationsplash;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.gms.maps.model.Polygon;
import com.google.firebase.firestore.FirebaseFirestore;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OverlayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class OverlayFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ProgressBar progressBar;
    private SeekBar seekBar3;
    private TextView clickableQuit;
    private TextView clickableUpdate;
    private OnFragmentInteractionListener mListener;
    private AnimationServiceUpdate mAnimationServiceUpdate;
    private String polygonId;
    private Polygon polygon;


    public interface OnFragmentInteractionListener {
        void onCloseFragment();
    }
    public interface AnimationServiceUpdate {

        void beginPolyService(Polygon polygon, String polygonId, float progress);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            // Ensure that the containing Activity implements both interfaces
            mAnimationServiceUpdate = (AnimationServiceUpdate) context;
            mListener = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnPolygonServiceListener and OtherInterface");
        }
       /* if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }


    public OverlayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OverlayFragment.
     */

    // TODO: Rename and change types and number of parameters
    public static OverlayFragment newInstance(String param1, String param2) {
        OverlayFragment fragment = new OverlayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overlay, container, false);

        progressBar = view.findViewById(R.id.progressBar);
        seekBar3 = view.findViewById(R.id.seekBar3);

        clickableQuit = view.findViewById(R.id.textView3);
        clickableUpdate = view.findViewById(R.id.textView1);

        clickableUpdate.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // Execute the method when the TextView is clicked
                    float progress = seekBar3.getProgress();
                    startPolygonService(polygon, polygonId, progress);


                    if (mListener != null) {
                        mListener.onCloseFragment();  // Call the method in the activity to close the fragment
                    }
                }
            });


        clickableQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Execute the method when the TextView is clicked
                if (mListener != null) {
                    mListener.onCloseFragment();  // Call the method in the activity to close the fragment
                }
            }
        });



        return view;
    }

    public void startPolygonService(Polygon polygon, String polygonId, float progress) {
        if (mAnimationServiceUpdate != null) {
            mAnimationServiceUpdate.beginPolyService(polygon, polygonId, progress);
        }
    }

    public void setPolygonId(String polygonId) {
        this.polygonId = polygonId;


    }
    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }




    public void setProgress(int progress) {
        if (progressBar != null && seekBar3 != null) {
            progressBar.setProgress(progress);
            seekBar3.setProgress(progress);
        }
    }


   @Override
   public void onDetach() {
       super.onDetach();
       mListener = null;
   }





}
