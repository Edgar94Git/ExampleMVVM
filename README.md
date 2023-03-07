# ExampleMVVM

Patron de diseño: MVVM y Clean Architecture

    //ViewModel
    implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1'

    //Lifecycle
    implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.5.1'

    //Fragment
    implementation 'androidx.fragment:fragment-ktx:1.5.5'

    //Activity
    implementation 'androidx.activity:activity-ktx:1.6.1'

    //Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

    //Coroutines
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4'

    //Dagger Hilt
    implementation 'com.google.dagger:hilt-android:2.44'
    kapt 'com.google.dagger:hilt-android-compiler:2.44'

    //Room
    implementation 'androidx.room:room-ktx:2.5.0'
    kapt 'androidx.room:room-compiler:2.5.0'

    testImplementation 'io.mockk:mockk:1.12.2'
    testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4'
    testImplementation 'androidx.arch.core:core-testing:2.2.0'
