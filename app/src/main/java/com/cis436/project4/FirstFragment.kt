package com.cis436.project4

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import coil.load
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.cis436.project4.databinding.FragmentFirstBinding
import org.json.JSONObject
import kotlin.random.Random

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        val quoteObserver = Observer<JSONObject> {
            result -> if (result.length() != 0) {
                binding.tvQuote.text = result.get("q").toString()
                binding.tvAuthor.text = result.get("a").toString()
            }
        }
        viewModel.getQuote().observe(viewLifecycleOwner, quoteObserver)

        binding.btGetQuote.setOnClickListener {
            getQuote()

            val id = Random.nextInt(1, 601)
            binding.imageView.load("https://picsum.photos/id/${id}/600")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getQuote() {
        val url = "https://zenquotes.io/api/" + viewModel.getMode()
        val queue = Volley.newRequestQueue(this.context)

        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            { response ->
                Log.i("Get Quote", response.toString())
                viewModel.setQuote(response.toString())
            },
            {
                Log.i("Get Quote", "That did not work!")
            }
        )

        queue.add(stringRequest)
    }
}