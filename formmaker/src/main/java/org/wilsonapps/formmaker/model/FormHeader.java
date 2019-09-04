package org.wilsonapps.formmaker.model;

/**
 * Object for header of the form lists
 * Created by Wilson.
 */

public class FormHeader extends BaseFormWidget {

    public FormHeader() {
    }

    /**
     * static method to create instance with title
     * @param title
     * @return
     */
    public static FormHeader createInstance(String title) {
        FormHeader formHeader = new FormHeader();
        formHeader.setType(BaseFormWidget.TYPE_HEADER);
        formHeader.setTitle(title);
        return formHeader;
    }

}
