package com.example.germanapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
   private lateinit var call_btn:Button
   private lateinit var sms_btn:Button
   private lateinit var web_btn:Button
   private lateinit var takephoto:Button
   private lateinit var email_btn:Button
   private lateinit var mpesa_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         call_btn = findViewById(R.id.callbtn)
        sms_btn = findViewById(R.id.smsbtn)

        takephoto = findViewById(R.id.btnphoto)
        email_btn = findViewById(R.id.emailbtn)
        mpesa_btn = findViewById(R.id.mpesabtn)


        call_btn.setOnClickListener {
         var phone = "+254798641332"
            var intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone,null))
            startActivity(intent)
            Toast.makeText(this, "Qaribu kwa calls",Toast.LENGTH_LONG).show()
        }
        sms_btn.setOnClickListener{
            val uri = Uri.parse("smsto:074590887")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("Hello", "How is today's weather")

            startActivity(intent)
            Toast.makeText(this,"Sending SMS" , Toast.LENGTH_LONG).show()
        }
        takephoto.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureIntent, 1)
            
        }
        email_btn.setOnClickListener {
            Toast.makeText(this,"EMAIL SENT",Toast.LENGTH_SHORT).show()

            val  emailIntent = Intent(
                    Intent.ACTION_SENDTO,
            Uri.fromParts("mailto", "abc@gmail.com", null)
            )

            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject")

            emailIntent.putExtra(Intent.EXTRA_TEXT, "Body")

            startActivity(
                Intent.createChooser
                    (emailIntent, "Send email...")
            )
        }
        mpesa_btn.setOnClickListener {
            val simToolKitLaunchIntent =
                applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitLaunchIntent?.let { startActivity(it) }
        }
} }