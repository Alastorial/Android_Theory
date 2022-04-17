package com.example.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.main.adapter.CategoryAdapter;
import com.example.main.adapter.CourseAdapter;
import com.example.main.model.Category;
import com.example.main.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // создаем компонент для отображения списка
    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    // static тк работаем в статичном методе с ними и хз почему еще, так просто надо
    static CourseAdapter courseAdapter;
    // создаем список с категориями
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCoursesList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // создаем список с категориями
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Игры"));
        categoryList.add(new Category(2, "Сайты"));
        categoryList.add(new Category(3, "Языки"));
        categoryList.add(new Category(4, "Книги"));
        categoryList.add(new Category(5, "Музыка"));
        categoryList.add(new Category(6, "Прочее"));
        categoryList.add(new Category(6, "Прочее"));


        // передаем в метод ниже
        setCategoryRecycler(categoryList);


        courseList.add(new Course(1, "java", "Профессия Java\nразработчик", "1 января", "начальный", "#424345", "Программа обучения Джава – рассчитана на новичков в данной сфере. За программу вы изучите построениеграфических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава! Программа обучения Джава – рассчитана на новичков в данной сфере. За программу вы изучите построениеграфических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава! Программа обучения Джава – рассчитана на новичков в данной сфере. За программу вы изучите построениеграфических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава! Программа обучения Джава – рассчитана на новичков в данной сфере. За программу вы изучите построениеграфических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава! Программа обучения Джава – рассчитана на новичков в данной сфере. За программу вы изучите построениеграфических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава! Программа обучения Джава – рассчитана на новичков в данной сфере. За программу вы изучите построениеграфических приложений под ПК, разработку веб сайтов на основе Java Spring Boot, изучите построение полноценных Андроид приложений и отлично изучите сам язык Джава!", 3));
        courseList.add(new Course(2, "python", "Профессия Python\nразработчик", "10 января", "начальный", "#9FA52D", "Test ", 3));

        fullCoursesList.addAll(courseList);

        // передаем в метод ниже
        setCourseRecycler(courseList);
    }

    // при нажатии на корзину переходим на активити корзины
    public void openShoppingCart(View view) {
        Intent intent = new Intent(this, OrderPage.class);
        startActivity(intent);
    }

    private void setCourseRecycler(List<Course> courseList) {
        // задаем, как именно отображать элементы (создаем менеджер отображения)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        // связываем компонент с его элементом в активити
        courseRecycler = findViewById(R.id.courseRecycler);
        // передаем в компонент менеджер
        courseRecycler.setLayoutManager(layoutManager);

        // создаем адаптер
        courseAdapter = new CourseAdapter(this, courseList);
        // передаем адаптер в компонент
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        // задаем, как именно отображать элементы (создаем менеджер отображения)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        // связываем компонент с его элементом в активити
        categoryRecycler = findViewById(R.id.categoryRecycler);
        // передаем в компонент менеджер
        categoryRecycler.setLayoutManager(layoutManager);

        // создаем адаптер
        categoryAdapter = new CategoryAdapter(this, categoryList);
        // передаем адаптер в компонент
        categoryRecycler.setAdapter(categoryAdapter);
    }

    @SuppressLint("NotifyDataSetChanged")
    public static void showCoursesByCategories(int category) {
        List<Course> filterCourses = new ArrayList<>();
        courseList.clear();
        courseList.addAll(fullCoursesList);

        for (Course c : courseList){
            if (c.getCategory() == category)
                filterCourses.add(c);
        }

        courseList.clear();
        courseList.addAll(filterCourses);

        // этот метод берет новый список и обновляет весь ресайкл в адаптере
        courseAdapter.notifyDataSetChanged();
    }

}