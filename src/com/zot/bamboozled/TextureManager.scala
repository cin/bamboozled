package com.zot.bamboozled

import collection.mutable.{ Map => MutieMap }
import javax.microedition.khronos.opengles.GL10

object TextureManager {

  val tm = MutieMap.empty[Int, Int]
  var gl: GL10 = _

  def init(gl: GL10) { this.gl = gl }

  def load(res: Int): Int = {
    val ctx = Engine.getContext
    ctx.getResources.openRawResource(res)
    1
  }
}
