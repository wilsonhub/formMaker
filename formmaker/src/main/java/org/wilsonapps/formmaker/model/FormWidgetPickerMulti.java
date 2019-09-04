package org.wilsonapps.formmaker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilson.
 */

public class FormWidgetPickerMulti extends BaseFormWidget {

    private String pickerTitle; // custom title for picker
    private List<String> options; // list of options for single and multi picker
    private List<String> optionsSelected; // list of selected options for single and multi picker
    private String positiveText = "Ok"; // text for positive operation, like "ok"
    private String negativeText = "Cancel"; // text for negative operation, like "cancel"

    public FormWidgetPickerMulti() {
    }

    public static FormWidgetPickerMulti createInstance() {
        FormWidgetPickerMulti FormWidgetPickerMulti = new FormWidgetPickerMulti();
        FormWidgetPickerMulti.setType(BaseFormWidget.TYPE_PICKER_MULTI);
        return FormWidgetPickerMulti;
    }

    public FormWidgetPickerMulti setTag(int mTag) {
        return (FormWidgetPickerMulti)  super.setTag(mTag);
    }

    public FormWidgetPickerMulti setType(int mType) {
        return (FormWidgetPickerMulti)  super.setType(mType);
    }

    public FormWidgetPickerMulti setTitle(String mTitle) {
        return (FormWidgetPickerMulti)  super.setTitle(mTitle);
    }

    public FormWidgetPickerMulti setValue(String mValue) {
        return (FormWidgetPickerMulti)  super.setValue(mValue);
    }

    public FormWidgetPickerMulti setHint(String mHint) {
        return (FormWidgetPickerMulti)  super.setHint(mHint);
    }

    public FormWidgetPickerMulti setRequired(boolean required) {
        return (FormWidgetPickerMulti)  super.setRequired(required);
    }

    // custom setters
    public FormWidgetPickerMulti setOptions(List<String> mOptions) {
        this.options = mOptions;
        return this;
    }

    public FormWidgetPickerMulti setOptionsSelected(List<String> mOptionsSelected) {
        this.optionsSelected = mOptionsSelected;
        return this;
    }

    public FormWidgetPickerMulti setPickerTitle(String title) {
        this.pickerTitle = title;
        return this;
    }

    // custom getters
    public List<String> getOptions() {
        return (this.options == null) ? new ArrayList<String>() : this.options;
    }

    public List<String> getOptionsSelected() {
        return (this.optionsSelected == null) ? new ArrayList<String>() : this.optionsSelected;
    }

    public FormWidgetPickerMulti setPositiveText(String positiveText) {
        this.positiveText = positiveText;
        return this;
    }

    public FormWidgetPickerMulti setNegativeText(String negativeText) {
        this.negativeText = negativeText;
        return this;
    }

    // custom getters
    public String getPickerTitle() {
        return this.pickerTitle;
    }

    public String getPositiveText() {
        return this.positiveText;
    }

    public String getNegativeText() {
        return this.negativeText;
    }

}
