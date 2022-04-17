package com.example.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.main.model.Order;

public class CoursePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_page);

        // создаем именно ConstraintLayout тк бекграунд цвет задается именно в этом объекте разметки
        ConstraintLayout courseBg = findViewById(R.id.coursePageBg);
        ImageView courseImage = findViewById(R.id.coursePageImage);
        TextView courseTitle = findViewById(R.id.coursePageTitle);
        TextView courseDate = findViewById(R.id.coursePageDate);
        TextView courseLevel = findViewById(R.id.coursePageLevel);
        TextView courseText = findViewById(R.id.coursePageText);

        // получаем переданные данные и устанавливаем их объектам разметки
        courseBg.setBackgroundColor(getIntent().getIntExtra("courseBg", 0));
        courseImage.setImageResource(getIntent().getIntExtra("courseImage", 0));
        courseTitle.setText(getIntent().getStringExtra("courseTitle"));
        courseDate.setText(getIntent().getStringExtra("courseDate"));
        courseLevel.setText(getIntent().getStringExtra("courseLevel"));
        courseText.setText(getIntent().getStringExtra("courseText"));

    }

    public void addToCart(View view){
        // получаем айди по интенту по экстра
//        int item_id = getIntent().getIntExtra("courseId", 0);
        // моим методом мы получаем тайтл товара
        String item_title = getIntent().getStringExtra("courseTitle");
        // добавляем в глобальный список корзины этот айди
//        Order.items_id.add(item_id);
        Order.items_title.add(item_title);
        // выводим тост
        Toast.makeText(this, "Добавлено!", Toast.LENGTH_LONG).show();
    }
}