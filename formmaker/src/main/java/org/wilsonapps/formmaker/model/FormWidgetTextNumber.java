package org.wilsonapps.formmaker.model;

/**
 * Created by Wilson.
 */

public class FormWidgetTextNumber extends BaseFormWidget {

    public FormWidgetTextNumber() {
    }

    public static FormWidgetTextNumber createInstance() {
        FormWidgetTextNumber FormWidgetTextNumber = new FormWidgetTextNumber();
        FormWidgetTextNumber.setType(BaseFormWidget.TYPE_EDITTEXT_NUMBER);
        return FormWidgetTextNumber;
    }

    public FormWidgetTextNumber setTag(int mTag) {
        return (FormWidgetTextNumber)  super.setTag(mTag);
    }

    public FormWidgetTextNumber setType(int mType) {
        return (FormWidgetTextNumber)  super.setType(mType);
    }

    public FormWidgetTextNumber setTitle(String mTitle) {
        return (FormWidgetTextNumber)  super.setTitle(mTitle);
    }

    public FormWidgetTextNumber setValue(String mValue) {
        return (FormWidgetTextNumber)  super.setValue(mValue);
    }

    public FormWidgetTextNumber setHint(String mHint) {
        return (FormWidgetTextNumber)  super.setHint(mHint);
    }

    public FormWidgetTextNumber setRequired(boolean required) {
        return (FormWidgetTextNumber)  super.setRequired(required);
    }
    
}
