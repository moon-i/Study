package com.moon.mvcmvpmvvm.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel: ViewModel() {
    private val dataModel = DataModel()

    private var _textData = MutableLiveData<String>("Loading...")
    val textData: LiveData<String> = _textData

    // 3. ViewModel은 Model에 데이터를 요청 하고 observable field로 매핑하여 외부로 노출
    fun getData() {
        _textData.value = dataModel.getData()
    }
}