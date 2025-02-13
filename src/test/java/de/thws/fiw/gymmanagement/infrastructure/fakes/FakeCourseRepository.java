package de.thws.fiw.gymmanagement.infrastructure.fakes.;

import de.thws.fiw.gymmanagement.domain.Course;
import de.thws.fiw.gymmanagement.domain.Trainer;
import de.thws.fiw.gymmanagement.infrastructure.CourseRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class FakeCourseRepository implements CourseRepositoryInterface {
    private final List<Course> courses = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @Override
    public Course save(Course course) {
        if (course.getId() == null || course.getId() == 0) {
            course.setId(idGenerator.getAndIncrement());
        }
        courses.add(course);
        return course;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return courses.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public Course update(long id, String name, int capacity, long trainerId) {
        Optional<Course> opt = findById(id);
        if (opt.isPresent()) {
            Course course = opt.get();
            course.setName(name);
            course.setCapacity(capacity);
            // In a fake repository, we assume the Trainer reference remains unchanged.
            return course;
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        courses.removeIf(c -> c.getId().equals(id));
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getName().equalsIgnoreCase(name)) {
                result.add(c);
            }
        }
        return result;
    }

    @Override
    public List<Course> findByTrainerId(long trainerId) {
        List<Course> result = new ArrayList<>();
        for (Course c : courses) {
            if (c.getTrainer() != null && c.getTrainer().getId() != null && c.getTrainer().getId() == trainerId) {
                result.add(c);
            }
        }
        return result;
    }
}
