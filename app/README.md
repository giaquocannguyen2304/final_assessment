# Final Project

## Project Overview
This Android application is developed as part of the final assessment for the NIT3213 course at Victoria University. It demonstrates the integration of a REST API, implementing user authentication, and displaying data retrieved from the server.

## Features
- User Authentication: Login screen with username and password fields
- Dashboard: Displays a list of entities retrieved from the server
- Details View: Shows detailed information about a selected entity

## Technical Stack
- Language: Kotlin
- Architecture: MVVM (Model-View-ViewModel)
- Dependency Injection: Hilt
- Networking: Retrofit with OkHttp
- Asynchronous Programming: Coroutines
- UI: XML layouts with RecyclerView for list display

## Setup and Installation
1. Clone the repository:
2. Open the project in Android Studio
3. Sync the project with Gradle files
4. Run the app on an emulator or physical device

## API Endpoints
- Base URL: `https://vu-nit3213-api.onrender.com/`
- Authentication: `POST /footscray/auth`
- Dashboard Data: `GET /dashboard/{keypass}`

## Usage
1. Launch the app
2. On the login screen, enter your credentials:
- Username: Your first name `Gia Quoc An Nguyen`
- Password: Your student ID (format: s12345678) `s8065036`
3. Upon successful login, you'll be redirected to the dashboard
4. Tap on any item in the dashboard to view its details

## Project Structure
- `app/src/main/java/com/example/finalassessment/`
- `app/`: Contains UI-related code (Activities, ViewModels)
- `data/`: Data models and network-related code
- `di/`: Dependency injection modules
- `repository/`: Repository classes for data operations
- `util/`: Utility classes and functions

## Contributing
This project is part of an academic assessment and is not open for external contributions.

## Troubleshooting
If you encounter any issues:
1. Ensure you're using the correct API endpoints
2. Check your internet connection
3. Verify your login credentials
4. Review Logcat for detailed error messages

## License
This project is created for educational purposes as part of the NIT3213 course at Victoria University. All rights reserved.

## Contact
For any queries related to this project, please contact to my email `s8065036@live.vu.edu.au`