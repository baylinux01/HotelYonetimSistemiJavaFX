# hotelManagementSystemJavaFX
Uygulama girişinde sunulan 4 çeşit databaseden istediğiniz database ile giriş yapılıp kullanılabilen hotel rezervasyon takip uygulaması

Repo indirildikten sonra program, bilgisayarınızda java(daha doğrusu jre) ve sqlite yüklü ise içerisindeki jar dosyasına tıklanarak çalıştırılabilir. 
Program her ne kadar 4 çeşit farklı database kullanabiliyor olsa da diğer databaselerle ilgili temel bilgileri yine sqlite ile tutar.
Jar dosyası çalıştırıldığında kendi database'ini kendisi oluşturur. 
Ancak programı çalıştırırken jar dosyasını masaüstünde çevresi çepeçevre bomboş olan bir alana koymaya özen gösterin. 
çünkü kendi database'ini aynı dizinde kendisi oluşturduğu için bazen database'i oluşturmak istediği yer masaüstündeki 
diğer objelerle çakışabiliyor ve dolayısıyla database'i oluşturamayabiliyor.
Bu durumda yapılan işlemlere otomatikmen olumsuz cevap verebiliyor. 
Bu durumdan sakınmak için jar dosyasını mutlaka masaüstünde çevresi bomboş bir yere koyun o şekilde çalıştırın.
Ayrıca uygulamaya MariaDB, Mysql veya PostgreSql ile giriş yaparsanız databasede girerken ismini programa belirttiğiniz(varsayılan olarak hotelmanagement) schema'yı önceden kendiniz oluşturmaya ve schema isminde büyük harf kullanmamaya, küçük harf kullanmaya ve Türkçe karakter kullanmamaya özen gösterin.
Aksi takdirde program doğru çalışmayabilir.
Programın dili İngilizce'dir.
Windows işletim sistemli bilgisayarlar için ikinci bir seçenek olarak exe uzantılı installer da eklenmiştir.
installer'a tıklayıp next'leyerek program windows bilgisayara yüklenebilir. 
Eğer bilgisayarınızda java(jre) ve sqlite'ın ikisi birden yüklü değil ise program düzgün çalışmayacaktır.
Ayrıca uygulama birden çok bilgisayarın aynı database'e bağlanıp kullanması için tasarlanmamıştır. Yani uygulama birden çok bilgisayarın aynı database'e bağlanıp beraber kullanması için uygun değildir.
