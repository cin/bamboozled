package com.zot.bamboozled

import android.opengl.{GLU, GLSurfaceView}
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
    gl.glViewport(0, 0, w, h)
    val ratio = w.toFloat / h
    gl.glMatrixMode(GL10.GL_PROJECTION)
    gl.glLoadIdentity()
    gl.glFrustumf(-ratio, ratio, -1, 1, 3, 7)
    gl.glMatrixMode(GL10.GL_MODELVIEW)
    gl.glLoadIdentity()
    GLU.gluLookAt(gl, 0, 0, -5, 0, 0, 0, 0, 1, 0)
  }

  def onDrawFrame(gl: GL10) {
    //Log.i(TAG, "onDrawFrame")
    Engine.tick(gl)
  }
}
