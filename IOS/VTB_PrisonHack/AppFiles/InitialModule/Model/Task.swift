//
//  Task.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 09.10.2021.
//

import Foundation
import RealmSwift

class Task: Object {
    
    @Persisted var title: String = ""
    @Persisted var completed: Bool = false
    @Persisted var questions = List<Question>()
    
    static func createTask(title: String, questions: [Question]) -> Task {
        let task = Task()
        task.title = title
        for question in questions {
            task.questions.append(question)
        }
        return task
    }
    
    static func readTasks() -> [Task] {
        var list = [Task]()
        let realm = try! Realm()
        let data = realm.objects(self)
        for item in data {
            list.append(item)
        }
        return list
    }
    
    public func makeCompleted() {
        let realm = try! Realm()
        do {
            try! realm.write {
                self.completed = true
            }
        }
    }
    
    static func initTasks() {
        let realm = try! Realm()
        let tasks: [Task] = [
            createTask(title: "Паи закрытых паевых инвестиционных фондов (ЗПИФ)", questions: [
                Question.createQuetion(text: "Допускается ли вторичное обращение паев закрытого паевого инвестиционного фонда?", answers: [
                    Answer.createAnswer(text: "Нет в любом случае", weight: 0),
                    Answer.createAnswer(text: "Да, если это предусмотрено правилами доверительного управления фондом", weight: 1),
                    Answer.createAnswer(text: "Ни один из ответов не является правильным", weight: 0),
                    Answer.createAnswer(text: "Да, поскольку возможность получить прибыль от операций с паями ЗПИФ гарантирована государством", weight: 0)
                ]),
                Question.createQuetion(text: "Если инвестор принимает решение продать принадлежащие ему паи закрытого паевого инвестиционного фонда, как быстро он может осуществить продажу?", answers: [
                    Answer.createAnswer(text: "Автоматически в день подачи поручения на продажу брокеру", weight: 0),
                    Answer.createAnswer(text: "Невозможно определить, поскольку заключить сделку можно только при условии, что найдется покупатель", weight: 0),
                    Answer.createAnswer(text: "Продажа будет осуществлена в тот день, когда инвестор выставил заявку на продажу, вне зависимости от того, есть ли на бирже встречные заявки на покупку или нет", weight: 0),
                    Answer.createAnswer(text: "Невозможно определить, поскольку заключить сделку можно только при условии, что такие паи захочет купить брокер", weight: 1)
                ]),
                Question.createQuetion(text: "Инвестиционный пай – это:", answers: [
                    Answer.createAnswer(text: "Ценная бумага, удостоверяющая долю в праве собственности на имущество паевого инвестиционного фонда", weight: 1),
                    Answer.createAnswer(text: "Сертификат, подтверждающий безусловное право пайщика на гарантированный процентный доход", weight: 0),
                    Answer.createAnswer(text: "Ни один из ответов не является правильным", weight: 0),
                    Answer.createAnswer(text: "Разность между текущей стоимостью чистых активов паевого инвестиционного фонда и стоимостью чистых активов фонда на дату его формирования", weight: 0)
                ]),
                Question.createQuetion(text: "Каким образом выплата промежуточного дохода по инвестиционным паям закрытого паевого инвестиционного фонда влияет на расчетную стоимость пая? Расчетная стоимость пая, как правило (при прочих равных условиях):", answers: [
                    Answer.createAnswer(text: "Не меняется, поскольку зависит от ключевой ставки", weight: 0),
                    Answer.createAnswer(text: "Растет", weight: 0),
                    Answer.createAnswer(text: "Снижается", weight: 1),
                    Answer.createAnswer(text: "Ни один из ответов не является  правильным", weight: 0)
                ])
            ]),
            createTask(title: "Облигации российских эмитентов, которым не присвоен рейтинг или он ниже уровня", questions: [
                Question.createQuetion(text: "Отсутствие кредитного рейтинга выпуска для любого выпуска облигаций означает:", answers: [
                    Answer.createAnswer(text: "Наличие повышенных рисков дефолта по данному выпуску облигаций", weight: 0),
                    Answer.createAnswer(text: "Отсутствие мнения кредитного рейтингового агентства о кредитном риске данного выпуска облигаций", weight: 1),
                    Answer.createAnswer(text: "Выпуск застрахован, поэтому рейтинг не требуется", weight: 0),
                    Answer.createAnswer(text: "Компания-эмитент находится в тяжёлом финансовом положении", weight: 0)
                ]),
                Question.createQuetion(text: "Пожалуйста, выберите правильный ответ из следующих утверждений:", answers: [
                    Answer.createAnswer(text: "Ликвидность облигаций зависит исключительно от уровня кредитного рейтинга эмитента облигаций", weight: 0),
                    Answer.createAnswer(text: "Как правило, чем ликвиднее облигация, тем меньше разница между ценами заявок на покупку и продажу (спред)", weight: 1),
                    Answer.createAnswer(text: "Ни один из ответов не является правильным", weight: 0),
                    Answer.createAnswer(text: "Чем меньшее количество облигаций находится в свободном обращении, тем выше ликвидность облигаций", weight: 0)
                ]),
                Question.createQuetion(text: "Кредитный рейтинг облигаций — это:", answers: [
                    Answer.createAnswer(text: "Оценка кредитным рейтинговым агентством способности компании - эмитента облигаций выполнять взятые на себя финансовые обязательства по этим облигациям", weight: 1),
                    Answer.createAnswer(text: "Страховка кредитного рейтингового агентства компании", weight: 0),
                    Answer.createAnswer(text: "Рекомендация Банка России покупать облигации", weight: 0),
                    Answer.createAnswer(text: "Сертификат, дающий право компании продавать свои облигации физическим лицам", weight: 0)
                ]),
                Question.createQuetion(text: "Если инвестор принимает решение продать принадлежащие ему низколиквидные облигации, как быстро он может это сделать?", answers: [
                    Answer.createAnswer(text: "В любой рабочий день, определенный самим инвестором", weight: 0),
                    Answer.createAnswer(text: "Невозможно определить, поскольку заключить сделку можно только при условии, что найдется покупатель", weight: 1),
                    Answer.createAnswer(text: "После предоставления брокеру документов, подтверждающих покупку облигаций", weight: 0),
                    Answer.createAnswer(text: "Не раньше выставления заявки на продажу облигаций в специальной биржевой секции", weight: 0)
                ])
            ]),
            createTask(title: "Облигации иностранных эмитентов в валюте (еврооблигации) которым не присвоен рейтинг или он ниже нужного уровня", questions: [
                Question.createQuetion(text: "В случае, если Вы купили иностранную облигацию за 100 долларов США и продали ее через год за 110 долларов США, при этом курс доллара США за указанный год вырос с 50 до 75 рублей, Ваш налогооблагаемый доход в России составит:", answers: [
                    Answer.createAnswer(text: "10 долларов США", weight: 0),
                    Answer.createAnswer(text: "Ни один из ответов не является правильным", weight: 0),
                    Answer.createAnswer(text: "3 250 рублей", weight: 1),
                    Answer.createAnswer(text: "750 рублей", weight: 0)
                ]),
                Question.createQuetion(text: "Кредитный рейтинг компании, обеспечивающей (осуществляющей) исполнение обязательств (выплаты) по облигациям — это:", answers: [
                    Answer.createAnswer(text: "Свидетельство высокой надёжности и качества услуг компании, обеспечивающей (осуществляющей) исполнение обязательств (выплаты) по облигациям", weight: 0),
                    Answer.createAnswer(text: "Оценка кредитным рейтинговым агентством способности компании, обеспечивающей (осуществляющей) исполнение обязательств (выплаты) по облигациям, выполнять взятые на себя финансовые обязательства по этим облигациям", weight: 1),
                    Answer.createAnswer(text: "Заверение кредитного рейтингового агентства, что компания, обеспечивающая (осуществляющая) исполнение обязательств (выплаты) по облигациям, не допустит дефолта по этим облигациям в течение ближайших месяцев", weight: 0),
                    Answer.createAnswer(text: "Информация об уровне кредитной задолженности компании, обеспечивающей ей (осуществляющей) исполнение обязательств (выплаты) по облигациям", weight: 0)
                ]),
                Question.createQuetion(text: "Пожалуйста, выберите правильный ответ из следующих утверждений:", answers: [
                    Answer.createAnswer(text: "Чем выше цена облигаций, тем выше ликвидность облигаций", weight: 0),
                    Answer.createAnswer(text: "Как правило, чем ликвиднее облигация, тем меньше разница между ценами заявок на покупку и продажу (спред)", weight: 1),
                    Answer.createAnswer(text: "Покупка облигаций квалифицированными инвесторами повышает ликвидность облигаций", weight: 0),
                    Answer.createAnswer(text: "Наличие иных видов ценных бумаг у эмитента облигаций снижает ликвидность облигаций", weight: 0)
                ]),
                Question.createQuetion(text: "Если инвестор принимает решение продать принадлежащие ему низколиквидные облигации, как быстро он может это сделать?", answers: [
                    Answer.createAnswer(text: "Исключительно после обращения к представителю владельцев облигаций", weight: 0),
                    Answer.createAnswer(text: "Невозможно определить, поскольку заключить сделку можно только при условии, что найдется покупатель", weight: 1),
                    Answer.createAnswer(text: "Не ранее даты получения заключения о цене продажи от Экспертного совета по существенным рыночным отклонениям Банка России", weight: 0),
                    Answer.createAnswer(text: "Ни один из ответов не является  правильным", weight: 0)
                ])
            ])
        ]
        for task in tasks {
            try! realm.write { realm.add(task) }
        }
    }
}

class Question: Object {
    
    @Persisted var text: String = ""
    @Persisted var answers = List<Answer>()
    
    static func createQuetion(text: String, answers: [Answer]) -> Question {
        let question = Question()
        question.text = text
        for answer in answers {
            question.answers.append(answer)
        }
        return question
    }
}

class Answer: Object {
    
    @Persisted var text: String
    @Persisted var weight: Int
    
    static func createAnswer(text: String, weight: Int) -> Answer {
        let answer = Answer()
        answer.text = text
        answer.weight = weight
        return answer
    }
}
