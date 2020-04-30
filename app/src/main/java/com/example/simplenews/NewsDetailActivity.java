package com.example.simplenews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);

        final int i=1;
        Button favorite_btn = (Button)findViewById(R.id.favorite);
        Button favorite_cancel = (Button)findViewById(R.id.cancel);
        Button favorite_add = (Button)findViewById(R.id.add);

        favorite_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(NewsDetailActivity.this, FavoriteActivity.class);
                startActivity(intent);
            }
        });

        favorite_cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("删除数据");
                MySQLiteOpenHelper dbHelper_cancel = new MySQLiteOpenHelper(NewsDetailActivity.this,"test_carson",2);
                SQLiteDatabase sqliteDatabase_cancel = dbHelper_cancel.getWritableDatabase();
                String sql = "delete from user where id=i";
                sqliteDatabase_cancel.execSQL(sql);
                sqliteDatabase_cancel.close();
            }
        });

        favorite_add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                System.out.println("插入数据");
                MySQLiteOpenHelper dbHelper_add = new MySQLiteOpenHelper(NewsDetailActivity.this,"test_carson",2);
                SQLiteDatabase  sqliteDatabase_add = dbHelper_add.getWritableDatabase();
                ContentValues values1 = new ContentValues();
                values1.put("id", i);
                values1.put("name", "carson");
                sqliteDatabase_add.insert("user", null, values1);
                sqliteDatabase_add.close();
            }
        });
    }
}
