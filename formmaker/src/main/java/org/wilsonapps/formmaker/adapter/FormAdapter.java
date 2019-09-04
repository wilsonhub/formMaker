package org.wilsonapps.formmaker.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.recyclerview.widget.RecyclerView;

import org.wilsonapps.formmaker.R;
import org.wilsonapps.formmaker.listener.FormItemEditTextListener;
import org.wilsonapps.formmaker.listener.OnFormWidgetValueChangedListener;
import org.wilsonapps.formmaker.listener.ReloadListener;
import org.wilsonapps.formmaker.model.BaseFormWidget;
import org.wilsonapps.formmaker.viewholder.BaseViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetHeader;
import org.wilsonapps.formmaker.viewholder.FormWidgetPickerDateViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetPickerMultiViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetPickerSingleViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetPickerTimeViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetSwitchViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetTextEmailViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetTextMultiLineViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetTextNumberViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetTextPasswordViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetTextPhoneViewHolder;
import org.wilsonapps.formmaker.viewholder.FormWidgetTextSingleLineViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * The adapter the holds and displays the form objects
 * Created by Wilson.
 */

public class FormAdapter extends RecyclerView.Adapter<BaseViewHolder> implements ReloadListener {

    private Context mContext;
    private List<BaseFormWidget> mDataset;
    private OnFormWidgetValueChangedListener mListener;

    /**
     * public constructor with context
     * @param context
     */
    public FormAdapter(Context context, OnFormWidgetValueChangedListener listener) {
        mContext = context;
        mListener = listener;
        mDataset = new ArrayList<>();
    }

    /**
     * adds list of elements to be shown
     * @param formObjects
     */
    public void addElements(List<BaseFormWidget> formObjects) {
        this.mDataset = formObjects;
        notifyDataSetChanged();
    }

    /**
     * adds single element to be shown
     * @param formObject
     */
    public void addElement(BaseFormWidget formObject) {
        this.mDataset.add(formObject);
        notifyDataSetChanged();
    }

    /**
     * set value for any unique index
     * @param position
     * @param value
     */
    public void setValueAtIndex(int position, String value) {
        BaseFormWidget baseFormWidget = mDataset.get(position);
        baseFormWidget.setValue(value);
        notifyDataSetChanged();
    }

    /**
     * set value for any unique tag
     * @param tag
     * @param value
     */
    public void setValueAtTag(int tag, String value) {
        for (BaseFormWidget f : this.mDataset) {
            if (f.getTag() == tag) {
                f.setValue(value);
                return;
            }
        }
        notifyDataSetChanged();
    }

    /**
     * get value of any element by tag
     * @param index
     * @return
     */
    public BaseFormWidget getValueAtIndex(int index) {
        return (mDataset.get(index));
    }

    /**
     * get value of any element by tag
     * @param tag
     * @return
     */
    public BaseFormWidget getValueAtTag(int tag) {
        for (BaseFormWidget f : this.mDataset) {
            if (f.getTag() == tag) {
                return f;
            }
        }

        return null;
    }

    /**
     * get whole dataset
     * @return
     */
    public List<BaseFormWidget> getDataset() {
        return mDataset;
    }

    /**
     * get value changed listener
     * @return
     */
    public OnFormWidgetValueChangedListener getValueChangeListener() {
        return mListener;
    }

    /**
     * gets total item count
     * @return
     */
    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    /**
     * gets view item type based on header, or the form element type
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return mDataset.get(position).getType();
    }

    /**
     * creating the view holder to be shown for a position
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // get layout based on header or element type
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v;
        switch (viewType) {
            case BaseFormWidget.TYPE_HEADER:
                v = inflater.inflate(R.layout.form_widget_header, parent, false);
                return new FormWidgetHeader(v);
            case BaseFormWidget.TYPE_EDITTEXT_TEXT_SINGLELINE:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetTextSingleLineViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormWidget.TYPE_EDITTEXT_TEXT_MULTILINE:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetTextMultiLineViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormWidget.TYPE_EDITTEXT_NUMBER:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetTextNumberViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormWidget.TYPE_EDITTEXT_EMAIL:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetTextEmailViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormWidget.TYPE_EDITTEXT_PHONE:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetTextPhoneViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormWidget.TYPE_EDITTEXT_PASSWORD:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetTextPasswordViewHolder(v, new FormItemEditTextListener(this));
            case BaseFormWidget.TYPE_PICKER_DATE:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetPickerDateViewHolder(v, mContext, this);
            case BaseFormWidget.TYPE_PICKER_TIME:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetPickerTimeViewHolder(v, mContext, this);
            case BaseFormWidget.TYPE_PICKER_SINGLE:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetPickerSingleViewHolder(v, mContext, this);
            case BaseFormWidget.TYPE_PICKER_MULTI:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetPickerMultiViewHolder(v, mContext, this);
            case BaseFormWidget.TYPE_SWITCH:
                v = inflater.inflate(R.layout.form_widget_switch, parent, false);
                return new FormWidgetSwitchViewHolder(v, mContext, this);
            default:
                v = inflater.inflate(R.layout.form_widget, parent, false);
                return new FormWidgetTextSingleLineViewHolder(v, new FormItemEditTextListener(this));
        }
    }

    /**
     * draws the view for the position specific view holder
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(BaseViewHolder holder, final int position) {

        // updates edit text listener index
        if (holder.getListener() != null) {
            holder.getListener().updatePosition(holder.getAdapterPosition());
        }

        // gets current object
        BaseFormWidget currentObject = mDataset.get(position);
        holder.bind(position, currentObject, mContext);
    }

    /**
     * use the listener to update value and notify dataset changes to adapter
     * @param position
     * @param updatedValue
     */
    @Override
    public void updateValue(int position, String updatedValue) {
        mDataset.get(position).setValue(updatedValue);
        notifyDataSetChanged();
        if (mListener != null)
            mListener.onValueChanged(mDataset.get(position));
    }

}