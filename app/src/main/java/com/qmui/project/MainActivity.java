package com.qmui.project;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.google.gson.Gson;
import com.qmui.project.bean.DayBean;
import com.qmui.project.constant.Constants;
import com.qmui.project.network.RetrofitSingle;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private TextView date;
    private TextView lunar;
    private TextView lunarYear;
    private TextView avoid;
    private TextView suit;

    private String REASON_SUCCESS = "Success";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //  两套activity_main资源文件，当屏幕宽度大于900dp，系统会去layout-w900dp包下获取资源文件
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        date = findViewById(R.id.date);
        lunar = findViewById(R.id.lunar);
        lunarYear = findViewById(R.id.lunarYear);
        avoid = findViewById(R.id.avoid);
        suit = findViewById(R.id.suit);
    }

    private void initData() {
        RetrofitSingle.getInstance()
                .retrofit().create(Constants.class)
                .day("2019-10-1",Constants.APPKEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DayBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("-------->>>",e.getMessage());
                    }

                    @Override
                    public void onNext(DayBean dayBean) {
                        Log.e("-------->>>",new Gson().toJson(dayBean));
                        if (dayBean.getReason().equals(REASON_SUCCESS)){
                            DayBean.ResultBean.DataBean dataBean = dayBean.getResult().getData();
                            date.setText(dataBean.getDate());
                            lunar.setText(dataBean.getLunar());
                            lunarYear.setText(dataBean.getLunarYear());
                            avoid.setText(dataBean.getAvoid());
                            suit.setText(dataBean.getSuit());
                        }
                    }
                });
    }
}
