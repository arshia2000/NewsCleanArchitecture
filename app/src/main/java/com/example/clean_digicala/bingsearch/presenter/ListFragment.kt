package com.example.clean_digicala.bingsearch.presenter

import NewsAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.clean_digicala.R
import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import com.example.clean_digicala.bingsearch.domain.model.NewsModel
import com.example.clean_digicala.databinding.FragmentListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NewsViewModel by viewModel()
    private lateinit  var adapter:NewsAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


       _binding=FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

     init()

        val observer= Observer<List<ArticlesItem>>{ data->

            this.adapter=NewsAdapter(data,view.context)
             binding.newsActivityList.adapter =this.adapter

        }

        viewModel.data.observe(viewLifecycleOwner,observer)



        binding.newsFragmentEtSearch.doOnTextChanged { text, start, before, count ->

            viewModel.getNews(text.toString())

        }











    }


    private fun init(){

         binding.newsActivityList.setLayoutManager(LinearLayoutManager(context));


    }



}