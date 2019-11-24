package application.controller;

import application.dto.TimeMarkDto;
import application.service.IStopWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class StopWatchController {

    private final IStopWatchService stopWatchService;

    @Autowired
    public StopWatchController(IStopWatchService stopWatchService) {
        this.stopWatchService = stopWatchService;
    }

    @GetMapping("/timeMarks")
    public ResponseEntity<List<TimeMarkDto>> getTimeMarks(){
        return new ResponseEntity<>(stopWatchService.getAllTimeMarks(), HttpStatus.OK);
    }

    @PostMapping("/timeMark")
    public ResponseEntity<Boolean> addTimeMark(@RequestBody TimeMarkDto timeMark){
        return new ResponseEntity<>(stopWatchService.insertTimeMark(timeMark), HttpStatus.OK);
    }

    @DeleteMapping("/timeMarks")
    public ResponseEntity<Boolean> clearTimeMarks(){
        return new ResponseEntity<>(stopWatchService.clearTimeMarks(), HttpStatus.OK);
    }

    @DeleteMapping("/timeMark")
    public ResponseEntity<Boolean> removeTimeMark(@RequestParam String timeMark){
        return new ResponseEntity<>(stopWatchService.removeTimeMark(timeMark), HttpStatus.OK);
    }
}