package org.wilsonapps.formmaker.model;

/**
 * Created by Wilson.
 */

public class FormWidgetTextSingleLine extends BaseFormWidget {

    public FormWidgetTextSingleLine() {
    }

    public static FormWidgetTextSingleLine createInstance() {
        FormWidgetTextSingleLine FormWidgetTextSingleLine = new FormWidgetTextSingleLine();
        FormWidgetTextSingleLine.setType(BaseFormWidget.TYPE_EDITTEXT_TEXT_SINGLELINE);
        return FormWidgetTextSingleLine;
    }

    public FormWidgetTextSingleLine setTag(int mTag) {
        return (FormWidgetTextSingleLine)  super.setTag(mTag);
    }

    public FormWidgetTextSingleLine setType(int mType) {
        return (FormWidgetTextSingleLine)  super.setType(mType);
    }

    public FormWidgetTextSingleLine setTitle(String mTitle) {
        return (FormWidgetTextSingleLine)  super.setTitle(mTitle);
    }

    public FormWidgetTextSingleLine setValue(String mValue) {
        return (FormWidgetTextSingleLine)  super.setValue(mValue);
    }

    public FormWidgetTextSingleLine setHint(String mHint) {
        return (FormWidgetTextSingleLine)  super.setHint(mHint);
    }

    public FormWidgetTextSingleLine setRequired(boolean required) {
        return (FormWidgetTextSingleLine)  super.setRequired(required);
    }

}
