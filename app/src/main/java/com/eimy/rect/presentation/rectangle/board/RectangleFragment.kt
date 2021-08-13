package com.eimy.rect.presentation.rectangle.board

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.eimy.rect.databinding.FragmentRectangleBoardBinding
import com.eimy.rect.domain.model.BOARD_SIZE
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
class RectangleFragment : Fragment(), OnClickListener {

    private val viewModel: RectangleBoardViewModel by viewModels()
    private lateinit var adapter: BoardGridAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRectangleBoardBinding.inflate(
            inflater,
        )

        binding.viewModel = viewModel
        adapter = BoardGridAdapter(this)
        binding.rvBoardGrid.layoutManager = GridLayoutManager(requireContext(), BOARD_SIZE)
        binding.rvBoardGrid.adapter = adapter
        binding.rvBoardGrid.animation = null
        binding.lifecycleOwner = this
        return binding.root
    }

    // Temporary fix data binding was not updating list
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.rectangleUI.observe(viewLifecycleOwner) {
            adapter.notifyDataSetChanged()
        }
    }

    @InternalCoroutinesApi
    override fun onClick(position: Int) {
        viewModel.updateRectangle(position)
    }
}