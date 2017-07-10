# Android Development Training

Note: Several source codes/modules are not available for debugging. Only Lessons 1, 3, 4, and 13 are available for debugging.

#### Requirements
`Android Studio 2.3.x`
`Kotlin Plugin`
`Kotlin Parcelable Plugin`
`Java JDK`

# Session 1
------------
#### Lesson 01 - Layout Managers
There are three (3) main layout managers that are widely used:
  - LinearLayout
  - RelativeLayout
  - FrameLayout

```
open 01_LayoutManagers > res > layout
```

##### Linear Layout
>View group that aligns all children in a single direction, vertically or horizontally.
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Vertical 1"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Vertical 2"/>
</LinearLayout>
```


##### Relative Layout
>View group that displays child views in relative positions. The position of each view can be specified as relative to sibling elements (such as to the left-of or below another view) or in positions relative to the parent RelativeLayout area (such as aligned to the bottom, left or center).
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
              android:orientation="vertical"
              android:layout_width="match_parent"
              android:layout_height="match_parent">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Vertical 1"/>
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Vertical 2"/>
</LinearLayout>
```



##### Frame Layout
>FrameLayout is designed to block out an area on the screen to display a single item. Generally, FrameLayout should be used to hold a single child view, because it can be difficult to organize child views in a way that's scalable to different screen sizes without the children overlapping each other. You can, however, add multiple children to a FrameLayout and control their position within the FrameLayout by assigning gravity to each child, using the `android:layout_gravity` attribute.

>Child views are drawn in a stack, with the most recently added child on top. The size of the FrameLayout is the size of its largest child (plus padding), visible or not (if the FrameLayout's parent permits). Views that are GONE are used for sizing only if `setConsiderGoneChildrenWhenMeasuring()` is set to true.
```xml
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
             android:layout_width="match_parent"
             android:layout_height="match_parent">

    <ProgressBar
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"/>

</FrameLayout>
```

-----------------------------------------------------------

#### Lesson 02 - UI Components
>All user interface elements in an Android app are built using View and ViewGroup objects. A View is an object that draws something on the screen that the user can interact with. A ViewGroup is an object that holds other View (and ViewGroup) objects in order to define the layout of the interface.

>Android provides a collection of both View and ViewGroup subclasses that offer you common input controls (such as buttons and text fields) and various layout models (such as a linear or relative layout).

```
open 02_UIComponents > res > layout
```

Samples:

##### TextView
```xml
<TextView
        android:id="@+id/txtFirstTextview"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="I'm a TextView with id = txtFirstTextview"/>
```
##### Button
```xml
<Button
        android:id="@+id/btnFirstButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button with id = btnFirstButton"/>
```
##### EditText
```xml
<EditText
        android:id="@+id/edtFirstEditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="I'm an editable text"/>
```
##### CheckBox
```xml
<CheckBox
        android:id="@+id/cbFirstCheckBox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="First CheckBox"/>
```
##### RadioGroup
```xml
<RadioGroup
        android:id="@+id/rgFirstRadioGroup"
        android:orientation="vertical"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">
        <RadioButton
            android:id="@+id/rbFirstRadioBtn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="First Radio Button"/>
        <RadioButton
            android:id="@+id/rbSecondRadioBtn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Second Radio Button"/>
        <RadioButton
            android:id="@+id/rbThirdRadioBtn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Third Radio Button"/>
    </RadioGroup>
```

-----------------------------------------------------------

#### Lesson 03 - Setting Component Events
>On Android, there's more than one way to intercept the events from a user's interaction with your application. When considering events within your user interface, the approach is to capture the events from the specific View object that the user interacts with. The View class provides the means to do so.

>Within the various View classes that you'll use to compose your layout, you may notice several public callback methods that look useful for UI events. These methods are called by the Android framework when the respective action occurs on that object. For instance, when a View (such as a Button) is touched, the onTouchEvent() method is called on that object. However, in order to intercept this, you must extend the class and override the method. However, extending every View object in order to handle such an event would not be practical. This is why the View class also contains a collection of nested interfaces with callbacks that you can much more easily define. These interfaces, called event listeners, are your ticket to capturing the user interaction with your UI.

>While you will more commonly use the event listeners to listen for user interaction, there may come a time when you do want to extend a View class, in order to build a custom component. Perhaps you want to extend the Button class to make something more fancy. In this case, you'll be able to define the default event behaviors for your class using the class event handlers.

##### Event Listeners
`onClick()`
`onLongClick()`
`onFocusChange()`
`etc..`

```
open 03_SettingComponentEvents > java > maru.a03_settingscomponentevents > MainActivity.java
```

Sample
```kotlin
class MainActivity: AppCompatActivity {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        val btnShowToast = findViewById(R.id.btnShow) as Button
        
        btnShowToast.setOnClickListener {
            Toast.makeText(it.context, "Toast", Toast.LENGTH_SHORT).show()
        }
    }
    
}
```

-----------------------------------------------------------

#### Lesson 04 - Starting new Activity
```
open 04_StartingNewActivity
```
##### Create SecondActivity.class
```kotlin
class SecondActivity: AppCompatActivity() {
    
    override fun onCreate(...) {
        super.onCreate(...)
        setContentView(...)
        
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
        
    }

}
```
##### Respond to a button 
```kotlin
    override fun onCreate(...) {
        val btnShowSecondActivity = findViewById(...) as Button
        
        btnShowSeconActivity.setOnClickListener {
            val intent = Intent(it.context, SecondActivity::class.java)
            startActivity(intent)
        }
    }
```
##### Add Second Activity to Manifest
Inside application tag, add another activity
```xml
    
    <application  ...
                 android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">...</activity>
        <activity android:name=".SecondActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
    </application>

```

-----------------------------------------------------------

#### Lesson 05 - Android Activity Lifecycle
```
open 05_AndroidLifecycle
```
<img src="https://developer.android.com/guide/components/images/activity_lifecycle.png"/>

To navigate transitions between stages of the activity lifecycle, the Activity class provides a core set of six callbacks: `onCreate()`, `onStart()`, `onResume()`, `onPause()`, `onStop()`, and `onDestroy()`. The system invokes each of these callbacks as an activity enters a new state.

-----------------------------------------------------------

#### Lesson 06 - Styling Elements
```
open 06_StylingElements 
```
##### Create custom Button Selector

Samples:
Make sure we already have the resources for ic_check_circle_black_24dp/search_black_24dp

`button_selector.xml`:
```xml
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_selected="true"
        android:drawable="@drawable/ic_check_circle_black_24dp"/>
    <item android:state_pressed="true"
        android:drawable="@drawable/ic_check_circle_black_24dp"/>
    <item android:state_selected="false" android:drawable="@drawable/ic_search_black_24dp"/>
</selector>
```
`activity_main.xml`:
```xml
<Button
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:drawableStart="@drawable/ic_check_circle_black_24dp"
        android:text="Button with icon at left"/>
```

-----------------------------------------------------------


# Session 2
------------
#### Lesson 07 - Logging And Debugging
```
open 07_LoggingAndDebugging
```
>`Android Monitor` includes a logcat Monitor that displays debug messages. The logcat Monitor displays system messages, such as when a garbage collection occurs, as well as messages that you can add to your app using the Log class. It displays messages in real time and also keeps a history so you can view older messages.

>To display just the information of interest, you can create filters, modify how much information is displayed in messages, set priority levels, display messages produced by app code only, and search the log. By default, the logcat Monitor shows the log output related to the most recently run app only.

>When an app throws an exception, the logcat Monitor shows a message followed by the associated stack trace containing links to the code. This feature can help you fix errors and improve app operation.

Log Levels:
 - Verbose - Show all log messages (the default).
 - Debug - Show debug log messages that are useful during development only, as well as the message levels lower in this list.
 - Info - Show expected log messages for regular usage, as well as the message levels lower in this list.
 - Warn - Show possible issues that are not yet errors, as well as the message levels lower in this list.
 - Error - Show issues that have caused errors, as well as the message level lower in this list.
 - Assert - Show issues that the developer expects should never happen.

Logcat Message Format:
    `Log.d(tag, message)`
    `Log.v(tag, message)`
    `Log.w(tag, message)`
    `Log.e(tag, message)`
    `Log.i(tag, message)`
    `Log.d(tag, message)`
    
> Open a class to try Breakpoints and Evaluate Expressions

------------
#### Lesson 08 - Connecting To Internet
```
open 08_ConnectingToInternet
```
Creating a HTTP request is so simple for Android apps. We are going to use HTTPUrlConnection class to achieve such functionality.

Sample:
```kotlin
    fun makeHTTPRequest() {
        val url = URL("https://ghibliapi.herokuapp.com/")
        val http = url.openConnection()
        http.connect()
    }
```
------------
#### Lesson 09 - Permissions
```
open 09_Permissions > manifests
```
A basic Android app has no permissions associated with it by default, meaning it cannot do anything that would adversely impact the user experience or any data on the device. To make use of protected features of the device, you must include one or more `<uses-permission>` tags in your `app manifest`.

For example, an app that needs to connect to internet would specify:
```xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.android.app.myapp" >
    <uses-permission android:name="android.permission.INTERNET" />
    ...
</manifest>
```
> See [Developer Page](https://developer.android.com/guide/topics/permissions/requesting.html) for the list of `normal` and `dangerous` permission

------------
#### Lesson 10 - AsycTask
```
open 10_AsycTask
```
>AsyncTask enables proper and easy use of the UI thread. This class allows you to perform background operations and publish results on the UI thread without having to manipulate threads and/or handlers.

>AsyncTask is designed to be a helper class around Thread and Handler and does not constitute a generic threading framework. AsyncTasks should ideally be used for short operations (a few seconds at the most.) 

Sample:
```kotlin
  override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        object : AsyncTask<Void, Void, Void>() {
            override fun onPreExecute() {
                super.onPreExecute()
                // runs in UI Thread
            }

            override fun doInBackground(vararg p0: Void?): Void? {
                // runs in background thread
                makeHTTPRequest()
                return null
            }
            
            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)
                // runs in UI Thread
            }
        }
    }
```
------------
#### Lesson 11 - ListView
```
open 11_ListView
```
>ListView is a view group that displays a list of scrollable items. The list items are automatically inserted to the list using an `Adapter` that pulls content from a source such as an array or database query and converts each item result into a view that's placed into the list.

Sample `Adapter`:
```kotlin
class PresidentListAdapter(context: Context?, resource: Int, objects: MutableList<President>) :
        ArrayAdapter<President>(context, resource, objects) {

    private var ctx = context
    private var res = resource
    private var items = objects
    private var inflater = ctx?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var view = convertView
        var holder: ViewHolder

        if (view == null) {
            view = inflater.inflate(res, parent, false)
            holder = ViewHolder()

            // api 26
            holder.name = view.findViewById<TextView>(R.id.txtName)
            holder.location = view.findViewById<TextView>(R.id.txtLocation)
            
            // api 25
            /*
                holder.name = view.findViewById(R.id.txtName) as TextView
                holder.location = view.findViewById(R.id.txtLocation) as TextView
             */

            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }

        val president = items[position]

        holder.name?.text = president.name
        holder.location?.text  = president.location

        return view
    }

    inner class ViewHolder {
        var name: TextView? = null
        var location: TextView? = null
    }
}
```
`Usage MainActivity.kt`
```kotlin

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presidents = mutableListOf(
                President("DU30", "PH"),
                President("Trump", "US"),
                President("Putin", "RU"),
                President("Xi Jinping", "CH"),
                President("Mugabe", "ZI"),
                President("Bidhya", "NE"),
                President("Pranab", "IN"),
                President("Tsai", "TA"),
                President("Kim Jong Un", "NK")
        )

        val adapter = PresidentListAdapter(this, R.layout.list_item_president, presidents)

        val listView = findViewById(R.id.lvSampleList) as ListView

        listView.adapter = adapter
    }
```
------------
#### Lesson 12 - Parsing JSON
```
open 12_ParsinJson
```
In able to parse a JSON, we need to use `JsonReader` class that is available for Android Framework. A `JsonReader` accepts an `InputStream` parameter in order to read a notation.

Sample:
> `makeHTTPCall()` From Lesson 10
```kotlin
fun makeHTTPCall() {
        val url = URL("https://ghibliapi.herokuapp.com/films")
        val http = url.openConnection()
        
        http.connect()
        
        val reader = JsonReader(InputStreamReader(http.getInputStream()))
        
        reader.beginArray()
        while (reader.hasNext()) {
            var id: String = ""
            var title: String = ""

            reader.beginObject()
            while (reader.hasNext()) {

                val name = reader.nextName()
                when (name) {
                    "id" -> id = reader.nextString()
                    "title" -> title = reader.nextString()
                    else -> reader.skipValue()
                }

            }
            reader.endObject()

            films.add(
                    Film(id, title)
            )
        }
        reader.endArray()

    }
```
Note: Remember, the `JsonReader` always stream from start to end of an `InputStream`

### Additional: Wrapping Up
```
open 13_WrappingUp
```
This module contains all of the lessons expect styling an element. 



### Helpful Libraries

* [RetroFit](http://square.github.io/retrofit/) - Easy JSON Parsing
* [Realm](https://realm.io/) - Easy SQLite
* [ButterKnife](http://jakewharton.github.io/butterknife/) - View binding for less code boilerplates

