package com.zot.bamboozled

import android.view.GestureDetector.OnGestureListener
import android.view.MotionEvent
import android.util.Log
import Engine.toast
import Gesty.TAG

object Gesty {
  val TAG = "Gesty"
}

class Gesty extends OnGestureListener {
  override def onDown(e: MotionEvent): Boolean = {
    val msg = "onDown: " + e.toString
    Log.i(TAG, msg)
    //toast(msg)
    true
  }

  override def onFling(e1: MotionEvent, e2: MotionEvent, vx: Float, vy: Float): Boolean = {
    val msg = "onFling: " + e1.toString + " " + e2.toString + " (" + vx + ", " + vy + ")"
    Log.i(TAG, msg)
    toast(msg)
    true
  }

  override def onLongPress(e: MotionEvent) {
//    toast("looooooong press")
  }

  override def onScroll(e1: MotionEvent, e2: MotionEvent, x: Float, y: Float): Boolean = {
    val msg = "onScroll: " + e1.toString + " " + e2.toString + " (" + x + ", " + y + ")"
    Log.i(TAG, msg)
//    toast(msg)
    true
  }

  override def onSingleTapUp(e: MotionEvent): Boolean = {
    val msg = "onSingleTapUp: " + e.toString
    Log.i(TAG, msg)
//    toast(msg)
    true
  }

  override def onShowPress(e: MotionEvent) {
    val msg = "onShowPress: " + e.toString
    Log.i(TAG, msg)
//    toast(msg)
  }
}
