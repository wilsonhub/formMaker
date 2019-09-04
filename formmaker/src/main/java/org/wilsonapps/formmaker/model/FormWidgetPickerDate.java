package org.wilsonapps.formmaker.model;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Created by Wilson.
 */

public class FormWidgetPickerDate extends BaseFormWidget {

    private String dateFormat; // custom format for date

    public FormWidgetPickerDate() {
    }

    public static FormWidgetPickerDate createInstance() {
        FormWidgetPickerDate FormWidgetPickerDate = new FormWidgetPickerDate();
        FormWidgetPickerDate.setType(BaseFormWidget.TYPE_PICKER_DATE);
        FormWidgetPickerDate.setDateFormat("dd/MM/yy");
        return FormWidgetPickerDate;
    }

    public FormWidgetPickerDate setTag(int mTag) {
        return (FormWidgetPickerDate)  super.setTag(mTag);
    }

    public FormWidgetPickerDate setType(int mType) {
        return (FormWidgetPickerDate)  super.setType(mType);
    }

    public FormWidgetPickerDate setTitle(String mTitle) {
        return (FormWidgetPickerDate)  super.setTitle(mTitle);
    }

    public FormWidgetPickerDate setValue(String mValue) {
        return (FormWidgetPickerDate)  super.setValue(mValue);
    }

    public FormWidgetPickerDate setHint(String mHint) {
        return (FormWidgetPickerDate)  super.setHint(mHint);
    }

    public FormWidgetPickerDate setRequired(boolean required) {
        return (FormWidgetPickerDate)  super.setRequired(required);
    }

    // custom setter
    public FormWidgetPickerDate setDateFormat(String format) {
        checkValidDateFormat(format);
        this.dateFormat = format;
        return this;
    }

    // custom getter
    public String getDateFormat() {
        return this.dateFormat;
    }

    private void checkValidDateFormat(String format) {
        try {
            new SimpleDateFormat(format, Locale.US);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Date format is not correct: " + e.getMessage());
        }
    }
    
}
