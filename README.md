# CustomerArchivingApplication

Müşteri Arşivleme Sistemi

-- Müşterilerin listelenmesi, müşteri eklenmesi, güncellenmesi ve silinmesi

-- Dosyaların listelenmesi, dosya eklenmesi, güncellenmesi ve silinmesi

isterlerini karşılayan Java Spring Boot projesi olarak geliştirilmiştir.

-- Database olarak PostgreSQL kullanılmıştır.
-- Proje içerisinde database scriptleri yer almaktadır.
-- Uygulama 8010 portunda çalışmaktadır.
-- İstek yapılacak endpoint adresleri şu şekildedir..

	-->http://localhost:8010/api(Base adress)
		-->/customers (GET)
		-->/customer/{id} (GET)
		-->/customer (POST)
		-->/customer/{id} (PUT)
		-->/customer/{id} (DELETE)
		-->/folders (GET)
		-->/folder/{id} (GET)
		-->/folder (PUT)
		-->/folder/{id} (DELETE)
		-->/users (GET)
		
