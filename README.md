# Form Maker
Build a Form Page Using FormMaker
This library efficiently builds bigger forms on-the-fly.
Forms with large number of Widgets can easily be added programmatically within a few minutes.

## Features
- Fast color change as needed
- Easily build big and bigger forms with minimal effort

## Installation
Add the JitPack repository in your build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
And add the dependency
[![](https://jitpack.io/v/wils0n28/formMaker.svg)](https://jitpack.io/#wils0n28/formMaker)
*replacing ${version} with the version number in jitpack*

```
	dependencies {
        implementation 'com.github.wils0n28:formMaker:${version}'
	}
```


## How to use
1. Add a Recyclerview anywhere in the layout where you want your list to be shown.

``` 'xml'
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <androidx.recyclerview.widget.RecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:id="@+id/recyclerView"
        android:descendantFocusability="beforeDescendants" />

</LinearLayout>
```

2. Add the Form Widgets programmatically in your activity
``` 'java'
// initialize variables
mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
mFormBuilder = new FormBuildHelper(this, mRecyclerView);

// declare form wisgets
FormHeader header = FormHeader.createInstance("Personal Info");
FormWidgetTextEmail element = FormWidgetTextEmail.createInstance().setTitle("Email").setHint("Enter Email");

// add them in a list
List<FormObject> formItems = new ArrayList<>();
formItems.add(header);
formItems.add(element);

// build and display the form
mFormBuilder.addFormWidgets(formItems);
mFormBuilder.refreshView();
```
3. Now build and run!!

### Changelog

####v1.0
1. New FormWidget type: Switch.
2. New way to define the form wisgets.
2. Can set Titles in alert dialogs for Date and Time type form element.
3. Can set Positive and negative texts for Date, Time and Switch type form wisgets.
4. Can set Date and Time formats (if unset, default format will be used).

#### Header:
``` 'java'
FormHeader header = FormHeader.createInstance("Personal Info");
```

#### Regular Widgets:

**General object format**
``` 'java'
<Class> element = <Class>.createInstance()
    .setTag(101123151) // optional tag to uniquely identify the elemnt for later use
    .setType(FormWidget.TYPE_PICKER_MULTI_CHECKBOX) // setting input type
    .setTitle("Pick your favourite Color") // setting title
    .setValue("Red") // setting value of the field, if any
    .setOptions(Green) // setting pickable options, if any
    .setHint("e.g. Red, Green etc") // setting hints, if any
    .setRequired(false); // marking if the form element is required to be filled to make the form valid, include if needed
```

**Samples:**
``` 'java'
// email input
FormWidgetTextEmail element = FormWidgetTextEmail.createInstance().setTitle("Email").setHint("Enter Email");

// phone number input
FormWidgetTextPhone element = FormWidgetTextPhone.createInstance().setTitle("Phone").setValue("+8801712345678");

// single line text input
FormWidgetTextSingleLine element = FormWidgetTextSingleLine.createInstance().setTitle("Location").setValue("Dhaka");

// multi line text input (default 4)
FormWidgetTextMultiLine element = FormWidgetTextMultiLine.createInstance().setTitle("Address");

// number element input
FormWidgetTextNumber element = FormWidgetTextNumber.createInstance().setTitle("Zip Code").setValue("1000");

// date picker input
FormWidgetPickerDate element = FormWidgetPickerDate.createInstance().setTitle("Date").setDateFormat("MMM dd, yyyy");

// time picker input
FormWidgetPickerTime element = FormWidgetPickerTime.createInstance().setTitle("Time").setTimeFormat("KK hh");

// password input
FormWidgetTextPassword element = FormWidgetTextPassword.createInstance().setTitle("Password").setValue("abcd1234");

// switch input
FormWidgetSwitch element = FormWidgetSwitch.createInstance().setTitle("Frozen?").setSwitchTexts("Yes", "No");

// single item picker input
List<String> colors = new ArrayList<>();
colors.add("Red");
colors.add("Green");
colors.add("Yellow");
colors.add("Pink");
FormWidgetPickerSingle element = FormWidgetPickerSingle.createInstance().setTitle("Single Color").setOptions(colors).setPickerTitle("Pick any Color");

// multiple items picker input
List<String> colors = new ArrayList<>();
colors.add("Red");
colors.add("Green");
colors.add("Yellow");
colors.add("Pink");
FormWidgetPickerMulti element = FormWidgetPickerMulti.createInstance().setTitle("Multi Color").setOptions(colors).setPickerTitle("Pick one or more color").setNegativeText("clear");
```

### Set form element value change listener to get changed value instantly
While creating new instance of FormBuildHelper, add a listener in the constructor

Have a look at the example code for details

``` 'java'
FormBuildHelper mFormBuilder = new FormBuildHelper(this, mRecyclerView, new OnFormWidgetValueChangedListener() {
    @Override
    public void onValueChanged(FormWidget formWidget) {
        // do anything here with formWidget.getValue()
    }
}
);
```

### Set unique tags for form wisgets (for later value retrieval)
Just add a unique tag for the element
``` 'java'
FormWidget element = FormWidget.createInstance()
    .setTag(2149) // unique tag number to identify this element
    .setType(FormWidget.TYPE_PICKER_MULTI_CHECKBOX)
    .setTitle("Pick your favourite fruit");
```

### Get value for unique form wisgets
Use the unique tag assigned earlier to retrieve value (See examples in this repo)
``` 'java'
FormWidget targetWidget = mFormBuilder.getFormWidget(2149);
String targetValue = targetWidget.getValue();
```

### Check if form is valid
Use this method if you need to check whether the required wisgets of the form is completed
```'java'
mFormBuilder.isValidForm(); // returns boolean whether the form is valid or not
```

### Form accent color change
If you want to change the colors, just override the colors in your **colors.xml** file:
```'xml'
<color name="colorFormMasterHeaderBackground">#DDDDDD</color>
<color name="colorFormMasterHeaderText">#000000</color>
<color name="colorFormMasterWidgetBackground">#FFFFFF</color>
<color name="colorFormMasterWidgetTextTitle">#222222</color>
<color name="colorFormMasterWidgetTextValue">#000000</color>
<color name="colorFormMasterDivider">#DDDDDD</color>
```

### Form UI change
If you want to change how the forms look, just override the layout xml named form_element.xml and/or form_element_header.xml in your project.

Just make sure to keep the ID name same as it is in the library for the components.
```
android:id="@+id/formWidgetTitle"
android:id="@+id/formWidgetValue"
```

License
-----------------
This Library is released under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0).
