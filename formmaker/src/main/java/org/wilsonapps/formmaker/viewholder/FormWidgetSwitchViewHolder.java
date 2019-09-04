package org.wilsonapps.formmaker.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;

import org.wilsonapps.formmaker.R;
import org.wilsonapps.formmaker.listener.ReloadListener;
import org.wilsonapps.formmaker.model.BaseFormWidget;
import org.wilsonapps.formmaker.model.FormWidgetSwitch;

/**
 * Created by Wilson.
 */

public class FormWidgetSwitchViewHolder extends BaseViewHolder {

    public AppCompatTextView mTextViewTitle, mTextViewPositive, mTextViewNegative;
    public SwitchCompat mSwitch;
    private ReloadListener mReloadListener;
    private BaseFormWidget mFormWidget;
    private FormWidgetSwitch mFormWidgetSwitch;
    private int mPosition;

    public FormWidgetSwitchViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.FormWidgetTitle);
        mTextViewPositive = (AppCompatTextView) v.findViewById(R.id.FormWidgetPositiveText);
        mTextViewNegative = (AppCompatTextView) v.findViewById(R.id.FormWidgetNegativeText);
        mSwitch = (SwitchCompat) v.findViewById(R.id.FormWidgetSwitch);
        mReloadListener = reloadListener;
    }

    @Override
    public void bind(final int position, BaseFormWidget FormWidget, final Context context) {
        mFormWidget = FormWidget;
        mPosition = position;
        mFormWidgetSwitch = (FormWidgetSwitch) mFormWidget;

        mTextViewTitle.setText(mFormWidgetSwitch.getTitle());
        mTextViewPositive.setText(mFormWidgetSwitch.getPositiveText());
        mTextViewNegative.setHint(mFormWidgetSwitch.getNegativeText());
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mReloadListener.updateValue(position, b ? mFormWidgetSwitch.getPositiveText() : mFormWidgetSwitch.getNegativeText());
            }
        });
    }

}
