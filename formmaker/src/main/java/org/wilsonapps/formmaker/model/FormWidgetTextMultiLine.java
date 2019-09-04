package org.wilsonapps.formmaker.model;

/**
 * Created by Wilson.
 */

public class FormWidgetTextMultiLine extends BaseFormWidget {

    public FormWidgetTextMultiLine() {
    }

    public static FormWidgetTextMultiLine createInstance() {
        FormWidgetTextMultiLine FormWidgetTextMultiLine = new FormWidgetTextMultiLine();
        FormWidgetTextMultiLine.setType(BaseFormWidget.TYPE_EDITTEXT_TEXT_MULTILINE);
        return FormWidgetTextMultiLine;
    }

    public FormWidgetTextMultiLine setTag(int mTag) {
        return (FormWidgetTextMultiLine)  super.setTag(mTag);
    }

    public FormWidgetTextMultiLine setType(int mType) {
        return (FormWidgetTextMultiLine)  super.setType(mType);
    }

    public FormWidgetTextMultiLine setTitle(String mTitle) {
        return (FormWidgetTextMultiLine)  super.setTitle(mTitle);
    }

    public FormWidgetTextMultiLine setValue(String mValue) {
        return (FormWidgetTextMultiLine)  super.setValue(mValue);
    }

    public FormWidgetTextMultiLine setHint(String mHint) {
        return (FormWidgetTextMultiLine)  super.setHint(mHint);
    }

    public FormWidgetTextMultiLine setRequired(boolean required) {
        return (FormWidgetTextMultiLine)  super.setRequired(required);
    }

}
