package com.qmui.project.constant;

import com.qmui.project.bean.DayBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * 创建日期：2019/9/19
 * 创建人：崔斌浩
 * QQ:785248126
 * 说明：常量
 */
public interface Constants {
    //  请求地址
    String APPKEY = "3f4743ff0204412c7ca147044b997aff";

    @GET("calendar/day")
    Observable<DayBean> day(@Query("date") String date,@Query("key") String key);
}
