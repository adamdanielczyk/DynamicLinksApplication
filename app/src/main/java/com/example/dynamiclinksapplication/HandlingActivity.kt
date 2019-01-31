package com.example.dynamiclinksapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks

class HandlingActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    Log.d("HandlingActivity", intent.toUri(Intent.URI_INTENT_SCHEME))

    FirebaseDynamicLinks.getInstance()
      .getDynamicLink(intent)
      .addOnSuccessListener(this) { pendingDynamicLinkData ->
        Log.d("HandlingActivity", pendingDynamicLinkData.link.toString())
      }
  }
}