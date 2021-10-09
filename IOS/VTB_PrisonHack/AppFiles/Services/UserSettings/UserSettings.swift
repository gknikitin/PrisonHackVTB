//
//  UserSettings.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 08.10.2021.
//

import Foundation

final class UserSettings {
    
    static var userRank: Int! {
        get {
            return UserDefaults.standard.integer(forKey: "rank")
        } set {
            let defaults = UserDefaults.standard
            let key = "rank"
            if let rank = newValue {
                defaults.set(rank, forKey: key)
            } else {
                defaults.removeObject(forKey: key)
            }
        }
    }
    
    static var firstLaunch: Bool! {
        get {
            return UserDefaults.standard.bool(forKey: "firstLaunch")
        } set {
            let defaults = UserDefaults.standard
            let key = "firstLaunch"
            if let firstLaunch = newValue {
                defaults.set(firstLaunch, forKey: key)
            } else {
                defaults.removeObject(forKey: key)
            }
        }
    }
}
