

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.clean_digicala.R
import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import com.example.clean_digicala.bingsearch.presenter.ListFragmentDirections
import com.example.clean_digicala.bingsearch.presenter.adapter.viewholder.NewsViewHolder


class NewsAdapter(private val data:List<ArticlesItem>,private var context:Context,private var view:View):RecyclerView.Adapter<NewsViewHolder>() {


    lateinit var navController: NavController

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_news_recycler, parent, false)

        return NewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {



            holder.txt_title?.text = data[position].title
            holder.txt_publish?.text = data[position].author

            holder.layout?.setOnClickListener(View.OnClickListener {

//                val intent = Intent(Intent.ACTION_VIEW)
//                intent.data = Uri.parse(data[position].url)
//                context.startActivity(intent)


//                navController = Navigation.findNavController(view)
//                var bundle=Bundle()
//                bundle.putParcelable("data",data[position])
//
//                navController!!.navigate(
//                    R.id.action_listFragment2_to_detailFragment,bundle)

                view.findNavController().navigate(ListFragmentDirections.actionListFragment2ToDetailFragment(data[position]))

             //   Navigation.createNavigateOnClickListener(R.id.action_listFragment2_to_detailFragment,bundle)


            })




    }

    override fun getItemCount(): Int {

        return data.size
    }


}