package com.zot.bamboozled

import android.opengl.GLSurfaceView
import android.content.Context
import android.view.{ MotionEvent, GestureDetector }


object View {
  val TAG = "View"
}

class View(context: Context) extends GLSurfaceView(context) {
  val renderer = new Renderer
  setRenderer(renderer)

  val gd = new GestureDetector(context, new Gesty)

  override def onTouchEvent(event: MotionEvent): Boolean = {
    gd.onTouchEvent(event)
  }
}
