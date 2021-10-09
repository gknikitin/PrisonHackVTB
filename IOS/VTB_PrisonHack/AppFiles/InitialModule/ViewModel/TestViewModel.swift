//
//  TestViewModel.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 09.10.2021.
//

import Foundation
import RxSwift

class TestViewModel {
    
    let currentQuestion = PublishSubject<Question>()
    let result = PublishSubject<String>()
    var questions = [Question]()
    var questionNumber = 0
    var totalScore = 0
    var task: Task?
    
    public func setQuestions(task: Task) {
        self.task = task
        for question in task.questions {
            questions.append(question)
        }
    }
    
    public func setQuestion() {
        let message: String
        if questionNumber  <= questions.count - 1 {
            currentQuestion.onNext(questions[questionNumber])
        } else {
            if totalScore == 4 {
                if let task = task {
                    if !task.completed {
                        task.makeCompleted()
                        let currentrank: Int = UserSettings.userRank
                        UserSettings.userRank = currentrank + 1
                    }
                }
                message = "Вы отлично разбираетесь в данной теме! Так держать!"
            } else {
                message = "Вы ответили на \(totalScore) вопросов из 4. В следующий раз постарайтесь!"
            }
            result.onNext(message)
        }
    }
    
    public func addPoint(point: Int) {
        totalScore += point
        questionNumber += 1
        setQuestion()
    }
    
}
