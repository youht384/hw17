package com.example.hw17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.TextView);
        listView = (ListView) findViewById(R.id.ListView);

        ArrayAdapter<CharSequence> arrAdap
                = ArrayAdapter.createFromResource(MainActivity.this,
                R.array.region_list,  //設定清單內容資訊
                android.R.layout.simple_list_item_single_choice); //設定列表選項格式  simple_list_item_1 另一種預設介面

        listView.setAdapter(arrAdap); //將設定好的 ArrayAdapter 丟進 ListView

        listView.setSelector(R.color.colorLightGreen); //改變選取項目的背景色為淺綠
        listView.setSelection(2); //ListView 預設會選取第3筆資料 

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE); //設定列表選擇模式(單選)
        listView.setOnItemClickListener(ListViewOnClickListener);
    }

    private AdapterView.OnItemClickListener ListViewOnClickListener
            = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            // TODO Auto-generated method stub

            textView.setText("你選擇了: " + ((TextView) view).getText());
        }
    };

}
