# _homework-1-senolkara içerisindeki projenin factory pattern ile düzenlenmiş halidir._

* ### Package'lar incelendiğinde kullanılacak sınıflardan implemente edilecek İnterface'ler sınıf adının sonuna INF eki eklenerek oluşturulmuştur. 
* ### Bu İnterface'leri implemente eden sınıfların üretilmesi için kullanılacak factory sınıflarının adları kullanılacak sınıfların adlarının sonuna Factory eki eklenerek oluşturulmuştur. (örn: ProductFactory, OrderFactory vs. gibi) Factory sınıflarının içerisinde üretilmesi istenilen sınıfları return edecek static bir fonksiyon bulunmaktadır ve bazı factory sınıflarında bu fonksiyona yardımcı olan diğer static fonksiyonlar yer almaktadır.
* ### Factory sınıflarının içerisinde üretilmesi istenilen sınıfları return edecek static bir fonksiyon bulunmasının amacı: Factory sınıflarından bağımsız olarak çağırılması ve istenilen sınıfların oluşturulmasıdır.
