package oslomet.oblig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {

    @Autowired
    private FilmRespository repo;


    //Post-kall for å lagre billetter
    @PostMapping("/lagre")
    public void lagreFilm(Film innFilm){
        repo.lagreFilm(innFilm);
    }

    //Get-kall for å hente billetttene
    @GetMapping("/hentAlle")
    public List <Film> hentAlle(){
        return repo.hentAlleFilmer();
    }
    //Get kall for å slette alle billetter
    @GetMapping("/slettAlle")
    public void slettAlle(){
        repo.slettAlleFilmer();
    }
}