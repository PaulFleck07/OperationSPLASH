package com.example.operationsplash;

import com.google.firebase.firestore.FirebaseFirestore;

public class FirestoreInstance {

        private static FirebaseFirestore db;

        private FirestoreInstance() {
            // Private constructor to prevent instantiation
        }

        public static synchronized FirebaseFirestore getInstance() {
            if (db == null) {
                db = FirebaseFirestore.getInstance();
            }
            return db;
        }
    }

