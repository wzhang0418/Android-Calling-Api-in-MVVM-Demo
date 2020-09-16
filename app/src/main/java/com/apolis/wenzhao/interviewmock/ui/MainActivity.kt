package com.apolis.wenzhao.interviewmock.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apolis.wenzhao.interviewmock.R
import com.apolis.wenzhao.interviewmock.adapter.AdapterRecyclerView
import com.apolis.wenzhao.interviewmock.databinding.ActivityMainBinding
import com.apolis.wenzhao.interviewmock.viewmodel.EpisodeViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var episodeViewModel: EpisodeViewModel
    private lateinit var binding: ActivityMainBinding
    private val mAdapter: AdapterRecyclerView = AdapterRecyclerView(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        episodeViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(EpisodeViewModel::class.java)
        binding.viewModel = episodeViewModel

        //Add divider line for each item
        recycler_view_episode.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))

        initList()
        observerData()
    }

    override fun onStart() {
        super.onStart()
        episodeViewModel.getEpisodeData()
    }

    private fun observerData() {
        episodeViewModel.getEpisodeObserver().observe(this, Observer {
            if (it != null) {
                mAdapter.setData(it)
                Log.d("MYTAG", it.toString())
            }else{
                Log.d("MYTAG", "cannot observe")
            }
        })
    }

    private fun initList() {
        binding.recyclerViewEpisode.apply {
            adapter = mAdapter
        }
    }

}