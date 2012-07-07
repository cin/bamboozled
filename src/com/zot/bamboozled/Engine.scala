package com.zot.bamboozled

import java.nio.{ByteBuffer, ByteOrder, FloatBuffer}
import javax.microedition.khronos.opengles.GL10
import android.opengl.GLU
import android.content.Context
import android.widget.Toast
import android.util.Log


object Engine {
  val TAG = "Engine"

  private var bbz:      Bamboozled = _
  private var context:  Context    = _
  private var renderer: Renderer   = _
  private var view:     View       = _

  val state    = new PlayState
  var lastTick = 0L
  var currTick = 0L
  var dt       = 0L

  def init(bbz: Bamboozled) {
    this.bbz = bbz
    context  = bbz.getApplicationContext
    view     = bbz.getGlView
    renderer = view.renderer
    state.create()
  }

  def getActivity = bbz
  def getContext  = context
  def getRenderer = renderer
  def getView     = view

  def toast(msg: String) { Toast.makeText(context, msg, Toast.LENGTH_SHORT).show() }

  def resize(gl: GL10, w: Int, h: Int) {
    gl.glViewport(0, 0, w, h)
    val ratio = w.toFloat / h
    gl.glMatrixMode(GL10.GL_PROJECTION)
    gl.glLoadIdentity()
    GLU.gluPerspective(gl, 45.0f, ratio, 1.0f, 100.0f)

    gl.glMatrixMode(GL10.GL_MODELVIEW)
    gl.glLoadIdentity()
    GLU.gluLookAt(gl,
      0.0f, 0.0f, 5.0f, /* camera location */
      0.0f, 0.0f, 0.0f, /* center point */
      0.0f, 1.0f, 0.0f) /* up vector */
  }

  def tick(gl: GL10) {
    val time = System.nanoTime
    dt       = time - lastTick
    if (update) draw(gl)
    lastTick = time
  }

  protected def draw(gl: GL10) {
    gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT)
    gl.glMatrixMode(GL10.GL_MODELVIEW)
    state.draw(gl)
  }

  protected def update: Boolean = state.update
}
