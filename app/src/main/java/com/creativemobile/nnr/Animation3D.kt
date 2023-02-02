package com.creativemobile.nnr

import android.graphics.Camera
import android.view.animation.Animation
import android.view.animation.Transformation

class Animation3D(
    var fromXDegrees: Float,
    var toXDegrees: Float,
    var fromYDegrees: Float,
    var toYDegrees: Float,
    var fromZDegrees: Float,
    var toZDegrees: Float

) : Animation() {
    lateinit var camera: Camera
    var width: Int = 0
    var height:Int = 0

    override fun initialize(width: Int, height: Int, parentWidth: Int, parentHeight: Int) {
        super.initialize(width, height, parentWidth, parentHeight)
        this.width = width / 2
        this.height = height/2
        camera = Camera()
    }

    override fun applyTransformation(interpolatedTime: Float, t: Transformation) {
        val xDegrees: Float = fromXDegrees + (toXDegrees - fromXDegrees) * interpolatedTime
        val yDegrees: Float = fromYDegrees + (toYDegrees - fromYDegrees) * interpolatedTime
        val zDegrees: Float = fromZDegrees + (toZDegrees - fromZDegrees) * interpolatedTime
        val matrix = t.matrix
        camera.save()
        camera.rotateX(xDegrees)
        camera.rotateY(yDegrees)
        camera.rotateZ(zDegrees)
        camera.getMatrix(matrix)
        camera.restore()
        matrix.preTranslate(-this.width.toFloat(), -this.height.toFloat())
        matrix.postTranslate(this.width.toFloat(), this.height.toFloat())


    }
}