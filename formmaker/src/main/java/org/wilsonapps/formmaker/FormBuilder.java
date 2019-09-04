package org.wilsonapps.formmaker;

import android.content.Context;
import android.text.TextUtils;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.wilsonapps.formmaker.adapter.FormAdapter;
import org.wilsonapps.formmaker.listener.OnFormWidgetValueChangedListener;
import org.wilsonapps.formmaker.model.BaseFormWidget;

import java.util.List;

/** Wrapper class around the adapter to assist in building form
 * Created by Wilson.
 */

public class FormBuilder {

    private FormAdapter mFormAdapter;

    /**
     * constructor without listener callback for changed values
     * @param context
     * @param recyclerView
     */
    public FormBuilder(Context context, RecyclerView recyclerView) {
        initializeFormBuildHelper(context, recyclerView, null);
    }

    /**
     * constructor with listener callback for changed values
     * @param context
     * @param recyclerView
     */
    public FormBuilder(Context context, RecyclerView recyclerView, OnFormWidgetValueChangedListener listener) {
        initializeFormBuildHelper(context, recyclerView, listener);
    }

    /**
     * private method for initializing form build helper
     * @param context
     * @param recyclerView
     * @param listener
     */
    private void initializeFormBuildHelper(Context context, RecyclerView recyclerView, OnFormWidgetValueChangedListener listener) {

        // initialize form adapter
        this.mFormAdapter = new FormAdapter(context, listener);

        // set up the recyclerview with adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        linearLayoutManager.setStackFromEnd(false);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mFormAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    /**
     * add list of form elements to be shown
     * @param baseFormWidgets
     */
    public void addFormWidgets(List<BaseFormWidget> baseFormWidgets) {
        this.mFormAdapter.addElements(baseFormWidgets);
    }

    /**
     * get value of specific form element
     * @param tag
     * @return
     */
    public BaseFormWidget getFormWidget(int tag) {
        return this.mFormAdapter.getValueAtTag(tag);
    }

    /**
     *
     * return true if the form is valid
     *
     * @return
     */
    public boolean isValidForm() {
        for (int i = 0; i < this.mFormAdapter.getItemCount(); i++) {
            BaseFormWidget baseFormWidget = this.mFormAdapter.getValueAtIndex(i);
            if (baseFormWidget.isRequired() && TextUtils.isEmpty(baseFormWidget.getValue())) {
                return false;
            }
        }
        return true;
    }

}