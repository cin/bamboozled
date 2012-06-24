package com.zot.bamboozled

import javax.microedition.khronos.opengles.GL10


object Engine {
  val state    = new PlayState
  var lastTick = 0L
  var currTick = 0L
  var dt       = 0L

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
