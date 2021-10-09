//
//  TestViewController.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 09.10.2021.
//

import UIKit
import RxSwift

class TestViewController: UIViewController {
    
    @IBOutlet weak var questionLabel: UILabel!
    @IBOutlet weak var resultLabel: UILabel!
    @IBOutlet weak var firstValueTitle: UILabel!
    @IBOutlet weak var secondValueTitle: UILabel!
    @IBOutlet weak var thirdValueTitle: UILabel!
    @IBOutlet weak var fourthValueTitle: UILabel!
    
    
    public let viewModel = TestViewModel()
    private let disposeBag = DisposeBag()
    private var firstValue = 0
    private var secondValue = 0
    private var thirdValue = 0
    private var fourthValue = 0
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        addBindings()
        viewModel.setQuestion()
        addTapRecognizers()
        resultLabel.isHidden = true
    }
    
    private func addBindings() {
        viewModel.currentQuestion.observe(on: MainScheduler.instance)
            .subscribe { [weak self] question in
                let question = question.element
                self?.questionLabel.text = question?.text
                self?.firstValueTitle.text = question?.answers[0].text
                self?.secondValueTitle.text = question?.answers[1].text
                self?.thirdValueTitle.text = question?.answers[2].text
                self?.fourthValueTitle.text = question?.answers[3].text
                self?.firstValue = question!.answers[0].weight
                self?.secondValue = question!.answers[1].weight
                self?.thirdValue = question!.answers[2].weight
                self?.fourthValue = question!.answers[3].weight
                
            }.disposed(by: disposeBag)
        viewModel.result.observe(on: MainScheduler.instance)
            .subscribe { [weak self] message in
                self?.firstValueTitle.isHidden = true
                self?.secondValueTitle.isHidden = true
                self?.thirdValueTitle.isHidden = true
                self?.fourthValueTitle.isHidden = true
                self?.resultLabel.isHidden = false
                self?.resultLabel.text = message.element
            }.disposed(by: disposeBag)
    }
    
    private func addTapRecognizers() {
        let tapFirstRecognizer = UITapGestureRecognizer(target: self, action: #selector(tapFirst))
        let tapSecondRecognizer = UITapGestureRecognizer(target: self, action: #selector(tapSecond))
        let tapThirdRecognizer = UITapGestureRecognizer(target: self, action: #selector(tapThird))
        let tapFourthRecognizer = UITapGestureRecognizer(target: self, action: #selector(tapFourth))
        firstValueTitle.addGestureRecognizer(tapFirstRecognizer)
        firstValueTitle.isUserInteractionEnabled = true
        secondValueTitle.addGestureRecognizer(tapSecondRecognizer)
        secondValueTitle.isUserInteractionEnabled = true
        thirdValueTitle.addGestureRecognizer(tapThirdRecognizer)
        thirdValueTitle.isUserInteractionEnabled = true
        fourthValueTitle.addGestureRecognizer(tapFourthRecognizer)
        fourthValueTitle.isUserInteractionEnabled = true
    }
    
    @IBAction func goBack(_ sender: Any) {
        navigationController?.popViewController(animated: true)
    }

    
    @objc func tapFirst() {
        viewModel.addPoint(point: firstValue)
    }
    
    @objc func tapSecond() {
        viewModel.addPoint(point: secondValue)
    }
    
    @objc func tapThird() {
        viewModel.addPoint(point: thirdValue)
    }
    
    @objc func tapFourth() {
        viewModel.addPoint(point: fourthValue)
    }
    
}
