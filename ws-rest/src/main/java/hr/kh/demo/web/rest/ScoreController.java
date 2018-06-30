package hr.kh.demo.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hr.kh.demo.web.dto.ScoreResponse;

@RestController
public class ScoreController {
	
	@GetMapping("score")
	@ResponseBody
	public ScoreResponse getScore(@RequestParam("term") String term) {
		
		ScoreResponse response = new ScoreResponse(term, 5d);
		
		return response;
	}

}
