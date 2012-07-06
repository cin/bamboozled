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

  val tri = Array(
    0.0f,  1.0f, 0.0f,
    -1.0f, -1.0f, 0.0f,
    1.0f, -1.0f, 0.0f
  )

  var fb: FloatBuffer = _

  def init(bbz: Bamboozled) {
    this.bbz = bbz
    context  = bbz.getApplicationContext
    view     = bbz.getGlView
    renderer = view.renderer
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

    fb = ByteBuffer.allocateDirect(tri.size * 4).order(ByteOrder.nativeOrder).asFloatBuffer()
    fb.put(tri).position(0)
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
    gl.glPushMatrix()
//      gl.glLoadIdentity()
      gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f)
      gl.glTranslatef(0.0f, 0.0f, 0.0f)
      gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
      gl.glVertexPointer(3, GL10.GL_FLOAT, 0, fb)
      gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, 3)
      gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
    gl.glPopMatrix()
  }

  protected def update: Boolean = state.update
}
