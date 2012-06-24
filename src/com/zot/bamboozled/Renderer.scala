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
  }

  def onSurfaceChanged(gl: GL10, w: Int, h: Int) {
    Log.i(TAG, "onSurfaceChanged")
    gl.glViewport(0, 0, w, h)
  }

  def onDrawFrame(gl: GL10) {
    Log.i(TAG, "onDrawFrame")
    gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT)
  }
}
