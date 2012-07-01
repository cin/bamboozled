package com.zot.bamboozled

import collection.mutable.ListBuffer
import javax.microedition.khronos.opengles.GL10


class PlayState extends State {
  private var objects = new ListBuffer[GameObject]

  override def create() {
  }

  override def update: Boolean = {
    true
  }

  override def destroy() {
  }

  override def draw(gl: GL10) {
  }
}
