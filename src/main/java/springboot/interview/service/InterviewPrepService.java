package springboot.interview.service;


import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InterviewPrepService {

    @Autowired
    public ObjectMapper objectMapper;

    public String calculateFizzBuzz(List<String> inputList) {
        Map<String,List<String>> mapForEachInput = new HashMap<String,List<String>>();
        String jsonOutput = StringUtils.EMPTY;


        try {
            inputList.stream().forEach(s -> {
                if (StringUtils.isEmpty(s)) {
                    List<String> outputMessages = new ArrayList<>();
                    outputMessages.add("Invalid Item");
                    mapForEachInput.put(s, outputMessages);
                } else {
                    if (!Character.isDigit(s.charAt(0))) {
                        List<String> outputMessages = new ArrayList<>();
                        outputMessages.add("Invalid Item");
                        mapForEachInput.put(s, outputMessages);
                    }
                    else if (Integer.valueOf(s) % 15 == 0) {
                        List<String> outputMessages = new ArrayList<>();
                        outputMessages.add("FizzBuzz");
                        mapForEachInput.put(s, outputMessages);
                    } else if (Integer.valueOf(s) % 3 == 0) {
                        List<String> outputMessages = new ArrayList<>();
                        outputMessages.add("Fizz");
                        mapForEachInput.put(s, outputMessages);
                    } else if (Integer.valueOf(s) % 5 == 0) {
                        List<String> outputMessages = new ArrayList<>();
                        outputMessages.add("Buzz");
                        mapForEachInput.put(s, outputMessages);
                    } else {
                        List<String> outputMessages = new ArrayList<>();
                        outputMessages.add("Divided " + s + " by 3");
                        outputMessages.add("Divided " + s + " by 5");
                        mapForEachInput.put(s, outputMessages);
                    }
                }

            });

            System.out.println(objectMapper.writeValueAsString(mapForEachInput));
             jsonOutput = objectMapper.writeValueAsString(mapForEachInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonOutput;
    }
}
