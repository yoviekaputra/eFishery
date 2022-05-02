eFishery app hanya terdiri dari beberapa halaman:
1. SplashScreen
- Melakukan startup background worker untuk synchronizing data dari API ke local
- Sehingga ketika proses ini terjadi, user di arahkan ke halaman ini sebagai indikator persiapan data

2. HomeScreen
Halaman ini terdiri dari beberapa komponen
- AppBar
  AppBar berisikan logo dari eFishery website
- Pencarian
  Komponen pencarian ditempatkan di bawah AppBar dan diatas daftar harga, karena mempermudah user saat melakuan pencarian dimana hasil pencarian akan langsung tampil dibawah Keyword yang diinputkan.
  Pencarian ini juga dikasih icon "search" di Leading komponen tanpa menerima interaksi dari user dan icon "close" di Trailing dengan tujuan mempermudah User untuk menghapus secara menyeluruh keyword yang dinputkan.
- Daftar Harga Perikanan
  Daftar harga perikanan dengan highlight adalah field komoditas dan harga. Sehingga untuk komoditas di posisikan di bagian TitleText dan harga di bagian ExtraText.
- Floating Button Menu
  Komponen ini diposisikan terapung dibagian bawah dan tengah secara horizontal. Tujuannya adalah mempermudah User dalam menjangkau komponen saat ingin melakukan sorting, filter, ataupun penambahan komoditas.
  Floating Button akan berwarna abu-abu jika tidak digunakan, dan berwarna hijau jika menu tersebut digunakan.
  Beberapa menu dari Floating Button Menu
  - Sorting: akan menampilkan dialog pilihan pengurutan, bertujuan untuk pengurutan harga perikanan 
  - Filter: akan menampilkan dialog pilihan penyaringan data, bertujuan untuk penyaringan harga perikanan berdasarkan provinsi
  - Add: akan menampilkan dialog halaman input komoditas baru.
