package chapter12.lecture;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Lecture lecture = new Lecture(
                "Java Programming",
                70,
                List.of(81, 90, 78, 85, 92, 88, 76, 95, 89, 84)
        );

        System.out.println(lecture.evaluate());

        // TODO: MEMO -> Upcasting
        Lecture lecture2 = new GradeLecture(
                "Java Programming with Grades",
                70,
                List.of(
                        new Grade("A", 100, 90),
                        new Grade("B", 89, 80),
                        new Grade("C", 79, 70),
                        new Grade("D", 69, 60),
                        new Grade("F", 59, 0)
                ),
                List.of(81, 90, 78, 85, 92, 88, 76, 95, 89, 84)
        );

        System.out.println(lecture2.evaluate());

        Professor professor = new Professor(
                "siso",
                lecture
        );

        System.out.println(professor.compileStatistics());

        Professor professor2 = new Professor(
                "s1s0",
                lecture2
        );

        System.out.println(professor2.compileStatistics());

        // TODO: MEMO -> Downcasting
        GradeLecture downcastedLecture = (GradeLecture) lecture2;
    }
}
