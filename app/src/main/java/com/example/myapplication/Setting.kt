package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceFragmentCompat

class Setting : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        // res/xml/preferences.xml ファイルに従って設定画面を構成
        setPreferencesFromResource(R.xml.setting, rootKey)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view=super.onCreateView(inflater, container, savedInstanceState)
        view?.setBackgroundColor(Color.parseColor("#F0F0F3"))
        return view
    }
}