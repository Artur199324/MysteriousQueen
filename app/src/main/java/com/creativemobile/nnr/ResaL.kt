package com.creativemobile.nnr

import android.content.Context
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import com.creativemobile.nnr.MainActivity
import com.creativemobile.nnr.click
import com.creativemobile.nnr.point
import com.creativemobile.nnr.win
import java.lang.Exception


class ResaL {

    var mainActivity: MainActivity

    constructor(mainActivity: MainActivity) {
        this.mainActivity = mainActivity
        res()
    }


    fun res() {

        if (mainActivity.arrayList.get(1).tag == mainActivity.arrayList.get(3).tag) {
            mainActivity.clinArr()
            mainActivity.clliON()

            win++
            when (click) {
                in 0..4 -> {
                    point += 300
                    mainActivity.binding.textViewScore.text = "Score: $point"
                }

                in 4..6 -> {
                    point += 220
                    mainActivity.binding.textViewScore.text = "Score: $point"
                }

                in 6..500 -> {
                    point += 120
                    mainActivity.binding.textViewScore.text = "Score: $point"
                }
            }

            if (win == 6) {
                mainActivity.binding.imageViewScT.visibility = View.VISIBLE
                mainActivity.binding.textViewRes.visibility = View.VISIBLE
                mainActivity.binding.textViewScore2.visibility = View.VISIBLE
                mainActivity.binding.textViewRes.text = "You won"
                mainActivity.binding.textViewScore2.text = "Score: $point"
                mainActivity.aniRot(mainActivity.binding.cardd1, mainActivity.binding.ii1)
                mainActivity.aniRot(mainActivity.binding.cardd2, mainActivity.binding.ii2)
                mainActivity.aniRot(mainActivity.binding.cardd3, mainActivity.binding.ii3)
                mainActivity.aniRot(mainActivity.binding.cardd4, mainActivity.binding.ii4)
                mainActivity.aniRot(mainActivity.binding.cardd5, mainActivity.binding.ii5)
                mainActivity.aniRot(mainActivity.binding.cardd6, mainActivity.binding.ii6)
                mainActivity.aniRot(mainActivity.binding.cardd7, mainActivity.binding.ii7)
                mainActivity.aniRot(mainActivity.binding.cardd8, mainActivity.binding.ii8)
                mainActivity.aniRot(mainActivity.binding.cardd9, mainActivity.binding.ii9)
                mainActivity.aniRot(mainActivity.binding.cardd10, mainActivity.binding.ii10)
                mainActivity.aniRot(mainActivity.binding.cardd11, mainActivity.binding.ii11)
                mainActivity.aniRot(mainActivity.binding.cardd12, mainActivity.binding.ii12)
                Handler().postDelayed({
                    mainActivity.binding.imageViewScT.visibility = View.INVISIBLE
                    mainActivity.binding.textViewRes.visibility = View.INVISIBLE
                    mainActivity.binding.textViewScore2.visibility = View.INVISIBLE
                    mainActivity.binding.textView6.text = "Score : $point"
                    mainActivity.getSharedPreferences( mainActivity.packageName, Context.MODE_PRIVATE).edit()
                        .putInt("ssss", point).apply()
                    mainActivity.invisb()
                }, 3000)
                mainActivity.countDownTimer.cancel()
            }


        } else {
            click++
            object : CountDownTimer(1000, 1000) {
                override fun onTick(p0: Long) {

                }

                override fun onFinish() {

                    try {
                        mainActivity.aniRot(
                            mainActivity.arrayList.get(0),
                            mainActivity.arrayList.get(1)
                        )
                        mainActivity.aniRot(
                            mainActivity.arrayList.get(2),
                            mainActivity.arrayList.get(3)
                        )
                    }catch (e:Exception){

                    }

                    mainActivity.clinArr()
                }

            }.start()

        }
    }
}