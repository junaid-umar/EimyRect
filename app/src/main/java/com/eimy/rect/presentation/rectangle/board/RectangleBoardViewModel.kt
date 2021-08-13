package com.eimy.rect.presentation.rectangle.board

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eimy.rect.domain.model.BOARD_SIZE
import com.eimy.rect.domain.usecase.SearchLargestRectangle
import com.eimy.rect.presentation.model.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RectangleBoardViewModel
@Inject constructor(
    private val searchLargestRectangle: SearchLargestRectangle,
    private val rectangleUIMapper: RectangleUIMapper
) : ViewModel() {

    private val _rectangles: MutableLiveData<RectangleUI> = MutableLiveData()

    private var rectangleList = RectangleUI(
        MutableList(BOARD_SIZE * BOARD_SIZE) { index ->
            RectangleType.NOT_SELECTED
        }, 0
    )


    init {
        _rectangles.value = rectangleList
    }


    @InternalCoroutinesApi
    fun updateRectangle(position: Int) {

        rectangleList.rectangleList.run {
            this.set(position, this[position].changeRectangleType())
        }

        _rectangles.value = rectangleList

        viewModelScope.launch(Dispatchers.Default) {
            searchLargestRectangle.execute(
                rectangleList.rectangleList.toDomainList()
            ).collect {
                withContext(Dispatchers.Main) {
                    rectangleList = rectangleUIMapper.mapFromDomainModel(it)

                    _rectangles.value = rectangleList
                }
            }
        }
    }

    val rectangleUI: LiveData<RectangleUI>
        get() = _rectangles
}