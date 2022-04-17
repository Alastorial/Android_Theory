package com.example.main.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.main.CoursePage;
import com.example.main.R;
import com.example.main.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.CourseViewHolder> {

    // переданное активите (главное в нашем случае)
    Context context;
    List<Course> courses;

    public CourseAdapter(Context context, List<Course> courses) {
        this.context = context;
        this.courses = courses;
    }

    @NonNull
    @Override
    // указываем дизайн для отображения каждого элемента
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // LayoutInflater Создает экземпляр XML-файла макета в соответствующих объектах View
        // from Получает LayoutInflater из заданного контекста
        // inflate создаем новую иерархию представлений из указанного xml-ресурса
        View courseItems = LayoutInflater.from(context).inflate(R.layout.course_item, parent, false);
        // создаем объект CourseViewHolder с переданными в него XML элементами
        return new CourseViewHolder(courseItems);

    }

    @Override
    // указываем, что будем подставлять в дизайн
    // подставляем значения
    public void onBindViewHolder(@NonNull CourseViewHolder holder, @SuppressLint("RecyclerView") int position) {
        // position - итератор по элементам списка
        // holder - дизайн каждого отдельного элемента - это объект класса CourseViewHolder, где лежат все элементы, помещенные в поля
        // holder.courseBg.setBackgroundColor(Color.parseColor(courses.get(position).getColor())); - это для LinearLayout
        holder.courseBg.setCardBackgroundColor(Color.parseColor(courses.get(position).getColor()));

        // создаем идентификатор  фотографии:
        // getResources(): создаем окно ко всем ресурсам проекта
        // getIdentifier(): возвращает ресурс из заданной папки
        // превращаем название картинки в идентификатор
        int imageId = context.getResources().getIdentifier("ic_" + courses.get(position).getImg(), "drawable", context.getPackageName());
        holder.courseImage.setImageResource(imageId);

        // устанавливаем текст карточке в соответствии с данными текущего объекта из массива объектов
        holder.courseTitle.setText(courses.get(position).getTitle());
        holder.courseDate.setText(courses.get(position).getDate());
        holder.courseLevel.setText(courses.get(position).getLevel());

        // обращаемся ко всему объе
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // создали намерение перейти на другую активити
                Intent intent = new Intent(context, CoursePage.class);

                // прописываем анимацию
                // чтобы связать две картинки, необходимо в их параметрах transitionName указать одинаковые имена
                // передаем текущее активити и пару из текущей картинки и ключа, по которому надо будет связать с другой картинкой
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context,
                        new Pair<View, String>(holder.courseImage, "courseImage"));

                // передаем данные ключ значение
                intent.putExtra("courseBg", Color.parseColor(courses.get(position).getColor()));
                intent.putExtra("courseImage", imageId);
                intent.putExtra("courseTitle", courses.get(position).getTitle());
                intent.putExtra("courseDate", courses.get(position).getDate());
                intent.putExtra("courseLevel", courses.get(position).getLevel());
                intent.putExtra("courseText", courses.get(position).getText());
                intent.putExtra("courseId", courses.get(position).getId());

                // запустили другую активити
                context.startActivity(intent, options.toBundle());


            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    // с какими элементами будем работать
    public static final class CourseViewHolder extends RecyclerView.ViewHolder {

        // Объявляем переменные
        CardView courseBg;
        ImageView courseImage;
        TextView courseTitle, courseDate, courseLevel;


        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            // создаем переменные для элементов в XML разметке
            courseBg = itemView.findViewById(R.id.courseBg);
            courseImage = itemView.findViewById(R.id.courseImage);
            courseTitle = itemView.findViewById(R.id.courseTitle);
            courseDate = itemView.findViewById(R.id.courseDate);
            courseLevel = itemView.findViewById(R.id.courseLevel);
        }
    }
}
