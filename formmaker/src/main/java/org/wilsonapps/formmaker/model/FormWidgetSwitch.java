package org.wilsonapps.formmaker.model;

/**
 * Created by Wilson.
 */

public class FormWidgetSwitch extends BaseFormWidget {

    private String positiveText; // text for right side
    private String negativeText; // text for left side

    public FormWidgetSwitch() {
    }

    public static FormWidgetSwitch createInstance() {
        FormWidgetSwitch FormWidgetSwitch = new FormWidgetSwitch();
        FormWidgetSwitch.setType(BaseFormWidget.TYPE_SWITCH);
        return FormWidgetSwitch;
    }

    public FormWidgetSwitch setTag(int mTag) {
        return (FormWidgetSwitch)  super.setTag(mTag);
    }

    public FormWidgetSwitch setType(int mType) {
        return (FormWidgetSwitch)  super.setType(mType);
    }

    public FormWidgetSwitch setTitle(String mTitle) {
        return (FormWidgetSwitch)  super.setTitle(mTitle);
    }

    public FormWidgetSwitch setValue(String mValue) {
        return (FormWidgetSwitch)  super.setValue(mValue);
    }

    public FormWidgetSwitch setHint(String mHint) {
        return (FormWidgetSwitch)  super.setHint(mHint);
    }

    public FormWidgetSwitch setRequired(boolean required) {
        return (FormWidgetSwitch)  super.setRequired(required);
    }

    // custom setters
    public FormWidgetSwitch setSwitchTexts(String positiveText, String negativeText) {
        this.positiveText = positiveText;
        this.negativeText = negativeText;
        return this;
    }

    // custom getters
    public String getPositiveText() {
        return this.positiveText;
    }

    public String getNegativeText() {
        return this.negativeText;
    }

}
