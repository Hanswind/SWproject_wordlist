package com.example.worldlist_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.TextView;

import java.lang.String;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class word extends AppCompatActivity {

    //사전 데이터 생성
    Map<String, String> dict = new HashMap<String, String>();



    //내단어리스트 생성
    List<String[]> wordlist = new ArrayList<String[]>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);
        dict.put("apple", "사과");
        dict.put("contribution", "기부금");

        Button re =(Button)findViewById(R.id.button);
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(
                        getApplicationContext(),
                        search1.class

                );
                startActivity(intent);
            }
        });

    }

    public void onClickAppend(View v){   // '등록하기' 누르면 입력한 데이터 wordlist에 데이터 추가
        EditText text1= (EditText) findViewById(R.id.word);
        String words = text1.getText().toString();

        EditText text2 = (EditText) findViewById(R.id.sentence);
        String sentence = text2.getText().toString();

        wordlist.add(new String[]{words, sentence});
        Intent intent = new Intent(word.this, search1.class);
        intent.putExtra("word",words);
        intent.putExtra("desc",sentence);
        startActivity(intent);

        TextView res = (TextView) findViewById(R.id.textView_word_list);
        res.append(wordlist.get(0)[0]);
        res.append(wordlist.get(0)[1]);


    }

    public void onClickFindWord(View v){
        EditText text = (EditText) findViewById(R.id.word);
        EditText text2 = (EditText) findViewById(R.id.sentence);
        String t = text.getText().toString();

        if(dict.containsKey(t) == true) {
            text2.setText(dict.get(t));
        }
        else{
            text2.setText("no data");
        }
    }





}



