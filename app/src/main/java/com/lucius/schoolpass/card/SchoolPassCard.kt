package com.lucius.schoolpass.card

/**
 * @author LuciusRen
 * @since v1.1.0 2021-3-21 21:06:32
 * @email renhongfeiasd@gmail.com
 * @description 学校通行证的实体类
 */
class SchoolPassCard {
    companion object {
        const val NAME_UNDEFINE = "UN_DEF"
        const val ID_NUM_UNDEFINE = "0000"
        const val DATE_TIME_UNDEFINE = "2021-01-01 00:00"
    }

    /**
     * 学生姓名
     */
    var studentName = NAME_UNDEFINE

    /**
     * 学生学号，这里是为了保证兼容不同的情况，使用字符串
     */
    var studentId = ID_NUM_UNDEFINE

    // 下面依次是学生的 学院、专业、年级，都是用字符串
    var studentDepartment = NAME_UNDEFINE
    var studentMajor = NAME_UNDEFINE
    var studentGrade = NAME_UNDEFINE

    /**
     * 通行证审批人 / 执行人
     */
    var cardExecutorName = NAME_UNDEFINE

    // 出校时间、返校时间
    var leaveDateTime = DATE_TIME_UNDEFINE
    var backDateTime = DATE_TIME_UNDEFINE
}