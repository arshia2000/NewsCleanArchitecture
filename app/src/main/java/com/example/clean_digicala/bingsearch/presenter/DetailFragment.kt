package com.example.clean_digicala.bingsearch.presenter

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.clean_digicala.R
import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import com.example.clean_digicala.databinding.FragmentDetailBinding
import com.example.clean_digicala.databinding.FragmentListBinding
import com.squareup.picasso.Picasso


/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters


    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit  var data:ArticlesItem


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding=FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



       init()

        val typeface = resources.getFont(R.font.aleo)
        binding.detailFragmentDescription.typeface = typeface

        val typefaceTitle = resources.getFont(R.font.bebas)
        binding.detailFragmentTitle.typeface = typefaceTitle

        val typefaceDate = resources.getFont(R.font.times_new_roman)
        binding.detailFragmentDate.typeface = typefaceDate

        val typefaceAuthor = resources.getFont(R.font.times_new_roman)
        binding.detailFragmentAuthor.typeface = typefaceAuthor

        binding.fragmentDetailBtn.setOnClickListener(View.OnClickListener {


            val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(data.url)
               startActivity(intent)



        })






    }


    private fun init(){

         data= arguments?.get("Article") as ArticlesItem
        binding.detailFragmentTitle.text=data.title.toString()
        binding.detailFragmentAuthor.text=data.author.toString()
        binding.detailFragmentDate.text=data.publishedAt.toString()
        binding.detailFragmentDescription.text=data.description.toString()
        Picasso.get().load(data.urlToImage.toString()).placeholder(R.drawable.ic_launcher_foreground).into(binding.detailFragmentImg)


    }




}