package com.zot.bamboozled

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.opengl.GLSurfaceView
import Bamboozled.TAG


object Bamboozled {
  val TAG = "com/zot/bamboozled"
}

class Bamboozled extends Activity {
  var glView: GLSurfaceView = _

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    Log.i(TAG, "onCreate")
    glView = new View(this)
    setContentView(glView)
  }

  override protected def onPause() {
    super.onPause()
    Log.i(TAG, "onPause")
    glView.onPause()
  }

  override protected def onResume() {
    super.onResume()
    Log.i(TAG, "onResume")
    glView.onResume()
  }
}
