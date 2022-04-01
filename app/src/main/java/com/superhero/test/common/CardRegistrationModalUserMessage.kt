package com.superhero.test.common

import test.R

class CardRegistrationModalUserMessage(title: Int, message: String) : CustomModalBaseFragment() {
    override val dialogTittle = title
    override val dialogUserMessage = message
    override val dialogMessage: Int
        get() = R.string.modal_error_tittle
    override val dialogIcon: Int
        get() = R.drawable.ic_cancel_black_24dp
    override val dialogButtonText: Int
        get() = R.string.register_number_error_dialog_button
}