package com.example.instagram

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.instagram.databinding.FragmentPostBinding
import com.google.gson.Gson
import java.io.InputStream

class PostFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentPostBinding? = null
    private val binding get() = _binding!!

    private lateinit var pagerAdapter: ViewPagerAdapter
    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPostBinding.inflate(inflater, container, false)

        binding.bookmark.setOnClickListener(this)
        binding.comment.setOnClickListener(this)
        binding.imageLike.setOnClickListener(this)
        binding.profilePhoto.setOnClickListener(this)
        binding.menu.setOnClickListener(this)

        viewPager = binding.viewPager;


        pagerAdapter = ViewPagerAdapter(childFragmentManager)

        val map = context?.let { FakeNetworkModel().getFakeData(it) }

        map?.forEach {
            pagerAdapter.addFragment(ImageFragment.newInstance(it.value), it.value)
        }
        viewPager.adapter = pagerAdapter

        return binding.root
    }

    override fun onClick(v: View) {
        when (v.id) {
            binding.bookmark.id -> {
                toast("bookmark")
            }
            binding.comment.id -> {
                toast("comment")
            }
            binding.imageLike.id -> {
                toast("imageLike")
            }
            binding.profilePhoto.id -> {
                toast("profilePhoto")
            }
            binding.menu.id -> {
                toast("menu")
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            PostFragment().apply {
                arguments = Bundle().apply {}
            }
    }


    private fun toast(message: CharSequence) {
        val toast = Toast.makeText(context, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }
}