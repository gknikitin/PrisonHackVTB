//
//  ViewController.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 08.10.2021.
//

import UIKit
import RxSwift
import RxCocoa

class ViewController: UIViewController {

    @IBOutlet weak var rankLabel: UILabel!
    private let viewModel = MainScreenViewModel()
    private let disposeBag = DisposeBag()
    
    override func viewDidLoad() {
        super.viewDidLoad()
        addBindigs()
    }
    
    override func viewWillAppear(_ animated: Bool) {
        viewModel.getRank()
    }
    
    private func addBindigs() {
        viewModel.rank.observe(on: MainScheduler.instance)
            .subscribe { [weak self] rank in
                self?.rankLabel.text = rank
            }.disposed(by: disposeBag)

    }

    @IBAction func goToAbout(_ sender: Any) {
        let storyBoard: UIStoryboard = UIStoryboard(name: "Main", bundle: nil)
        guard let vc = storyBoard.instantiateViewController(withIdentifier: "aboutVC") as? AboutViewController else { return }
        navigationController?.pushViewController(vc, animated: true)
    }
    
    @IBAction func goToTaskList(_ sender: Any) {
        let storyBoard: UIStoryboard = UIStoryboard(name: "Main", bundle: nil)
        guard let vc = storyBoard.instantiateViewController(withIdentifier: "taskVC") as? TasksViewController else { return }
        navigationController?.pushViewController(vc, animated: true)
    }
}

