//
//  TasksViewController.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 08.10.2021.
//

import UIKit
import RxSwift
import RxCocoa

class TasksViewController: UIViewController {
    
    @IBOutlet weak var rankLabel: UILabel!
    @IBOutlet weak var tasksTable: UITableView!
    let viewModel = TasksViewModel()
    private let disposeBag = DisposeBag()
    var tasks = [Task]()

    override func viewDidLoad() {
        super.viewDidLoad()
        addBindings()
        tasksTable.register(UINib(nibName: "TaskTableViewCell", bundle: nil), forCellReuseIdentifier: "TaskTableViewCell")
    }
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
        tasks = Task.readTasks()
        tasksTable.reloadData()
    }
    
    private func addBindings() {
        viewModel.rank.observe(on: MainScheduler.instance)
            .subscribe { [weak self] rank in
                self?.rankLabel.text = rank
            }.disposed(by: disposeBag)
    }
    @IBAction func goBack(_ sender: Any) {
        navigationController?.popToRootViewController(animated: true)
    }
    
}

extension TasksViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return tasks.count
    }

    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tasksTable.dequeueReusableCell(withIdentifier: "TaskTableViewCell") as! TaskTableViewCell
        let task = tasks[indexPath.row]
        cell.setupCell(title: task.title, completed: task.completed)
        return cell
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        150
    }

    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let task = tasks[indexPath.row]
        let storyBoard: UIStoryboard = UIStoryboard(name: "Main", bundle: nil)
        guard let vc = storyBoard.instantiateViewController(withIdentifier: "testVC") as? TestViewController else { return }
        vc.viewModel.setQuestions(task: task)
        navigationController?.pushViewController(vc, animated: true)
    }

}
