package com.example.sample;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

public class OpenGLES20Activity extends Activity implements SurfaceHolder.Callback {

    static
    {
        System.loadLibrary( "native-lib" );
    }

    private static final String APPLICATION = "QuestZDoom";

    private SurfaceView mView;
    private SurfaceHolder mSurfaceHolder;
    private long mNativeHandle;

    @Override
    public void onCreate(Bundle icicle) {
        Log.v(APPLICATION, "----------------------------------------------------------------" );
        Log.v(APPLICATION, "GLES3JNIActivity::onCreate()" );
        super.onCreate( icicle );

        mView = new SurfaceView( this );
        setContentView( mView );
        mView.getHolder().addCallback( this );

        // Force the screen to stay on, rather than letting it dim and shut off
        // while the user is watching a movie.
        getWindow().addFlags( WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON );

        // Force screen brightness to stay at maximum
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.screenBrightness = 1.0f;
        getWindow().setAttributes( params );

        mNativeHandle = GLES3JNILib.onCreate( this);
    }

    @Override protected void onStart()
    {
        Log.v(APPLICATION, "GLES3JNIActivity::onStart()" );
        super.onStart();

        if ( mNativeHandle != 0 )
        {
            GLES3JNILib.onStart(mNativeHandle, this);
        }
    }

    @Override protected void onResume()
    {
        Log.v(APPLICATION, "GLES3JNIActivity::onResume()" );
        super.onResume();

        if ( mNativeHandle != 0 )
        {
            GLES3JNILib.onResume(mNativeHandle);
        }
    }

    @Override protected void onPause()
    {
        Log.v(APPLICATION, "GLES3JNIActivity::onPause()" );
        if ( mNativeHandle != 0 )
        {
            GLES3JNILib.onPause(mNativeHandle);
        }
        super.onPause();
    }

    @Override protected void onStop()
    {
        Log.v(APPLICATION, "GLES3JNIActivity::onStop()" );
        if ( mNativeHandle != 0 )
        {
            GLES3JNILib.onStop(mNativeHandle);
        }
        super.onStop();
    }

    @Override protected void onDestroy()
    {
        Log.v(APPLICATION, "GLES3JNIActivity::onDestroy()" );

        if ( mSurfaceHolder != null )
        {
            GLES3JNILib.onSurfaceDestroyed( mNativeHandle );
        }

        if ( mNativeHandle != 0 )
        {
            GLES3JNILib.onDestroy(mNativeHandle);
        }

        super.onDestroy();
        mNativeHandle = 0;
    }

    @Override public void surfaceCreated( SurfaceHolder holder )
    {
        Log.v(APPLICATION, "GLES3JNIActivity::surfaceCreated()" );
        if ( mNativeHandle != 0 )
        {
            GLES3JNILib.onSurfaceCreated( mNativeHandle, holder.getSurface() );
            mSurfaceHolder = holder;
        }
    }

    @Override public void surfaceChanged( SurfaceHolder holder, int format, int width, int height )
    {
        Log.v(APPLICATION, "GLES3JNIActivity::surfaceChanged()" );
        if ( mNativeHandle != 0 )
        {
            GLES3JNILib.onSurfaceChanged( mNativeHandle, holder.getSurface() );
            mSurfaceHolder = holder;
        }
    }

    @Override public void surfaceDestroyed( SurfaceHolder holder )
    {
        Log.v(APPLICATION, "GLES3JNIActivity::surfaceDestroyed()" );
        if ( mNativeHandle != 0 )
        {
            GLES3JNILib.onSurfaceDestroyed( mNativeHandle );
            mSurfaceHolder = null;
        }
    }
}