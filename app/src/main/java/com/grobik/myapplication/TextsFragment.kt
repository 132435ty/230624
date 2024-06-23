package com.grobik.myapplication
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
class TextsFragment : Fragment() {
    private lateinit var textList: MutableList<TextView>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_texts, container, false)

        textList = mutableListOf()
        val layout = view.findViewById<ViewGroup>(R.id.text_layout)

        for (i in 1..100) {
            val textView = TextView(context)
            textView.text = "Text $i"
            textList.add(textView)
            layout.addView(textView)
        }

        return view
    }
}