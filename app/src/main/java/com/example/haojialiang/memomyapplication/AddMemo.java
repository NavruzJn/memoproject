package com.example.haojialiang.memomyapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddMemo extends AppCompatActivity {
    @BindView(R.id.et_adt_title)
    EditText etAdtTitle;
    @BindView(R.id.et_adt_content)
    EditText etAdtContent;
    @BindView(R.id.tv_adt_date)
    TextView tvAdtDate;
    @BindView(R.id.btn_adt_save)
    Button btnAdtSave;
    int mYear = 2018;
    int mMonth = 12;
    int mDay = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_memo);
    }


    @OnClick({R.id.tv_adt_date, R.id.btn_adt_save})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_adt_date:
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        tvAdtDate.setText(year + "-" + month + "-" + dayOfMonth);

                    }
                }, mYear, mMonth-1, mDay).show();
                break;
            case R.id.btn_adt_save:
//                showLoading();
                switch (btnAdtSave.getText().toString()) {
//                    case "Add":
//                        mPresenter.addTask(etAdtTitle.getText().toString(), etAdtContent.getText().toString(), tvAdtDate.getText().toString(), mCustomType);
//                        break;
//                    case "Update":
//                        mPresenter.updateTask(todoSection.t.getId(), etAdtTitle.getText().toString(), etAdtContent.getText().toString(), tvAdtDate.getText().toString(), todoSection.t.getStatus(), mEditType);
//                        break;
                }
                break;
        }
    }



    public void addpicture(View view) {
    }

    public void addmemo(View view) {
    }
}
