package com.arjupta.arsenicdetector

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arjupta.arsenicdetector.databinding.ActivityResultAnalysisBinding

class ResultAnalysisActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityResultAnalysisBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityResultAnalysisBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        // TODO("Send the image to backend for image processing that is later on used to generate results")
    }
}