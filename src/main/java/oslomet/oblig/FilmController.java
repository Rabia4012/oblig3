package oslomet.oblig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FilmController {
    public final List <Film> alleFilmer = new ArrayList<>();
    @PostMapping("/lagre")
    public void lagreFilm(Film innFilm){
        alleFilmer.add(innFilm);
    }

    @GetMapping("/hentAlle")
    public List <Film> hentAlle(){
        return alleFilmer;
    }
}
