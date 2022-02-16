package com.moon.mvcmvpmvvm.mvp

class MVPPresenterImpl(val view: MVPPresenter.MVPView) : MVPPresenter {
    val model: DataModel = DataModel()

    // 3. Presenter는 model에 데이터를 요청 하여 응답받고 View에 데이터 응답
    override fun getData() {
        view.setDataInTextView(model.getData())
    }
}