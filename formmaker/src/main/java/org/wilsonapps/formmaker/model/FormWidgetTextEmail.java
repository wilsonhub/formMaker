package org.wilsonapps.formmaker.model;

/**
 * Created by Wilson.
 */

public class FormWidgetTextEmail extends BaseFormWidget {

    public FormWidgetTextEmail() {
    }

    public static FormWidgetTextEmail createInstance() {
        FormWidgetTextEmail FormWidgetTextEmail = new FormWidgetTextEmail();
        FormWidgetTextEmail.setType(BaseFormWidget.TYPE_EDITTEXT_EMAIL);
        return FormWidgetTextEmail;
    }

    public FormWidgetTextEmail setTag(int mTag) {
        return (FormWidgetTextEmail)  super.setTag(mTag);
    }

    public FormWidgetTextEmail setType(int mType) {
        return (FormWidgetTextEmail)  super.setType(mType);
    }

    public FormWidgetTextEmail setTitle(String mTitle) {
        return (FormWidgetTextEmail)  super.setTitle(mTitle);
    }

    public FormWidgetTextEmail setValue(String mValue) {
        return (FormWidgetTextEmail)  super.setValue(mValue);
    }

    public FormWidgetTextEmail setHint(String mHint) {
        return (FormWidgetTextEmail)  super.setHint(mHint);
    }

    public FormWidgetTextEmail setRequired(boolean required) {
        return (FormWidgetTextEmail)  super.setRequired(required);
    }

}
