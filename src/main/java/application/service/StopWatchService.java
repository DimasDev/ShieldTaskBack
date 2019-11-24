package application.service;

import application.dto.TimeMarkDto;
import application.entities.TimeMarkEntity;
import application.repositories.StopWatchRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class StopWatchService implements IStopWatchService {

    private final StopWatchRepository repository;

    private final ModelMapper mapper;

    @Autowired
    public StopWatchService(StopWatchRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public boolean insertTimeMark(TimeMarkDto timeMark) {
        timeMark.setTime(timeMark.getTime().substring(0, 8));
        return !Objects.isNull(repository.save(mapper.map(timeMark, TimeMarkEntity.class)));
    }

    @Override
    public boolean clearTimeMarks() {
        repository.deleteAll();
        return repository.count()==0;
    }

    @Override
    public List<TimeMarkDto> getAllTimeMarks() {
        return repository.findAll()
                .stream()
                .map(timeMarkEntity -> mapper.map(timeMarkEntity, TimeMarkDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeTimeMark(String timeMark) {
        TimeMarkEntity entity = repository.findByTime(timeMark);
        repository.delete(entity);
        return !repository.findOne(Example.of(entity)).isPresent();
    }
}
