package com.creativemobile.nnr

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import com.creativemobile.nnr.databinding.ActivityWebBinding
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import io.michaelrocks.paranoid.Obfuscate
import java.io.File
import java.io.IOException
import java.util.*

class WebActivity : AppCompatActivity() {
    lateinit var binding: ActivityWebBinding
    var collback: ValueCallback<Array<Uri>>? = null
    var filePath: String? = null


    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this, decod("Nqcfkpi...",2), Toast.LENGTH_LONG).show()
        CookieManager.getInstance().setAcceptCookie(true)
        CookieManager.getInstance().setAcceptThirdPartyCookies(binding.web, true)
        binding.web.loadUrl(
            if (Save(this).saveStr == ""){
                intent.extras?.get(decod("wtn", 2)).toString()
            }else{
                Save(this).saveStr
            }
            )
        binding.web.apply {
            isSaveEnabled = true
            isFocusable = true
            isFocusableInTouchMode = true
            webChromeClient = @Obfuscate object : WebChromeClient() {

                override fun onShowFileChooser(
                    webView: WebView?,
                    filePathCallback: ValueCallback<Array<Uri>>?,
                    fileChooserParams: FileChooserParams?
                ): Boolean {

                    Dexter.withContext(this@WebActivity).withPermission(
                        Manifest.permission.CAMERA
                    )
                        .withListener(object : PermissionListener {
                            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {

                                processIntent(filePathCallback, cameraGranted = true)
                            }

                            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {

                                processIntent(filePathCallback, cameraGranted = false)
                            }

                            override fun onPermissionRationaleShouldBeShown(
                                permissionRequest: PermissionRequest?,
                                permissionToken: PermissionToken?
                            ) {

                                permissionToken?.continuePermissionRequest()
                            }
                        }).check()




                    return true

                }

            }
            webViewClient = @Obfuscate object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    if (Save(context).saveStr == "") {

                        Save(context).saveStr = url.toString()
                    } else {
                        Log.d("tec","yyr")
                    }
                }

                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    val url = request?.url?.toString()
                    if (url?.startsWith(decod("jvvru://v.og/lqkpejcv", 2)) == true) {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                    }
                    return if (request?.url == null || url?.startsWith(
                            decod(
                                "jvvr://",
                                2
                            )
                        ) == true || url?.startsWith(
                            decod("jvvru://", 2)
                        ) == true
                    )
                        false
                    else
                        try {
                            if (url?.startsWith(decod("ocknvq", 2)) == true) {
                                startActivity(
                                    Intent.createChooser(
                                        Intent(Intent.ACTION_SEND).apply {
                                            type = decod("rnckp/vgzv", 2)
                                            putExtra(
                                                Intent.EXTRA_EMAIL,
                                                url.replace(decod("ocknvq:", 2), "")
                                            )
                                        },
                                        decod("Ockn", 2)
                                    )
                                )
                            } else if (url?.startsWith(decod("vgn:", 2)) == true) {
                                startActivity(Intent.createChooser(Intent(Intent.ACTION_DIAL).apply {
                                    data = Uri.parse(url)
                                }, decod("Ecnn", 2)))
                            }
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                            view!!.context.startActivity(intent)
                            true
                        } catch (e: java.lang.Exception) {
                            true
                        }
                }
            }

        }

        binding.web.settings.apply {
            setRenderPriority(WebSettings.RenderPriority.HIGH)
            savePassword = true
            saveFormData = true
            mixedContentMode = 0
            javaScriptEnabled = true
            setAppCacheEnabled(true)
            domStorageEnabled = true
            allowUniversalAccessFromFileURLs = true
            allowFileAccessFromFileURLs = true
            loadsImagesAutomatically = true
            databaseEnabled = true
            useWideViewPort = true
            allowFileAccess = true
            pluginState = WebSettings.PluginState.ON
            javaScriptCanOpenWindowsAutomatically = true
            loadWithOverviewMode = true
            allowContentAccess = true
            setSupportMultipleWindows(false)
            builtInZoomControls = true
            displayZoomControls = false
            cacheMode = WebSettings.LOAD_DEFAULT
            userAgentString = userAgentString.replace(decod("; yx",2), "")
        }

    }

    private var doubleBackToExitPressedOnce = false
    override fun onBackPressed() {
        if (binding.web.canGoBack()) {
            if (doubleBackToExitPressedOnce) {
                binding.web.stopLoading()
                val link = if (Save(this).saveStr == "") {
                    intent.extras?.get(decod("wtn", 2)).toString()
                }else{
                    Save(this).saveStr
                }
                binding.web.loadUrl(link)

            }
            this.doubleBackToExitPressedOnce = true
            binding.web.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                doubleBackToExitPressedOnce = false
            }, 2000)
        }

    }

    private fun createFileForPhoto(): File {
        val format =
            SimpleDateFormat(decod("aaaaOOff_JJoouu", 2), Locale.getDefault()).format(Date())
        val dirFile = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("TMP_N_${format}_JoeJolfd", ".jpg", dirFile)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        var results: Array<Uri>? = null
        if (resultCode == RESULT_OK) {
            if (requestCode == 1) {
                if (null == collback) {
                    return
                }
                if (data == null || data.data == null) {
                    if (filePath != null) {
                        results = arrayOf(Uri.parse(filePath))
                    }
                } else {
                    val dataString = data.dataString
                    if (dataString != null) {
                        results = arrayOf(Uri.parse(dataString))
                    }
                }
            }
        }
        collback?.onReceiveValue(results)
        collback = null

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        try {
            binding.web.restoreState(savedInstanceState)
        }catch (e:Exception){}

    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        try {
            binding.web.restoreState(outState)
        }catch (e:Exception){}

    }


    private fun processIntent(
        filePathCallback: ValueCallback<Array<Uri>>?,
        cameraGranted: Boolean
    ) {
        collback = filePathCallback
        var takePictureIntent: Intent? = null

        if (cameraGranted) {
            takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            var photoFile: File? = null
            try {
                photoFile = createFileForPhoto()
                takePictureIntent.putExtra(decod("RjqvqRcvj", 2), filePath)
            } catch (e: IOException) {

            }


            if (photoFile != null) {
                filePath = decod("hkng:", 2) + photoFile.absolutePath
                val uri = FileProvider.getUriForFile(
                    this@WebActivity,
                    application.packageName + decod(".rtqxkfgt", 2),
                    photoFile
                )

                takePictureIntent.apply {
                    putExtra(MediaStore.EXTRA_OUTPUT, uri)
                    addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                }
            } else {
                takePictureIntent = null
            }

        }

        val intentArray: Array<Intent?> =
            takePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)


        val contentSelectionIntent = Intent(Intent.ACTION_GET_CONTENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = decod("kocig/*",2)
        }

        Intent(Intent.ACTION_CHOOSER).run {
            putExtra(Intent.EXTRA_INTENT, contentSelectionIntent)
            putExtra(Intent.EXTRA_TITLE, decod("Kocig Ejqqugt", 2))
            putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray)
            startActivityForResult(this, 1)

        }
    }
}

