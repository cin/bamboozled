package com.zot.bamboozled

import javax.microedition.khronos.opengles.GL10
import android.content.Context
import android.widget.Toast


object Engine {
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
  }

  def getActivity = bbz
  def getContext  = context
  def getRenderer = renderer
  def getView     = view

  def toast(msg: String) { Toast.makeText(context, msg, Toast.LENGTH_SHORT).show() }

  def tick(gl: GL10) {
    val time: Long = System.nanoTime
    dt = time - lastTick
    if (update) draw(gl)
    lastTick = time
  }

  protected def draw(gl: GL10) {
    gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT)
  }

  protected def update: Boolean = state.update
}
