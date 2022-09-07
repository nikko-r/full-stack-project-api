package com.example.fullstackprojectapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io. * ;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class CSVDataLoader {
    private final FullStackProjectApiRepository fullStackProjectApiRepository;
    @Autowired
    public CSVDataLoader(FullStackProjectApiRepository fullStackProjectApiRepository){
        this.fullStackProjectApiRepository=fullStackProjectApiRepository;
    }
    public void updateSQL() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("..\\full-stack-project-site\\src\\data\\data.csv"));
        ArrayList<String> data = new ArrayList();
        sc.useDelimiter("");
        while (sc.hasNextLine()) {
            data.add(sc.nextLine().replaceAll(",",";"));
        }
        String lastCSVEntryStr = (data.toArray()[data.toArray().length-1]).toString();
        System.out.println(lastCSVEntryStr);
        String[] lastCSVEntryArr = lastCSVEntryStr.split(";");
        System.out.println(lastCSVEntryArr[0]); //Date Time

        LocalDateTime convertToDateTime = LocalDateTime.parse(lastCSVEntryArr[0].replace(" ", "T"));

        float mrh = Float.parseFloat(lastCSVEntryArr[1]);
        int cpm = Integer.parseInt(lastCSVEntryArr[2]);

        var dataValueAsString = Arrays.copyOfRange(lastCSVEntryArr, 3, lastCSVEntryArr.length);

        List<Integer> dataValues = new ArrayList<>();

        Arrays.stream(dataValueAsString).forEach(c -> {
            dataValues.add(Integer.parseInt(c));
        });

        CSVData csvData = new CSVData(
                0,
                convertToDateTime,
                mrh,
                cpm,
                dataValues.get(0),
                dataValues.get(1),
                dataValues.get(2),
                dataValues.get(3),
                dataValues.get(4),
                dataValues.get(5),
                dataValues.get(6),
                dataValues.get(7),
                dataValues.get(8),
                dataValues.get(9),
                dataValues.get(10),
                dataValues.get(11),
                dataValues.get(12),
                dataValues.get(13),
                dataValues.get(14),
                dataValues.get(15),
                dataValues.get(16),
                dataValues.get(17),
                dataValues.get(18),
                dataValues.get(19),
                dataValues.get(20),
                dataValues.get(21),
                dataValues.get(22),
                dataValues.get(23),
                dataValues.get(24),
                dataValues.get(25),
                dataValues.get(26),
                dataValues.get(27),
                dataValues.get(28),
                dataValues.get(29),
                dataValues.get(30),
                dataValues.get(31),
                dataValues.get(32),
                dataValues.get(33),
                dataValues.get(34),
                dataValues.get(35),
                dataValues.get(36),
                dataValues.get(37),
                dataValues.get(38),
                dataValues.get(39),
                dataValues.get(40),
                dataValues.get(41),
                dataValues.get(42),
                dataValues.get(43),
                dataValues.get(44),
                dataValues.get(45),
                dataValues.get(46),
                dataValues.get(47),
                dataValues.get(48),
                dataValues.get(49),
                dataValues.get(50),
                dataValues.get(51),
                dataValues.get(52),
                dataValues.get(53),
                dataValues.get(54),
                dataValues.get(55),
                dataValues.get(56),
                dataValues.get(57),
                dataValues.get(58),
                dataValues.get(59)
        );

        List<CSVData> sqlData = fullStackProjectApiRepository.findAll();

        if(sqlData.isEmpty()) {
            saveToDatabase(csvData);
        } else {
            if(convertToDateTime.equals(sqlData.get(0).getDateTime())) {
                return;
            } else {
                fullStackProjectApiRepository.save(csvData);
            }
        }

        sc.close();
    }

    private void saveToDatabase(CSVData csvData) {
        fullStackProjectApiRepository.save(csvData);
    }
}