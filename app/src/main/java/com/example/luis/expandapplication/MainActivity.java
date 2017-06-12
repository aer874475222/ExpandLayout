package com.example.luis.expandapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private ExpandLayout expand_layout;
    private CheckBox checkbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initExpandView();

    }

    public void initExpandView() {
        checkbox= (CheckBox) findViewById(R.id.checkbox);
        checkbox.setOnClickListener(onClick);
        expand_layout = (ExpandLayout) findViewById(R.id.expand_layout);
        expand_layout.setRetractHeight(200f);//可通过这段设置缩放高度
        expand_layout.initExpand(true);

    }

    View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.checkbox:
                    expand_layout.toggleExpand();
                    break;
            }
        }
    };
}
