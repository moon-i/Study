package com.moon.mvcmvpmvvm.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.moon.mvcmvpmvvm.R

/**
 *  Controller 역할을 수행
 * */
class MVCActivity : AppCompatActivity() {
    // view 선언
    val eventButton: AppCompatButton by lazy {
        findViewById(R.id.eventButton)
    }

    val textView: TextView by lazy {
        findViewById(R.id.textView)
    }
    // model 생성
    val model = DataModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvcactivity)

        // 1. 사용자 action이 controller로 들어
        eventButton.setOnClickListener {
            // 2. Controller는 action에 맞는 데이터 처리를 model에 요청 및 갱신
            // 3. Controller는 model을 통새 View를 갱신
            textView.text = model.getData()
        }
    }
}