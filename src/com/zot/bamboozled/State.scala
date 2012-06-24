package com.zot.bamboozled

import javax.microedition.khronos.opengles.GL10


trait State {
  def create()
  def update: Boolean
  def draw(gl: GL10)
  def destroy()
}
