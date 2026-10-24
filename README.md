# CoffeeOrder Pro

Mobil Uygulama Dersi Ödevi · Mehmetcan Sütsatan · 250053429

Kotlin/XML Android uygulaması ve aynı menüyü sunan mobil web prototipi.
Müşteri, masa, kahve, adet ve ekstra seçimiyle sipariş özeti hesaplanır.
Siparişler sunucuya gönderilmez; ödeme veya gerçek QR sipariş altyapısı bulunmaz.

## Dosyalar

- `app/`: Android kaynakları, manifest ve yerleşim.
- `web/index.html`: Bağımsız mobil web menüsü.
- `build.gradle.kts`, `settings.gradle.kts`: Android proje yapılandırması.

## Android

Depo kökünü Android Studio ile açın. JDK 17, Android SDK 35 gerekir.
Gradle Wrapper bu kaynak paketinde yoktur; kurulu Gradle 8.10.2 ile
`gradle wrapper --gradle-version 8.10.2` çalıştırıp ardından Android Studio'da senkronize edin.
Windows'ta Türkçe karakter içermeyen bir yol kullanın (ör. `C:/Projects/cofepro`).
Bu incelemede Android SDK/Gradle olmadığı için APK derlemesi ve cihaz testi yapılmadı.

## Web menüsü

```sh
python -m http.server 8000 --directory web
```

`http://localhost:8000/?table=5` adresini açın. Geçerli masa parametresi ve
müşteri adı olmadan özet oluşturulmaz. Adet 1–99 arasındadır.

## Fiyat hesabı

| Kahve | TL |
|---|---:|
| Türk Kahvesi | 60 |
| Espresso | 75 |
| Latte | 100 |
| Cappuccino | 95 |
| Americano | 80 |

Krema +15 TL, çikolata +20 TL. Toplam = (kahve + ekstralar) × adet.
İki Latte, krema ve çikolata: 270 TL. Fiyatlar demo verisidir.

## Sonraki geliştirmeler

Gerçek sipariş aktarımı, sunucu fiyat doğrulaması, sepet, sipariş geçmişi,
personel paneli ve yayımlanmış masa QR kodları henüz uygulanmadı.
