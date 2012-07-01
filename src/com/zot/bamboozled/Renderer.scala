package com.zot.bamboozled

import android.opengl.GLSurfaceView
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10
import android.util.Log
import Renderer.TAG


object Renderer {
  val TAG = "Renderer"
}

class Renderer extends GLSurfaceView.Renderer {
  override def onSurfaceCreated(gl: GL10, config: EGLConfig) {
    Log.i(TAG, "onSurfaceCreated")
    gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f)
  }

  def onSurfaceChanged(gl: GL10, w: Int, h: Int) {
    Log.i(TAG, "onSurfaceChanged")
    Engine.resize(gl, w, h)
  }

  def onDrawFrame(gl: GL10) {
    //Log.i(TAG, "onDrawFrame")
    Engine.tick(gl)
  }
}
