<b>New York Most Popular Article Project</b>

It is a simple app to hit the NY Times Most Popular Articles API and show a list of articles,
that shows details when items on the list are tapped (a typical master/detail app)

The code uses [Most popular article of NewYork API) to load and display articles with their description.

Most Popular Article Api: https://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=sample key

You can replace the sample key with your key that you got from the below link:

LINK:
https://developer.nytimes.com/get-started.
# Requirements

As this code uses Jetpack, you will need Android Studio 3.2+.

<b>Libraries used on the project</b></br>
AppCompat, CardView, RecyclerView as DesignLibrary
Data binding
Retrofit 
Junit
Livedata
Espresso

<b>Design Pattern used in the project</b></br>
MVVM design pattern is used .

<b>Installing project on Android Studio</b></br>
 
<b>Steps:</b><br/>
1.Download the  project Zip from Github account. Don't use VCS in android studio.<br/>
2.(Optional)Copy the folder extracted into your AndroidStudioProjects folder which must contain the hidden .git folder.<br/>
3.Open Android Studio-> File-> Open->Existing android studio -> Select android  project directory.<br/>
4.Project is imported in your android studio.<br/>

<b>Running the tests</b><br/>
To use JUnit tests for your Android application, you need to add it as dependency to your Gradle build file.<br/>

 
// For espresso test cases<br/>
androidTestImplementation ('com.android.support.test.espresso:espresso-core:3.0.2', {<br/>
   exclude group: 'com.android.support', module: 'support-annotations'<br/>
})<br/>
// For recycler view actions<br/>
androidTestImplementation ('com.android.support.test.espresso:espresso-contrib:2.0') {<br/>
   exclude group: 'com.android.support', module: 'appcompat'<br/>
   exclude group: 'com.android.support', module: 'support-v4'<br/>
   exclude module: 'recyclerview-v7'<br/>
}
 
// For espresso activity rule
androidTestImplementation "com.android.support.test:rules:1.0.2"<br/>
androidTestImplementation "com.android.support.test:runner:1.0.2"<br/>

<b>Using Android Studio</b><br/>
To run a unit test, right-click on your test class in the Project window and select Run.<br/>

<b>Location of Test Report</b><br/>
The Test reports are created in the app/build/reports/tests/debug/ directory. The index.html gives an overview and links to the individual test pages.<br/>

<b>Coverage Report to be generated</b><br/>
Lastly, in the latest Android Studio, you should be able to run your JUnit-Run Configuration by clicking on the 'Run with Coverage' button.<br/>
In Android Studio 2.1.3 the is label Run Unit tests with Coverage where Unit test is the name of your test configuration as shown in the following screenshot:<br/>
https://user-images.githubusercontent.com/41769480/69937601-336aa880-1501-11ea-83d7-5fb6bd9eb7b5.png

<b>Authors</b><br/>
JYOTI DAHIYA- Senior Android Developer.<br/>



