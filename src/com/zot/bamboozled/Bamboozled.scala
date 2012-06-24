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
  private var glView: View = _
  def getGlView = glView

  override protected def onCreate(savedInstanceState: Bundle) {
    super.onCreate(savedInstanceState)
    Log.i(TAG, "onCreate")
    // order matters here. engine needs the view to be initialized first.
    glView = new View(this)
    Engine.init(this)
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
