package org.wilsonapps.formmaker.model;

/**
 * Created by Wilson.
 */

public class FormWidgetTextPhone extends BaseFormWidget {

    public FormWidgetTextPhone() {
    }

    public static FormWidgetTextPhone createInstance() {
        FormWidgetTextPhone FormWidgetTextPhone = new FormWidgetTextPhone();
        FormWidgetTextPhone.setType(BaseFormWidget.TYPE_EDITTEXT_PHONE);
        return FormWidgetTextPhone;
    }

    public FormWidgetTextPhone setTag(int mTag) {
        return (FormWidgetTextPhone)  super.setTag(mTag);
    }

    public FormWidgetTextPhone setType(int mType) {
        return (FormWidgetTextPhone)  super.setType(mType);
    }

    public FormWidgetTextPhone setTitle(String mTitle) {
        return (FormWidgetTextPhone)  super.setTitle(mTitle);
    }

    public FormWidgetTextPhone setValue(String mValue) {
        return (FormWidgetTextPhone)  super.setValue(mValue);
    }

    public FormWidgetTextPhone setHint(String mHint) {
        return (FormWidgetTextPhone)  super.setHint(mHint);
    }

    public FormWidgetTextPhone setRequired(boolean required) {
        return (FormWidgetTextPhone)  super.setRequired(required);
    }
    
}
