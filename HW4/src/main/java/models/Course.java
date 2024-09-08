package models;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "courses")
public class Course {
    private static final String[] titles = new String[]{"Математика", "Русский язык", "История", "Физика", "Химия", "Литература", "Физкультура"};
    private static final Random random = new Random();



    public static Course create() {
        return new Course(titles[random.nextInt(titles.length)], LocalDate.now().toString(), null);
    }
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
    //region конструкторы, гетерры и сеттеры
    public Course(String title, String begin, String end) {
        this.title = title;
        this.begin = begin;
        this.end = end;
    }

    public Course() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }


    public int getId() {
        return id;

    }


    //endregion

    //region Поля

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 10)
    private String begin;

    @Column(nullable = true, length = 10)
    private String end;

    //endregion


}
