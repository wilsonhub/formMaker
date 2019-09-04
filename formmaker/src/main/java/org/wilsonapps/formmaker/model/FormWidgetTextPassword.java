package org.wilsonapps.formmaker.model;

/**
 * Created by Wilson.
 */

public class FormWidgetTextPassword extends BaseFormWidget {

    public FormWidgetTextPassword() {
    }

    public static FormWidgetTextPassword createInstance() {
        FormWidgetTextPassword FormWidgetTextPassword = new FormWidgetTextPassword();
        FormWidgetTextPassword.setType(BaseFormWidget.TYPE_EDITTEXT_PASSWORD);
        return FormWidgetTextPassword;
    }

    public FormWidgetTextPassword setTag(int mTag) {
        return (FormWidgetTextPassword)  super.setTag(mTag);
    }

    public FormWidgetTextPassword setType(int mType) {
        return (FormWidgetTextPassword)  super.setType(mType);
    }

    public FormWidgetTextPassword setTitle(String mTitle) {
        return (FormWidgetTextPassword)  super.setTitle(mTitle);
    }

    public FormWidgetTextPassword setValue(String mValue) {
        return (FormWidgetTextPassword)  super.setValue(mValue);
    }

    public FormWidgetTextPassword setHint(String mHint) {
        return (FormWidgetTextPassword)  super.setHint(mHint);
    }

    public FormWidgetTextPassword setRequired(boolean required) {
        return (FormWidgetTextPassword)  super.setRequired(required);
    }
    
}
