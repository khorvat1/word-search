package hr.kh.demo.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hr.kh.demo.core.dto.ScoreResponse;
import hr.kh.demo.core.service.ScoreService;

@RestController
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@GetMapping("score")
	public ScoreResponse getScore(@RequestParam("term") String term) {
		
		ScoreResponse response = new ScoreResponse(term, scoreService.getScore(term));
		
		return response;
	}

}
