# Push-Up Counter using Light and Proximity Sensors

This is a simple Android app that uses the light and proximity sensors on a mobile device to count push-ups. The app is designed to be easy to use and can help users track their progress as they work towards their fitness goals.

## Getting Started

To use the app, you will need to have an Android device with a light and proximity sensor. You can download the `pushup.apk` file from the GitHub repository and install it on your device.

To install the app:

1. Download the `pushup.apk` file from the GitHub repository.
2. On your Android device, go to Settings > Security > Unknown Sources and enable the option to allow installation of apps from unknown sources.
3. Open the `pushup.apk` file from your device's file manager or downloads folder.
4. Follow the on-screen instructions to install the app.
5. Once the app is installed, open it and place your device on a stable surface to start counting push-ups using the light and proximity sensors.

## How to Use

To use the app, place your mobile device on a stable surface and get into the push-up position. The app will detect your movements using the proximity sensor and the change in light intensity using the light sensor and count your push-ups as you perform them.

The app features a simple and easy-to-use interface that displays your current push-up count and allows you to set a target goal. You can also reset the count to start over.

## Code Structure

The main code for this app is contained in the `MainActivity.java` file. This file contains the logic for detecting push-ups using the light and proximity sensors and updating the UI accordingly.

The `MainActivity` class extends the `AppCompatActivity` class and implements the `SensorEventListener` interface to detect changes in the sensor data. The `onCreate` method sets up the UI and initializes the sensors. The `onSensorChanged` method is called when there is a change in the sensor data, and it updates the push-up count and UI accordingly.

## Features

The Push-Up Counter app features the following:

- Uses the light and proximity sensors on a mobile device to count push-ups
- Simple and easy-to-use interface to track progress
- Option to set a target goal
- Ability to reset the count to start over

## Conclusion

The Push-Up Counter app is a useful tool for anyone looking to track their push-up progress. With its simple interface and use of mobile sensors, the app is easy to use and can help users achieve their fitness goals. Give it a try and see how many push-ups you can do!
