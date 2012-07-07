package com.zot.bamboozled

import java.nio.{ByteOrder, ByteBuffer, FloatBuffer}
import javax.microedition.khronos.opengles.GL10


class Sprite extends GameObject with Renderable {
  val tri = Array(
    -1.0f, -1.0f, 0.0f,
    -1.0f,  1.0f, 0.0f,
    1.0f, -1.0f, 0.0f,
    1.0f,  1.0f, 0.0f
  )

  var fb: FloatBuffer = _

  override def init() {
    fb = ByteBuffer.allocateDirect(tri.size * 4).order(ByteOrder.nativeOrder).asFloatBuffer()
    fb.put(tri).position(0)
  }

  override def update() = true

  override def draw(gl: GL10) {
    gl.glPushMatrix()
      //gl.glLoadIdentity()
      gl.glColor4f(1.0f, 0.0f, 0.0f, 0.0f)
      gl.glTranslatef(0.0f, 0.0f, 0.0f)
      gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
      gl.glVertexPointer(3, GL10.GL_FLOAT, 0, fb)
      gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, tri.length / 3)
      gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)
    gl.glPopMatrix()
  }
}
