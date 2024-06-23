package com.grobik.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class ButtonsFragment : Fragment() {
    private lateinit var buttonList: MutableList<Button>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_buttons, container, false)

        buttonList = mutableListOf()
        val layout = view.findViewById<ViewGroup>(R.id.button_layout)

        for (i in 1..100) {
            val button = Button(context)
            button.text = "Button $i"
            buttonList.add(button)
            layout.addView(button)
        }

        return view
    }
}