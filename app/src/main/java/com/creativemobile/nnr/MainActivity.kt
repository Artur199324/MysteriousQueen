package com.creativemobile.nnr

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import com.creativemobile.nnr.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var arrayList: ArrayList<ImageView>
    lateinit var countDownTimer: CountDownTimer
    var time = 5
    var timeGame = 60
    var arrayListCl: ArrayList<ImageView> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button3.setOnClickListener {
            onBackPressed()
        }

        var cc = getSharedPreferences(packageName, MODE_PRIVATE).getInt("ssss", 0)
        if (cc != 0) {
            binding.button4.visibility = View.VISIBLE
        }
        binding.textView6.text = "Score : $cc"
        arrayListCl.add(binding.cardd1)
        arrayListCl.add(binding.cardd2)
        arrayListCl.add(binding.cardd3)
        arrayListCl.add(binding.cardd4)
        arrayListCl.add(binding.cardd5)
        arrayListCl.add(binding.cardd6)
        arrayListCl.add(binding.cardd7)
        arrayListCl.add(binding.cardd8)
        arrayListCl.add(binding.cardd9)
        arrayListCl.add(binding.cardd10)
        arrayListCl.add(binding.cardd11)
        arrayListCl.add(binding.cardd12)

        binding.imageViewSetting.setOnClickListener {
            tim()

        }

        binding.button4.setOnClickListener {
            sta()
        }

        binding.buttonStart.setOnClickListener {
            binding.textView6.text = "Score : 0"
            getSharedPreferences(packageName, Context.MODE_PRIVATE).edit()
                .putInt("ssss", 0).apply()
            sta()
        }

    }

    fun tim() {
        binding.buttonStart.isClickable = false
        binding.button4.isClickable = false
        binding.imageViewScT.visibility = View.VISIBLE
        binding.textView.visibility = View.VISIBLE
        binding.radioButton.visibility = View.VISIBLE
        binding.radioButton2.visibility = View.VISIBLE
        binding.radioButton3.visibility = View.VISIBLE
        var tt = getSharedPreferences(packageName, MODE_PRIVATE).getInt("ttt", 30)
        when (tt) {
            30 -> binding.radioButton.isChecked = true
            45 -> binding.radioButton2.isChecked = true
            60 -> binding.radioButton3.isChecked = true
        }

        binding.radioButton.setOnClickListener {
            binding.radioButton.isChecked = true
            binding.radioButton2.isChecked = false
            binding.radioButton3.isChecked = false
            getSharedPreferences( packageName, Context.MODE_PRIVATE).edit()
                .putInt("ttt", 30).apply()
            closSting()

        }
        binding.radioButton2.setOnClickListener {
            binding.radioButton.isChecked = false
            binding.radioButton3.isChecked = false
            binding.radioButton2.isChecked = true
            getSharedPreferences( packageName, Context.MODE_PRIVATE).edit()
                .putInt("ttt", 45).apply()
            closSting()
        }
        binding.radioButton3.setOnClickListener {
            binding.radioButton2.isChecked = false
            binding.radioButton.isChecked = false
            binding.radioButton3.isChecked = true
            getSharedPreferences( packageName, Context.MODE_PRIVATE).edit()
                .putInt("ttt", 60).apply()
            closSting()
        }

    }

    fun closSting(){

        object : CountDownTimer(2000,1000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                binding.imageViewScT.visibility = View.INVISIBLE
                binding.textView.visibility = View.INVISIBLE
                binding.radioButton.visibility = View.INVISIBLE
                binding.radioButton2.visibility = View.INVISIBLE
                binding.radioButton3.visibility = View.INVISIBLE
                binding.buttonStart.isClickable = true
                binding.button4.isClickable = true
            }

        }.start()

    }

    fun sta() {
        binding.imageViewSetting.isClickable = false
        point = 0
        click = 0
        win = 0
        binding.textViewScore.text = "Score: $point"
        viseb()
        clickCart()
        randomImage(binding)
        ani(binding.cardd1, binding.ii1)
        ani(binding.cardd2, binding.ii2)
        ani(binding.cardd3, binding.ii3)
        ani(binding.cardd4, binding.ii4)
        ani(binding.cardd5, binding.ii5)
        ani(binding.cardd6, binding.ii6)
        ani(binding.cardd7, binding.ii7)
        ani(binding.cardd8, binding.ii8)
        ani(binding.cardd9, binding.ii9)
        ani(binding.cardd10, binding.ii10)
        ani(binding.cardd11, binding.ii11)
        ani(binding.cardd12, binding.ii12)
        val countDownTimer = object : CountDownTimer(5000, 1000) {
            override fun onTick(p0: Long) {
                time--
                binding.textViewTime.text = time.toString()
            }

            override fun onFinish() {
                binding.textViewTime.visibility = View.INVISIBLE
                time = 5;
                aniRot(binding.cardd1, binding.ii1)
                aniRot(binding.cardd2, binding.ii2)
                aniRot(binding.cardd3, binding.ii3)
                aniRot(binding.cardd4, binding.ii4)
                aniRot(binding.cardd5, binding.ii5)
                aniRot(binding.cardd6, binding.ii6)
                aniRot(binding.cardd7, binding.ii7)
                aniRot(binding.cardd8, binding.ii8)
                aniRot(binding.cardd9, binding.ii9)
                aniRot(binding.cardd10, binding.ii10)
                aniRot(binding.cardd11, binding.ii11)
                aniRot(binding.cardd12, binding.ii12)

                timeGam(getSharedPreferences(packageName, MODE_PRIVATE).getInt("ttt", 30))
            }

        }
        countDownTimer.start()
    }

    fun ani(imageViewCart: ImageView, imageViewImg: ImageView) {

        val animation3D = Animation3D(0F, 0F, 180F, 0F, 0F, 0F)
        animation3D.duration = 1000
        animation3D.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                Handler().postDelayed({
                    imageViewImg.alpha = 1.0F
                }, 500)


            }

            override fun onAnimationEnd(animation: Animation) {

            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        imageViewCart.startAnimation(animation3D)
        imageViewImg.startAnimation(animation3D)
    }

    fun aniRot(imageViewCart: ImageView, imageViewImg: ImageView) {
        val animation3D = Animation3D(0F, 0F, 0F, 180F, 0F, 0F)
        animation3D.duration = 1000
        animation3D.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                clinArr()
                Handler().postDelayed({
                    imageViewImg.alpha = 0.0F
                }, 500)

            }

            override fun onAnimationEnd(animation: Animation) {
                clliON()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        imageViewCart.startAnimation(animation3D)
        imageViewImg.startAnimation(animation3D)
    }

    fun clickCart() {

        binding.cardd1.setOnClickListener {
            if (binding.ii1.alpha == 0.0F) {
                ani(binding.cardd1, binding.ii1)
                arrayList.add(binding.cardd1)
                arrayList.add(binding.ii1)
                Log.d("weq", arrayList.size.toString())
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)


                }

            }
        }

        binding.cardd2.setOnClickListener {
            if (binding.ii2.alpha == 0.0F) {
                ani(binding.cardd2, binding.ii2)
                arrayList.add(binding.cardd2)
                arrayList.add(binding.ii2)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd3.setOnClickListener {
            if (binding.ii3.alpha == 0.0F) {
                ani(binding.cardd3, binding.ii3)
                arrayList.add(binding.cardd3)
                arrayList.add(binding.ii3)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd4.setOnClickListener {
            if (binding.ii4.alpha == 0.0F) {
                ani(binding.cardd4, binding.ii4)
                arrayList.add(binding.cardd4)
                arrayList.add(binding.ii4)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd5.setOnClickListener {
            if (binding.ii5.alpha == 0.0F) {
                ani(binding.cardd5, binding.ii5)
                arrayList.add(binding.cardd5)
                arrayList.add(binding.ii5)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd6.setOnClickListener {
            if (binding.ii6.alpha == 0.0F) {
                ani(binding.cardd6, binding.ii6)
                arrayList.add(binding.cardd6)
                arrayList.add(binding.ii6)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd7.setOnClickListener {
            if (binding.ii7.alpha == 0.0F) {
                ani(binding.cardd7, binding.ii7)
                arrayList.add(binding.cardd7)
                arrayList.add(binding.ii7)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd8.setOnClickListener {
            if (binding.ii8.alpha == 0.0F) {
                ani(binding.cardd8, binding.ii8)
                arrayList.add(binding.cardd8)
                arrayList.add(binding.ii8)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd9.setOnClickListener {
            if (binding.ii9.alpha == 0.0F) {
                ani(binding.cardd9, binding.ii9)
                arrayList.add(binding.cardd9)
                arrayList.add(binding.ii9)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd10.setOnClickListener {
            if (binding.ii10.alpha == 0.0F) {
                ani(binding.cardd10, binding.ii10)
                arrayList.add(binding.cardd10)
                arrayList.add(binding.ii10)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd11.setOnClickListener {
            if (binding.ii11.alpha == 0.0F) {
                ani(binding.cardd11, binding.ii11)
                arrayList.add(binding.cardd11)
                arrayList.add(binding.ii11)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)

                }
            }

        }

        binding.cardd12.setOnClickListener {
            if (binding.ii12.alpha == 0.0F) {
                ani(binding.cardd12, binding.ii12)
                arrayList.add(binding.cardd12)
                arrayList.add(binding.ii12)
                if (arrayList.size == 4) {
                    clliOF()
                    ResaL(this)
                }
            }

        }
    }

    fun clinArr() {
        arrayList = ArrayList()
    }

    fun clliOF() {
        for (i in 0 until arrayListCl.size) {
            arrayListCl.get(i).isClickable = false
        }
    }

    fun clliON() {
        for (i in 0 until arrayListCl.size) {
            arrayListCl.get(i).isClickable = true
        }
    }

    fun timeGam(tii: Int) {
        win = 0
        timeGame = tii
        point = 0
        var ff = tii * 1000
        countDownTimer = object : CountDownTimer(ff.toLong(), 1000) {
            override fun onTick(p0: Long) {
                timeGame--
                binding.textViewTime2.text = "Time: $timeGame"
            }

            override fun onFinish() {
                binding.imageViewScT.visibility = View.VISIBLE
                binding.textViewRes.visibility = View.VISIBLE
                binding.textViewRes.text = "You lost"

                aniRot(binding.cardd1, binding.ii1)
                aniRot(binding.cardd2, binding.ii2)
                aniRot(binding.cardd3, binding.ii3)
                aniRot(binding.cardd4, binding.ii4)
                aniRot(binding.cardd5, binding.ii5)
                aniRot(binding.cardd6, binding.ii6)
                aniRot(binding.cardd7, binding.ii7)
                aniRot(binding.cardd8, binding.ii8)
                aniRot(binding.cardd9, binding.ii9)
                aniRot(binding.cardd10, binding.ii10)
                aniRot(binding.cardd11, binding.ii11)
                aniRot(binding.cardd12, binding.ii12)
                Handler().postDelayed({
                    invisb()
                    binding.imageViewScT.visibility = View.INVISIBLE
                    binding.textViewRes.visibility = View.INVISIBLE

                }, 3000)

            }

        }
        countDownTimer.start()
    }

    fun viseb() {
        binding.button4.visibility = View.INVISIBLE
        binding.buttonStart.visibility = View.INVISIBLE
        binding.textViewTime.visibility = View.VISIBLE
        binding.textViewTime2.visibility = View.VISIBLE
        binding.textViewScore.visibility = View.VISIBLE
    }

    fun invisb() {
        binding.imageViewSetting.isClickable = true
        var cc = getSharedPreferences(packageName, MODE_PRIVATE).getInt("ssss", 0)
        if (cc != 0) {
            binding.button4.visibility = View.VISIBLE
        }
        binding.buttonStart.visibility = View.VISIBLE
        binding.textViewTime.visibility = View.INVISIBLE
        binding.textViewTime2.visibility = View.INVISIBLE
        binding.textViewScore.visibility = View.INVISIBLE
    }


    override fun onBackPressed() {
        try {
            countDownTimer.cancel()
        }catch (e: Exception){

        }

        startActivity(Intent(applicationContext,StartActivity::class.java))
        finishAffinity()
    }
}