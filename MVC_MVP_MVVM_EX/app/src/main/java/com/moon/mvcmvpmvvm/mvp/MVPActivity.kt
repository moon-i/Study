package com.moon.mvcmvpmvvm.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.moon.mvcmvpmvvm.R

// View역할
class MVPActivity : AppCompatActivity(), MVPPresenter.MVPView {
    val eventButton: AppCompatButton by lazy {
        findViewById(R.id.eventButton)
    }

    val textView: TextView by lazy {
        findViewById(R.id.textView)
    }

    val mvpPresenter: MVPPresenter = MVPPresenterImpl(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvpactivity)

        // 1. 사용자 action이 View를 통해 들어온다
        eventButton.setOnClickListener {
            // 2. View는 action에 맞는 데이터를 presenter에 요청
            mvpPresenter.getData()
        }
    }

    // 4. View는 전달받는 데이터로 ui를 갱신
    // MVPView interface 구현
    override fun setDataInTextView(data: String) {
        textView.text = data
    }
}