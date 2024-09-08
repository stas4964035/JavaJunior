package task;

import models.Course;
import models.CoursesRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Collection;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        try (SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {

            CoursesRepositoryImpl coursesRepository = new CoursesRepositoryImpl(sessionFactory);
            coursesRepository.add(Course.create());
            coursesRepository.add(Course.create());
            coursesRepository.add(Course.create());
            Course secondCourse = coursesRepository.getById(2);
            System.out.println(secondCourse);

            secondCourse.setTitle("Third Course");
            coursesRepository.update(secondCourse);

            System.out.println(coursesRepository.getById(2));

            coursesRepository.delete(secondCourse);

            Collection<Course> courses = coursesRepository.getAll();
            courses.forEach(System.out::println);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
