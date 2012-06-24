package com.zot.bamboozled

import android.opengl.GLSurfaceView
import android.content.Context
import android.view.MotionEvent
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10
import android.util.Log
import View.TAG

object View {
  val TAG = "View"
}

class View(context: Context) extends GLSurfaceView(context) {
  val renderer = new Renderer
  setRenderer(renderer)

  override def onTouchEvent(event: MotionEvent): Boolean = {
    Log.i(TAG, "onTouchEvent: " + event.toString)
    true
  }
}
