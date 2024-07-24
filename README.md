# hotelManagementSystemJavaFX
Uygulama girişinde sunulan 4 çeşit databaseden istediğiniz database ile giriş yapılıp kullanılabilen,
İngilizce ve Türkçe olmak üzere 2 dili destekleyen
hotel rezervasyon takip uygulaması
Uygulamadan hotel görevlisi gözünden rezervasyonlar takip edilebiliyor. 
Bunun için öncelikle oda eklemek gerekiyor. Hotelin tüm odaları sisteme eklendikten sonra, bir odaya rezervasyon yapılmak istendiğinde rezervasyon yapılmak istenen tarih aralığında müsait olan odaları gösteriyor ve seçim olanağı sağlıyor. Yapılan rezervasyon istenirse sonradan güncellenedebiliyor.
Program ayrıca yapılan rezervasyonun
ücretinin ödenip ödenmediği ile ilgili bilgiyi de tutuyor ve hotelin odalardan toplamda ne kadar para tahsil ettiğini ve ne kadar alacağı olduğunu da gösteriyor.
Repo indirildikten sonra program, bilgisayarınızda Amazon Corretto JDK 21 ve sqlite yüklü ise içerisindeki jar dosyasına tıklanarak çalıştırılabilir. 
Program her ne kadar 4 çeşit farklı database kullanabiliyor olsa da diğer databaselerle ilgili temel bilgileri yine sqlite ile tutar.
Jar dosyası çalıştırıldığında kendi database'ini kendisi oluşturur. 
Ancak programı çalıştırırken jar dosyasını masaüstünde çevresi çepeçevre bomboş olan bir alana koymaya özen gösterin. 
çünkü kendi database'ini aynı dizinde kendisi oluşturduğu için bazen database'i oluşturmak istediği yer masaüstündeki 
diğer objelerle çakışabiliyor ve dolayısıyla database'i oluşturamayabiliyor.
Bu durumda yapılan işlemlere otomatikmen olumsuz cevap verebiliyor. 
Bu durumdan sakınmak için jar dosyasını mutlaka masaüstünde çevresi bomboş bir yere koyun o şekilde çalıştırın.
Ayrıca uygulamaya MariaDB, Mysql veya PostgreSql ile giriş yaparsanız databasede girerken ismini programa belirttiğiniz(varsayılan olarak hotelmanagement) schema'yı önceden kendiniz oluşturmaya ve schema isminde büyük harf kullanmamaya, küçük harf kullanmaya ve Türkçe karakter kullanmamaya özen gösterin.
Aksi takdirde program doğru çalışmayabilir.
Program İngilizce ve Türkçe olmak üzere 2 dili desteklemekte ve bu diller arasında anında geçiş yapma olanağı sağlamaktadır.
Ayrıca bilgisayarınızda Amazon Corretto JDK 21 ve sqlite'ın ikisi birden yüklü değil ise program düzgün çalışmayacaktır. Ben sadece Amazon Corretto JDK 21 ile denedim diğer JDK veya versiyonlar ile muhtemelen yine çalışır ama belki şekillerde kaymalar olabilir.

