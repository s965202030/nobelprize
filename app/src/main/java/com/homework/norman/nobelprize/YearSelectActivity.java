package com.homework.norman.nobelprize;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class YearSelectActivity extends AppCompatActivity {

    public final static String MESSAGE_SELECT_YEAR = "com.homework.norman.nobelprize.select_year";

    private final static String TAG = "YearSelectActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_year_select);
    }

    public void btn_submit(View view){
        Log.d(TAG, "Btn clicked");
        final EditText select_year_view = (EditText) findViewById(R.id.edit_text_year);
        String select_year = select_year_view.getText().toString();
        if(select_year == null || TextUtils.isEmpty(select_year)){
            new AlertDialog.Builder(this)
                    .setTitle("沒有輸入年")
                    .setMessage("請輸入年")
                    .setPositiveButton("好", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            select_year_view.requestFocus();
                        }
                    })
                    .show();
        }else{
            Intent intent = new Intent(this, NobelPrizeListActivity.class);
            intent.putExtra(MESSAGE_SELECT_YEAR, select_year);
            startActivity(intent);
        }



    }
}
