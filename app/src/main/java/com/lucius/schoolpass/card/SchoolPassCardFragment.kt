package com.lucius.schoolpass.card

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import com.lucius.schoolpass.R
import kotlinx.android.synthetic.main.fragment_school_pass_card.*
import java.text.SimpleDateFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * @author LuciusRen(issane)
 * @since v1.1.0 2021/3/21 21:08
 * @email renhongfeiasd@gmail.com
 * A simple [Fragment] subclass.
 * Use the [SchoolPassCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SchoolPassCardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_school_pass_card, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 测试用的实体类
        val schoolPassCard = SchoolPassCard()
        schoolPassCard.cardExecutorName = "张三"
        schoolPassCard.leaveDateTime = "2021-03-07 09:40"
        schoolPassCard.backDateTime = "2021-03-07 09:40"
        schoolPassCard.studentName = "大大大"
        schoolPassCard.studentId = "2018134004"
        schoolPassCard.studentDepartment = "软件学院"
        schoolPassCard.studentMajor = "软件工程"
        schoolPassCard.studentGrade = "2019级"
        schoolPassCard.studentClass = "19软件1班"
        // end of 测试用的实体类
        loadSchoolPass(schoolPassCard)
    }

    private fun loadSchoolPass(schoolPassCardEntity: SchoolPassCard?) {
        schoolPassCardEntity?.let { entity ->
            tv_leave_time?.text = "出校时间：${entity.leaveDateTime}"
            tv_back_time?.text = "返校时间：${entity.backDateTime}"
            tv_student_name?.text = "姓      名：${entity.studentName}"
            tv_student_id?.text = "学      号：${entity.studentId}"
            tv_student_department?.text = "学      院：${entity.studentDepartment}"
            tv_student_major?.text = "专      业：${entity.studentMajor}"
            tv_student_grade?.text = "年      级：${entity.studentGrade}"
            tv_student_class?.text = "班      级：${entity.studentClass}"
            tv_executor?.text = "审  批  人：${entity.cardExecutorName}"
        }
        // 所有固定信息加载完成之后，读取一次当前时间
        updateTime()
//        timeThread.start()
    }

    /**
     * 向主界面的时刻表更新当前时间
     */
    @UiThread
    private fun updateTime() {
        val date = Date()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val dateTimeStr = dateFormat.format(date)
        tv_current_time?.text = dateTimeStr
    }


//    private val mHandler = Handler(Looper.getMainLooper(), Handler.Callback { msg ->
//        when (msg.what) {
//            100 -> {
//                updateTime()
//                true
//            }
//            else -> false
//        }
//    })
//
//    private val timeThread = object : Thread() {
//        override fun run() {
//            super.run()
//            while (true) {
//                sleep(1000L)
//                mHandler.sendEmptyMessage(100)
//            }
//        }
//    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SchoolPassCardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                SchoolPassCardFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}