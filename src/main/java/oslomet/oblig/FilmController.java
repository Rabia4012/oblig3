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
    private FilmRespository rep;
    public final List <Film> alleFilmer = new ArrayList<>();
    @PostMapping("/lagre")
    public void lagreFilm(Film innFilm){
        rep.lagreFilm(innFilm);
    }

    @GetMapping("/hentAlle")
    public List <Film> hentAlle(){
        return rep.hentAlleFilmer();
    }
    @GetMapping("/slettAlle")
    public void slettAlle(){
        rep.slettAlleFilmer();
    }
}