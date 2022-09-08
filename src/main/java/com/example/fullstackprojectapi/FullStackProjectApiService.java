package com.example.fullstackprojectapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FullStackProjectApiService {
    @Autowired
    com.example.fullstackprojectapi.FullStackProjectApiRepository fullStackProjectApiRepository;

    public List<CSVData> getAllCSVData() {
        return fullStackProjectApiRepository.findAll();
    }
}
