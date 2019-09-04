package org.wilsonapps.formmaker.listener;

import android.text.Editable;
import android.text.TextWatcher;

import org.wilsonapps.formmaker.adapter.FormAdapter;
import org.wilsonapps.formmaker.model.BaseFormWidget;

/**
 * Edit text listener for form element edit texts
 * Created by Wilson.
 */

public class FormItemEditTextListener implements TextWatcher {

    private int position;
    private FormAdapter formAdapter;

    public FormItemEditTextListener(FormAdapter formAdapter) {
        this.formAdapter = formAdapter;
    }

    public void updatePosition(int position) {
        this.position = position;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        // get current form element, existing value and new value
        BaseFormWidget baseFormWidget = formAdapter.getDataset().get(position);
        String currentValue = baseFormWidget.getValue();
        String newValue = charSequence.toString();

        // trigger event only if the value is changed
        if (!currentValue.equals(newValue)) {
            baseFormWidget.setValue(newValue);
            if (formAdapter.getValueChangeListener() != null)
                formAdapter.getValueChangeListener().onValueChanged(baseFormWidget);
        }

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
