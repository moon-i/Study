package com.moon.mvcmvpmvvm.mvp

interface MVPPresenter {
    fun getData()
    interface MVPView {
        fun setDataInTextView(data: String)
    }
}