package com.moon.mvcmvpmvvm.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.moon.mvcmvpmvvm.databinding.ActivityMvvmactivityBinding

class MVVMActivity : AppCompatActivity() {
    lateinit var binding: ActivityMvvmactivityBinding
    val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 4. View는 ViewModel을 구독해서 자신을 변경
        // 이렇게 observe setting해줄수도 있고, xml에서 dataBinding 을 사용할 수 도 있다.
        // setObserver()

        // 4. View를 DataBinding을 이용해서 자신을 유연하게 변
        // dataBinding 사용
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // 1. 사용자 action이 view를 통해 들어온다.
        binding.eventButton.setOnClickListener {
            // 2. View는 action에 맞는 data를 ViewModel에 요청
            viewModel.getData()
        }
    }

    private fun setObserver() {
        viewModel.textData.observe(this) { data ->
            binding.textView.text = data
        }
    }
}