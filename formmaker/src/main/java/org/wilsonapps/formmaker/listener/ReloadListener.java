package org.wilsonapps.formmaker.listener;

/**
 * Callback for if any data in form element list is changed
 * Created by Wilson.
 */

public interface ReloadListener {
    void updateValue(int position, String updatedValue);
}
