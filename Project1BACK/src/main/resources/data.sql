INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

INSERT INTO prevoznik(id, naziv, adresa, pib)VALUES(1, 'Severtrans', 'Filipa Kljajica bb, Sombor', '1234565765');  
INSERT INTO prevoznik(id, naziv, adresa, pib)VALUES(2, 'Lasta', 'Autoput Beograd-Nis, 4, Beograd', '23354263463');

INSERT INTO prevoznik(id, naziv, adresa, pib)VALUES(3, 'NisEkspres', 'Stevana Sindjelica 59, Nis', '143254256426');    
              
              
INSERT INTO linija (id, broj_mesta, cena_karte, vreme_polaska, destinacija, prevoznik_id)VALUES(1, 50, 322.0, '14:50', 'Srbobran', 1);    
INSERT INTO linija (id, broj_mesta, cena_karte, vreme_polaska, destinacija, prevoznik_id)VALUES(2, 45, 220.0, '18:10', 'Vrbas', 2); 
INSERT INTO linija (id, broj_mesta, cena_karte, vreme_polaska, destinacija, prevoznik_id)VALUES(3, 35, 150.0, '06:30', 'Beograd', 3); 
INSERT INTO linija (id, broj_mesta, cena_karte, vreme_polaska, destinacija, prevoznik_id)VALUES(4, 80, 540.0, '05:10', 'Krusevac',1); 
INSERT INTO linija (id, broj_mesta, cena_karte, vreme_polaska, destinacija, prevoznik_id)VALUES(5, 44, 440.0, '15:30', 'Nis', 2); 
INSERT INTO linija (id, broj_mesta, cena_karte, vreme_polaska, destinacija, prevoznik_id)VALUES(6, 40, 210.0, '12:00', 'Vrnjacka Banja',3); 