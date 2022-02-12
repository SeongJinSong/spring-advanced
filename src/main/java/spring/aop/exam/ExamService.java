package spring.aop.exam;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.aop.exam.annotation.Retry;
import spring.aop.exam.annotation.Trace;

@Service
@RequiredArgsConstructor
public class ExamService {
    private final ExamRepository examRepository;

    @Trace
    @Retry
    public void request(String itemId){
        examRepository.save(itemId);
    }
}
