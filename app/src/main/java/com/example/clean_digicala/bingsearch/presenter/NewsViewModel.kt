package com.example.clean_digicala.bingsearch.presenter

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clean_digicala.bingsearch.data.entity.BingNewsEntity
import com.example.clean_digicala.bingsearch.domain.model.NewsModel
import com.example.clean_digicala.bingsearch.domain.usecase.GetNewsList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel( private var getNewsList: GetNewsList):ViewModel() {


    var data= MutableLiveData<List<ArticlesItem>>()


    fun getNews(){

       viewModelScope.launch(Dispatchers.IO) {


           val array= getNewsList.getNews().articles as List<ArticlesItem>
          data.postValue(array)


       }

    }

}
