package com.zot.bamboozled

import java.nio.IntBuffer
import javax.microedition.khronos.opengles.GL10
import com.zot.bamboozled.{ TextureManager => TM }

class Texture(res: Int) {

  var id: Int = -1

  def gen(): Int = {
    val i = IntBuffer.allocate(1)
    TM.gl.glGenTextures(1, i)
    id = i.get(0)
    id
  }

  def bind() { TM.gl.glBindTexture(GL10.GL_TEXTURE_2D, id) }
}
