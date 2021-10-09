//
//  TasksViewModel.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 09.10.2021.
//

import Foundation
import RxSwift

class TasksViewModel {
    
    public let rank: PublishSubject<String> = PublishSubject()
    
    
    public func getRank() {
        let currRank: Int
        if let rank = UserSettings.userRank {
            currRank = rank
        } else {
            currRank = 0
            UserSettings.userRank = 0
        }
        switch currRank {
        case 0:
            rank.onNext("Новичок в инвестициях")
        case 1:
            rank.onNext("Начинающий инвестор")
        case 2:
            rank.onNext("Хороший знаток инвестиций")
        default:
            rank.onNext("Профи")
        }
    }
    
    public func getTasks() -> [Task] {
        Task.readTasks()
    }
    
}
