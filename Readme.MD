# Pezesha Products App

Pezesha Products is a sample mobile application built using Jetpack Compose, Hilt for Dependency Injection, Retrofit for API calls, Room for local database, and Coroutines for asynchronous operations. The app follows the MVVM architecture and Clean Architecture principles.

## Features

- Display a list of products fetched from a remote API.
- Search for products using a search bar.
- View detailed information about a product.
- Offline caching of product data using Room.

## Technologies Used

- Jetpack Compose
- Hilt for Dependency Injection
- Retrofit for API calls
- Room for local database
- Coroutines for asynchronous operations
- MVVM architecture
- Clean Architecture principles

## Setup Instructions

1. **Clone the repository:**

```bash
git clone https://github.com/your-repo/pezeshaproducts.git
cd pezeshaproducts
```

2. **Open the project in Android Studio:**

   Open Android Studio and select `Open an existing project`. Navigate to the `pezeshaproducts` directory and open it.

3. **Build the project:**

   Let Android Studio build the project and resolve all dependencies.

4. **Run the app:**

   Connect an Android device or start an emulator. Click the `Run` button in Android Studio to install and run the app on your device/emulator.

## Modules

- **data**: Contains data models, local data source (Room), remote data source (Retrofit), and repository.
- **di**: Contains Hilt dependency injection modules.
- **ui**: Contains UI components, screens, ViewModel, and theming.
- **view**: Contains composable functions for product list screen, product detail screen, product item, and search bar.

## Firebase Distribution

The app is distributed via Firebase App Distribution. You can download the latest version of the app using the following link:

[Download Pezesha Products App](https://appdistribution.firebase.dev/i/0091d57e446d76a7)

## Screenshots

_Add screenshots of the app here._

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## Author

- **Cliff Gor** - [GitHub Profile](https://github.com/cliff-gor)

## Contact

For any inquiries or support, please contact [cliff.gor.dev@gmail.com](mailto:cliff.gor.dev@gmail.com).