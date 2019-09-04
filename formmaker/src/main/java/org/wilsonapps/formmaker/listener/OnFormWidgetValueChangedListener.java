package org.wilsonapps.formmaker.listener;


import org.wilsonapps.formmaker.model.BaseFormWidget;

/**
 * Callback to activity when any data in form adapter is changed
 */

public interface OnFormWidgetValueChangedListener {

    void onValueChanged(BaseFormWidget baseFormWidget);

}