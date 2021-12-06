package springboot.interview;


import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import springboot.interview.controller.InterviewPrepController;
import springboot.interview.service.InterviewPrepService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class InterviewApplicationTests {

	@InjectMocks
	InterviewPrepService interviewPrepService;
	@InjectMocks
	ObjectMapper objectMapper;

	@Before
	public void init() {
		interviewPrepService.objectMapper = objectMapper;
	}

	@Test
	public void inputStringIsAlphabetExpectInvalidItem() {
		//Input String with Alphabet
		List<String> input = new ArrayList<String>();
		input.add("A");

		Map<String,List<String>> responseMap = null;

		//Expected Response
		List<String> response = new ArrayList<String>();
		response.add("Invalid Item");
		try {
			responseMap = new ObjectMapper().readValue(interviewPrepService.calculateFizzBuzz(input), Map.class);
		} catch (Exception e) {
			e.getMessage();
		}
		Assert.assertArrayEquals((responseMap.get("A")).toArray(),response.toArray());
	}

	@Test
	public void inputStringIsEmptyExpectInvalidItem() {
		//Input String with Alphabet
		List<String> input = new ArrayList<String>();
		input.add("");

		Map<String,List<String>> responseMap = null;

		//Expected Response
		List<String> response = new ArrayList<String>();
		response.add("Invalid Item");
		try {
			responseMap = new ObjectMapper().readValue(interviewPrepService.calculateFizzBuzz(input), Map.class);
		} catch (Exception e) {
			e.getMessage();
		}
		Assert.assertArrayEquals((responseMap.get("")).toArray(),response.toArray());
	}


	@Test
	public void inputStringIsNotDivisibleBy3Or5() {
		//Input String with Alphabet
		String inputNumber = "23";
		List<String> input = new ArrayList<String>();
		input.add(inputNumber);

		Map<String,List<String>> responseMap = null;

		//Expected Response
		List<String> response = new ArrayList<String>();
		response.add("Divided " + inputNumber + " by 3");
		response.add("Divided " + inputNumber + " by 5");
		try {
			responseMap = new ObjectMapper().readValue(interviewPrepService.calculateFizzBuzz(input), Map.class);
		} catch (Exception e) {
			e.getMessage();
		}
		Assert.assertArrayEquals((responseMap.get(inputNumber)).toArray(),response.toArray());
	}

	@Test
	public void inputStringIsDivisibleBy3And5() {
		//Input String with Alphabet
		List<String> input = new ArrayList<String>();
		input.add("30");

		Map<String,List<String>> responseMap = null;

		//Expected Response
		List<String> response = new ArrayList<String>();
		response.add("FizzBuzz");
		try {
			responseMap = new ObjectMapper().readValue(interviewPrepService.calculateFizzBuzz(input), Map.class);
		} catch (Exception e) {
			e.getMessage();
		}
		Assert.assertArrayEquals((responseMap.get("30")).toArray(),response.toArray());
	}

	@Test
	public void inputStringIsDivisibleBy3() {
		//Input String with Alphabet
		List<String> input = new ArrayList<String>();
		input.add("9");

		Map<String,List<String>> responseMap = null;

		//Expected Response
		List<String> response = new ArrayList<String>();
		response.add("Fizz");
		try {
			responseMap = new ObjectMapper().readValue(interviewPrepService.calculateFizzBuzz(input), Map.class);
		} catch (Exception e) {
			e.getMessage();
		}
		Assert.assertArrayEquals((responseMap.get("9")).toArray(),response.toArray());
	}

	@Test
	public void inputStringIsDivisibleBy5() {
		//Input String with Alphabet
		List<String> input = new ArrayList<String>();
		input.add("10");

		Map<String,List<String>> responseMap = null;

		//Expected Response
		List<String> response = new ArrayList<String>();
		response.add("Buzz");
		try {
			responseMap = new ObjectMapper().readValue(interviewPrepService.calculateFizzBuzz(input), Map.class);
		} catch (Exception e) {
			e.getMessage();
		}
		Assert.assertArrayEquals((responseMap.get("10")).toArray(),response.toArray());
	}
}
