package co.com.nubank.mobile.challenge.ui.landing.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import co.com.nubank.mobile.challenge.R
import co.com.nubank.mobile.challenge.databinding.ActivityLandingBinding
import co.com.nubank.mobile.challenge.infrastructure.core.aplication.entities.Link
import co.com.nubank.mobile.challenge.ui.landing.adapters.RecentlyLinksAdapter
import co.com.nubank.mobile.challenge.ui.landing.extensions.containThisLink
import co.com.nubank.mobile.challenge.ui.landing.extensions.isValidUrl
import co.com.nubank.mobile.challenge.ui.landing.viewmodel.ShortLinkViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LandingActivity : DaggerAppCompatActivity(), RecentlyLinksAdapter.BtnViewLinkItemListener,
    ShortLinkViewModel.ErrorView {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<ShortLinkViewModel> { viewModelFactory }

    private lateinit var binding: ActivityLandingBinding

    private lateinit var adapter: RecentlyLinksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_landing)

        setContentView(binding.root)

        binding.apply {
            viewmodel = viewModel
            lifecycleOwner = this@LandingActivity
        }

        setupUi()

        setupRecyclerView()

        setupObserveViewData()
    }

    private fun setupUi() {
        binding.sendButton.setOnClickListener {
            showError(false)

            binding.urlInputField.error = ""

            sendUrlToShort()
        }
    }

    private fun sendUrlToShort() {
        val link = binding.urlEditTextField.text.toString()

        if (link.isValidUrl()) {
            if (viewModel.recentlyItems.value.containThisLink(link)) {
                binding.urlInputField.error = getString(R.string.link_already_exist)
            } else {
                viewModel.postShortLink(link, this)
            }
        } else {
            binding.urlInputField.error = getString(R.string.link_invalid)
        }
    }

    private fun setupRecyclerView() {
        adapter = RecentlyLinksAdapter(this)
        binding.recentlyLinksRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.recentlyLinksRecyclerView.adapter = adapter
    }

    private fun setupObserveViewData() {

        viewModel.recentlyItems.observe(this) {
            binding.urlEditTextField.setText("")
            adapter.setItems(ArrayList(it))
        }

        viewModel.dataLoading.observe(this) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
            binding.recentlyLinksRecyclerView.visibility = if (it) View.GONE else View.VISIBLE
        }
    }

    override fun onLinkView(link: Link) {
        Toast.makeText(
            this,
            getString(R.string.link_shorted, link.getShortLink()),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun showError(showErrorScreen: Boolean, errorMessage: String?) {
        if (showErrorScreen) {
            binding.recentlyLinksRecyclerView.visibility = View.GONE
            binding.errorView.root.visibility = View.VISIBLE
            binding.errorView.errorViewText.text = errorMessage
        } else {
            binding.errorView.root.visibility = View.GONE
        }
    }
}