package com.zot.bamboozled

import collection.mutable.ListBuffer
import java.util.{ ArrayList, List }
import javax.microedition.khronos.opengles.GL10


class PlayState extends State {
  override def create() {
  }

  override def update: Boolean = {
    true
  }

  override def destroy() {
  }

  override def draw(gl: GL10) {
  }

  private var objects = new ListBuffer[GameObject]
}
