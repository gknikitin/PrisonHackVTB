//
//  TaskTableViewCell.swift
//  VTB_PrisonHack
//
//  Created by Ilya Buzyrev on 09.10.2021.
//

import UIKit

class TaskTableViewCell: UITableViewCell {

    @IBOutlet weak var titleLabel: UILabel!
    @IBOutlet weak var checkedImage: UIImageView!
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    func setupCell(title: String, completed: Bool) {
        titleLabel.text = title
        checkedImage.isHidden = !completed
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
}
