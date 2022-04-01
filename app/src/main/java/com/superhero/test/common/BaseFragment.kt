package com.superhero.test.common

import androidx.fragment.app.Fragment


open class BaseFragment : Fragment() {

    var progressDialogFragment: CustomProgressDialog? = null
    private var cardRegistrationModal: CardRegistrationModalUserMessage? = null

    open fun onLoadingDialog(title: String, message: String) {
        progressDialogFragment = CustomProgressDialog.newInstance(title, message)
        progressDialogFragment?.show(childFragmentManager, "dialog")
    }

    open fun hideLoadingDialog() {
        progressDialogFragment?.dismiss()
    }

    open fun onErrorDialogUserMessage(title: Int, message: String) {
        cardRegistrationModal = CardRegistrationModalUserMessage(title, message)
        cardRegistrationModal?.show(parentFragmentManager, "Error")
        cardRegistrationModal?.onBackToHomeButton = {
            cardRegistrationModal?.dismiss()
        }
        cardRegistrationModal?.onCloseButton = {
            cardRegistrationModal?.dismiss()
        }
    }

}