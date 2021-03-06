package com.superhero.test.common

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import test.databinding.FragmentModalErrorBinding


abstract class CustomModalBaseFragment : DialogFragment() {
    @get:StringRes
    abstract val dialogTittle: Int

    @get:StringRes
    abstract val dialogMessage: Int

    open val dialogUserMessage: String? = null

    @get:DrawableRes
    abstract val dialogIcon: Int

    @get:StringRes
    abstract val dialogButtonText: Int

    private lateinit var binding: FragmentModalErrorBinding

    var onCloseButton: (() -> Unit)? = null
    var onBackToHomeButton: (() -> Unit)? = null
    var onDismissDialog: (() -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? = initViewBinding(layoutInflater)

    private fun initViewBinding(layoutInflater: LayoutInflater): View {
        binding = FragmentModalErrorBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            textTitle.text = getFormattedTitle() ?: getString(dialogTittle)
            textMessageContent.text = getFormattedMessage() ?: getString(dialogMessage)
            dialogUserMessage?.let { buttonGoHome.visibility = View.GONE }
            buttonGoHome.text = getString(dialogButtonText)
            errorIcon.setImageResource(dialogIcon)

            buttonGoHome.setOnClickListener {
                onBackToHomeButton?.invoke()
            }

            closeButton.setOnClickListener {
                onCloseButton?.invoke()
            }
        }
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        onDismissDialog?.invoke()
    }

    open fun getFormattedTitle(): String? = null
    open fun getFormattedMessage(): String? = dialogUserMessage
}