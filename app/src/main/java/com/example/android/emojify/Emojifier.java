package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    public static void detectFaces(Context context, Bitmap bitmap) {
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setLandmarkType(FaceDetector.ALL_LANDMARKS)
                .build();

        SparseArray<Face> faces = detector.detect(frame);

        if(faces.size() > 0){
            String LOG = "Faces detected is ";
            Log.v(LOG, String.valueOf(faces.size()));
        } else {
            Toast.makeText(context,"No faces detected",Toast.LENGTH_LONG).show();
        }
    }
}
