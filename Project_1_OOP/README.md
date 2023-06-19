# App.java
    Pada 'App.java' terdapat method showMenu.

    Menu.showMenu();
    Untuk menampilkan menu Read, Insert, Edit, Delete, dan Quit.

# com 
    Terdiri dari beberapa package yaitu:
    1. config
    2. layout
    3. model
    4. repository

## 1. config
    MyConfig            : terdiri dari barisan kode yang menghubungkan ke localhost.

## 2. layout
    DeleteData          : menampilkan menu untuk penghapusan data produk.
    EditData            : menampilkan menu untuk mengubah data produk.
    InsertData          : menampilkan menu untuk menambahkan produk ke database.
    Menu                : tampilan awal yang menampilkan pilihan untuk melakukan operasi data.
    ReadData            : menampilkan semua data yang ada di database.

## 3.model
    Product             : class yang memiliki atribut untuk data produk.

## 4. repository
    ProductRepository   : berisi tentang sistem operasi untuk menjalankan method CRUD.