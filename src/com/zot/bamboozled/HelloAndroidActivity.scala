package com.zot.bamboozled

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.opengl.GLSurfaceView
import HelloAndroidActivity.TAG

object HelloAndroidActivity {
  val TAG = "com/zot/bamboozled"
}

class HelloAndroidActivity extends Activity {
  var glView: GLSurfaceView = _

  /**
   * Called when the activity is first created.
   * @param savedInstanceState If the activity is being re-initialized after
   *                           previously being shut down then this Bundle contains the data it most
   *                           recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
   */
  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    Log.i(TAG, "onCreate")
    glView = new View(this)
    setContentView(glView)
  }

  override protected def onPause() {
    super.onPause()
    glView.onPause()
  }

  override protected def onResume() {
    super.onResume()
    glView.onResume()
  }
}