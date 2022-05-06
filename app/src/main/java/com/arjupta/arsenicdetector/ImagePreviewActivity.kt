package com.arjupta.arsenicdetector

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arjupta.arsenicdetector.databinding.ActivityImagePreviewBinding
import java.io.File


class ImagePreviewActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityImagePreviewBinding

    companion object {
        const val ImageName = "image_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityImagePreviewBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        // Set up listeners
        viewBinding.sendButton.setOnClickListener { sendForAnalysis() }

        // Show Image preview
        val imageName = intent.getStringExtra(ImageName)!!
        showImagePreview(imageName)
    }

    private fun showImagePreview(imageName: String) {
        val path = "${getExternalFilesDir(Environment.DIRECTORY_PICTURES)}/$imageName"
        val imgFile = File(path)
        if (imgFile.exists()) {
            val myBitmap = BitmapFactory.decodeFile(imgFile.absolutePath)
            viewBinding.imagePreview.setImageBitmap(myBitmap)
        } else {
            Toast.makeText(this, "Image not found", Toast.LENGTH_SHORT).show()
        }
    }

    private fun sendForAnalysis() {
        val intent = Intent(this, ResultAnalysisActivity::class.java)
        startActivity(intent)
        finish()
    }
}