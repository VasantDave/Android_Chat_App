package com.example.android_chat_app

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.NavController

class profile_fragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var logoutButton: Button
    lateinit var profileImage: ImageView
    lateinit var profileChangeButton: ImageView
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val layout = inflater.inflate(R.layout.fragment_profile_fragment, container, false)
        logoutButton = layout.findViewById(R.id.logoutButton)
        profileImage = layout.findViewById(R.id.profileImage)
        profileChangeButton = layout.findViewById(R.id.profileChangeButton)
        logoutButton.setOnClickListener {
            var intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
        }
        profileChangeButton.setOnClickListener {
            //Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
            val builder = AlertDialog.Builder(context)
            builder.setTitle("Profile Photo")
            builder.setPositiveButton("Gallary") { _, _ ->
                Toast.makeText(context, "Gallary", Toast.LENGTH_SHORT).show()
                val intent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
                changeImage.launch(intent)
            }
            builder.setNegativeButton("Camera") { _, _ ->
                Toast.makeText(context, "Camera", Toast.LENGTH_SHORT).show()
                takePictureUsingCamera()
            }
            builder.show()
        }
        return layout
    }

    val changeImage = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val imageUri = it.data?.data
            profileImage.setImageURI(imageUri)
        }
    }

    private fun takePictureUsingCamera() {
        val takePicture = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(takePicture, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val imageBitmap = data?.extras?.get("data") as Bitmap
            profileImage.setImageBitmap(imageBitmap)
        }
    }
}