☕ CoffeeOrder Pro
Mobil Uygulama Dersi Ödevi
Bilgi	Açıklama
Öğrenci Numarası	250053429
Proje Adı	CoffeeOrder Pro — Kahve Sipariş ve QR Menü Uygulaması
Ders	Mobil Uygulama
Platform	Android Studio ve mobil web tarayıcısı
Kullanılan Diller	Kotlin, XML, HTML, CSS, JavaScript
Sürüm	v0.1 (prototip)
Çalışma Takvimi	8–14 Ekim 2026


1. Projenin Amacı
CoffeeOrder Pro, bir kafede müşterilerin kahve türünü, adedini ve ekstra malzemeleri seçerek sipariş tutarını görebilmesi için hazırlanmış bir mobil uygulama ödevidir. Android uygulamasına ek olarak, masa numarasını URL üzerinden tanıyan mobil uyumlu bir QR menü prototipi bulunmaktadır.
Bu sürüm eğitim amaçlı prototiptir. Siparişler gerçek bir işletmeye iletilmez ve ödeme alınmaz.
2. Mevcut Özellikler
Android uygulaması (Kotlin + XML)
- Müşteri adı girişi: Sipariş verecek kişinin adını alır; boş bırakılırsa uyarı gösterir.
- Masa numarası: Pozitif tam sayı olarak masa numarası ister; geçersiz değeri kabul etmez.
- Kahve seçimi: Türk Kahvesi, Espresso, Latte, Cappuccino ve Americano seçenekleri sunar.
- Adet kontrolü: + ve − butonlarıyla adet değişir; adet 1'in altına düşmez.
- Ekstra malzemeler: Krema (+15 TL) ve çikolata (+20 TL) kutucukları seçilebilir.
- Anlık fiyat hesaplama: Kahve türü, adet veya ekstra seçenekleri değiştiğinde toplam yeniden hesaplanır.
- Sipariş özeti: Müşteri, masa, kahve, adet, ekstralar ve toplam tutar bir uyarı penceresinde gösterilir.
- Sıfırlama: Müşteri/masa alanlarını ve seçenekleri ilk hâline döndürür.
Mobil QR web menüsü (HTML + CSS + JavaScript)
- Telefon ekranlarına uyumlu bir kahve menüsü sunar.
- Aynı beş kahve çeşidi için seçim ve örnek fiyatlandırma içerir.
- URL'deki ?table=5 gibi parametrelerden masa numarasını okur.
- Müşteri adı, ekstra malzeme ve adet seçimiyle fiyatı günceller.
- Geçerli masa numarası ve müşteri adıyla demo sipariş özeti gösterir.
Not: Web menüsü yayımlanmış değildir. QR kod görselleri henüz üretilmedi; menü yalnızca uygun bir web adresine yayımlandıktan sonra masa QR kodlarıyla kullanılabilir.
3. Örnek Fiyatlar
Kahve	Birim fiyat
Türk Kahvesi	60 TL
Espresso	75 TL
Latte	100 TL
Cappuccino	95 TL
Americano	80 TL


Krema: 15 TL · Çikolata: 20 TL
Hesaplama: Toplam = (Kahve fiyatı + seçilen ekstralar) × Adet
Örnek: 2 Latte + krema + çikolata = (100 + 15 + 20) × 2 = 270 TL.
4. Proje Dosyaları
CoffeeOrderPro/
├── app/
│   ├── build.gradle.kts
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/example/coffeeorderpro/MainActivity.kt
│       └── res/layout/activity_main.xml
├── web/
│   └── index.html
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
└── README.md
- MainActivity.kt: Android sipariş akışı, kontroller ve fiyat hesaplama.
- activity_main.xml: Android kullanıcı arayüzü.
- web/index.html: Mobil web menüsü, masa parametresi ve demo sipariş özeti.
5. Android Studio ile Açma
1. Android Studio'yu açın ve Open seçeneğine tıklayın.
2. CoffeeOrderPro klasörünü seçin.
3. JDK 17 ve Android SDK 35 kurulu olmalıdır.
4. Gradle senkronizasyonunu tamamlayın.
5. Emülatör veya USB hata ayıklama açık Android telefon seçerek Run düğmesine basın.
Uyarı: Bu prototip paketinde Gradle Wrapper dosyaları bulunmamaktadır. Android Studio'nun Gradle yapılandırması gerekebilir. Android derleme ve fiziksel cihaz testleri henüz doğrulanmamıştır.
6. QR Web Menüsünü Yerelde Açma
Projenin kök klasöründe terminal açarak:
python -m http.server 8000 --directory web
Tarayıcıda örnek masa bağlantısını açın:
http://localhost:8000/?table=5
Gerçek QR menü için web/index.html dosyası HTTPS destekli bir sunucuda yayımlanmalı, ardından her masaya ait bağlantı QR koduna dönüştürülmelidir. localhost bağlantısı müşterilerin telefonlarından doğrudan erişilebilir değildir.
7. Planlanan Ancak Henüz Tamamlanmayan Özellikler
Aşağıdakiler mevcut v0.1 sürümünde çalışan özellik olarak bulunmamaktadır:
- Koyu espresso/antrasit tema ve burger restoranı tarzı açılır ürün detay paneli.
- Birden fazla farklı ürün içeren alışveriş sepeti.
- Room ile yerel sipariş geçmişi.
- Firebase veya başka ortak backend ile gerçek zamanlı sipariş senkronizasyonu.
- QR web menüsünden işletmeye gerçek sipariş gönderimi.
- Personel/yönetici paneli, sipariş durum yönetimi ve ciro raporları.
- Kullanıcı yetkilendirmesi, sunucu tarafında fiyat doğrulaması ve ödeme entegrasyonu.
- Yayımlanmış web menüsü, masalara özel üretilmiş QR görselleri ve APK teslimi.
8. Test Durumu
Mevcut kod, Android ve web tarafında temel sipariş işlevlerini tanımlamaktadır. Ancak başarılı Android derlemesi, emülatör testi, fiziksel cihaz testi ve uçtan uca QR sipariş aktarımı bu sürüm için doğrulanmamıştır. Kaynak kodda bir işlevin bulunması, gerçek cihazda çalıştığının kanıtı değildir.
9. Sonuç
CoffeeOrder Pro v0.1, Mobil Uygulama Dersi kapsamında Kotlin ve XML ile kullanıcı arayüzü, olay yönetimi, giriş doğrulama ve dinamik fiyat hesaplama konularını uygulayan bir prototiptir. QR web menüsü, aynı sipariş fikrinin mobil tarayıcıda nasıl sunulabileceğini göstermektedir. Projenin sonraki aşaması, iki arayüzü ortak bir veritabanı ve sipariş yönetim sistemiyle birleştirmektir.
Ders: Mobil Uygulama Dersi Ödevi
Öğrenci No: 250053429
Proje: CoffeeOrder Pro
