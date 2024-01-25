package org.example.quizapp.service;

import org.example.quizapp.dao.QuestionDao;
import org.example.quizapp.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class QuestionService {
    @Autowired
    QuestionDao questionDao;
    public List<Question> getAllQuestions(){
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category){
        return questionDao.findByCategory(category);
    }

}
