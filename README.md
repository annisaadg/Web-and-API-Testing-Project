# Web Automation Testing Menggunakan Cucumber dan Selenium
## Deskripsi
Program ini bertujuan untuk menguji website Swag Labs (https://www.saucedemo.com/) dan API User Controller dari Dummy API (https://dummyapi.io/docs). Proyek ini dikembangkan menggunakan bahasa Java.

## Fitur / Method yang Diuji
- **API TESTING:** Method DELETE, GET, POST, PUT
- **WEB TESTING:** Halaman Login, Dashboard, Menu, Cart, Detail Product

## Build With
Web automation testing pada project ini menggunakan:
- Cucumber
- Selenium
- WebDriverManager
- JUnit
- Cucumber Reporting
- Maven
- Rest Assured

## Prerequisites

- **Java Development Kit (JDK)** versi 8
- **Apache Maven** versi 3.6.0+
- **IDE Visual Studio Code** dengan ekstensi Java atau Maven terbaru
- **Web Browser** 

## Directory Tree Project
```
├───reports
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───tubes
│   └───test
│       ├───java
│       │   └───com
│       │       └───tubes
│       │           ├───dummyapi
│       │           │   ├───helper
│       │           │   ├───logic
│       │           │   │   └───request
│       │           │   ├───model
│       │           │   ├───runner
│       │           │   └───stepDef
│       │           └───websaucedemo
│       │               ├───pages
│       │               ├───stepdefinition
│       │               ├───TestRunner
│       │               └───utils
│       └───resources
│           ├───dummyapi
│           │   ├───data
│           │   ├───features
│           │   └───schema
│           └───websaucedemo
│               └───features
└───target
```
### Penjelasan Struktur Project
**src/test/resources/dummyapi**
1. Folder data: Menyimpan data yang digunakan dalam pengujian API.
2. Folder features: Menyimpan file fitur Cucumber yang mendefinisikan skenario pengujian untuk berbagai endpoint API.
3. Folder schema: Menyimpan skema JSON yang digunakan untuk memvalidasi struktur respons API.

**src/test/resources/websaucedemo**
1. Fodler features:  Menyimpan file fitur Cucumber yang mendefinisikan skenario pengujian untuk aplikasi web.

**src/test/java/com/tubes/dummyapi**
1. Folder helper
   - SetUpEndPoint.java: Berisi kelas atau metode yang digunakan untuk mengatur endpoint API yang akan digunakan dalam pengujian.
2. Folder logic
   - request/EndPoint.java: Berisi definisi endpoint API yang akan diakses.
   - request/RequestAPIUserManagement.java: Berisi metode untuk membuat permintaan ke API terkait manajemen pengguna.
   - APIRequestProcessor.java: Berisi logika untuk memproses permintaan API.
   - APIUserTest.java: Berisi kelas atau metode yang digunakan untuk menguji fungsi API pengguna.
3. Folder Model
   - Location.java: Model kelas yang merepresentasikan data lokasi pengguna.
   - UserProfile.java: Model kelas yang merepresentasikan data profil pengguna.
5. Folder runner
   - APITestRunner.java: Berisi kelas untuk menjalankan pengujian API menggunakan Cucumber.
7. Folder stepDef
   - Berisi definisi langkah-langkah (step definitions) Cucumber untuk pengujian API. Setiap file di sini mendefinisikan bagaimana setiap langkah dalam file fitur (feature file) harus dieksekusi.

**src/test/java/com/tubes/websaucedemo**
1. Foler pages
   - CartPage.java: Berisi objek halaman (page object) untuk halaman keranjang (cart) dalam aplikasi web.
   - DashboardPage.java: Berisi objek halaman untuk halaman dashboard dalam aplikasi web.
   - DetailPage.java: Berisi objek halaman untuk halaman detail produk dalam aplikasi web.
   - LoginPage.java: Berisi objek halaman untuk halaman login dalam aplikasi web.
2. Folder stepdefinition
   - CartStepDefinitions.java: Berisi definisi langkah-langkah Cucumber untuk pengujian halaman keranjang.
   - DashboardStepDefinitions.java: Berisi definisi langkah-langkah Cucumber untuk pengujian halaman dashboard.
   - DetailStepDefinitions.java: Berisi definisi langkah-langkah Cucumber untuk pengujian halaman detail.
   - LoginStepDefinitions.java: Berisi definisi langkah-langkah Cucumber untuk pengujian halaman login.
   - MenuStepDefinitions.java: Berisi definisi langkah-langkah Cucumber untuk pengujian menu navigasi.
3. TestRunner.java: Berisi kelas untuk menjalankan pengujian web menggunakan Cucumber.
4. Folder utils
   - DriverManager.java: Berisi kelas atau metode untuk mengelola driver WebDriver yang digunakan untuk pengujian web.


## Run Automation test

1. Clone project ini

```bash
  git clone [https://github.com/suciawalia/Web-Automation-Testing.git](https://github.com/annisaadg/Web-and-API-Testing-Project.git)
```

2.  Jalankan perintah berikut untuk menginstall artifak yang didefinisikan
```
mvn clean install
```

3. Jalankan command ini untuk menjalankan test web 

```bash
   mvn test -Pweb
```

4. Jalankan command ini untuk menjalankan test API 

```bash
   mvn test -Papi
```

## Generate Report by tools

Dengan menambahkan plugin "html:test-report.html" pada TestRunner.java

```bash
@CucumberOptions(features="src/test/resources",
        glue= {},
        plugin ={"pretty","json:target/cucumber.json","html:test-report.html"}
        )
```
## Test Cases
### A. API Testing
**POST**
```
1. Melakukan request create user ketika tidak ada app-id pada header.
2. Melakukan request create user ketika memasukkan app-id yang invalid pada header.
3. Melakukan request create user dengan mengisi hanya required field dimana field firstName dan lastName di dalam range yang valid dan field email diisi dengan format yang valid.
4. Melakukan request create user dimana semua field diisi dengan nilai dalam range dan format yang valid.
5. Melakukan request create user dengan mengisi hanya required field dengan field firstName kosong.
```
**PUT**
```
```
**GET**
```
```
**DELETE**
```
```

### B. Web Testing
**Login**
```
1. Login menggunakan username yang terdaftar pada sistem.
2. Login dengan keadaan username dan password tidak diisi.
3. Login dengan keadaan username tidak terdaftar pada sistem.
```
**Dashboard**
```
1. Verifikasi tampilan daftar barang.
2. Verifikasi tampilan menuju halaman cart.
3. Validasi Button "Add to Cart" berubah menjadi "Remove"
```
**Menu**
```
1. Verifikasi halaman menu.
2. Verifikasi menu "About".
3. Verifikasi menu "Logout".
```
**Cart**
```
```
**Detail Product**
```
```
**End to End Testing**
```
```

## Kelompok 7
- 211524001 | Adinda Faayza Malika [@adindafaayza](https://github.com/adindafaayza)
- 211524003 | Annisa Dinda Gantini [@annisaadg](https://github.com/annisaadg)
- 211524027 | Suci Awalia Gardara [@suciawalia](https://github.com/suciawalia)
