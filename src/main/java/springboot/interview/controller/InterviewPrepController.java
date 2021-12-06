package springboot.interview.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import prep.interview.interview.api.DemoApi;
import prep.interview.interview.model.FizzBuzzRequest;
import springboot.interview.service.InterviewPrepService;

@RestController
public class InterviewPrepController  implements DemoApi{
    @Autowired
    InterviewPrepService interviewPrepService;

   @Override
    public ResponseEntity<String> calculateFizzBuzz(FizzBuzzRequest fizzBuzzRequest) throws Exception {
       System.out.println("Inside Controller");
       String output = interviewPrepService.calculateFizzBuzz(fizzBuzzRequest.getInput());
        return ResponseEntity.ok(output);
    }
}