//
//  AboutViewController.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 08.10.2021.
//

import UIKit

class AboutViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()

        // Do any additional setup after loading the view.
    }
    

    @IBAction func more(_ sender: Any) {
        guard let url = URL(string: "https://apps.apple.com/ru/app/%D0%B2%D1%82%D0%B1-%D0%BC%D0%BE%D0%B8-%D0%B8%D0%BD%D0%B2%D0%B5%D1%81%D1%82%D0%B8%D1%86%D0%B8%D0%B8/id1364026756") else { return }
        UIApplication.shared.open(url)
    }
    @IBAction func goBack(_ sender: Any) {
        navigationController?.popToRootViewController(animated: true)
    }
    
    @IBAction func goToCite(_ sender: Any) {
        guard let url = URL(string: "https://broker.vtb.ru/login/vtbinvest/") else { return }
        UIApplication.shared.open(url)
    }
    @IBAction func goToSchool(_ sender: Any) {
        guard let url = URL(string: "https://school.vtb.ru/") else { return }
        UIApplication.shared.open(url)
    }
}
