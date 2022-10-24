package co.com.nubank.mobile.challenge.ui.landing.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import co.com.nubank.mobile.challenge.databinding.LinkItemBinding
import co.com.nubank.mobile.challenge.infrastructure.core.aplication.entities.Link

/***
 * Adapter para el Recycler View
 */
internal class RecentlyLinksAdapter(private val listener: BtnViewLinkItemListener) :
    RecyclerView.Adapter<LinkViewHolder>() {

    /***
     * Declaracion del Listener por medio de la interfaz
     */
    internal interface BtnViewLinkItemListener {
        fun onLinkView(item: Link)
    }

    private val items = ArrayList<Link>()

    fun setItems(items: ArrayList<Link>) {
        this.items.clear()
        this.items.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LinkViewHolder {
        val binding: LinkItemBinding =
            LinkItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LinkViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: LinkViewHolder, position: Int) =
        holder.bindLink(items[position])

    override fun getItemCount(): Int = items.size
}

internal class LinkViewHolder(
    private val itemBinding: LinkItemBinding,
    private val listener: RecentlyLinksAdapter.BtnViewLinkItemListener
) : RecyclerView.ViewHolder(itemBinding.root as View), View.OnClickListener {

    private lateinit var link: Link

    init {
        itemBinding.root.setOnClickListener(this)
    }

    internal fun bindLink(item: Link) {
        this.link = item
        itemBinding.alias.text = item.getAlias()
        itemBinding.link.text = item.getSelfLink()
    }

    override fun onClick(p0: View?) {
        listener.onLinkView(link)
    }
}