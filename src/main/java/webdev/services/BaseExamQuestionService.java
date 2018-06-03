package webdev.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import webdev.models.BaseExamQuestion;
import webdev.models.Exam;
import webdev.repositories.BaseExamQuestionRepository;
import webdev.repositories.EssayExamQuestionRepository;
import webdev.repositories.ExamRepository;

import java.util.List;
import java.util.Optional;

public class BaseExamQuestionService {

    @Autowired
    BaseExamQuestionRepository baseExamQuestionRepository;
    @Autowired
    ExamRepository examRepository;

    @GetMapping("/api/exam/{eid}/question")
    public List<BaseExamQuestion> findQuestionsByExam(@PathVariable("eid") int eid) {
        Optional<Exam> maybeExam = examRepository.findById(eid);
        if (maybeExam.isPresent()) {
            return maybeExam.get().getQuestions();
        }
        return null;
    }
}
