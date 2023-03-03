package com.techmania.chatappuidesign

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.Toolbar
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager2
    lateinit var mToolbar: Toolbar

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabLayout)
        viewPager = findViewById(R.id.viewPager)
        mToolbar = findViewById(R.id.main_page_toolbar)

        setSupportActionBar(mToolbar)
        supportActionBar!!.title = "Chat App UI"

        val adapter = ChatViewPagerAdapter(supportFragmentManager,lifecycle)

        viewPager.adapter = adapter

        val tabLayoutMediator = TabLayoutMediator(tabLayout,viewPager
            ,true,true, TabLayoutMediator.TabConfigurationStrategy { tab, position ->

                //viewPager.setCurrentItem(1,false)

                if(position == 3){

                   // val tabIcon : ImageView = ImageView(this)
                    //tab.customView = tabIcon
                    //tabIcon.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
                    //tabIcon.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                    //tabIcon.setBackgroundResource(R.drawable.ic_baseline_photo_camera_24)

                }else {

                    val tabText : TextView = TextView(this)
                    tab.customView = tabText
                    tabText.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT
                    tabText.layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                    tabText.setTextColor(resources.getColor(R.color.myGray,theme))
                    tabText.setTypeface(null,Typeface.BOLD)
                    tabText.textSize = 16F
                    tabText.isAllCaps = true

                    if (position == 0){
                        tabText.text = "Chats"
                        tabText.setTextColor(Color.WHITE)
                        tabText.setTypeface(null,Typeface.BOLD)
                    }else if (position == 1){
                        tabText.text = "Status"
                    }else if (position == 2){
                        tabText.text = "Calls"
                    }
                }

                /*
                when(position){

                    0 -> tab.text = "Requests"
                    1 -> tab.text = "Chat"
                    2 -> tab.text = "Friends"
                }*/

            })
        tabLayoutMediator.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val tabText : TextView = tab!!.customView as TextView
                tabText.setTextColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val tabText : TextView = tab!!.customView as TextView
                tabText.setTextColor(resources.getColor(R.color.myGray,theme))
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                TODO("Not yet implemented")
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu,menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return super.onOptionsItemSelected(item)
    }
}