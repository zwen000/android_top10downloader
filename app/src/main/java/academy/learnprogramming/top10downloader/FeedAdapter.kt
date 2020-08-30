package academy.learnprogramming.top10downloader

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ViewHolder(v: View) {
    val tvName: TextView = v.findViewById(R.id.tvName)
    val tvArtist: TextView = v.findViewById(R.id.tvArtist)
    val tvSummary: TextView = v.findViewById(R.id.tvSummary)
}

class FeedAdapter(context: Context, private val resource: Int, private val applications: List<FeedEntry>): ArrayAdapter<FeedEntry>(context, resource, applications) {
//    private val TAG = "FeedAdapter"
    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        Log.d(TAG, "getView() called")
        val view:View
        val viewHolder:ViewHolder

        if (convertView == null) {
//            Log.d(TAG, "getView() called with null convertedView")
            view = inflater.inflate(resource, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
//            Log.d(TAG, "getView provided a convertedView")
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val currentApp = applications[position]
        viewHolder.tvName.text = currentApp.name
        viewHolder.tvArtist.text = currentApp.artist
        viewHolder.tvSummary.text = currentApp.summary
        return view

    }

    override fun getCount(): Int {
//        Log.d(TAG, "getCount() called")
        return applications.size
    }

}