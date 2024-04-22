package oslomet.oblig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Repository
public class FilmRespository {
    @Autowired
    private JdbcTemplate db;

    public void lagreFilm(Film innFilm){
        String sql="INSERT INTO Film(film, antall, fornavn, etternavn, nummer, epost) VALUES(?,?,?,?,?,?)";
        db.update(sql,innFilm.getFilm(),innFilm.getAntall(),innFilm.getFornavn(),
                innFilm.getEtternavn(),innFilm.getNummer(),innFilm.getEpost());
    }
    public List <Film> hentAlleFilmer(){
        String sql = "SELECT * FROM Film";
        List <Film> alleFilmer = db.query(sql, new BeanPropertyRowMapper(Film.class));
        Collections.sort(alleFilmer, Comparator.comparing(Film::getEtternavn));
        return alleFilmer;
    }
    public void slettAlleFilmer(){
        String sql ="DELETE FROM Film";
        db.update(sql);
    }
}
