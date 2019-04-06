package com.example.todo_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Information> infoArrayList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.submit_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.todoText);
                String d = editText.getText().toString();
                if (d.length()!=0) {
                    infoArrayList.add(new Information(d,0));
                    editText.setText("");
                    addView();

                }
            }
        });

    }

    private void addView() {
        Myadapter myadapter = new Myadapter(this,infoArrayList);
        GridView gridView = findViewById(R.id.grid);
        gridView.setAdapter(myadapter);
    }

}
