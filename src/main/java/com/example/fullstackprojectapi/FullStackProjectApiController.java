package com.example.fullstackprojectapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.lang.Integer.parseInt;

@CrossOrigin
@RestController
public class FullStackProjectApiController {
    @Autowired
    com.example.fullstackprojectapi.FullStackProjectApiService fullStackProjectApiService;

    @GetMapping("/csvdata")
    public ResponseEntity<List<CSVData>> getCSVData() {
        List<CSVData> csvdata = fullStackProjectApiService.getAllCSVData();
        return ResponseEntity.status(HttpStatus.OK).body(csvdata);
    }

    @GetMapping("/csvdatalast")
    public ResponseEntity<CSVData> getCSVDataLast() {
        List<CSVData> csvdata = fullStackProjectApiService.getAllCSVData();
        return ResponseEntity.status(HttpStatus.OK).body(csvdata.get(csvdata.size()-1));
    }
}
