package com.kuderitest.mycontactmanangement

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_phone_num.*

class EditPhoneNumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)
        // 메인에서 전달된 번호 EditText에 표시
        val myNumber = intent.getStringExtra("myPhoneNum")
        // editText에는 setText 활용
        editNumber.setText(myNumber)
        //연락처 변경 버튼 클릭시
        editOkBtn.setOnClickListener {
            // 변경된 번호 저장
            val newEditNumber = editNumber.text.toString()
//            입력한 번호를 가지고 메인으로 복귀
//            입력한 번호를 담아주는 용도로 사용할 Intent
            val resultIntent = Intent()
            resultIntent.putExtra("newEditPhoneNum", newEditNumber)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}