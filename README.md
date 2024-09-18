# NIT3213 Android Application

## Project Overview

This Android application is developed as part of the NIT3213 Final Assignment, demonstrating proficiency in API integration, user interface design, and Android development best practices. The app consists of three main screens: Login, Dashboard, and Details, and interacts with the 'vu-nit3213-api' for authentication and data retrieval.

## Features

1. **Login Screen**
   - User authentication with username (student's first name) and password (student ID)
   - POST request to `/footscray/auth` endpoint
   - Error handling for unsuccessful login attempts
   - Navigation to the Dashboard upon successful login

2. **Dashboard Screen**
   - RecyclerView implementation to display entity summaries
   - GET request to `/dashboard/{keypass}` endpoint
   - Click functionality on items to navigate to Details screen

3. **Details Screen**
   - Comprehensive display of entity information, including description
   - User-friendly layout for clear information presentation

## API Details

Base URL: `https://vu-nit3213-api.onrender.com`

1. **Login Endpoint**
   - URL: `/footscray/auth`
   - Method: POST
   - Request Body: 
     ```json
     {
       "username": "Gia Quoc An",
       "password": "s8065036"
     }
     ```
   - Successful Response (200 OK):
     ```json
     {
       "keypass": "courses"
     }
     ```

2. **Dashboard Endpoint**
   - URL: `/dashboard/{courses}`
   - Method: GET
   - Successful Response (200 OK):
     ```json
     {
       "entities": [
         {
           "courseCode": "value1",
           "courseName": "value2",
           "credits": "value3",
           "description": "Detailed description"
           "instructor": "value4",
         },
         // More objects...
       ],
       "entityTotal": 7
     }
     ```

## Technical Specifications

- **Dependency Injection**: Implemented using [Hilt/Koin]
- **Architecture**: Follows clean code principles with a well-organized project structure
- **Testing**: Unit tests for critical components
- **Version Control**: Git with meaningful commit messages and clear history

## Setup and Installation

1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Run the application on an emulator or physical device

## Building and Running

1. In Android Studio, select 'Build' > 'Build Bundle(s) / APK(s)' > 'Build APK(s)'
2. Once built, select 'Run' > 'Run app'

## Testing

Run unit tests by right-clicking on the test directory and selecting 'Run Tests'

## Contributing

1. Fork the repository
2. Create a new branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## Contact

Gia Quoc An Nguyen - s8065036@live.vu.edu.au

Project Link: https://github.com/giaquocannguyen2304/final_assessment
