package com.techmania.chatappuidesign

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ChatViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3;
    }

    override fun createFragment(position: Int): Fragment {
        var fragment = Fragment()

        when(position){
            //0 -> fragment = CameraFragment.newInstance()
            0 -> fragment = RequestsFragment.newInstance()
            1 -> fragment = ChatFragment.newInstance()
            2 -> fragment = FriendsFragment.newInstance()
        }

        return fragment
    }
}