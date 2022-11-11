/*
연락처를 보여주고 / 변경하는 각각의 화면을 만들어주세요.
지난 챕터의 닉네임 변경과 비슷한 구조로 만들어주시면 됩니다.
그리고 아래의 기능을 구현해보세요.

1. 연락처 변경 버튼을 누르면 => 변경용 화면에서 데이터를 입력받고, 확인을 누르면 메인화면으로 돌아와서 반영해주세요.
2. 연락처 변경 버튼을 눌렀을때, 기존에 적혀있는 연락처가 -> 변경 화면의 EditText에서 미리 적혀있게 해주세요.
※ hint : TextView의 text값도 변수에 담아서 사용할 수 있습니다.
3. 전화연결 버튼을 누르면, DIAL 액션을 실행하도록 해주세요.*/
package com.kuderitest.mycontactmanangement

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQUEST_FOR_PHONENUM = 1004
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//       연락처 변경 버튼 클릭
        editPhoneNumBtn.setOnClickListener {
            //기존 번호 저장
            val myPhoneNumber = myPhoneNum.text.toString()
            //Intent 활용
            val myIntent = Intent(this,EditPhoneNumActivity::class.java)
            myIntent.putExtra("myPhoneNum", myPhoneNumber)
            startActivityForResult(myIntent, REQUEST_FOR_PHONENUM)
        }
//        Dial을 통한 전화 실행
        dialPhoneNum.setOnClickListener {
            val myPhoneNumber = myPhoneNum.text.toString()
            val myUri = Uri.parse("tel:${myPhoneNumber}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // 돌아온 이유가 연락처 변경인가?
        if (requestCode == REQUEST_FOR_PHONENUM){
            // 연락처 변경 버튼을 통해서 돌아온 것인지 확인
            if (resultCode == RESULT_OK){
//                실제 첨부된 새 번호를 텍스트 뷰에 반영
                val newPhoneNum = data?.getStringExtra("newEditPhoneNum")
                myPhoneNum.text = newPhoneNum
            }
        }
    }
}