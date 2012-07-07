package com.zot.bamboozled

import javax.microedition.khronos.opengles.GL10

trait Renderable {
  def draw(gl: GL10)
}
