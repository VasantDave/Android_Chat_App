import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_chat_app.R
import com.example.android_chat_app.chat_message_view

class ChatDataAdapter(var chatData: List<ChatUserData>) :
    RecyclerView.Adapter<ChatDataAdapter.MyViewHolder>() {
    lateinit var view: View

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.chatProfileImage)
        var title: TextView = itemView.findViewById(R.id.chatProfileTitle)
        var subTitle: TextView = itemView.findViewById(R.id.chatProfileSubTitle)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        view = LayoutInflater.from(parent.context).inflate(R.layout.chat_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //var imageId : Int = Integer.parseInt(holder.image.setImageResource(chatData[position].image).toString())
        holder.image.setImageResource(chatData[position].image)
        holder.title.text = chatData[position].title
        holder.subTitle.text = chatData[position].subTitle
        holder.itemView.setOnClickListener {
            //Toast.makeText(view.context, chatData[position].title, Toast.LENGTH_SHORT).show()
            var intent = Intent(view.context, chat_message_view::class.java)
//            intent.putExtra(
//                "Profile", Integer.parseInt(
//                    holder.image.setImageResource(chatData[position].image)
//                        .toString()
//                )
//            )
            intent.putExtra("Title", holder.title.text)
            intent.putExtra("Sub Title", holder.subTitle.text)
            //intent.putExtra("Profile",imageId)
            view.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return chatData.size
    }

}