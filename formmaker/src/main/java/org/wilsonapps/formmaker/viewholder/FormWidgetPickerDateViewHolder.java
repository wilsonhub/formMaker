package org.wilsonapps.formmaker.viewholder;

import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.DatePicker;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.wilsonapps.formmaker.R;
import org.wilsonapps.formmaker.listener.ReloadListener;
import org.wilsonapps.formmaker.model.BaseFormWidget;
import org.wilsonapps.formmaker.model.FormWidgetPickerDate;
import org.wilsonapps.formmaker.model.FormWidgetPickerMulti;

/**
 * ViewHolder for DatePicker
 * Created by Wilson.
 */

public class FormWidgetPickerDateViewHolder extends BaseViewHolder {

    private AppCompatTextView mTextViewTitle;
    private AppCompatEditText mEditTextValue;
    private DatePickerDialog mDatePickerDialog;
    private Calendar mCalendarCurrentDate;
    private ReloadListener mReloadListener;
    private BaseFormWidget mFormWidget;
    private int mPosition;

    public FormWidgetPickerDateViewHolder(View v, Context context, ReloadListener reloadListener) {
        super(v);
        mTextViewTitle = (AppCompatTextView) v.findViewById(R.id.FormWidgetTitle);
        mEditTextValue = (AppCompatEditText) v.findViewById(R.id.FormWidgetValue);
        mReloadListener = reloadListener;
        mCalendarCurrentDate = Calendar.getInstance();
    }

    @Override
    public void bind(int position, BaseFormWidget FormWidget, final Context context) {
        mFormWidget = FormWidget;
        mPosition = position;

        mDatePickerDialog = new DatePickerDialog(context,
                date,
                mCalendarCurrentDate.get(Calendar.YEAR),
                mCalendarCurrentDate.get(Calendar.MONTH),
                mCalendarCurrentDate.get(Calendar.DAY_OF_MONTH));

        mTextViewTitle.setText(FormWidget.getTitle());
        mEditTextValue.setText(FormWidget.getValue());
        mEditTextValue.setHint(FormWidget.getHint());
        mEditTextValue.setFocusableInTouchMode(false);

        mEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerDialog.show();
            }
        });

        mTextViewTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerDialog.show();
            }
        });
    }

    /**
     * setting up date picker dialog listener
     */
    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mCalendarCurrentDate.set(Calendar.YEAR, year);
            mCalendarCurrentDate.set(Calendar.MONTH, monthOfYear);
            mCalendarCurrentDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            String myFormatDate = ((FormWidgetPickerDate) mFormWidget).getDateFormat();
            SimpleDateFormat sdfDate = new SimpleDateFormat(myFormatDate, Locale.US);

            String currentValue = mFormWidget.getValue();
            String newValue = sdfDate.format(mCalendarCurrentDate.getTime());

            // trigger event only if the value is changed
            if (!currentValue.equals(newValue)) {
                mReloadListener.updateValue(mPosition, newValue);
            }
        }

    };

}
