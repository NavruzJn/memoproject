package com.example.haojialiang.memomyapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddMemoFragment extends Fragment {
    @BindView(R.id.et_adt_title)
    EditText etAdtTitle;
    @BindView(R.id.et_adt_content)
    EditText etAdtContent;
    @BindView(R.id.tv_adt_date)
    TextView tvAdtDate;
    @BindView(R.id.btn_adt_save)
    Button btnAdtSave;


    public AddMemoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_memo, container, false);
    }

}
