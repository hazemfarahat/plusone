/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zoumapps.plusone;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient.ConnectionCallbacks;
import com.google.android.gms.common.GooglePlayServicesClient.OnConnectionFailedListener;
import com.google.android.gms.plus.PlusClient;
import com.google.android.gms.plus.PlusOneButton;

import android.app.Activity;
import android.os.Bundle;

/**
 * Example usage of the +1 button.
 */
public class PlusOneActivity extends Activity
        implements ConnectionCallbacks, OnConnectionFailedListener {
    private static final String TAG = PlusOneActivity.class.getSimpleName();
    private static final String URL = "http://blog.zoumapps.com";

    // The request code must be 0 or higher.
    private static final int PLUS_ONE_REQUEST_CODE = 0;

    private PlusClient mPlusClient;
    private PlusOneButton mPlusOneStandardButtonWithAnnotation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plus_one_activity);

        mPlusClient = new PlusClient(this, this, this);

     
        mPlusOneStandardButtonWithAnnotation = (PlusOneButton) findViewById(
                R.id.plus_one_standard_ann_button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPlusClient.connect();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPlusOneStandardButtonWithAnnotation.initialize(mPlusClient, URL, PLUS_ONE_REQUEST_CODE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPlusClient.disconnect();
    }

    @Override
    public void onConnectionFailed(ConnectionResult status) {
        // Nothing to do.
    }

    @Override
    public void onConnected() {
        // Nothing to do.
    }

    @Override
    public void onDisconnected() {
        // Nothing to do.
    }
}
