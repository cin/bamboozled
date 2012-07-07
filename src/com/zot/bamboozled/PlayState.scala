package com.zot.bamboozled

import collection.mutable.ListBuffer
import javax.microedition.khronos.opengles.GL10


class PlayState extends State {
  private var objects = new ListBuffer[GameObject]

  override def create() {
    val sprite = new Sprite
    sprite.init()
    objects += sprite
  }

  override def update: Boolean = {
    var res = false
    objects.foreach(res |= _.update)
    res
  }

  override def destroy() {
  }

  override def draw(gl: GL10) {
    objects.foreach(draw(_, gl))
  }

  private def draw(o: GameObject, gl: GL10) {
    o match {
      case r: Renderable => r.draw(gl)
      case _ => ()
    }
  }
}
