package com.techmania.chatappuidesign

import android.app.Activity.RESULT_OK
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment

class CameraFragment : Fragment() {

    companion object{
        fun newInstance() : CameraFragment{
            return CameraFragment()
        }
    }

    lateinit var imageView : ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val view : View = inflater.inflate(R.layout.camera,container,false)

        imageView = view.findViewById(R.id.imageView);

        val myTakePhoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        try {
            startActivityForResult(myTakePhoto,1)
        }catch (e : ActivityNotFoundException){
            Toast.makeText(activity,"Error: ${e.toString()}",Toast.LENGTH_LONG).show()
        }

        return view;
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            imageView.setImageBitmap(imageBitmap)
        }
    }

}