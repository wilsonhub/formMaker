package org.wilsonapps.formmaker.model;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Wilson.
 */

public class FormWidgetPickerTime extends BaseFormWidget {

    private String timeFormat; // custom format for date

    public FormWidgetPickerTime() {
    }

    public static FormWidgetPickerTime createInstance() {
        FormWidgetPickerTime FormWidgetPickerTime = new FormWidgetPickerTime();
        FormWidgetPickerTime.setType(BaseFormWidget.TYPE_PICKER_TIME);
        FormWidgetPickerTime.setTimeFormat("KK:mm a");
        return FormWidgetPickerTime;
    }

    public FormWidgetPickerTime setTag(int mTag) {
        return (FormWidgetPickerTime)  super.setTag(mTag);
    }

    public FormWidgetPickerTime setType(int mType) {
        return (FormWidgetPickerTime)  super.setType(mType);
    }

    public FormWidgetPickerTime setTitle(String mTitle) {
        return (FormWidgetPickerTime)  super.setTitle(mTitle);
    }

    public FormWidgetPickerTime setValue(String mValue) {
        return (FormWidgetPickerTime)  super.setValue(mValue);
    }

    public FormWidgetPickerTime setHint(String mHint) {
        return (FormWidgetPickerTime)  super.setHint(mHint);
    }

    public FormWidgetPickerTime setRequired(boolean required) {
        return (FormWidgetPickerTime)  super.setRequired(required);
    }

    // custom setter
    public FormWidgetPickerTime setTimeFormat(String format) {
        checkValidTimeFormat(format);
        this.timeFormat = format;
        return this;
    }

    // custom getter
    public String getTimeFormat() {
        return this.timeFormat;
    }

    private void checkValidTimeFormat(String format) {
        try {
            new SimpleDateFormat(format, Locale.US);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Time format is not correct: " + e.getMessage());
        }
    }

}
