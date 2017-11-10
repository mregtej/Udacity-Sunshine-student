package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

/**
 * Created by uidq4441 on 10.11.2017.
 */

public class SettingsFragment extends PreferenceFragmentCompat implements
        SharedPreferences.OnSharedPreferenceChangeListener{

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.settings);

        PreferenceScreen preferenceScreen = getPreferenceScreen();
        for(int index = 0; index < preferenceScreen.getPreferenceCount(); index++) {
            Preference p = preferenceScreen.getPreference(index);
            // Identify all non CheckBoxPreferences
            // Different setSummary handling
            if(!(p instanceof CheckBoxPreference)) {
                // Get current value of ListPreference (by key)
                String value = getPreferenceManager().getSharedPreferences().getString(p.getKey(),"");
                // Set value as summary
                setPreferenceSummary(p, value);
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void setPreferenceSummary(Preference p, String value) {
        // Special summary-handling for ListPreferences
        if(p instanceof ListPreference) {
            // Get index from current value
            ListPreference lp = (ListPreference) p;
            int index = lp.findIndexOfValue(value);
            // Find entry by index (from entry-array) and set it as summary
            if(index >= 0) {
                lp.setSummary(lp.getEntries()[index]);
            }
        }
        // Special summary-handling for EditTextPreferences
        if(p instanceof EditTextPreference) {
            p.setSummary(value);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        // Find preference by key
        Preference p = findPreference(key);
        // Special summary-handling for non CheckBoxPreferences
        if(!(p instanceof CheckBoxPreference)) {
            String value = sharedPreferences.getString(key,"");
            setPreferenceSummary(p, value);
        }
    }

}
