# Zodiac App

This project is a feature-rich Android application that determines a user's zodiac sign based on their birthdate and provides detailed insights about the sign. Built using Jetpack Compose and the MVVM architecture, the app emphasizes modularity, scalability, and a clean UI.

----------

## Features

### Main Features:

-   **Zodiac Sign Identification**:
    -   Users can input their birthdate to determine their zodiac sign.
-   **Detailed Insights**:
    -   Provides information such as constellation stars and a brief description of the zodiac sign.
-   **Beautiful UI**:
    -   Includes dynamic icons and images for each zodiac sign.
-   **Offline Support**:
    -   No internet required to fetch data.

----------

## Architecture

This project uses the **MVVM Architecture** to ensure separation of concerns, making the app maintainable and scalable.

### Core Components

1.  **Model Layer**:
    -   Contains the `Zodiac` data class for defining the zodiac sign structure.
    -   Includes the `ZodiacRepository` for mapping dates to zodiac signs.
2.  **ViewModel Layer**:
    -   `ZodiacDetailsViewModel`: Fetches zodiac details based on the input date.
3.  **View Layer**:
    -   Built with **Jetpack Compose**, featuring screens for date input and zodiac details.
    -   Implements navigation between screens using **Jetpack Navigation**.

----------

## Getting Started

### Prerequisites

-   Android Studio Dolphin or newer.
-   A system with Java 8+ installed.

----------

### Steps to Run the Project

1.  Clone the repository:
    
    ```bash
    git clone https://github.com/NayanPahuja/MyZodiac.git
    
    ```
    
2.  Open the project in Android Studio.
    
3.  Build the project:
    
    -   Use the `Build` menu or press `Shift + F9`.
4.  Run the app on an emulator or physical device:
    
    -   Select a device and click on the green "Play" button in the toolbar.

----------

## Screens

### 1. **Birthdate Input Screen**

-   Allows users to input their birthdate.
-   Validates the input for proper date format (`DD-MM-YYYY`).

### 2. **Zodiac Details Screen**

-   Displays the user's zodiac sign, it's constellation stars , some information, and a custom icon/image.
-   Uses dynamic data retrieved from the `ZodiacRepository`.

----------

## Directory Structure

```plaintext
📦 Zodiac App
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/example/myzodiac
│   │   │   │   ├── model
│   │   │   │   │   ├── Zodiac.kt
│   │   │   │   │   └── ZodiacRepository.kt
│   │   │   │   ├── viewmodel
│   │   │   │   │   └── ZodiacViewModel.kt
│   │   │   │   ├── ui
│   │   │   │   │   ├── theme
│   │   │   │   │   └── views
│   │   │   │   │   │   └── BirthdateActivity.kt
│   │   │   │   │   │   └── ResultActivity.kt
│   │   │   │   ├── navigation
│   │   │   │   │   └── NavGraph.kt
│   │   │   │   └── MainActivity.kt
│   │   │   └── res
│   │   │       ├── drawable
│   │   │       └── values
├── build.gradle
└── README.md

```
----------

## Milestones

1.  Build a robust repository for zodiac date mapping.
2.  Implement user-friendly UI using Jetpack Compose.
3.  Integrate state management using `StateFlow`.
4.  Add validation for birthdate input.
5.  Create a repository to handle zodiac data.
----------

## Future Improvements

1.  Add support for localization to display zodiac information in multiple languages.
2.  Integrate push notifications to send daily horoscope updates.
3.  Enhance the UI with animations and interactive elements.
4.  Expand features to include personality traits and compatibility analysis.
5.  Implement a backend API for dynamic zodiac data updates.

----------

## Why Jetpack Compose?

### Advantages:

-   **Declarative UI**:
    -   Simplifies UI development with less boilerplate.
-   **Better Performance**:
    -   Optimized rendering using Android's modern rendering engine.
-   **Ease of Maintenance**:
    -   Component-based architecture ensures modular and reusable code.
