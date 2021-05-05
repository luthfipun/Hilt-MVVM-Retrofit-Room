package github.luthfipun.hiltmvi.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import github.luthfipun.hiltmvi.databinding.ItemViewBinding
import github.luthfipun.hiltmvi.domain.model.User
import github.luthfipun.hiltmvi.domain.util.loadImage

class MainAdapter: RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var lists = mutableListOf<User>()

    fun addData(items: List<User>){
        lists.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lists[position])
    }

    override fun getItemCount() = lists.size

    class ViewHolder(
        private val itemViewBinding: ItemViewBinding
    ): RecyclerView.ViewHolder(itemViewBinding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            itemViewBinding.apply {
                fullName.text = "${user.firstName} ${user.lastName}"
                email.text = user.email
                avatar.loadImage(user.avatar)
            }
        }
    }
}