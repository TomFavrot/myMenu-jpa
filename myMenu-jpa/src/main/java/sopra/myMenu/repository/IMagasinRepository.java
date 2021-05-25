package sopra.myMenu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenu.model.Magasin;

public interface IMagasinRepository extends JpaRepository<Magasin, Long> {

}
