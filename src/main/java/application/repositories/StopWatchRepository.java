package application.repositories;

import application.entities.TimeMarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopWatchRepository extends JpaRepository<TimeMarkEntity, Integer> {
    TimeMarkEntity findByTime(String timeMark);
}
