package org.wilsonapps.formmaker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wilson.
 */

public class FormWidgetPickerSingle extends BaseFormWidget {

    private String pickerTitle; // custom title for picker
    private List<String> mOptions; // list of options for single and multi picker
    private List<String> mOptionsSelected; // list of selected options for single and multi picker

    public FormWidgetPickerSingle() {
    }

    public static FormWidgetPickerSingle createInstance() {
        FormWidgetPickerSingle FormWidgetPickerSingle = new FormWidgetPickerSingle();
        FormWidgetPickerSingle.setType(BaseFormWidget.TYPE_PICKER_SINGLE);
        FormWidgetPickerSingle.setPickerTitle("Pick one");
        return FormWidgetPickerSingle;
    }

    public FormWidgetPickerSingle setTag(int mTag) {
        return (FormWidgetPickerSingle)  super.setTag(mTag);
    }

    public FormWidgetPickerSingle setType(int mType) {
        return (FormWidgetPickerSingle)  super.setType(mType);
    }

    public FormWidgetPickerSingle setTitle(String mTitle) {
        return (FormWidgetPickerSingle)  super.setTitle(mTitle);
    }

    public FormWidgetPickerSingle setValue(String mValue) {
        return (FormWidgetPickerSingle)  super.setValue(mValue);
    }

    public FormWidgetPickerSingle setHint(String mHint) {
        return (FormWidgetPickerSingle)  super.setHint(mHint);
    }

    public FormWidgetPickerSingle setRequired(boolean required) {
        return (FormWidgetPickerSingle)  super.setRequired(required);
    }

    // custom setters
    public FormWidgetPickerSingle setOptions(List<String> mOptions) {
        this.mOptions = mOptions;
        return this;
    }

    public FormWidgetPickerSingle setOptionsSelected(List<String> mOptionsSelected) {
        this.mOptionsSelected = mOptionsSelected;
        return this;
    }

    public FormWidgetPickerSingle setPickerTitle(String title) {
        this.pickerTitle = title;
        return this;
    }

    // custom getters
    public List<String> getOptions() {
        return (this.mOptions == null) ? new ArrayList<String>() : this.mOptions;
    }

    public List<String> getOptionsSelected() {
        return (this.mOptionsSelected == null) ? new ArrayList<String>() : this.mOptionsSelected;
    }

    public String getPickerTitle() {
        return this.pickerTitle;
    }

}
