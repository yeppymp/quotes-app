# Quotes App

Quotes App merupakan aplikasi sederhana yang bisa menampilkan quotes secara **random** atau **acak**.
Quotes random tersebut diambil dari API [forismatic.com](https://forismatic.com/en/api/ "API Forismatic")

### Requirement
1. Android Studio
> Dalam hal ini diharapkan menggunakan Android Studio versi 3.0.0 ,karena akan menggunakan kotlin
2. Install AVD *(Android Virtual Device)* atau Genymotion untuk men-debug proyek Quotes App ini.
> Lewati langkah ini jika anda menggunakan perangkat android langsung
3. Jika menggunakan perangkat android langsung, ikuti tutorial berikut [Menjalankan aplikasi di perangkat keras](https://developer.android.com/studio/run/device.html?hl=id "developer.android.com")

### Tutorial
1. Buat *new project* di Android Studio. Kurang lebih seperti berikut:

![alt text](https://github.com/yeppymp/quotes-app/raw/master/new-project.png "New Project")

> Jangan lupa untuk mencentang *Include kotlin support*


2. Setelah itu klik *Next* dan pada target devices pilih API android yang dibutuhkan, semakin kecil semakin banyak kesempatan untuk aplikasi kita bisa dipakai banyak orang. Dalam contoh saya menggunakan versi Android Kitkat

![alt text](https://github.com/yeppymp/quotes-app/raw/master/target-devices.png "Target Devices")


3. klik *Next* ,lalu tambahkan activity pertama aplikasi kita. Untuk saat ini kita menggunakan **Empty Activity** dahulu.

![alt text](https://github.com/yeppymp/quotes-app/raw/master/add-activity.png "Add Activity")


4. klik *Next* lagi, lalu configurasikan nama activity, dan nama layoutnya. Lalu klik *finish*

![alt text](https://github.com/yeppymp/quotes-app/raw/master/configure-activity.png "Configure Activity")


5. Tunggu hingga build selesai, lalu buka file *activity_main.xml*, di *app\res\layout*

6. Kurang lebih untuk layout *activity_main.xml* seperti berikut:
![alt text](https://github.com/yeppymp/quotes-app/raw/master/activity-main.png "Activity Main Layout")


7. Setelah itu kita akan membuat sebuah class untuk quotes nanti. Klik *File > New > Kotlin File/Class* dan simpan di *main/java* ,lalu beri nama *Quote.kt*, dan kind nya pilih *Class*. isi Class Quote.kt seperti berikut:
![alt text](https://github.com/yeppymp/quotes-app/raw/master/quote-class.png "Class Quote")


8. Lalu buka file *app > Gradle Script > build.gradle (Module: app)*, didalam file inilah kita akan menginstall beberapa package ,seperti [OkHttp](http://square.github.io/okhttp/ "OkHttp"). OkHttp digunakan untuk mengambil data dari API.
isikan file build.gradle seperti ini:

![alt text](https://github.com/yeppymp/quotes-app/raw/master/module-gradle1.png "Module Gradle")
![alt text](https://github.com/yeppymp/quotes-app/raw/master/module-gradle2.png "Module Gradle")

9. Langkah berikutnya kita akan membuat adapter layout dengan *CardView*. Klik *File > New > XML > Layout XML File*, isikan nama *quote.xml* dengan root tag *Linear Layout*.

10. Isikan file *quote.xml* seperti berikut:
![alt text](https://github.com/yeppymp/quotes-app/raw/master/quotes-xml1.png "Quote XML")
![alt text](https://github.com/yeppymp/quotes-app/raw/master/quotes-xml2.png "Quote XML")
![alt text](https://github.com/yeppymp/quotes-app/raw/master/quotes-xml3.png "Quote XML")
![alt text](https://github.com/yeppymp/quotes-app/raw/master/quotes-xml4.png "Quote XML")


11. Langkah terakhir kita akan bermain *logic* nya di file *MainActivity.kt* ,kurang lebih isinya seperti ini:
![alt text](https://github.com/yeppymp/quotes-app/raw/master/main-activity1.png "Main Activity")
> Di dalam *function* onCreate kita set listview yang ada di *activity_main.xml* dengan QuotesAdapter, agar ketika ada data baru bisa langsung *attach* ke listView.
![alt text](https://github.com/yeppymp/quotes-app/raw/master/main-activity2.png "Main Activity")

> Script diatas merupakan QuoteAdapter yang digunakan untuk menjembatani antara data dan listView.


![alt text](https://github.com/yeppymp/quotes-app/raw/master/main-activity3.png "Main Activity")

> Dalam *function* addQuote ,disinilah kita mengambil random quotes dari API [forismatic.com](https://forismatic.com/en/api/ "API Forismatic") yang dimana data tersebut akan diserahkan kepada adapte, dan adapter akan otomatis menambahkan 1 list pada listView kita, atau lebih tepatnya akan bertambah 1 CardView dengan random quotes.


12. Langkah terakhir adalah menjalankannya di device, baik emulator atau external device langsung di smartphone android anda. Klik run dan pilih device, dan lihat hasilnya!


![alt text](https://github.com/yeppymp/quotes-app/raw/master/hasil.jpg "Quotes App")


# Selamat Mencoba :)
