package com.example.instagram

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.instagram.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCamera.setOnClickListener(this)
        binding.btnDirect.setOnClickListener(this)
        binding.btnHome.setOnClickListener(this)
        binding.btnSearch.setOnClickListener(this)
        binding.btnAddPost.setOnClickListener(this)
        binding.btnLike.setOnClickListener(this)
        binding.btnProfile.setOnClickListener(this)

        supportFragmentManager
            .beginTransaction()
            .add(binding.frameLayout.id, PostFragment.newInstance(), "PostFragment")
            .commit()

    }

    override fun onClick(v: View) {
        when (v.id) {
            binding.btnHome.id -> {
                toast("home")
            }
            binding.btnSearch.id -> {
                toast("search")
            }
            binding.btnAddPost.id -> {
                toast("add post")
            }
            binding.btnLike.id -> {
                toast("likes")
            }
            binding.btnProfile.id -> {
                toast("profile")
            }
        }
    }

    private fun toast(message: CharSequence) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

}