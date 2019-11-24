package application.service;

import application.dto.TimeMarkDto;

import java.util.List;

public interface IStopWatchService {
    boolean insertTimeMark(TimeMarkDto timeMark);
    boolean clearTimeMarks();
    List<TimeMarkDto> getAllTimeMarks();
    boolean removeTimeMark(String timeMark);
}
