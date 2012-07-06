package com.zot.bamboozled

import javax.microedition.khronos.opengles.GL10
import com.zot.bamboozled.{ TextureManager => TM }

case class Texture(res: Int) {

  var id: Int = -1

  def gen(): Int = {
    val i = Array(id)
    TM.gl.glGenTextures(1, i, 0)
    id = i(0)
    id
  }

  def bind() { TM.gl.glBindTexture(GL10.GL_TEXTURE_2D, id) }
}
