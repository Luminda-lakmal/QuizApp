package org.example.quizapp.controller;

import org.example.quizapp.entities.Question;
import org.example.quizapp.entities.QuestionWrapper;
import org.example.quizapp.entities.Response;
import org.example.quizapp.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    QuizService quizService;
    @PostMapping("quiz")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestBody int numQ, @RequestParam String title){
        return quizService.createQuiz(category, numQ, title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
