

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.clean_digicala.R
import com.example.clean_digicala.bingsearch.data.entity.ArticlesItem
import com.example.clean_digicala.bingsearch.presenter.adapter.viewholder.NewsViewHolder


class NewsAdapter(private val data:List<ArticlesItem>,private var context:Context):RecyclerView.Adapter<NewsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.custom_news_recycler, parent, false)

        return NewsViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {

        holder.txt_title?.text  = data[position].title
        holder.txt_publish?.text=data[position].author

        holder.layout?.setOnClickListener(View.OnClickListener {

            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(data[position].url)
            context.startActivity(intent)

        })

    }

    override fun getItemCount(): Int {

        return data.size
    }


}