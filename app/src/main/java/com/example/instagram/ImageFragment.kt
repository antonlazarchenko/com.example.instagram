package com.example.instagram

import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instagram.databinding.FragmentImageBinding
import java.io.InputStream


private const val ARG_IMAGE = "image"

class ImageFragment : Fragment() {

    private var _binding: FragmentImageBinding ? = null
    private val binding get() = _binding!!

    private lateinit var image: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            image = it.getString(ARG_IMAGE).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentImageBinding.inflate(inflater, container, false)

//        val decodedByte = Base64.decode(image, Base64.DEFAULT)
//        val bitmap = BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.size)
//        binding.postImage.setImageBitmap(bitmap)

        val inputStream: InputStream = context?.resources?.assets?.open(image) ?: return null
        val drawable: Drawable = BitmapDrawable(context?.resources, inputStream)
        binding.postImage.setImageDrawable(drawable)

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(image: String) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_IMAGE, image)
                }
            }
    }
}