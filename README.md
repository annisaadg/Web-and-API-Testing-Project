# Web Automation Testing Menggunakan Cucumber dan Selenium
## Deskripsi
Program ini bertujuan untuk mengotomatisasi pengujian fitur login dan logout pada website Swag Labs (https://www.saucedemo.com/) menggunakan Cucumber dan Selenium. Dengan menggunakan pendekatan Behaviour Driven Development (BDD).

## Tentang Project Web Automation Testing

### Fitur
- **Login:** Pengguna dapat mengakses akun mereka dengan memasukkan kredensial yang valid (username dan password). 
- **Logout:** Pengguna dapat melakukan logout dari akun mereka dan kembali ke halaman login.

### Build With
Web automation testing pada project ini menggunakan:
- Cucumber
- Selenium
- WebDriverManager
- JUnit
- Cucumber Reporting
- Maven

## Directory Tree Project
```
.
├───.vscode
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───testswaglabs
│   │               ├───pages
│   │               └───utils
│   └───test
│       ├───java
│       │   └───com
│       │       └───testswaglabs
│       │           ├───stepdefinition
│       │           └───TestRunner
│       └───resources
└───target
    ├───classes
    │   └───com
    │       └───testswaglabs
    │           ├───pages
    │           └───utils
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       └───testCompile
    │           └───default-testCompile
    ├───surefire-reports
    └───test-classes
        └───com
            └───testswaglabs
                ├───stepdefinition
                └───TestRunner
```
### Penjelasan Directory Root Project
1. **src:** Ini adalah direktori sumber (source) utama yang berisi kode sumber aplikasi.
2. **main/java/com/testswaglabs/pages:** Ini adalah direktori untuk menyimpan kode yang menerapkan pola Page Object Model serta Page Factory yang berisi elemen-elemen halaman yang digunakan pada kode pengujian
3. **main/java/com/testswaglabs/utils:** Ini adalah direktori untuk menyimpan kode untuk mengelola web driver
4. **test/java/com/testswaglabs/stepdefinition:** Ini adalah direktori untuk menyimpan kode pengujian yang berisi untuk mengotomatiskan skenario pengujian
5. **test/java/com/testswaglabs/TestRunner:** Ini adalah direktori untuk menyimpan kode yang digunakan untuk menjalankan skenario pengujian
6. **test/resources:** Ini adalah direktori untuk menyimpan list feature (cucumber)
7. **target:** Ini adalah direktori yang berisi hasil dari proses kompilasi dan pembuatan (build) lainnya.
12. **classes/com/testswaglabs:** Direktori tempat hasil kompilasi dari kode sumber utama ditempatkan.
13. **generated-sources:** Direktori untuk sumber yang dihasilkan, mungkin oleh proses generasi kode.
14. **generated-test-sources:** Direktori untuk sumber pengujian yang dihasilkan.
15. **maven-status/maven-compiler-plugin:** Direktori yang berisi informasi status proyek yang dihasilkan oleh Maven.
17. **surefire-reports:** Direktori yang berisi laporan hasil pengujian yang dihasilkan oleh Surefire plugin.
18. **pom.xml:** Ini adalah berkas POM (Project Object Model) Maven yang berisi konfigurasi proyek, dependensi, dan informasi lainnya yang diperlukan oleh Maven untuk membangun proyek.
19. **test-report.html:** Ini adalah hasil generate report test yang sudah dijalankan

## Prerequisites

- **Java Development Kit (JDK)** versi 8
- **Apache Maven** versi 3.6.0+
- **IDE Visual Studio Code** dengan ekstensi Java atau Maven terbaru
- **Browser** 

## Menjalankan Aplikasi

Clone project ini

```bash
  git clone https://github.com/suciawalia/Web-Automation-Testing.git
```

## Menjalankan Tests

Jalankan command ini untuk menjalankan test

```bash
   mvn test
```
## Generate Report by tools

Dengan menambahkan "html:test-report.html" pada TestRunner.java

```bash
@CucumberOptions(features="src/test/resources",
        glue= {"com.testswaglabs.stepdefinition"},
        plugin ={"pretty","json:target/cucumber.json","html:test-report.html"}
        )
```
## Test Cases
1. Login Menggunakan Username yang Terdaftar pada Sistem
2. Login dengan Keadaan Username dan Password Tidak Diisi
3. Login dengan Keadaan Username Tidak Diisi
4. Login dengan Keadaan Password Tidak Diisi
5. Login dengan Keadaan Username Tidak Terdaftar pada Sistem
6. Login dengan Keadaan Username Terdaftar Pada Sistem namun Password Tidak Sesuai
7. Logout dengan Menekan Tombol "Logout"

## Hasil Tests
### Root file test report
```
..\test-report.html
```
### Hasil Test Report
**1. Summary**

![image](https://github.com/suciawalia/Web-Automation-Testing/assets/99374578/ffb90a61-712f-4e1b-a302-c2b13dc58b8f)

- Jumlah scenario yang dieksekusi dan menghasilkan fail (Failed) adalah 5
- Jumlah scenario yang dieksekusi dan menghasilkan pass (Passed) adalah 2
- Waktu untuk eksekusi testnya (Duration) adalah 1m 30.646s
- Test yang dinjalankan mengguanakan dependency cucumber-JVM versi 6.9.0
- Java Runtime Environment OpenJDK 64-Bit Server VM versi 25.382-b05.
- Sistem operasi (Windows 11) dan arsitektur CPU (amd64)

**2. Test Result Fitur Login**

![image](https://github.com/suciawalia/Web-Automation-Testing/assets/99374578/10bf9216-1ecc-40c2-b64e-9e4038d98a7b)

![image](https://github.com/suciawalia/Web-Automation-Testing/assets/99374578/be3abfb3-5d2e-4aab-ab3c-2bf593573fe6)

Dari hasil eksekusi scenario untuk fitur login terdapat 5 scenario yang dieksekusi yaitu 
- User successfully logs in with registered username and password dengan scenario status passed semua yang ditandai dengan icon ceklis bewarna hijau
- User attempts to login without providing username and password dengan scenario status failed detailnya pada tahap expected result "Then" yang ditandai dengan icon x berwarna merah
- User attempts to login without providing username dengan scenario status failed detailnya pada tahap expected result "Then" yang ditandai dengan icon x berwarna merah
- User attempts to login without providing password dengan scenario status failed detailnya pada tahap expected result "Then" yang ditandai dengan icon x berwarna merah
- Username isn't registered in the system dengan scenario status failed detailnya pada tahap expected result "Then" yang ditandai dengan icon x berwarna merah dan terdapat scenario status skipped pada tahap "And I should remain on the login page"
- Password isn't registered in the system dengan scenario status failed detailnya pada tahap expected result "Then" yang ditandai dengan icon x berwarna merah


## Kelompok 7
- 211524001 | Adinda Faayza Malika [@adindafaayza](https://github.com/adindafaayza)
- 211524003 | Annisa Dinda Gantini [@annisaadg](https://github.com/annisaadg)
- 211524027 | Suci Awalia Gardara [@suciawalia](https://github.com/suciawalia)
