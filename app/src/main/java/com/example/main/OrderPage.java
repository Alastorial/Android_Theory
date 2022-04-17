package com.example.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.main.model.Order;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        // создаем список-виджет и прикрепляем его к виджету на разметке
        ListView orders_list = findViewById(R.id.orders_list);

        /*
        // решение от айтипрогера - перебор всех элементов и сравнение их айди с айди в корзине
        // я думаю, что это неправильно, тк если элементов очень много - проблематично при каждом открытии
        // корзины проходиться по всем ним. лучше сразу передавать название курса в корзину и не ебать мозг
        List<String> coursesTitle = new ArrayList<>();
        for (Course c : MainActivity.fullCoursesList) {
            if (Order.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        // (это уже не активное решение, сохранил тк там идет преобразование множество в массив)
        // устанавливаем адаптер, указывая текущую активити, используем встроенный адаптер и берем множество, которое преобразовываем в массив
        // в адаптер уже передан массив айдишников, поэтому он сразу же отрисовывает все
        // orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Order.items_id.toArray()));
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle));
        */
        // устанавливаем адаптер, указывая текущую активити, используем встроенный адаптер и берем множество, которое преобразовываем в массив
        orders_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Order.items_title.toArray()));
    }
}