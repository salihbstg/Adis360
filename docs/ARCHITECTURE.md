# Adis360 — Architecture Decision Records

**Proje:** Adis360  
**Doküman:** Mimari Kararlar  
**Durum:** Geliştirme aşamasında

## ADR-001: Proje Mimarisi

**Karar:** Modüler Monolith.

Sistemin ilk sürümü modüler monolith mimarisiyle geliştirilecektir.

**Neden?**
- Başlangıçta operasyonel karmaşıklığı azaltmak.
- Modüller arasında sorumluluk ayrımı sağlamak.
- İleride ihtiyaç duyulması halinde modüllerin mikroservislere ayrılabilmesine imkân tanımak.

## ADR-002: Multi-Tenant Yapısı

**Karar:** Adis360, çok kiracılı (Multi-Tenant) SaaS platformu olacaktır.

- Her firma kendi işletmesini yönetecektir.
- Her firma tek bir şubeye sahip olacaktır.
- Firmalar birbirlerinin verilerine erişemeyecektir.
- Firmaya ait veriler firma ilişkisi üzerinden ayrıştırılacaktır.

## ADR-003: Firma Kayıt ve Abonelik Modeli

**Karar:** Self-Service Registration.

- Firmalar kendileri kayıt olabilecektir.
- Kayıt işlemi otomatik olarak aktifleşecektir.
- Ücretsiz deneme süresi 30 gün olacaktır.
- Firma sahibi kayıt sırasında ilk yönetici hesabına sahip olacaktır.
- Firma ve kullanıcı oluşturma işlemleri tek bir transaction içerisinde gerçekleştirilecektir.
- Deneme süresi sona erdiğinde işletme verileri silinmeyecektir.

## ADR-004: Kullanıcı Yönetimi

**Karar:** Firma ve kullanıcı hesapları ayrı entity ve tablolar olacaktır.

- Bir firma birden fazla kullanıcıya sahip olabilir.
- Kullanıcı hesapları firma kapsamında yönetilecektir.
- Çalışanlardan T.C. kimlik numarası veya resmî kimlik bilgisi istenmeyecektir.
- Sistem gerçek kişinin kimliğini değil, kullanıcı hesabını yönetecektir.
- Platform yöneticisi firma hesabına bağlı olmak zorunda değildir.

## ADR-005: Rol ve Yetkilendirme Sistemi

**Karar:** Merkezi rol ve yetki yönetimi kullanılacaktır.

- Roller Adis360 tarafından tanımlanacaktır.
- Firmalar kendilerine sunulan rolleri aktif veya pasif duruma getirebilecektir.
- Firmalar yeni rol tanımlayamayacaktır.
- Bir role bağlı kullanıcılar varken o rol pasifleştirilemeyecektir.
- Her rolün başlangıç yetkileri sistem tarafından belirlenecektir.
- Firma, rolün yetkilerini kendi ihtiyacına göre değiştirebilecektir.

## ADR-006: Varsayılan Rol ve Yetkilerin Yönetimi

**Karar:** Varsayılan rol ve yetki eşleşmeleri veritabanında tutulacaktır.

**Neden?**
- Yeni bir uygulama sürümü yayınlamadan varsayılan yetkiler değiştirilebilmelidir.
- Merkezi yönetim sağlanmalıdır.
- Firma bazlı özelleştirmeler desteklenmelidir.

Varsayılan yetkiler ile firma tarafından özelleştirilen yetkiler birbirinden ayrılacaktır.

Mevcut firmaların özelleştirmelerinin merkezi varsayılan değişikliklerinden nasıl etkileneceği ayrıca kararlaştırılacaktır.

## ADR-007: Transaction Yönetimi

**Karar:** Birbiriyle ilişkili kritik veritabanı işlemleri transaction kapsamında yürütülecektir.

Örnek: Firma kaydı sırasında Company ve User oluşturma işlemleri.

- İki işlem de başarılı olursa COMMIT.
- İşlemlerden herhangi biri başarısız olursa ROLLBACK.

Böylece yarım kalmış kayıtların oluşması önlenecektir.

---

## Henüz Kararlaştırılmamış Konular

- Bir kullanıcıya birden fazla rol atanabilmesi.
- Varsayılan yetki değişikliklerinin mevcut firmalara uygulanma politikası.
- Abonelik paketleri ve ödeme modeli.
- Firma doğrulama ve hesap kapatma süreçleri.
- Veritabanı izolasyonu ve güvenlik politikalarının detayları.